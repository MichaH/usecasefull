/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.tree;
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
public class NodeUsecases extends AbstractNode {

    private static final Log LOGGER = LogFactory.getLog(NodeUsecases.class);
    
    final private UseCaseQueue ucQueue = new UseCaseQueue();
            
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    NodeUsecases(AbstractNode father, NodeCallback nodeCallback) {
        super(Element.usecases, father, nodeCallback);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public Node startElement(Element element, Attributes attributes)
            throws SAXException {
        
        switch (element) {
            case usecase:
                nodeCallback.startUsecase();
                return new NodeUsecase(this, nodeCallback, ucQueue);
            default:
                throw new SAXException("element 'usecase' expected");
        }
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    @Override
    protected void endElementExe() {
        LOGGER.info("size of usecase queue is " + ucQueue.size());
    }
}
