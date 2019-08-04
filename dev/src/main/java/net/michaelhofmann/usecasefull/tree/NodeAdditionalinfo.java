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
import org.xml.sax.SAXException;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeAdditionalinfo extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeAdditionalinfo.class);
    private final AdditionalInfo additionalInfo = new AdditionalInfo();
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    NodeAdditionalinfo(AbstractNode father, NodeCallback nodeCallback, 
            Attributes attributes, UseCase usecase) {
        super(Element.additionalinfo, Optional.of(attributes), father, 
                nodeCallback, usecase);
        usecase.getAdditionalInfos().put(getAttributeNum(), additionalInfo);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        
        switch (element) {
            case content: {
                NodeContent node = new NodeContent(
                        this, nodeCallback, usecase, additionalInfo);
                nodeCallback.startContent();
                return node;
            }
            case note: {
                NodeAdditionalNote node = new NodeAdditionalNote(
                        this, nodeCallback, usecase, additionalInfo);
                nodeCallback.startAdditionalNote();
                return node;
            }
            case code: {
                NodeCode node = new NodeCode(
                        this, nodeCallback, attributes, usecase, additionalInfo);
                nodeCallback.startCode(node.getAttributeLayoutSpaces());
                return node;
            }
        }
        return this;
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
    
    final public int getAttributeNum() {
        return getAttributeInt("num");
    }
}
