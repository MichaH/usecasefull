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
public class AbstractContainer {

    private static final Log LOGGER = LogFactory.getLog(AbstractContainer.class);

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public AbstractContainer() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    protected String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

}
