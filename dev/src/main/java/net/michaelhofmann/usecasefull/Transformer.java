/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Transformer {
    
    private static final Log LOGGER = LogFactory.getLog(Transformer.class);
    private static Options options = new Options();
    private File inputFile;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LOGGER.info("Transformer starting.....\n");
        try {
            options = getOptions();
            if (args.length == 0) {
                usage();
            }
            CommandLine cmd = new DefaultParser().parse(options, args);
            if (new Transformer().execute(cmd)) {
                LOGGER.info("... stopped");
            }

        } catch (ParseException ex) {
            LOGGER.error("Error while parsing command line arguments", ex);
            usage();
        } catch (Exception ex) {
            LOGGER.error("Error ", ex);
        }
    }

    private boolean execute(CommandLine cmd) throws IOException, Exception {
        
        getVersion().ifPresent(s -> System.out.println("Version " + s));

        if (cmd.hasOption("h")) {
            usage();
            return false;
        }
        if (cmd.hasOption("l")) {
            loggerDemo();
            return false;
        }
        
        if ( ! cmd.hasOption("f")) {
            return false;
        }            

        String fileName = cmd.getOptionValue("f");
        if (StringUtils.isBlank(fileName)) {
            System.out.println("no input file given");
            return false;
        }
        inputFile = new File(fileName);
        
        new Traversor(cmd, inputFile).start();
        return true;
    }

    private void loggerDemo() {
        LOGGER.trace("trace");
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
        LOGGER.error("error with exception", new Exception("demo exception"));
    }
    
    private static Options getOptions() throws ParseException {
        return new Options()
                .addOption("h", "help", false,
                        "print help")
                .addOption("l", "logtest", false,
                        "only test logging")
                .addOption("f", "inputfile", true,
                        "path to xml input file")
                .addOption("v", "visitor", true,
                        "full qualified visitor class")
                ;
    }

    private static void usage() {
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Transformer", options);
    }
    
    private Optional<String> getVersion() {
        
        Optional<String> optVersion = Optional.empty();
        
        try (InputStream is = getClass().getResourceAsStream(
                    "META-INF/maven/net.michaelhofmann/usecasefull/pom.properties")) {
            
            if ( ! optVersion.isPresent()) {
                Properties p = new Properties();
                if (is != null) {
                    p.load(is);
                    optVersion = Optional.of(p.getProperty("version", ""));
                }
            }
            
            if ( ! optVersion.isPresent()) {
                Package aPackage = getClass().getPackage();
                if (aPackage != null) {
                    if (StringUtils.isNotBlank(aPackage.getImplementationVersion())) {
                        optVersion = Optional.of(aPackage.getImplementationVersion());
                    } else if (StringUtils.isNotBlank(aPackage.getSpecificationVersion())) {
                        optVersion = Optional.of(aPackage.getSpecificationVersion());
                    }
                }
            }
        } catch (IOException e) {
        }

        return optVersion;
    }
}
