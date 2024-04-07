package jabberpoint.accessor;

import java.util.Vector;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jabberpoint.presentation.Presentation;
import jabberpoint.slide.Slide;
import jabberpoint.slideitem.SlideItem;
import jabberpoint.slideitem.items.BitmapItem;
import jabberpoint.slideitem.items.TextItem;
import jabberpoint.style.StyleOptions;
import jabberpoint.style.styles.Style;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;


/**
 * <p>This is the XMLAccessor, it reads and writes XML files</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class XMLAccessor extends Accessor {

    private String getTitle(Element element, String tagName) {
        NodeList titles = element.getElementsByTagName(tagName);
        return titles.item(0).getTextContent();

    }

    public void loadFile(Presentation presentation, String filename) throws IOException {
        int slideNumber = 0;
        int itemNumber = 0;
        int max = 0;
        int maxItems = 0;

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(filename)); // Create a JDOM document
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTitle(doc, "Show Title"));

            NodeList slides = doc.getElementsByTagName("slide");
            max = slides.getLength();

            for (slideNumber = 0; slideNumber < max; slideNumber++) {
                Element xmlSlide = (Element) slides.item(slideNumber);
                Slide slide = new Slide();
                slide.setTitle(getTitle(xmlSlide, "title"));
                presentation.append(slide);

                NodeList slideItems = xmlSlide.getElementsByTagName("item");
                maxItems = slideItems.getLength();
                for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
                    Element item = (Element) slideItems.item(itemNumber);
                    loadSlideItem(slide, item);
                }
            }
        } catch (IOException iox) {
            System.err.println(iox.toString());
        } catch (SAXException sax) {
            System.err.println(sax.getMessage());
        } catch (ParserConfigurationException pcx) {
            System.err.println("Parser Configuration Exception");
        }
    }

    protected void loadSlideItem(Slide slide, Element item) {
        int level = 1; // default
        StyleOptions styleOptions = new StyleOptions();
        Style style = styleOptions.getText();
        NamedNodeMap attributes = item.getAttributes();

        String leveltext = attributes.getNamedItem("level").getTextContent();

        if (leveltext != null) {
            try {
                level = Integer.parseInt(leveltext);
            } catch (NumberFormatException x) {
                System.err.println("Number Format Exception");
            }
        }

        String type = attributes.getNamedItem("kind").getTextContent();

        if ("text".equals(type)) {
            slide.appendTextItem(style, item.getTextContent());
        } else {
            if ("image".equals(type)) {
                slide.appendBitMapItem(style, item.getTextContent());
            } else {
                System.err.println("Unknown Element type");
            }
        }
    }

    public void saveFile(Presentation presentation, String filename) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filename));
        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
        out.println("<presentation>");
        out.print("<showtitle>");
        out.print(presentation.getTitle());
        out.println("</showtitle>");
        for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++) {
            Slide slide = presentation.getSlide(slideNumber);
            out.println("<slide>");
            out.println("<title>" + slide.getTitle() + "</title>");
            Vector<SlideItem> slideItems = slide.getSlideItems();
            for (int itemNumber = 0; itemNumber < slideItems.size(); itemNumber++) {
                SlideItem slideItem = (SlideItem) slideItems.elementAt(itemNumber);
                out.print("<item kind=");
                if (slideItem instanceof TextItem) {
                    out.print("\"text\" style=\"" + slideItem.getStyle() + "\">");
                    out.print(((TextItem) slideItem).getText());
                } else {
                    if (slideItem instanceof BitmapItem) {
                        out.print("\"image\" style=\"" + slideItem.getStyle() + "\">");
                        out.print(((BitmapItem) slideItem).getImageName());
                    } else {
                        System.out.println("Ignoring " + slideItem);
                    }
                }
                out.println("</item>");
            }
            out.println("</slide>");
        }
        out.println("</presentation>");
        out.close();
    }
}
