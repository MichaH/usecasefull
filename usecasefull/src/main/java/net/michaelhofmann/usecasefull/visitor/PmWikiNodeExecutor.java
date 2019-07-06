/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class PmWikiNodeExecutor implements NodeCallback {

    private static final Log LOGGER = LogFactory.getLog(PmWikiNodeExecutor.class);

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public PmWikiNodeExecutor() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    @Override
    public void startDocument() {
        System.out.println("(:title UseCases MobilHardware :)\n");
        System.out.println("(:toc :)\n");
    }
    
    @Override
    public void startUsecases() {
    }

    @Override
    public void startUsecase() {
        System.out.println("\n----");
        System.out.print("!!! ");
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
    public void startDescription() {
    }
    
    @Override
    public void startSummary() {
    }
    
    @Override
    public void startNotes() {
        System.out.println("\n!!!!! Bemerkungen");
    }

    private int actorCounter = 0;
    
    @Override
    public void startActors() {
        System.out.print("'''Akteure'''");
        actorCounter = 0;
    }

    @Override
    public void startActor() {
    }
    
    @Override
    public void contentIdent(String content) {
        System.out.print(" " + content);
    }

    @Override
    public void contentSubtype(String content) {
        System.out.print(content);
    }

    @Override
    public void contentName(String content) {
        System.out.println(" | " + content);
    }

    @Override
    public void contentSummary(String content) {
        content = normalize(content);
        System.out.println(" \n [+" + content + "+]\n ");
    }

    @Override
    public void startNote() {
    }

    @Override
    public void contentNote(String content) {
        content = normalize(content);
        System.out.println("* " + content);
    }
    
    @Override
    public void contentActor(String content) {
        if (StringUtils.isNotBlank(content)) {
            content = normalize(content);
            if (actorCounter > 0) {
                System.out.print(", ");
            } else {
                System.out.print(" : ");
            }
            System.out.print(content);
            actorCounter++;
        }
    }
    
    private String normalize(String lines) {
        return lines != null ? lines.replaceAll("\\s*\\n\\s*", " ") : "";
    }

    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
    }

}
