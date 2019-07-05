/*
 *  O R A N G E   O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 */
package net.michaelhofmann.usecasefull;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import net.michaelhofmann.usecasefull.tree.NodeRoot;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import net.michaelhofmann.usecasefull.tree.Node;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import net.michaelhofmann.usecasefull.visitor.PmWikiNodeExecutor;
import net.michaelhofmann.usecasefull.visitor.StdoutNodeExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Parse {
    
    private static final Log LOGGER = LogFactory.getLog(Parse.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Parse().start();
    }

    private void start() {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // NodeCallback callback = new StdoutNodeExecutor();
            NodeCallback callback = new PmWikiNodeExecutor();
            
            final NodeRoot nodeRoot = new NodeRoot(null, callback);

            DefaultHandler handler = new DefaultHandler() {
                
                Node pointer = nodeRoot;

                @Override
                public void startDocument() throws SAXException {
                    pointer.startDocument();
                }

                @Override
                public void startElement(String uri, String localName,
                        String element, Attributes attributes)
                        throws SAXException {
                    
                    // System.out.println("startElement = " + element);
                    pointer = pointer.startElement(
                            uri, localName, element, attributes);
                }

                @Override
                public void endElement(String uri, String localName,
                        String element)
                        throws SAXException {

                    // System.out.println("endElement = " + element);
                    pointer = pointer.endElement(uri, localName, element);
                }

                @Override
                public void characters(char ch[], int start, int length)
                        throws SAXException {
                    String content = new String(ch, start, length);
                    LOGGER.debug("content = " + content);
                    pointer.addCcontent(content);
                }
            };

            File file = new File("C:\\proj\\wob\\abis\\AbisClient\\sysdoc\\AbisDataDicUseCases.xml");
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            System.out.println("Parsing.......");
            
            saxParser.parse(is, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
