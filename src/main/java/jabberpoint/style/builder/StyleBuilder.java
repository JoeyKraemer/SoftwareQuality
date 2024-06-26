package jabberpoint.style.builder;

import java.awt.*;

/** <p>This is a StyleBuilder, it creates the steps to build a style</p>
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public interface StyleBuilder {

	 void setIndent(int indent);
	 void setColor(Color color);
	 void setFontSize(int fontSize);
	 void setLeading(int leading);
}
