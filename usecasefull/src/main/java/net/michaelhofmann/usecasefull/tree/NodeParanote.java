/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeParanote extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeParanote.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeParanote(AbstractNode father, NodeCallback nodeCallback,
            UseCase usecase) {
        super(Element.paranote, NULL_ATTRIBUTES, father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        nodeCallback.contentParanote(content.toString());
        usecase.getNotes().add(content.toString());
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
    
}
