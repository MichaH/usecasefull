/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import net.michaelhofmann.usecasefull.definition.GoalLevel;
import net.michaelhofmann.usecasefull.definition.Scope;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Subtype extends AbstractContainer {

    private static final Log LOGGER = LogFactory.getLog(Subtype.class);
    
    private Scope scope;
    private GoalLevel goalLevel;
    private String typeName;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public Subtype() {
    }

    public Subtype(Scope scope, GoalLevel goalLevel, String typeName) {
        this.scope = scope;
        this.goalLevel = goalLevel;
        this.typeName = typeName;
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    
    /*  ***********************************************************************
     *  Additional  G e t t e r 
     **************************************************************************/

    
    /*  ***********************************************************************
     *  G e t t e r  and  S e t t e r
     **************************************************************************/

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public GoalLevel getGoalLevel() {
        return goalLevel;
    }

    public void setGoalLevel(GoalLevel goalLevel) {
        this.goalLevel = goalLevel;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
