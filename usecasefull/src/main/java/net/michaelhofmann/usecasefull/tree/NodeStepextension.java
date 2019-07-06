/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import java.util.Optional;
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
public class NodeStepextension extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeStepextension.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeStepextension(AbstractNode father, NodeCallback nodeCallback, 
            Attributes attributes, UseCase usecase) {
        super(Element.stepextension, Optional.of(attributes), father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        
        return this;
    }
    
    @Override
    protected void endElementExe() {
        long step = getAttributeStep();
        long order = getAttributeOrder();
        nodeCallback.contentStepextension(content.toString(), step, order);
        // .... usecase.getWorkflow().getSteps().get(step);
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public long getAttributeStep() {
        if (optAttributes.isPresent()) {
            try {
                Attributes attr = optAttributes.get();
                return Long.parseLong(attr.getValue("step"));
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public long getAttributeOrder() {
        if (optAttributes.isPresent()) {
            try {
                Attributes attr = optAttributes.get();
                return Long.parseLong(attr.getValue("order"));
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else {
            return 0;
        }
    }
}
