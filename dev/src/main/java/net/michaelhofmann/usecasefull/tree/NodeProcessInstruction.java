/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import java.util.Optional;
import net.michaelhofmann.usecasefull.definition.Element;
import net.michaelhofmann.usecasefull.usecase.ProcessInstruction;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeProcessInstruction extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeProcessInstruction.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeProcessInstruction(AbstractNode father, NodeCallback nodeCallback, 
            Attributes attributes, UseCase usecase) {
        super(Element.pi, Optional.of(attributes), father, nodeCallback, 
                usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        String process = getAttributeProcess();
        nodeCallback.contentProcessInstruction(process, content.toString());
        usecase.getProcessInstructions()
                .add(new ProcessInstruction(process, content.toString()));
        System.out.println("size = " + usecase.getProcessInstructions().size());
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public String getAttributeProcess() {
        return getAttributeString("process");
    }
}
