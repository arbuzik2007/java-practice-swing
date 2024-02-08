import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        JFrame jTrafficFrame = getFrame();
        jTrafficFrame.add(new TrafficLight());
        JFrame jSnowmanFrame = getFrame();
        jSnowmanFrame.add(new Snowman());
    }
    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2-250,
                dimension.height/2 - 150,
                500,
                300);
        return jFrame;
    }

    static class Snowman extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            int x = 100, x1 = 400, y = 20, w=80, h=50;
            //head
            g.drawOval(x1 / 2 - 5, y + (h * 2 / 3), w + 10, (int) (h*1.7));
            int faceY = (int) (y + (1.6 * h));
            int faceX = x1 / 2 + w / 2;
            //eyes
            g.drawOval(faceX - 5, faceY - 15, 7, 7);
            g.drawOval(faceX + 20, faceY - 15, 7, 7);
            //nose
            g.drawPolygon(new int[]{faceX + 15, faceX + 10, faceX + w + 8},
                    new int[]{faceY - 7 + w/4, faceY - w / 3 + w/4, (int) (faceY - h + (w*0.5))},
                    3);
            //torso
            int h1 = (int)2.75*h, w1 = 45;
            g.drawOval(x1 / 2 - w1/2, y + h1, w + w1, h1);
            int handW = 3, handH = 10;
            g.drawPolygon(new int[]{x, x + handW, (int) (x1 - 2.5 * w), (int) (x1 - 2.5 * w + handW)},
                    new int[]{y + h1 - handH, y + h1, y + h1 + h1 / 2, y + h1 + h1 / 2 - handH}, 4);
            g.drawPolygon(new int[]{(int) (x + 2.5 * w), (int) (x + 2.5 * w + handW), (int) (x1) -10, (int) (x1 + handW - 10)},
                    new int[]{y + h1 + h1 / 2, y + h1 + h1 / 2 - handH, y + h1 - handH, y + h1}, 4);
//            int fingerW = 8, fingerH = 9;
//            g.drawPolygon(new int[]{x + 3, x + 3 + fingerW, x+fingerW+4, x + 4 + fingerW + fingerW},
//                    new int[]{y + h1 - fingerH, y,y, y + h1}, 4);
            //bottom
            int h2 = 3*h, w2 = 60;
            g.drawOval(x1 / 2 - w2/2, y + h2, w + w2, h2);
            //hat
            g.drawRoundRect(x1 / 2, y, w, h, 10, 10);
            g.setColor(Color.white);
            g.fillOval(x1/ 2 - 14, y + h - 5, w + 28, h / 3);
            g.setColor(Color.black);
            g.drawOval(x1/ 2 - 14, y + h - 5, w + 28, h / 3);
            RoundRectangle2D rect = new RoundRectangle2D.Double(x1 / 2, y + (h * 2) / 3, w, h / 3, 1, 10);
            g2.setPaint(Color.white);
            g2.fill(rect);
            g2.setPaint(Color.black);
            g2.draw(rect);
            super.paintComponent(g);
        }
    }
    static class TrafficLight extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            ArrayList<Shape> toColour = new ArrayList<>();
            int x = 100, y = 100, w = 105, h = 50;
            Arc2D circle = new Arc2D.Double(x, y, w, h, 180, -180, Arc2D.OPEN);
            toColour.add(circle);
            //body
            toColour.add(new RoundRectangle2D.Float(x - 10,
                    y + h - 15,
                    w + 20,
                    325,
                    10,
                    10));
            //bottom part
            toColour.add(new RoundRectangle2D.Float((x + w + 20) / 2 + 10,
                    y + h + 325,
                    (w + 20) / 2,
                    40,
                    10,
                    10));
            //left side wings
            int x1 = 30, y1 = y + 300 / 3 - 45;
            int w1 = 50, h1 = 10;
            int w2 = 10, h2 = 50;
            toColour.add(new RoundRectangle2D.Float(x1, y1, w1, h1, 10, 10));
            toColour.add(new RoundRectangle2D.Float(x1 + h2 - w2, y1, w2, h2, 10, 10));
            toColour.add(new Polygon(new int[]{x1, x1 + w1 - 5, x1 + w1 - 7},
                    new int[]{y1 + 7, y1 + w2 / 2, y1 + h2},
                    3));
            int x2 = 30, y2 = y1 + 300 / 3;
            toColour.add(new RoundRectangle2D.Double(x2, y2, w1, h1, 10, 10));
            toColour.add(new RoundRectangle2D.Double(x2 + h2 - w2, y2, w2, h2, 10, 10));
            toColour.add(new Polygon(new int[]{x2, x2 + w1 - 5, x2 + w1 - 7},
                    new int[]{y2 + 7, y2 + w2 / 2, y2 + h2},
                    3));
            int y3 = y2 + 300 / 3;
            toColour.add(new RoundRectangle2D.Double(x2, y3, w1, h1, 10, 10));
            toColour.add(new RoundRectangle2D.Double(x2 + h2 - w2, y3, w2, h2, 10, 10));
            toColour.add(new Polygon(new int[]{x2, x2 + w1 - 5, x2 + w1 - 7},
                    new int[]{y3 + 7, y3 + w2 / 2, y3 + h2},
                    3));
            //right side wings
            int x3 = x2 + w + w - 7;
            toColour.add(new RoundRectangle2D.Double(x3 - 7, y3, w1 + 7, h1, 10, 10));
            toColour.add(new RoundRectangle2D.Double(x3 - 7, y3, w2, h2 - 1, 10, 10));
            toColour.add(new Polygon(new int[]{x3 + w1, x3 - 5, x3 - 3},
                    new int[]{y3 + 7, y3 + w2 / 2, y3 + h2},
                    3));
            toColour.add(new RoundRectangle2D.Double(x3 - 7, y2, w1 + 7, h1, 10, 10));
            toColour.add(new RoundRectangle2D.Double(x3 - 7, y2, w2, h2 - 1, 10, 10));
            toColour.add(new Polygon(new int[]{x3 + w1, x3 - 5, x3 - 3},
                    new int[]{y2 + 7, y2 + w2 / 2, y2 + h2},
                    3));
            toColour.add(new RoundRectangle2D.Double(x3 - 7, y1, w1 + 7, h1, 10, 10));
            toColour.add(new RoundRectangle2D.Double(x3 - 7, y1, w2, h2 - 1, 10, 10));
            toColour.add(new Polygon(new int[]{x3 + w1, x3 - 5, x3 - 3},
                    new int[]{y1 + 7, y1 + w2 / 2, y1 + h2},
                    3));

            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.darkGray);
            for (var shape:
                 toColour) {
                g2.fill(shape);
            }
            //light lids
            double r1 = 1.85 * w1, r2 = 1.7 * w1;
            g.setColor(Color.white);
            g2.fillOval(x + 7, y1 - 10, (int) r1, (int) r2);
            g2.fillOval(x + 7, y2 - 10, (int) r1, (int) r2);
            g2.fillOval(x + 7, y3 - 10, (int) r1, (int) r2);
            g.setColor(Color.darkGray);
            g2.fillOval(x + 7, y1, (int) r1, (int) r2);
            g2.fillOval(x + 7, y2, (int) r1, (int) r2);
            g2.fillOval(x + 7, y3, (int) r1, (int) r2);
            double rr = w1 * 1.65;
            g.setColor(Color.red);
            g2.fillOval(x + 18, y1 + 7, (int) rr - 10, (int) rr - 10);
            g.setColor(Color.yellow);
            g2.fillOval(x + 18, y2 + 7, (int) rr - 10, (int) rr - 10);
            g.setColor(Color.green);
            g2.fillOval(x + 18, y3 + 7, (int) rr - 10, (int) rr - 10);
            super.paintComponent(g);
        }
    }
}