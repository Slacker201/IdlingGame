package src.slUtils;
import java.awt.FontMetrics;
import java.awt.Graphics;

import src.slUtils.slVariables.*;

import java.awt.Color;
public class slButton {
    
    private String name, text, page;
    private int width, height;
    private Coords location;
    private Color backgroundColor, textColor;

    public slButton (   
            String name,
            String text,
            String page,
            Coords location, 
            int width, 
            int height,
            Color backgroundColor,
            Color textColor
            ) 
        {
        this.name = name;
        this.text = text;
        this.location = location;
        this.width = width;
        this.height = height;
        this.page = page;
        
        if (backgroundColor == null) {
            this.backgroundColor = new Color(211, 211, 211); // Light grey
        } else this.backgroundColor = backgroundColor;
        System.out.println(this.backgroundColor);
        if (textColor == null) {
            this.textColor = new Color(40, 40, 40); // Dark grey
        } else {
            this.textColor = textColor;
        }
        
    }

    public void drawButton(Graphics g, String page) {
        if (page.equals(this.page)) {

    
            // Set background color and draw the button rectangle
            g.setColor(this.backgroundColor);
            g.fillRect(this.location.getX(), this.location.getY(), width, height);
    
            FontMetrics metrics = g.getFontMetrics();
            int textWidth = metrics.stringWidth(this.text);
            int textHeight = metrics.getHeight();
            textHeight *= 1.1f;
    
            Coords textLocation = getAverageCoords(location, new Coords(location.getX() + width, location.getY() + height));
    
            // Set text color and draw the button text
            g.setColor(this.textColor);
            g.drawString(this.text, textLocation.getX() - textWidth / 2, textLocation.getY() + textHeight / 2);
        }
    }
    

    public boolean isClicked (int mouseX, int mouseY, String currentPage) {
        if ((
        mouseX < (location.getX()+width) && mouseX > location.getX())
        && 
        (mouseY < (location.getY()+height) && mouseY > location.getY())
        && 
        currentPage.equals(this.page)
        ) {
            return true;
        } else {
            return false;
        }
        
        

        
    }

    private Coords getAverageCoords (Coords a, Coords b) {
        Coords resultCoords = new Coords((a.getX()+b.getX())/2, (a.getY()+b.getY())/2);


        return resultCoords;
    }

    public String getName() {
        return this.name;
    }
}