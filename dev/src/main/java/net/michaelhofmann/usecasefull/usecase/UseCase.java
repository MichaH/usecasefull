/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */

package net.michaelhofmann.usecasefull.usecase;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    
    private String subtype;
    private String ident;
    private String name;
    private Set<String> actors = new HashSet<>();
    private Description description = new Description();
    private List<Note> notes = new ArrayList<>();
    private Set<String> seeAlsoRef = new HashSet<>();
    private Set<URI> seeAlsoLink = new HashSet<>();
    private Workflow workflow = new Workflow();
    private List<Parameter> parameters = new ArrayList<>();
    private State state = new State();
    
    private AdditionalGetter freemarks = new StandardPlusGetter();

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
            .collect(Collectors.joining(", "));
    }

    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

    public AdditionalGetter getFreemarks() {
        return freemarks;
    }
    
    public String getSubtypePrefix() {
        return "gfall".equalsIgnoreCase(subtype) ? "gf" : "uc";
    }
    
    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
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

    public Set<String> getActors() {
        return actors;
    }

    public void setActors(Set<String> actors) {
        this.actors = actors;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Set<String> getSeeAlsoRef() {
        return seeAlsoRef;
    }

    public void setSeeAlsoRef(Set<String> seeAlsoRef) {
        this.seeAlsoRef = seeAlsoRef;
    }

    public Set<URI> getSeeAlsoLink() {
        return seeAlsoLink;
    }

    public void setSeeAlsoLink(Set<URI> seeAlsoLink) {
        this.seeAlsoLink = seeAlsoLink;
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
}
