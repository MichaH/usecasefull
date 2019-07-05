/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.visitor;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public interface NodeCallback {

    public void startUsecases();
    public void startUsecase();
    public void startIdent();
    public void startSubtype();
    public void startName();
    public void startDescription();

    public void contentSubtype(String content);
    public void contentIdent(String content);
    public void contentName(String content);
    public void contentSummary(String content);

    
}
