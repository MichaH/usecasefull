/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.definition;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public enum Scope {
    
    Unknown("&#9888;"),
    OrganizationBlackbox("&#9751;"),   // ok
    OrganizationWhitebox("&#9750;"),   // ok
    SystemBlackbox("&#9632;"),         // ok
    SystemWhitebox("&#9744;"),         // ok
    Component("&#9874;");            
    
    private final String symbol;
    
    Scope(String symbol) {
        this.symbol = symbol;
    }
    
    public String toSymbol() {
        return symbol;
    }
    
    public String getSymbol() {
        return symbol;
    }
}
