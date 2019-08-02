/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.freemarks;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
final public class StandardPlusGetter implements AdditionalGetter {

    private static final Log LOGGER = LogFactory.getLog(StandardPlusGetter.class);

    private UseCase usecase;
    
    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public StandardPlusGetter() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    final public void init(UseCase usecase) {
        this.usecase = usecase;
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public static String getProgressBarWithLabel(int percent) {
        // normalize
        percent = percent < 0 ? 0 : percent;
        percent = percent > 100 ? 100 : percent;
        switch (percent) {
            case 0:
                return "- 0%";
            case 1:
                return "# 1%";
            default:
                int repeat = percent / 2;
                return StringUtils.repeat("#", repeat) + " " + percent + "%";
        }
    }

    public String getProgressBarWithLabel() {
        return getProgressBarWithLabel(usecase.getState().getPercent());
    }
}
