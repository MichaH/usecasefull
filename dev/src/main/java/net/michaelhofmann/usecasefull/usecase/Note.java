/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Note {

    private static final Log LOGGER = LogFactory.getLog(Note.class);
    
    private String content;
    private NoteStereotype stereotype;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public Note(String content, NoteStereotype stereotype) {
        this.content = content;
        this.stereotype = stereotype;
    }

    public Note() {
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

    public NoteStereotype getStereotype() {
        return stereotype;
    }

    public void setStereotype(NoteStereotype stereotype) {
        this.stereotype = stereotype;
    }
}
