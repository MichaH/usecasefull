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
        content = content.replaceAll("\\s*\\n\\s*", " ");
        System.out.println("[+" + content + "+]");
    }

    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
    }
}
