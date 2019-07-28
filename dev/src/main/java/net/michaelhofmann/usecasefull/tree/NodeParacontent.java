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

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeParacontent extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeParacontent.class);
    private final Parameter parameter;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeParacontent(AbstractNode father, NodeCallback nodeCallback,
            UseCase usecase, Parameter parameter) {
        super(Element.paracontent, NULL_ATTRIBUTES, father, nodeCallback, usecase);
        this.parameter = parameter;
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        nodeCallback.contentParacontent(content.toString());
        parameter.setContent(content.toString());
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
    
}
