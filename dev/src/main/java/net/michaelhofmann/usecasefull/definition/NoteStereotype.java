/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.definition;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public enum NoteStereotype {
    
    Default, Unknown, 
    Trigger, Precondition, Postcondition, PostconditionMinimal, 
    PostconditionSuccess, MainSuccessScenario, Invariance, Technology,
    Exception, Assumption, BusinessRule
}
