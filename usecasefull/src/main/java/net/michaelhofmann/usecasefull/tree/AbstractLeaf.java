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
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public abstract class AbstractLeaf extends AbstractNode {

    private static final Log LOGGER = LogFactory.getLog(AbstractLeaf.class);

    protected final UseCase usecase;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public AbstractLeaf(Element nodeType, AbstractNode father, 
            NodeCallback nodeCallback, UseCase usecase) {
        super(nodeType, father, nodeCallback);
        this.usecase = usecase;
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

}
