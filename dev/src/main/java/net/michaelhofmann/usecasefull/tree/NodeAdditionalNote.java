/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import net.michaelhofmann.usecasefull.definition.Element;
import net.michaelhofmann.usecasefull.usecase.AdditionalInfo;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeAdditionalNote extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeAdditionalNote.class);
    private final AdditionalInfo additionalInfo;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeAdditionalNote(AbstractNode father, NodeCallback nodeCallback,
            UseCase usecase, AdditionalInfo additionalInfo) {
        super(Element.note, NULL_ATTRIBUTES, father, nodeCallback, usecase);
        this.additionalInfo = additionalInfo;
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        nodeCallback.contentAdditionalNote(toLine(content.toString()));
        additionalInfo.getNotes().add(toLine(content.toString()));
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
    
}
