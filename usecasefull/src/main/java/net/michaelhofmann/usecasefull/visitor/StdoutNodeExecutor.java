/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;

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


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    @Override
    public void startDocument() {
        System.out.println("--> startDocument");
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
    public void startSubtype() {
        System.out.println("--> startSubtype");
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
    public void startNote() {
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
    public void contentIdent(String content) {
        System.out.println("    ident  = " + content);
    }

    @Override
    public void contentSubtype(String content) {
        System.out.println("    subtype  = " + content);
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
    public void contentNote(String content) {
        System.out.println("    note  = " + content);
    }
    
    @Override
    public void contentActor(String content) {
        System.out.println("    actor  = " + content);
    }

    @Override
    public void contentVariation(String content, long num) {
        System.out.println("    actor  = " + content + ", num=" + num);
    }

    
    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
    }


}
