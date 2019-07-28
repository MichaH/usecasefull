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
public class NodeActors extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeActors.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    NodeActors(AbstractNode father, NodeCallback nodeCallback,
            UseCase usecase) {
        super(Element.actors, NULL_ATTRIBUTES, father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        
        switch (element) {
            case actor:
                nodeCallback.startActor();
                return new NodeActor(this, nodeCallback, usecase);
            default:
                throw new SAXException("element 'actor' expected");
        }
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

}
