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
    private List<String> notes = new ArrayList<>();
    private Set<String> seeAlsoRef = new HashSet<>();
    private Set<URI> seeAlsoLink = new HashSet<>();

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public UseCase() {
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/


    /*  ***********************************************************************
     *  G e t t e r  und  S e t t e r
     **************************************************************************/

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

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
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
}
