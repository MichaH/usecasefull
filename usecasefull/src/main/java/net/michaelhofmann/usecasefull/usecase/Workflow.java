/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Workflow {

    private static final Log LOGGER = LogFactory.getLog(Workflow.class);
    
    private Map<Long, Step> steps = new TreeMap<>();

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public Workflow() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public Map<Long, Step> getSteps() {
        return steps;
    }

    public void setSteps(Map<Long, Step> steps) {
        this.steps = steps;
    }

    public Step putStep(Long order, Step value) {
        return steps.put(order, value);
    }
}
