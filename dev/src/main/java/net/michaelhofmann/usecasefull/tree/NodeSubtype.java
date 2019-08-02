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
import net.michaelhofmann.usecasefull.definition.GoalLevel;
import net.michaelhofmann.usecasefull.definition.Scope;
import net.michaelhofmann.usecasefull.usecase.Subtype;
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
public class NodeSubtype extends AbstractLeaf {

    private static final Log LOGGER = LogFactory.getLog(NodeSubtype.class);
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/
    
    NodeSubtype(AbstractNode father, NodeCallback nodeCallback,
            Attributes attributes, UseCase usecase) {
        super(Element.subtype, Optional.of(attributes), father, nodeCallback, usecase);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    protected void endElementExe() {
        Scope scope = getAttributeScope();
        GoalLevel goalLevel = getAttributeGoalLevel();
        nodeCallback.contentSubtype(content.toString(), scope, goalLevel);
        usecase.setSubtype(new Subtype(scope, goalLevel, content.toString()));
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
    
    public Scope getAttributeScope() {
        String str = getAttributeString("scope");
        if (StringUtils.isBlank(str)) {
            return Scope.Unknown;
        }
        try {
            return Scope.valueOf(str);
        } catch (IllegalArgumentException e) {
            return Scope.Unknown;
        }
    }

    public GoalLevel getAttributeGoalLevel() {
        String str = getAttributeString("goalLevel");
        if (StringUtils.isBlank(str)) {
            return GoalLevel.Unknown;
        }
        try {
            return GoalLevel.valueOf(str);
        } catch (IllegalArgumentException e) {
            return GoalLevel.Unknown;
        }
    }
}
