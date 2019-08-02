/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import net.michaelhofmann.usecasefull.definition.ActorStereotype;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Actor extends AbstractContainer {

    private static final Log LOGGER = LogFactory.getLog(Actor.class);

    private String name;
    private ActorStereotype stereotype;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public Actor() {
    }
    
    public Actor(String name) {
        this.name = name;
    }
    
    public Actor(String name, ActorStereotype stereotype) {
        this.name = name;
        this.stereotype = stereotype;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActorStereotype getStereotype() {
        return stereotype;
    }

    public void setStereotype(ActorStereotype stereotype) {
        this.stereotype = stereotype;
    }
}
