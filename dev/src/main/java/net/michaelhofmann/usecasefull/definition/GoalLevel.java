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
public enum GoalLevel {
    Unknown("?", "&#9888;"),
    VeryHighSummary("++", "&#9729;"),
    Summary("+", "&#9992;"), 	
    UserGoal("!", ""), 	
    Subfunction("-", ""), 	
    TooLow("--", "");

    private final String sign;
    private final String symbol;
    
    GoalLevel(String sign, String symbol) {
        this.sign = sign;
        this.symbol = symbol;
    }
    
    public String toSign() {
        return sign;
    }
    
    public String toSymbol() {
        return symbol;
    }
}