/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.michaelhofmann.usecasefull.definition.GoalLevel;
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import net.michaelhofmann.usecasefull.definition.Scope;
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
public class PmWikiNodeExecutor extends SimpleNopExecutor {

    private static final Log LOGGER = LogFactory.getLog(PmWikiNodeExecutor.class);
    
    public static final DateFormat DATEFORM = new SimpleDateFormat("dd.MM.yyyy");    
    
    private BufferedWriter out;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public PmWikiNodeExecutor() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public void init(CommandLine cmd) throws Exception {
        super.init(cmd);
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    private void writeln(String str) {
        write(str);
        write("\n");
    }
    
    private void write(String str) {
        try {
            out.write(str.toCharArray());
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
    
    
    @Override
    public void startDocument() {
        try {
            out = Files.newBufferedWriter(outputFilePath, charset, getOpenOptions());
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void endDocument() {
        try {
            out.flush();
            out.close();
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
    
    @Override
    public void startUsecases() {
    }

    @Override
    public void startUsecase() {
        writeln("\n\n----");
        write("!!! ");
    }

    @Override
    public void startIdent() {
    }

    @Override
    public void startSubtype(Scope scope, GoalLevel goalLevel) {
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
        writeln("\n!!!!! Bemerkungen");
    }

    private int actorCounter = 0;
    
    @Override
    public void startActors() {
        write("\n'''Akteure'''");
        actorCounter = 0;
    }

    @Override
    public void startActor() {
    }

    @Override
    public void startWorkflow() {
        writeln("\n!!!!! Workflow");        
    }
    
    @Override
    public void startStep(long order, String actor) {
    }

    @Override
    public void startStepextension(long step, long order) {
    }
    
    @Override
    public void startAdditionalinfo(long num) {
        writeln("\n!!!! Zusatzinformation " + num);        
    }
    
    @Override
    public void startContent() {
    }

    @Override
    public void startAdditionalNote() {
    }
    
    @Override
    public void startCode(String layoutSpaces) {
    }
    
    @Override
    public void startInput() {
        writeln("\n!!!! Eingangsparameter ");        
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
    public void startProcessInstruction(String attributeProcess) {
    }



    
    
    
    @Override
    public void contentIdent(String content) {
        write(" " + content + "[[#uc" + content + "]]");
    }

    @Override
    public void contentSubtype(String typeName, Scope scope, GoalLevel goalLevel) {
        write(typeName);
    }

    @Override
    public void contentName(String content) {
        writeln(" | " + content);
    }

    @Override
    public void contentSummary(String content) {
        content = normalize(content);
        writeln(" \n [+" + content + "+]\n ");
    }

    @Override
    public void contentVariation(String content, long num) {
        writeln("Variation " + num + ":");
        writeln("-> " + content);
    }
    
    @Override
    public void startNote(NoteStereotype stereotype) {
    }

    @Override
    public void contentNote(String content, NoteStereotype stereotype) {
        content = normalize(content);
        if ((stereotype == null) || (NoteStereotype.Default.equals(stereotype))) {
            writeln("* " + content);
        } else {
            writeln("* <" + stereotype.name() + "> " + content);
        }
    }
    
    @Override
    public void contentActor(String content) {
        if (StringUtils.isNotBlank(content)) {
            content = normalize(content);
            if (actorCounter > 0) {
                write(", ");
            } else {
                write(" : ");
            }
            write(content);
            actorCounter++;
        }
    }

    @Override
    public void contentStep(String content, long order, String actor) {
        if (StringUtils.isNotBlank(content)) {
            content = normalize(content);
            if (StringUtils.isBlank(actor)) {
                write(order + ". " + content);
            } else {
                write(order + ". (" + actor + ") " + content);
            }
            writeln(" \\\\");
        }        
    }

    @Override
    public void contentStepextension(String content, long step, long order) {
    }
    
    @Override
    public void contentContent(String content) {
        writeln(content + " \\\\");
    }

    @Override
    public void contentAdditionalNote(String content) {
    }
    
    @Override
    public void contentCode(String content, String layoutSpaces) {
        writeln("   " + content);
    }
    
    @Override
    public void contentParacontent(String content) {
        writeln("* -> ''" + content + "''");
    }
    
    @Override
    public void contentParanote(String content) {
        content = normalize(content);
        writeln("** " + content);
    }

    @Override
    public void contentState(String toString, Date upDate, int percent) {
        StringBuilder sb = new StringBuilder();
        if (percent > 0) {
            sb.append("\n[-'''Status''' : ");
            if (upDate != null) {
                sb.append("(").append(DATEFORM.format(upDate)).append(") ");
            }
            sb.append(progressColor(percent));
            sb.append(StandardPlusGetter.getProgressBarWithLabel(percent));
            sb.append(" %%");
            sb.append("-]");
        }
        if (sb.length() > 0) {
            writeln(sb.toString());
        }
    }

    @Override
    public void contentProcessInstruction(String process, String text) {
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
//        writeln("!!!! nach Ident-Nummer sortiert");
//        writeln("|| border=0");
//        String formatI = "||[[#uc%s|%s%s]] || ||%s ||%s ||";
//        ucQueue.stream()
//                .filter(u -> StringUtils.isNotBlank(u.getName()))
//                .filter(u -> StringUtils.isNotBlank(u.getIdent()))
//                .sorted((u1, u2) -> u1.getIdent().compareTo(u2.getIdent()))
//                .forEach(u -> {
//                    writeln(String.format(formatI,
//                            u.getIdent(),
//                            u.getSubtypePrefix(),
//                            u.getIdent(),
//                            u.getName(),
//                            progressBar4Listing(u)));
//        });
//        
//        writeln("!!!! nach Name sortiert");
//        writeln("|| border=0");
//        String formatN = "||[[#uc%s|%s]] || ||%s%s ||%s ||";
//        ucQueue.stream()
//                .filter(u -> StringUtils.isNotBlank(u.getName()))
//                .filter(u -> StringUtils.isNotBlank(u.getIdent()))
//                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
//                .forEach(u -> {
//                    writeln(String.format(formatN,
//                            u.getIdent(),
//                            u.getName(),
//                            u.getSubtypePrefix(),
//                            u.getIdent(),
//                            progressBar4Listing(u)));
//        });
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
