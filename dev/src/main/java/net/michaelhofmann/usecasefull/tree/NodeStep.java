/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import java.util.Optional;
import net.michaelhofmann.usecasefull.usecase.Step;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeStep extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeStep.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeStep(AbstractNode father, NodeCallback nodeCallback, 
            Attributes attributes, UseCase usecase) {
        super(Element.step, Optional.of(attributes), father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        long order = getAttributeOrder();
        String actor = getAttributeActor();
        nodeCallback.contentStep(content.toString(), order, actor);
        usecase.getWorkflow().putStep(
                order, new Step(order, actor, content.toString()));
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public long getAttributeOrder() {
        return getAttributeLong("order");
    }

    public String getAttributeActor() {
        if (optAttributes.isPresent()) {
            Attributes attr = optAttributes.get();
            return attr.getValue("actor");
        } else {
            return "";
        }
    }
}
