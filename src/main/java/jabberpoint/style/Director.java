package jabberpoint.style;


import jabberpoint.style.builder.StyleBuilder;

import java.awt.Color;

/** <p>This is the Director, through this class the creation of styles is requested</p>
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class Director {

    public void constructTitleOneStyle(StyleBuilder builder){
        builder.setIndent(0);
        builder.setColor(Color.green);
        builder.setFontSize(48);
        builder.setLeading(20);
    }

    public void constructTitleTwoStyle(StyleBuilder builder){
        builder.setIndent(0);
        builder.setColor(Color.red);
        builder.setFontSize(48);
        builder.setLeading(20);
    }

    public void constructSubtitleOneStyle(StyleBuilder builder){
        builder.setIndent(20);
        builder.setColor(Color.blue);
        builder.setFontSize(40);
        builder.setLeading(10);
    }

    public void constructSubtitleTwoStyle(StyleBuilder builder){
        builder.setIndent(20);
        builder.setColor(Color.pink);
        builder.setFontSize(40);
        builder.setLeading(10);
    }

    public void constructTextStyle(StyleBuilder builder){
        builder.setIndent(50);
        builder.setColor(Color.black);
        builder.setFontSize(36);
        builder.setLeading(10);
    }

}
