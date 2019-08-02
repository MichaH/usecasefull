/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Link extends AbstractReference {

    private static final Log LOGGER = LogFactory.getLog(Link.class);
    
    private URI uri;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public Link() {
    }

    public Link(URI uri) {
        this.uri = uri;
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    /*  ***********************************************************************
     *  Additional  G e t t e r 
     **************************************************************************/
    
    public String getUriN2E() {
        return nullToEmpty(uri.toString());
    }
    
    /*  ***********************************************************************
     *  G e t t e r  and  S e t t e r
     **************************************************************************/

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
