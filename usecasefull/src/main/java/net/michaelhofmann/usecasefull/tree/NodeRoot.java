/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.tree;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeRoot extends AbstractNode {

    private static final Log LOGGER = LogFactory.getLog(NodeRoot.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public NodeRoot(AbstractNode father, NodeCallback nodeCallback) {
        super(Element.root, father, nodeCallback);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public void startDocument() {
         nodeCallback.startDocument();
    }
    
    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        
        switch (element) {
            case usecases:
                nodeCallback.startUsecases();
                return new NodeUsecases(this, nodeCallback);
            default:
                throw new SAXException("element 'usecases' expected");
        }
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
}
