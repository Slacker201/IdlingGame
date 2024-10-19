package src.slacker201.idlegame;
import javax.swing.*;

import src.slUtils.slButton;
import src.slUtils.slVariables.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class IdleGame extends JFrame {
    private String page = "home";
    private JPanel panel;
    private ArrayList<slButton> buttons;      // Panel where the rectangle is drawn

    public IdleGame () {
        setTitle("Idle Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buttons = new ArrayList<>();
        // Add buttons

        buttons.add(new slButton("start", "Start", "home", new Coords(30, 50), 35, 15, new Color(255, 0, 0), null));
        buttons.add(new slButton("addCopperWorker", "home", "Add a copper worker", new Coords(80, 50), 120, 15, new Color(255, 0, 0), null));
        buttons.add(new slButton("goToPage2", "--->", "home", new Coords(80, 100), 20, 15, new Color(255, 0, 0), null));
        buttons.add(new slButton("goToHomePage", "<---", "page2", new Coords(80, 100), 20, 15, new Color(255, 0, 0), null));
        
        
        // Panel where the rectangle is drawn
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Call the method to draw the rectangle between two coordinates

                for (int i = 0; i < buttons.size(); i++) {
                    buttons.get(i).drawButton(g, page);
                }

            }
        };

        // Adding MouseListener to detect clicks and update the screen
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Update coordinates based on click position

                
                // Check if a button is clicked
                for (int i = 0; i < buttons.size(); i++) {
                    boolean wasClicked = buttons.get(i).isClicked(e.getX(), e.getY(), page);
                    if (wasClicked) {
                        if (runButtonCommands(i)) {
                            break;
                        }
                    }

                }
                
                // Repaint the panel to update the rectangle
                panel.repaint();
            }
        });

        add(panel);
        setVisible(true);
    }

    private boolean runButtonCommands (int i) {
        System.out.println("Mouse clicked on button \"" + buttons.get(i).getName() + "\"");

        if (nameEquals(buttons, "goToPage2", i)) {
            page = "page2";
            return true;
        }
        if (nameEquals(buttons, "goToHomePage", i)) {
        page = "home";
            return true;
        }
        return false;
    }

    public boolean nameEquals (ArrayList<slButton> list, String string, int i) {
        return buttons.get(i).getName().equals(string);
    }

}
