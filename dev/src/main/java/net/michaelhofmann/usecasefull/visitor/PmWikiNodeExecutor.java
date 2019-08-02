/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.michaelhofmann.usecasefull.definition.Const;
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import net.michaelhofmann.usecasefull.freemarks.StandardPlusGetter;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class PmWikiNodeExecutor implements NodeCallback {

    private static final Log LOGGER = LogFactory.getLog(PmWikiNodeExecutor.class);
    
    public static final DateFormat DATEFORM = new SimpleDateFormat("dd.MM.yyyy");            

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public PmWikiNodeExecutor() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public void init(CommandLine cmd) {
    }

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
        System.out.println("\n\n----");
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
    public void startSummary() {
    }

    @Override
    public void startVariation(long num) {
    }
    
    @Override
    public void startNotes() {
        System.out.println("\n!!!!! Bemerkungen");
    }

    private int actorCounter = 0;
    
    @Override
    public void startActors() {
        System.out.print("\n'''Akteure'''");
        actorCounter = 0;
    }

    @Override
    public void startActor() {
    }

    @Override
    public void startWorkflow() {
        System.out.println("\n!!!!! Workflow");        
    }
    
    @Override
    public void startStep(long order, String actor) {
    }

    @Override
    public void startStepextension(long step, long order) {
    }
    
    @Override
    public void startAdditionalinfo(long num) {
        System.out.println("\n!!!! Zusatzinformation " + num);        
    }
    
    @Override
    public void startContent() {
    }

    @Override
    public void startCode(String layoutSpaces) {
    }
    
    @Override
    public void startInput() {
        System.out.println("\n!!!! Eingangsparameter ");        
    }

    @Override
    public void startParameter() {
    }

    @Override
    public void startParacontent() {
    }
    
    @Override
    public void startParanote() {
    }

    @Override
    public void startState(Date update, int percent) {
    }

    




    
    
    
    @Override
    public void contentIdent(String content) {
        System.out.print(" " + content + "[[#uc" + content + "]]");
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
        content = normalize(content);
        System.out.println(" \n [+" + content + "+]\n ");
    }

    @Override
    public void contentVariation(String content, long num) {
        System.out.println("Variation " + num + ":");
        System.out.println("-> " + content);
    }
    
    @Override
    public void startNote(NoteStereotype stereotype) {
    }

    @Override
    public void contentNote(String content, NoteStereotype stereotype) {
        content = normalize(content);
        if ((stereotype == null) || (NoteStereotype.Default.equals(stereotype))) {
            System.out.println("* " + content);
        } else {
            System.out.println("* <" + stereotype.name() + "> " + content);
        }
    }
    
    @Override
    public void contentActor(String content) {
        if (StringUtils.isNotBlank(content)) {
            content = normalize(content);
            if (actorCounter > 0) {
                System.out.print(", ");
            } else {
                System.out.print(" : ");
            }
            System.out.print(content);
            actorCounter++;
        }
    }

    @Override
    public void contentStep(String content, long order, String actor) {
        if (StringUtils.isNotBlank(content)) {
            content = normalize(content);
            if (StringUtils.isBlank(actor)) {
                System.out.print(order + ". " + content);
            } else {
                System.out.print(order + ". (" + actor + ") " + content);
            }
            System.out.println(" \\\\");
        }        
    }

    @Override
    public void contentStepextension(String content, long step, long order) {
    }
    
    @Override
    public void contentContent(String content) {
        System.out.println(content + " \\\\");
    }

    @Override
    public void contentCode(String content, String layoutSpaces) {
        System.out.println("   " + content);
    }
    
    @Override
    public void contentParacontent(String content) {
        System.out.println("* -> ''" + content + "''");
    }
    
    @Override
    public void contentParanote(String content) {
        content = normalize(content);
        System.out.println("** " + content);
    }

    @Override
    public void contentState(String toString, Date upDate, int percent) {
        StringBuilder sb = new StringBuilder();
        if (percent > 0) {
            sb.append("\n[-'''State''' : ");
            if (upDate != null) {
                sb.append("(").append(DATEFORM.format(upDate)).append(") ");
            }
            sb.append(progressColor(percent));
            sb.append(StandardPlusGetter.getProgressBarWithLabel(percent));
            sb.append(" %%");
            sb.append("-]");
        }
        if (sb.length() > 0) {
            System.out.println(sb.toString());
        }
    }
    
    private String progressColor(int percent) {
        if (percent > 99) {
            return "%green%";
        } else if (percent > 74) {
            return "%blue%";
        } else if (percent > 10) {
            return "%orange%";
        } else if (percent > 0) {
            return "%red%";
        } else {
            return "%black%";
        }
    }
    
    private String normalize(String lines) {
        return lines != null ? lines.replaceAll("\\s*\\n\\s*", " ") : "";
    }

    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
        System.out.println("!!!! nach Ident-Nummer sortiert");
        System.out.println("|| border=0");
        String formatI = "||[[#uc%s|%s%s]] || ||%s ||%s ||";
        ucQueue.stream()
                .filter(u -> StringUtils.isNotBlank(u.getName()))
                .filter(u -> StringUtils.isNotBlank(u.getIdent()))
                .sorted((u1, u2) -> u1.getIdent().compareTo(u2.getIdent()))
                .forEach(u -> {
                    System.out.println(String.format(formatI,
                            u.getIdent(),
                            u.getSubtypePrefix(),
                            u.getIdent(),
                            u.getName(),
                            progressBar4Listing(u)));
        });
        
        System.out.println("!!!! nach Name sortiert");
        System.out.println("|| border=0");
        String formatN = "||[[#uc%s|%s]] || ||%s%s ||%s ||";
        ucQueue.stream()
                .filter(u -> StringUtils.isNotBlank(u.getName()))
                .filter(u -> StringUtils.isNotBlank(u.getIdent()))
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .forEach(u -> {
                    System.out.println(String.format(formatN,
                            u.getIdent(),
                            u.getName(),
                            u.getSubtypePrefix(),
                            u.getIdent(),
                            progressBar4Listing(u)));
        });
    }
    
    private String progressBar4Listing(UseCase u) {
        if (u.getState().getPercent() < 1) {
            return "";
        } else {
            return "[-" + progressColor(u.getState().getPercent())
                    + StandardPlusGetter.getProgressBarWithLabel(u.getState().getPercent()) + "-]";
        }
    }

}
