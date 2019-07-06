/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.visitor;

import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public interface NodeCallback {

    public void startDocument();

    public void startUsecases();
    public void startUsecase();
    public void startIdent();
    public void startSubtype();
    public void startName();
    public void startActors();
    public void startActor();
    public void startDescription();
    public void startSummary();
    public void startVariation(long num);
    public void startNotes();
    public void startNote();
    public void startWorkflow();
    public void startStep(long attributeOrder, String attributeActor);
    public void startStepextension(long step, long order);

    public void contentSubtype(String content);
    public void contentIdent(String content);
    public void contentName(String content);
    public void contentActor(String content);
    public void contentSummary(String content);
    public void contentVariation(String toString, long num);
    public void contentNote(String content);
    public void contentStep(String toString, long order, String actor);
    public void contentStepextension(String toString, long step, long order);

    public void finishedQueue(UseCaseQueue ucQueue);
}
