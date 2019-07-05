/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull.tree;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public interface Node {

    public Node startElement(String uri, String localName, String elementName, 
            Attributes attributes)
            throws SAXException;
    public Node startElement(Element element, Attributes attributes)
            throws SAXException;

    public Node endElement(String uri, String localName, String elementName);
    public Node endElement(Element element);
    
    public void addCcontent(String content);
}
