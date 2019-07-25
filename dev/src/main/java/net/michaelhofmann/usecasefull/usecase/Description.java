/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Description {

    private static final Log LOGGER = LogFactory.getLog(Description.class);
    
    private String summary;
    private String detailed;
    private Map<Long, String> variations = new HashMap<>();
    private String link;
        
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public Description() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public Map<Long, String> getVariations() {
        return variations;
    }

    public void setVariations(Map<Long, String> variations) {
        this.variations = variations;
    }

    public String putVariation(Long num, String content) {
        return variations.put(num, content);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
