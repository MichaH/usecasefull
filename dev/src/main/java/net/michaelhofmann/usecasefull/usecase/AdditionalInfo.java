/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class AdditionalInfo extends AbstractContainer {

    private static final Log LOGGER = LogFactory.getLog(AdditionalInfo.class);
    
    private int num;
    private String content;
    private List<String> notes = new ArrayList<>();
    private String code;
    private String codePrefix;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public AdditionalInfo() {
    }

    public AdditionalInfo(int num) {
        this.num = num;
    }

    public AdditionalInfo(int num, String content) {
        this.num = num;
        this.content = content;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix;
    }
}
