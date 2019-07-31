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
    VeryHighSummary("++", "\u2601"),  // https://www.fileformat.info/info/unicode/char/2601/index.htm
    Summary("+", ""), 	
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