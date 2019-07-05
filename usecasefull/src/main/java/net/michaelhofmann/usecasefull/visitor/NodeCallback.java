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
    public void startId();

    public void contentId(String content);
    public void contentSubtype(String content);
    
}
