package com.ArestiKramer.JabberPoint.accessor;

/**
 * <p>This is the XMLAccessor, it reads and writes XML files</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 **/

import com.ArestiKramer.JabberPoint.presentation.Presentation;
import com.ArestiKramer.JabberPoint.slide.Slide;
import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.slideitem.items.TextItem;
import com.ArestiKramer.JabberPoint.style.StyleOptions;
import com.ArestiKramer.JabberPoint.style.styles.Style;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLAccessor extends Accessor {

    private static final Logger LOGGER = Logger.getLogger(XMLAccessor.class.getName());
    private static final String SHOW_TITLE = "show title";
    private static final String SLIDE = "slide";
    private static final String TITLE = "title";
    private static final String ITEM = "item";
    private static final String KIND = "kind";
    private static final String TEXT = "text";
    private static final String IMAGE = "image";

    private String getTitle(Element element, String tagName) {
        NodeList titles = element.getElementsByTagName(tagName);
        return titles.item(0).getTextContent();
    }

    @Override
    public void loadFile(Presentation presentation, String filename) throws IOException {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTitle(doc, SHOW_TITLE));
            loadSlides(presentation, doc);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            LOGGER.log(Level.SEVERE, "Error loading file", e);
        }
    }

    private void loadSlides(Presentation presentation, Element doc) {
        NodeList slides = doc.getElementsByTagName(SLIDE);
        for (int slideNumber = 0; slideNumber < slides.getLength(); slideNumber++) {
            Element xmlSlide = (Element) slides.item(slideNumber);
            Slide slide = new Slide();
            slide.setTitle(getTitle(xmlSlide, TITLE));
            presentation.append(slide);
            loadSlideItems(slide, xmlSlide);
        }
    }

    private void loadSlideItems(Slide slide, Element xmlSlide) {
        NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
        for (int itemNumber = 0; itemNumber < slideItems.getLength(); itemNumber++) {
            Element item = (Element) slideItems.item(itemNumber);
            loadSlideItem(slide, item);
        }
    }

    protected void loadSlideItem(Slide slide, Element item) {
        String type = getAttribute(item, KIND);
        StyleOptions styleOptions = new StyleOptions();
        Style style = styleOptions.getText();

        if (TEXT.equals(type)) {
            slide.appendTextItem(style, item.getTextContent());
        } else if (IMAGE.equals(type)) {
            slide.appendBitMapItem(style, item.getTextContent());
        } else {
            LOGGER.warning("Unknown Element type: " + type);
        }
    }

    private String getAttribute(Element item, String attribute) {
        NamedNodeMap attributes = item.getAttributes();
        return attributes.getNamedItem(attribute).getTextContent();
    }

    @Override
    public void saveFile(Presentation presentation, String filename) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            writePresentation(presentation, out);
        }
    }

    private void writePresentation(Presentation presentation, PrintWriter out) {
        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
        out.println("<presentation>");
        out.printf("<%s>%s</%s>%n", SHOW_TITLE, presentation.getTitle(), SHOW_TITLE);
        for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++) {
            writeSlide(presentation.getSlide(slideNumber), out);
        }
        out.println("</presentation>");
    }

    private void writeSlide(Slide slide, PrintWriter out) {
        out.println("<slide>");
        out.printf("<%s>%s</%s>%n", TITLE, slide.getTitle(), TITLE);
        for (SlideItem slideItem : slide.getSlideItems()) {
            writeSlideItem(slideItem, out);
        }
        out.println("</slide>");
    }

    private void writeSlideItem(SlideItem slideItem, PrintWriter out) {
        out.printf("<item kind=\"%s\" style=\"%s\">", slideItem instanceof TextItem ? TEXT : IMAGE, slideItem.getStyle());
        out.print(slideItem.getText());
        out.println("</item>");
    }
}
