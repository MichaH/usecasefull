/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import net.michaelhofmann.usecasefull.definition.Element;
import java.util.Optional;
import net.michaelhofmann.usecasefull.usecase.AdditionalInfo;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeCode extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeCode.class);
    private final AdditionalInfo additionalInfo;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeCode(AbstractNode father, NodeCallback nodeCallback, 
            Attributes attributes, UseCase usecase, AdditionalInfo additionalInfo) {
        super(Element.code, Optional.of(attributes), father, nodeCallback, usecase);
        this.additionalInfo = additionalInfo;
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        String layoutSpaces = getAttributeLayoutSpaces();
        nodeCallback.contentCode(content.toString(), layoutSpaces);
        additionalInfo.setCode(content.toString());
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public String getAttributeLayoutSpaces() {
        return getAttributeString("layoutSpaces");
    }
}
