/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.michaelhofmann.usecasefull.definition.NoteStereotype;
import net.michaelhofmann.usecasefull.freemarks.AdditionalGetter;
import net.michaelhofmann.usecasefull.freemarks.StandardPlusGetter;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class UseCase {
    
    private AdditionalGetter freemarks = new StandardPlusGetter();

    private Subtype subtype = new Subtype();
    private String ident;
    private String name;
    private Description description = new Description();
    private Set<Actor> actors = new HashSet<>();
    private List<Parameter> parameters = new ArrayList<>();
    private List<Note> notes = new ArrayList<>();
    private Workflow workflow = new Workflow();
    private Set<Reference> includes = new HashSet<>();
    private Map<Integer, AdditionalInfo> additionalInfos = new HashMap<>();
    private Set<Reference> seeAlsoSet = new HashSet<>();
    private History history = new History();
    private State state = new State();
    private Set<String> tags = new HashSet<>();
    private List<ProcessInstruction> processInstructions = new ArrayList<>();

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public UseCase() {
        freemarks.init(this);
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    public boolean add(Note e) {
        return notes.add(e);
    }
    
    public boolean addNote(String content, NoteStereotype stereotype) {
        return notes.add(new Note(content, stereotype));
    }

    /*  ***********************************************************************
     *  Derived  G e t t e r
     **************************************************************************/
    
    public String getActorsInline() {
        return actors.stream()
                .map(a -> a.getName())
                .collect(Collectors.joining(", "));
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public AdditionalGetter getFreemarks() {
        return freemarks;
    }
    
    public String getSubtypePrefix() {
        return "gfall".equalsIgnoreCase(subtype.getTypeName()) ? "gf" : "uc";
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public Subtype getSubtype() {
        return subtype;
    }

    public void setSubtype(Subtype subtype) {
        this.subtype = subtype;
    }
    
    public Set<Actor> getActors() {
        return actors;
    }
    
    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
    
    public Set<Reference> getIncludes() {
        return includes;
    }

    public void setIncludes(Set<Reference> includes) {
        this.includes = includes;
    }
    
    public Map<Integer, AdditionalInfo> getAdditionalInfos() {
        return additionalInfos;
    }

    public void setAdditionalInfos(Map<Integer, AdditionalInfo> additionalInfos) {
        this.additionalInfos = additionalInfos;
    }
    
    public Set<Reference> getSeeAlsoSet() {
        return seeAlsoSet;
    }

    public void setSeeAlsoSet(Set<Reference> seeAlsoSet) {
        this.seeAlsoSet = seeAlsoSet;
    }
    
    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
    
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
    
    public List<ProcessInstruction> getProcessInstructions() {
        return processInstructions;
    }

    public void setProcessInstructions(List<ProcessInstruction> processInstructions) {
        this.processInstructions = processInstructions;
    }
}
