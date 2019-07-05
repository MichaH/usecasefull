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
public abstract class AbstractNode implements Node {

    private static final Log LOGGER = LogFactory.getLog(AbstractNode.class);

    final protected Element nodeType;
    final protected Node father;
    final protected NodeCallback nodeCallback;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public AbstractNode(Element nodeType, AbstractNode father,
            NodeCallback nodeCallback) {
        
        assert nodeType != null : "nodeType is a mandatory parameter";
        assert nodeCallback != null : "nodeCallback is a mandatory parameter";
        
        this.nodeType = nodeType;
        this.father = father;
        this.nodeCallback = nodeCallback;

        LOGGER.debug("father fuer " + nodeType.name()
                + " = " + (father != null ? father.getNodeType().name() : null));
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public Node startElement(String uri, String localName, String elementName, 
            Attributes attributes) throws SAXException {
        return startElement(
                Element.valueOf(elementName.toLowerCase()), attributes);
    }
    
    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        throw new SAXException("element '" + getNodeType().name()
                + "' has no subelements");
    }
    
    @Override
    public Node endElement(String uri, String localName, String elementName) {
        return endElement(Element.valueOf(elementName.toLowerCase()));
    }
    
    @Override
    public Node endElement(Element element) {
        if (getNodeType().name().equalsIgnoreCase(element.name())) {
            endElementExe();
            return father;
        }
        return this;
    }
    
    protected void endElementExe() {
    }
    
    @Override
    public void content(String content) {
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public Element getNodeType() {
        return nodeType;
    }
}
