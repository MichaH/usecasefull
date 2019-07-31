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
import net.michaelhofmann.usecasefull.tree.Node;
import net.michaelhofmann.usecasefull.tree.NodeRoot;
import net.michaelhofmann.usecasefull.visitor.NodeCallback;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Michael.Hofmann@OrangeObjects.de
 */
public class Traversor {

    private static final Log LOGGER = LogFactory.getLog(Traversor.class);
    
    private final CommandLine cmd;
    private final File inputFile;

    /*  ***********************************************************************
     *  C o n s t r u c t o r
     **************************************************************************/

    public Traversor(CommandLine cmd, File inputFile) {
        this.cmd = cmd;
        this.inputFile = inputFile;
    }

    /*  ***********************************************************************
     *  M i s c
     **************************************************************************/

    void start() throws Exception {
        
        NodeCallback callback = callbackFromCommandline();
        callback.init(cmd);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
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

        InputStream inputStream = new FileInputStream(inputFile);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");

        InputSource is = new InputSource(reader);
        is.setEncoding("UTF-8");
        saxParser.parse(is, handler);
    }

    /*  ***********************************************************************
     *  G e t t e r  and  S e t t e r
     **************************************************************************/

    private NodeCallback callbackFromCommandline()
            throws Exception {
        String clazzName = cmd.getOptionValue("v");
        if (StringUtils.isBlank(clazzName)) {
            throw new Exception("no visitor class given");
        }
        Class clazz = Class.forName(clazzName);
        return (NodeCallback)clazz.newInstance();        
    }
}
