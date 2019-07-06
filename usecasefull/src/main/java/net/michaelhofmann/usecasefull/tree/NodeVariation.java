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

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeVariation extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeVariation.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeVariation(AbstractNode father, NodeCallback nodeCallback, 
            Attributes attributes, UseCase usecase) {
        super(Element.variation, Optional.of(attributes), father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        long num = getAttributeNum();
        nodeCallback.contentVariation(content.toString(), num);
        usecase.getDescription().putVariation(num, content.toString());
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public long getAttributeNum() {
        if (optAttributes.isPresent()) {
            try {
                Attributes attr = optAttributes.get();
                return Long.parseLong(attr.getValue("num"));
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else {
            return 0;
        }
    }

}
