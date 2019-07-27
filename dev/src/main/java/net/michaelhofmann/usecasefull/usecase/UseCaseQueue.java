/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import java.util.concurrent.LinkedTransferQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class UseCaseQueue extends LinkedTransferQueue<UseCase> {

    private static final Log LOGGER = LogFactory.getLog(UseCaseQueue.class);

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public UseCaseQueue() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

}
