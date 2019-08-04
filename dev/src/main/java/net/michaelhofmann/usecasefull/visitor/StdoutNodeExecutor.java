/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;
import java.util.Date;
import net.michaelhofmann.usecasefull.definition.Const;
import net.michaelhofmann.usecasefull.definition.GoalLevel;
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import net.michaelhofmann.usecasefull.definition.Scope;
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class StdoutNodeExecutor implements NodeCallback {

    private static final Log LOGGER = LogFactory.getLog(StdoutNodeExecutor.class);

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public StdoutNodeExecutor() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public void init(CommandLine cmd) {
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    @Override
    public void startDocument() {
        System.out.println("--> startDocument");
    }

    @Override
    public void endDocument() {
        System.out.println(
                String.format("--> endDocument"));        
    }

    @Override
    public void startUsecases() {
        System.out.println("--> startUsecases");
    }

    @Override
    public void startUsecase() {
        System.out.println("--> startUsecase");
    }

    @Override
    public void startIdent() {
        System.out.println("--> startId");
    }

    @Override
    public void startSubtype(Scope scope, GoalLevel goalLevel) {
        System.out.println(
                String.format("--> startSubtype : scope=%s, goalLevel=%s",
                scope.name(),
                goalLevel.name()));
    }

    @Override
    public void startName() {
        System.out.println("--> startName");
    }    
    
    @Override
    public void startDescription() {
        System.out.println("--> startDescription");
    }
    
    @Override
    public void startSummary() {
        System.out.println("--> startSummary");
    }
    
    @Override
    public void startNotes() {
        System.out.println("--> startNotes");
    }

    @Override
    public void startNote(NoteStereotype stereotype) {
        System.out.println("--> startNote");
    }

    @Override
    public void startActors() {
        System.out.println("--> startActors");
    }

    @Override
    public void startActor() {
        System.out.println("--> startActor");
    }
    
    @Override
    public void startVariation(long num) {
        System.out.println("--> startActor, num=" + num);
    }

    @Override
    public void startWorkflow() {
        System.out.println("--> startWorkflow");
    }

    @Override
    public void startStep(long order, String actor) {
        System.out.println("--> startStep, order=" + order + "actor=" + actor);
    }
    
    @Override
    public void startStepextension(long step, long order) {
        System.out.println("--> startStep, step=" + step + "order=" + order);
    }

    @Override
    public void startAdditionalinfo(long num) {
        System.out.println("--> startAdditionalinfo, num=" + num);
    }

    @Override
    public void startContent() {
        System.out.println("--> startContent");
    }

    @Override
    public void startAdditionalNote() {
        System.out.println("--> startAdditionalNote");
    }

    @Override
    public void startCode(String layoutSpaces) {
        System.out.println("--> startAdditionalinfo, layoutSpaces=" + layoutSpaces);
    }

    @Override
    public void startInput() {
        System.out.println("--> startInput");
    }
    
    @Override
    public void startParameter() {
        System.out.println("--> startParameter");
    }

    @Override
    public void startParacontent() {
        System.out.println("--> startParacontent");
    }

    @Override
    public void startParanote() {
        System.out.println("--> startParanote");
    }

    @Override
    public void startState(Date upDate, int percent) {
        System.out.println(
                String.format("--> startState : upDate=%s, percent=%d",
                Const.DATEFORM.format(upDate),
                percent));
    }

    


    
    
    
    @Override
    public void contentIdent(String content) {
        System.out.println("    ident  = " + content);
    }

    @Override
    public void contentSubtype(String typeName, Scope scope, GoalLevel goalLevel) {
        System.out.println(
                String.format("--> contentSubtype : scope=%s, goalLevel=%s\n%s",
                scope.name(),
                goalLevel.name(),
                typeName));
    }

    @Override
    public void contentName(String content) {
        System.out.println("    name  = " + content);
    }

    @Override
    public void contentSummary(String content) {
        System.out.println("    summary  = " + content);
    }

    @Override
    public void contentNote(String content, NoteStereotype stereotype) {
        System.out.println("    note  = " + content 
                + ", stereotype=" + stereotype.name());
    }
    
    @Override
    public void contentActor(String content) {
        System.out.println("    actor  = " + content);
    }

    @Override
    public void contentVariation(String content, long num) {
        System.out.println("    variation = " + content 
                + ", num=" + num);
    }

    @Override
    public void contentStep(String content, long order, String actor) {
        System.out.println("    step = " + content
                + ", order=" + order 
                + ", actor=" + actor);
    }

    @Override
    public void contentStepextension(String toString, long step, long order) {
    }

    @Override
    public void contentContent(String content) {
        System.out.println("    content  = " + content);
    }

    @Override
    public void contentAdditionalNote(String content) {
        System.out.println(
                String.format("--> contentAdditionalNote :\n%s",
                content));
    }

    @Override
    public void contentCode(String content, String layoutSpaces) {
        System.out.println("--> contentCode, layoutSpaces=" + layoutSpaces);
    }

    @Override
    public void contentParacontent(String toString) {
    }
    
    @Override
    public void contentParanote(String toString) {
    }

    @Override
    public void contentState(String text, Date upDate, int percent) {
        System.out.println(
                String.format("--> contentState : upDate=%s, percent=%d\n%s",
                Const.DATEFORM.format(upDate),
                percent,
                text));
    }

    

    
    
    
    
    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
    }



}
