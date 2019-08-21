/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.visitor;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import net.michaelhofmann.usecasefull.definition.GoalLevel;
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import net.michaelhofmann.usecasefull.definition.Scope;
import net.michaelhofmann.usecasefull.usecase.UseCase;
import net.michaelhofmann.usecasefull.usecase.UseCaseQueue;
import net.michaelhofmann.usecasefull.util.Jobinfo;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class SimpleNopExecutor implements NodeCallback {

    private static final Log LOGGER = LogFactory.getLog(SimpleNopExecutor.class);
    
    protected final String CHARSET = "UTF-8";
    protected final Charset charset;
    protected CommandLine cmd;
    protected Path outputFilePath;
    protected Comparator<UseCase> comparator;
    

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public SimpleNopExecutor() {
        charset = Charset.forName(CHARSET);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    @Override
    public void init(CommandLine cmd) throws Exception {
        this.cmd = cmd;
        equipOutputfileName(cmd);
        equipComparator(cmd);
    }
    
    private void equipComparator(CommandLine cmd) throws IOException {
        String sortField = cmd.getOptionValue("s");
        if (StringUtils.isBlank(sortField)) {
            LOGGER.debug("default sorting by name");
            sortField = "name";
        }
        switch (sortField.toLowerCase().trim()) {
            case "ident":
                comparator = (UseCase u1, UseCase u2) -> {
                    return u1.getIdent().compareTo(u2.getIdent());
                };
                break;
            case "name":
                comparator = (UseCase u1, UseCase u2) -> {
                    return u1.getName().compareTo(u2.getName());
                };
                break;
            default:
                throw new IllegalArgumentException("unknown sort field");
        }
    }
    
    private void equipOutputfileName(CommandLine cmd) throws IOException {
        String outputFileName = cmd.getOptionValue("of");
        if (StringUtils.isBlank(outputFileName)) {
            throw new IOException(
                    "no output filename given, please use -of");
        }
        outputFilePath = Paths.get(outputFileName);
        Jobinfo.getInstance().setOutputFile(outputFilePath);
    }

    protected OpenOption[] getOpenOptions() {
        Set<OpenOption> fileOptions = new HashSet<>();
        if (cmd.hasOption("a")) {
            fileOptions.add(StandardOpenOption.APPEND);
        }
        return fileOptions.toArray(new OpenOption[fileOptions.size()]);
    }
    
    
    
    @Override
    public void startDocument() {

    }

    @Override
    public void endDocument() {
    }
    
    @Override
    public void startUsecases() {
        
    }

    @Override
    public void startUsecase() {
        
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
    public void startActors() {
        
    }

    @Override
    public void startActor() {
        
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
        
    }

    @Override
    public void startNote(NoteStereotype stereotype) {
    }

    @Override
    public void startWorkflow() {
    }

    @Override
    public void startStep(long attributeOrder, String attributeActor) {
        
    }

    @Override
    public void startStepextension(long step, long order) {
        
    }

    @Override
    public void startAdditionalinfo(long num) {
        
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
    public void contentSubtype(String typeName, Scope scope, GoalLevel goalLevel) {
    }

    @Override
    public void contentIdent(String content) {
        
    }

    @Override
    public void contentName(String content) {
        
    }

    @Override
    public void contentActor(String content) {
        
    }

    @Override
    public void contentSummary(String content) {
        
    }

    @Override
    public void contentVariation(String toString, long num) {
        
    }

    @Override
    public void contentNote(String content, NoteStereotype stereotype) {
    }

    @Override
    public void contentStep(String toString, long order, String actor) {
        
    }

    @Override
    public void contentStepextension(String toString, long step, long order) {
        
    }

    @Override
    public void contentContent(String toString) {
        
    }

    @Override
    public void contentAdditionalNote(String content) {
    }

    @Override
    public void contentCode(String content, String layoutSpaces) {
        
    }

    @Override
    public void contentParacontent(String toString) {
        
    }

    @Override
    public void contentParanote(String toString) {
    }

    @Override
    public void contentState(String toString, Date upDate, int percent) {
    }


    @Override
    public void contentProcessInstruction(String process, String text) {
    }


    
    @Override
    public void finishedQueue(UseCaseQueue ucQueue) {
        
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/
}
