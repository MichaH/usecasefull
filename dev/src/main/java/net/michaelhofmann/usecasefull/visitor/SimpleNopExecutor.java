/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class SimpleNopExecutor implements NodeCallback {

    private static final Log LOGGER = LogFactory.getLog(SimpleNopExecutor.class);

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public SimpleNopExecutor() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public void init(CommandLine cmd) throws Exception {
    }
    
    @Override
    public void startDocument() {

    }

    @Override
    public void startUsecases() {
        
    }

    @Override
    public void startUsecase() {
        
    }

    @Override
    public void startIdent() {
        
    }

    @Override
    public void startSubtype() {
        
    }

    @Override
    public void startName() {
        
    }

    @Override
    public void startActors() {
        
    }

    @Override
    public void startActor() {
        
    }

    @Override
    public void startDescription() {
        
    }

    @Override
    public void startSummary() {
        
    }

    @Override
    public void startVariation(long num) {
        
    }

    @Override
    public void startNotes() {
        
    }

    @Override
    public void startNote(NoteStereotype stereotype) {
    }

    @Override
    public void startWorkflow() {
    }

    @Override
    public void startStep(long attributeOrder, String attributeActor) {
        
    }

    @Override
    public void startStepextension(long step, long order) {
        
    }

    @Override
    public void startAdditionalinfo(long num) {
        
    }

    @Override
    public void startContent() {
        
    }

    @Override
    public void startCode(String layoutSpaces) {
        
    }

    @Override
    public void startInput() {
        
    }

    @Override
    public void startParameter() {
        
    }

    @Override
    public void startParacontent() {
        
    }

    @Override
    public void startParanote() {
        
    }

    @Override
    public void contentSubtype(String content) {
        
    }

    @Override
    public void contentIdent(String content) {
        
    }

    @Override
    public void contentName(String content) {
        
    }

    @Override
    public void contentActor(String content) {
        
    }

    @Override
    public void contentSummary(String content) {
        
    }

    @Override
    public void contentVariation(String toString, long num) {
        
    }

    @Override
    public void contentNote(String content, NoteStereotype stereotype) {
    }

    @Override
    public void contentStep(String toString, long order, String actor) {
        
    }

    @Override
    public void contentStepextension(String toString, long step, long order) {
        
    }

    @Override
    public void contentContent(String toString) {
        
    }

    @Override
    public void contentCode(String content, String layoutSpaces) {
        
    }

    @Override
    public void contentParacontent(String toString) {
        
    }

    @Override
    public void contentParanote(String toString) {
        
    }

    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
        
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
}
