/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.tree;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import net.michaelhofmann.usecasefull.definition.Element;
import java.util.Optional;
import net.michaelhofmann.usecasefull.definition.Const;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.lang3.StringUtils;
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
    final protected Optional<Attributes> optAttributes;
    final protected Node father;
    final protected NodeCallback nodeCallback;
    
    final protected StringBuilder content = new StringBuilder();
    
    public static final Optional<Attributes> NULL_ATTRIBUTES = Optional.empty();
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public AbstractNode(Element nodeType, Optional<Attributes> optAttributes,
            AbstractNode father, NodeCallback nodeCallback) {
        
        assert nodeType != null : "nodeType is a mandatory parameter";
        assert nodeCallback != null : "nodeCallback is a mandatory parameter";
        
        this.nodeType = nodeType;
        this.optAttributes = optAttributes;
        this.father = father;
        this.nodeCallback = nodeCallback;

        LOGGER.debug("father fuer " + nodeType.name()
                + " = " + (father != null ? father.getNodeType().name() : null));
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public void startDocument() {
    }
    
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
                + "' has no subelements (" + element.name() + ")");
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
    public void addCcontent(String content) {
        this.content.append(content);
    }
    
    public long getAttributeLong(String attributeName) {
        if (optAttributes.isPresent()) {
            try {
                Attributes attr = optAttributes.get();
                return Long.parseLong(attr.getValue(attributeName));
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public int getAttributeInt(String attributeName) {
        if (optAttributes.isPresent()) {
            try {
                Attributes attr = optAttributes.get();
                return Integer.parseInt(attr.getValue(attributeName));
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public Date getAttributeDate(String attributeName) {
        if (optAttributes.isPresent()) {
            String dateStr = null;
            try {
                Attributes attr = optAttributes.get();
                dateStr = attr.getValue(attributeName);
                if (StringUtils.isBlank(dateStr)) {
                    return null;
                }
                // the content could be the documentation itself YYYY-MM-DD
                if (Const.DATEFORMSTR.equalsIgnoreCase(dateStr)) {
                    return null;
                }
                return Const.DATEFORM.parse(dateStr);
            } catch (ParseException ex) {
                LOGGER.error("wrong date format " + dateStr, ex);
                return null;
            }
        } else {
            return null;
        }
    }

    public String getAttributeString(String attributeName) {
        if (optAttributes.isPresent()) {
            Attributes attr = optAttributes.get();
            return attr.getValue(attributeName);
        } else {
            return "";
        }
    }    

    protected String toLine(String lines) {
        return lines != null ? lines.replaceAll("\\s*\\n\\s*", " ") : "";
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public Element getNodeType() {
        return nodeType;
    }
}
