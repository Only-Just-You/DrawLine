package org.example.repaine;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.Vector;

public class DrawLine extends Frame {
    Vector vLines = new Vector();

    public static void main(String[] args) {
        new DrawLine().init();
    }

    private void init() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                ((Window) e.getSource()).dispose();
                System.exit(0);
            }
        });
        addMouseListener(new MouseAdapter() {
            int orgX;
            int orgY;

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                orgX = e.getX();
                orgY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                Graphics g = e.getComponent().getGraphics();

                g.setFont(new Font("隶书",Font.ITALIC | Font.BOLD, 20));
                g.setColor(Color.red);

                g.drawString(new String(orgX + "," + orgY), orgX, orgY);
                g.drawString(new String(e.getX() + "," + e.getY()), e.getX(), e.getY());

                g.drawLine(orgX, orgY, e.getX(), e.getY());

                vLines.add(new MyLine(orgX, orgY, e.getX(), e.getY()));
            }
        });
        this.setSize(300,300);
        this.setTitle("鼠标绘直线");
        this.setLocation(350,350);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);

        Enumeration e = vLines.elements();
        while(e.hasMoreElements()){
            MyLine ln = (MyLine) e.nextElement();
            ln.drawMe(g);
        }
    }
}
