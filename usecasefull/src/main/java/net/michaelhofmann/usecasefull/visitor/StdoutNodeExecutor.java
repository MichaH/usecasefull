/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;
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


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    @Override
    public void startUsecases() {
        System.out.println("--> startUsecases");
    }

    @Override
    public void startUsecase() {
        System.out.println("--> startUsecase");
    }

    @Override
    public void startId() {
        System.out.println("--> startId");
    }

    @Override
    public void contentId(String content) {
        System.out.println("    id  = " + content);
    }

    @Override
    public void contentSubtype(String content) {
        System.out.println("    subtype  = " + content);
    }

}
