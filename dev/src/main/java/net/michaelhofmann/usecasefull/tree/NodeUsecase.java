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
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeUsecase extends AbstractNode {

    private static final Log LOGGER = LogFactory.getLog(NodeUsecase.class);
    
    private final UseCase usecase = new UseCase();
    private final UseCaseQueue ucQueue;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    NodeUsecase(AbstractNode father, NodeCallback nodeCallback,
            UseCaseQueue ucQueue) {
        super(Element.usecase, NULL_ATTRIBUTES, father, nodeCallback);
        this.ucQueue = ucQueue;
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        
        switch (element) {
            case subtype: {
                NodeSubtype node = new NodeSubtype(
                        this, nodeCallback, attributes, usecase);
                nodeCallback.startSubtype(
                        node.getAttributeScope(), node.getAttributeGoalLevel());
                return node;
            }
            case ident:
                nodeCallback.startIdent();
                return new NodeIdent(this, nodeCallback, usecase);
            case name:
                nodeCallback.startName();
                return new NodeName(this, nodeCallback, usecase);
            case description:
                nodeCallback.startDescription();
                return new NodeDescription(this, nodeCallback, usecase);
            case notes:
                nodeCallback.startNotes();
                return new NodeNotes(this, nodeCallback, usecase);
            case actors:
                nodeCallback.startActors();
                return new NodeActors(this, nodeCallback, usecase);
            case workflow:
                nodeCallback.startWorkflow();
                return new NodeWorkflow(this, nodeCallback, usecase);
            case input:
                nodeCallback.startInput();
                return new NodeInput(this, nodeCallback, usecase);
            case additionalinfo: {
                NodeAdditionalinfo node = new NodeAdditionalinfo(
                        this, nodeCallback, attributes, usecase);
                nodeCallback.startAdditionalinfo(
                        node.getAttributeNum());
                return node;
            }
            case state: {
                NodeState node = new NodeState(
                        this, nodeCallback, attributes, usecase);
                nodeCallback.startState(
                        node.getAttributeUpdate(), node.getAttributePercent());
                return node;
            }
        }
        return this;
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    @Override
    protected void endElementExe() {
        ucQueue.put(usecase);
        LOGGER.debug("usecase has been added to queue, size is " + ucQueue.size());
    }
}
