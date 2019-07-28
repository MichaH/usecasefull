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
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class NodeNote extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeNote.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeNote(AbstractNode father, NodeCallback nodeCallback,
            Attributes attributes, UseCase usecase) {
        super(Element.note, Optional.of(attributes), father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        nodeCallback.contentNote(content.toString(), getAttributeStereotype());
        usecase.addNote(content.toString(), getAttributeStereotype());
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
    
    public NoteStereotype getAttributeStereotype() {
        String name = getAttributeString("stereotype");
        if (StringUtils.isBlank(name)) {
            return NoteStereotype.Default;
        }
        try {
            return NoteStereotype.valueOf(name);
        } catch (IllegalArgumentException e) {
            return NoteStereotype.Unknown;
        }
    }
}
