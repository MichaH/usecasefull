/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.visitor;

import java.util.Date;
import net.michaelhofmann.usecasefull.definition.GoalLevel;
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import net.michaelhofmann.usecasefull.definition.Scope;
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import org.apache.commons.cli.CommandLine;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public interface NodeCallback {
    
    public void init(CommandLine cmd) throws Exception;

    public void startDocument();
    public void endDocument();

    public void startUsecases();
    public void startUsecase();
    public void startSubtype(Scope scope, GoalLevel goalLevel);
    public void startIdent();
    public void startName();
    public void startActors();
    public void startActor();
    public void startDescription();
    public void startSummary();
    public void startVariation(long num);
    public void startInput();
    public void startParameter();
    public void startParacontent();
    public void startParanote();
    public void startNotes();
    public void startNote(NoteStereotype stereotype);
    public void startWorkflow();
    public void startStep(long attributeOrder, String attributeActor);
    public void startStepextension(long step, long order);
    public void startAdditionalinfo(long num);
    public void startContent();
    public void startAdditionalNote();
    public void startCode(String layoutSpaces);
    public void startState(Date update, int percent);
    public void startProcessInstruction(String attributeProcess);

    public void contentSubtype(String toString, Scope scope, GoalLevel goalLevel);
    public void contentIdent(String content);
    public void contentName(String content);
    public void contentActor(String content);
    public void contentSummary(String content);
    public void contentVariation(String toString, long num);
    public void contentParacontent(String toString);
    public void contentParanote(String toString);
    public void contentNote(String content, NoteStereotype stereotype);
    public void contentStep(String toString, long order, String actor);
    public void contentStepextension(String toString, long step, long order);
    public void contentContent(String toString);
    public void contentAdditionalNote(String content);
    public void contentCode(String content, String layoutSpaces);
    public void contentState(String toString, Date upDate, int percent);
    public void contentProcessInstruction(String process, String text);

    public void finishedQueue(UseCaseQueue ucQueue);
}
