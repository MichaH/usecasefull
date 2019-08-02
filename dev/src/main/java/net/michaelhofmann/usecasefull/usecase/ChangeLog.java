/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class ChangeLog extends AbstractContainer {

    private static final Log LOGGER = LogFactory.getLog(ChangeLog.class);
    
    private Date upDate;
    private String author;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public ChangeLog() {
    }

    public ChangeLog(Date upDate, String author) {
        this.upDate = upDate;
        this.author = author;
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    
    /*  ***********************************************************************
     *  Additional  G e t t e r 
     **************************************************************************/

    public String getAuthorN2E() {
        return nullToEmpty(author);
    }
    
    /*  ***********************************************************************
     *  G e t t e r  and  S e t t e r
     **************************************************************************/

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
