/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class History extends AbstractContainer {

    private static final Log LOGGER = LogFactory.getLog(History.class);

    private ChangeLog creation = new ChangeLog();
    private List<ChangeLog> changeLogs = new ArrayList<>();

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public History() {
    }
    
    public History(Date upDate, String author) {
        creation = new ChangeLog(upDate, author);
    }
    
    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    
    /*  ***********************************************************************
     *  Additional  G e t t e r 
     **************************************************************************/

    
    /*  ***********************************************************************
     *  G e t t e r  and  S e t t e r
     **************************************************************************/

    public ChangeLog getCreation() {
        return creation;
    }

    public void setCreation(ChangeLog creation) {
        this.creation = creation;
    }

    public List<ChangeLog> getChangeLogs() {
        return changeLogs;
    }

    public void setChangeLogs(List<ChangeLog> changeLogs) {
        this.changeLogs = changeLogs;
    }
}
