/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import net.michaelhofmann.usecasefull.definition.Element;
import net.michaelhofmann.usecasefull.usecase.Parameter;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeParameter extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeParameter.class);
    private final Parameter parameter = new Parameter();
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeParameter(AbstractNode father, NodeCallback nodeCallback, UseCase usecase) {
        super(Element.parameter, NULL_ATTRIBUTES, father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        
        switch (element) {
            case paranote:
                nodeCallback.startParanote();
                return new NodeParanote(this, nodeCallback, usecase, parameter);
            case paracontent: {
                NodeParacontent node = new NodeParacontent(
                        this, nodeCallback, usecase, parameter);
                nodeCallback.startParacontent();
                return node;
            }
            case content: {
                throw new SAXException(
                        "'content' below paramter is no longer supported");
            }
            case note: {
                throw new SAXException(
                        "'note' below paramter is no longer supported");
            }
        }
        return this;
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

}
