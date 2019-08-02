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
public class UsecaseReference extends AbstractReference {

    private static final Log LOGGER = LogFactory.getLog(UsecaseReference.class);
    
    private String ident;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public UsecaseReference() {
    }

    public UsecaseReference(String ident) {
        this.ident = ident;
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    /*  ***********************************************************************
     *  Additional  G e t t e r 
     **************************************************************************/
    
    public String getIdentN2E() {
        return nullToEmpty(ident);
    }
    
    /*  ***********************************************************************
     *  G e t t e r  and  S e t t e r
     **************************************************************************/

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }
}
