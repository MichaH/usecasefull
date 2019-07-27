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
public class AgenUseCases2Parameter extends SimpleNopExecutor {

    private static final Log LOGGER = LogFactory.getLog(AgenUseCases2Parameter.class);

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public AgenUseCases2Parameter() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/
    
    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
        String formatI = ""
                + "%s.generatoren=AopDescription, AgrupDescription\n"
                + "%s.ablaufAopPackage=com.orangeobjects.eabis.operator.business.domain.service.hardware.operation\n"
                + "%s.ablaufAgrupPackage=com.orangeobjects.eabis.operator.business.domain.service.hardware.gruppe\n"
                + "%s.descriptionClass=com.orangeobjects.abis.elements.domain.hardware.MobHwServiceDescription\n";
        ucQueue.stream()
                .filter(u -> StringUtils.isNotBlank(u.getName()))
                .sorted((u1, u2) -> u1.getIdent().compareTo(u2.getIdent()))
                .forEach(u -> {
                    System.out.println(String.format(formatI,
                            u.getName(), u.getName(), u.getName(), u.getName()));
        });
    }
    
    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
}
