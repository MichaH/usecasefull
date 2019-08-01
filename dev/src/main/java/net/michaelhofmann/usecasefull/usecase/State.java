/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class State {

    private static final Log LOGGER = LogFactory.getLog(State.class);
    
    private String text = null;
    private Date upDate = null;
    private int percent = 0;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public State() {
    }

    public State(String text, Date upDate, int percent) {
        this.text = text;
        this.upDate = upDate;
        this.percent = percent;
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
