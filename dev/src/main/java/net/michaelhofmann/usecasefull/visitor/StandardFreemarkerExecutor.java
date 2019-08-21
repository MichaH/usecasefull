/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import net.michaelhofmann.usecasefull.util.Jobinfo;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class StandardFreemarkerExecutor extends SimpleNopExecutor {

    private static final Log LOGGER = LogFactory.getLog(StandardFreemarkerExecutor.class);

    private File templateDir ;
    private Template templateHeader;
    private Template templateUsecase;
    private Template templateFooter;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public StandardFreemarkerExecutor() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    public void init(CommandLine cmd) throws Exception {
        super.init(cmd);
        equipTemplateDir(cmd);
        equipFreemarker();
    }

    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
        
        try (BufferedWriter out 
                = Files.newBufferedWriter(outputFilePath, charset, getOpenOptions())) {
            
            // Header
            processHeader(Jobinfo.getInstance(), out);

            // Usecases
            ucQueue.stream()
                    .filter(u -> StringUtils.isNotBlank(u.getName()))
                    .sorted(comparator)
                    .forEach(u -> {
                        processUseCase(u, out);
            });
            
            // Footer
            processFooter(Jobinfo.getInstance(), out);
            
        } catch (IOException ex) {
            LOGGER.error("IO-Error", ex);
        }
    }

    private void processHeader(Jobinfo jobinfo, Writer out) {
        try {
            templateHeader.process(jobinfo, out);
        } catch (TemplateException | IOException ex) {
            LOGGER.error("process header error", ex);
        }
    }

    private void processUseCase(UseCase useCase, Writer out) {
        try {
            templateUsecase.process(useCase, out);
        } catch (TemplateException | IOException ex) {
            LOGGER.error("process useCase error", ex);
        }
    }
    
    private void processFooter(Jobinfo jobinfo, Writer out) {
        try {
            templateFooter.process(jobinfo, out);
        } catch (TemplateException | IOException ex) {
            LOGGER.error("process footer error", ex);
        }
    }

    private void equipFreemarker() throws IOException {
        // Create your Configuration instance, and specify if up to what
        // FreeMarker version (here 2.3.28) do you want to apply the fixes that
        // are not 100% backward-compatible. See the Configuration JavaDoc for
        // details.
        Configuration cfg = new Configuration(new Version("2.3.28"));
        cfg.setClassForTemplateLoading(this.getClass(), "");
        // Specify the source where the template files come from.
        cfg.setDirectoryForTemplateLoading(templateDir);
        // Set the preferred charset template files are stored in. UTF-8 is
        // a good choice in most applications.
        cfg.setDefaultEncoding(CHARSET);        
        // Sets how errors will appear.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        // Don't log exceptions inside FreeMarker that it will thrown at 
        // you anyway:
        cfg.setLogTemplateExceptions(true);
        // Wrap unchecked exceptions thrown during template processing into 
        // TemplateException-s.
        cfg.setWrapUncheckedExceptions(true);
        templateHeader = cfg.getTemplate("templateHeader.txt");
        templateUsecase = cfg.getTemplate("templateUsecase.txt");
        templateFooter = cfg.getTemplate("templateFooter.txt");
    }

    private void equipTemplateDir(CommandLine cmd) throws IOException {
        String dirName = cmd.getOptionValue("td");
        if (StringUtils.isBlank(dirName)) {
            throw new IOException(
                    "no template directory given, please use -td");
        }
        File dir = new File(dirName);
        if ( ! dir.exists() || ! dir.canRead()) {
            throw new IOException(
                    "template directory doesn't exist or can't be read");
        }
        templateDir = dir;
        LOGGER.info("template directory is " + templateDir.getAbsolutePath());
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

}
