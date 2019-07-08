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
public class Parameter {

    private static final Log LOGGER = LogFactory.getLog(Parameter.class);
    
    private String content;
    private String note;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public Parameter() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
