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
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class StandardMarkdownExecutor extends SimpleNopExecutor {

    private static final Log LOGGER = LogFactory.getLog(StandardMarkdownExecutor.class);

    private final String CHARSET = "UTF-8";
    private final Charset charset;
    
    private File templateDir ;
    private Path outputFilePath;
    private Template templateUsecase;
    private Template templateFooter;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public StandardMarkdownExecutor() {
        charset = Charset.forName(CHARSET);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    public void init(CommandLine cmd) throws IOException {
        equipTemplateDir(cmd);
        equipOutputfileName(cmd);
        equipFreemarker();
    }


    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
        try (BufferedWriter out = Files.newBufferedWriter(outputFilePath, charset)) {
            // Usecases
            ucQueue.stream()
                    .filter(u -> StringUtils.isNotBlank(u.getName()))
                    .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                    .forEach(u -> {
                        processUseCase(u, out);
            });
            // Footer
            processFooter(Jobinfo.getInstance(), out);
            
        } catch (IOException ex) {
            LOGGER.error("IO-Error", ex);
        }
    }

    @Override
    public void endDocument() {
    }
    
    private void processUseCase(UseCase useCase, Writer out) {
        try {
            templateUsecase.process(useCase, out);
        } catch (TemplateException | IOException ex) {
            LOGGER.error("process useCase error", ex);
        }
    }
    
    private void processFooter(Jobinfo jobinfo, BufferedWriter out) {
        try {
            templateFooter.process(jobinfo, out);
        } catch (TemplateException | IOException ex) {
            LOGGER.error("process jobinfo error", ex);
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
        templateUsecase = cfg.getTemplate("templateUsecase.md");
        templateFooter = cfg.getTemplate("templateFooter.md");
    }

    private void equipOutputfileName(CommandLine cmd) throws IOException {
        String outputFileName = cmd.getOptionValue("of");
        if (StringUtils.isBlank(outputFileName)) {
            throw new IOException(
                    "no output filename given, please use -of");
        }
        outputFilePath = Paths.get(outputFileName);
        Jobinfo.getInstance().setOutputFile(outputFilePath);
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
