/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class ProcessInstruction extends AbstractContainer {

    private static final Log LOGGER = LogFactory.getLog(ProcessInstruction.class);
    
    private String text;
    private String process;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public ProcessInstruction() {
    }

    public ProcessInstruction(String text, String process) {
        this.text = text;
        this.process = process;
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    
    /*  ***********************************************************************
     *  Additional  G e t t e r 
     **************************************************************************/

    public String getTextN2E() {
        return nullToEmpty(text);
    }
    
    /*  ***********************************************************************
     *  G e t t e r  and  S e t t e r
     **************************************************************************/

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
