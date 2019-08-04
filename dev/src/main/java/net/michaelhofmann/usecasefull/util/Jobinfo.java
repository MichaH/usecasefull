/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.util;

import java.io.File;
import java.nio.file.Path;
import java.util.Date;
import net.michaelhofmann.usecasefull.definition.Const;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Jobinfo {
    
    private File inputFile;
    private Path outputFile;
    private String visitorClazz;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    private Jobinfo() {
    }
    
    public static Jobinfo getInstance() {
        return JobinfoHolder.INSTANCE;
    }
    
    private static class JobinfoHolder {

        private static final Jobinfo INSTANCE = new Jobinfo();
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    public String getTimestamp() {
        return Const.TIMEFORM.format(new Date());
    }
    
    public String getInputfileName() {
        return inputFile != null ? inputFile.getName() : "";
    }
    
    public String getOutputfileName() {
        return outputFile != null ? outputFile.toFile().getName() : "";
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public Path getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(Path outputFile) {
        this.outputFile = outputFile;
    }

    public String getVisitorClazz() {
        return visitorClazz;
    }

    public void setVisitorClazz(String visitorClazz) {
        this.visitorClazz = visitorClazz;
    }
}
