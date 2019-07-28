/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.tree;
import net.michaelhofmann.usecasefull.definition.Element;
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
public class NodeWorkflow extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeWorkflow.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    NodeWorkflow(AbstractNode father, NodeCallback nodeCallback,
            UseCase usecase) {
        super(Element.workflow, NULL_ATTRIBUTES, father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        
        switch (element) {
            case step: {
                NodeStep node = new NodeStep(
                        this, nodeCallback, attributes, usecase);
                nodeCallback.startStep(
                        node.getAttributeOrder(), node.getAttributeActor());
                return node;
            }
            case stepextension: {
                NodeStepextension node = new NodeStepextension(
                        this, nodeCallback, attributes, usecase);
                nodeCallback.startStepextension(
                        node.getAttributeStep(), node.getAttributeOrder());
                return node;
            }
        }
        return this;
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

}
