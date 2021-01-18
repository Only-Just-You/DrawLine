package org.example.buffer;

import org.example.repaine.MyLine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawLine extends Frame {
    Image oimg = null;
    Graphics og = null;

    public static void main(String[] args) {
        new DrawLine().init();
    }

    private void init() {
        this.setSize(300,300);
        this.setLocation(350,350);
        this.setVisible(true);
        this.setTitle("鼠标绘直线");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                ((Window) e.getSource()).dispose();
                System.exit(0);
            }
        });

        Dimension d = getSize();
        oimg = createImage(d.width, d.height);
        og = oimg.getGraphics();

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
                Graphics g = getGraphics();
                g.setColor(Color.red);

                g.setFont(new Font("隶书",Font.ITALIC | Font.BOLD, 20));
                g.drawString(new String(orgX + "," + orgY), orgX, orgY);
                g.drawString(new String(e.getX() + "," + e.getY()), e.getX(), e.getY());

                MyLine line = new MyLine(orgX, orgY, e.getX(), e.getY());

                line.drawMe(g);

                og.setColor(Color.red);
                og.setFont(new Font("隶书",Font.ITALIC | Font.BOLD, 20));
                og.drawString(new String(orgX + "," + orgY), orgX, orgY);
                og.drawString(new String(e.getX() + "," + e.getY()), e.getX(), e.getY());

                line.drawMe(og);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(oimg != null)
            g.drawImage(oimg, 0, 0, this);
    }
}
