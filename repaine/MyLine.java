package org.example.repaine;

import java.awt.*;

public class MyLine {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public MyLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void drawMe(Graphics g){
        g.setColor(Color.red);

        g.setFont(new Font("隶书",Font.ITALIC | Font.BOLD, 20));
        g.drawString(new String(x1 + "," + y1), x1, y1);
        g.drawString(new String(x2 + "," + y2), x2, y2);

        g.drawLine(x1,y1,x2,y2);
    }
}
