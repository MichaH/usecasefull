/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import java.util.Date;
import java.util.Optional;
import net.michaelhofmann.usecasefull.definition.Element;
import net.michaelhofmann.usecasefull.usecase.State;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeState extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeState.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeState(AbstractNode father, NodeCallback nodeCallback, 
            Attributes attributes, UseCase usecase) {
        super(Element.state, Optional.of(attributes), father, nodeCallback, 
                usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        int percent = getAttributePercent();
        Date upDate = getAttributeUpdate();
        nodeCallback.contentState(content.toString(), upDate, percent);
        usecase.setState(new State(content.toString(), upDate, percent));
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public Date getAttributeUpdate() {
        return getAttributeDate("upDate");
    }

    public int getAttributePercent() {
        return getAttributeInt("percent");
    }
}
