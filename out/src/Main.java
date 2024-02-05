import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        JFrame jFrame = getFrame();
        jFrame.add(new TrafficLight());
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
    static class TrafficLight extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.darkGray);
            Graphics2D g2 = (Graphics2D) g;

            int x = 100, y = 100, w = 105, h = 50;
            Arc2D circle = new Arc2D.Double(x, y, w, h, 180, -180, Arc2D.OPEN);
            g2.fill(circle);
            //body
            g2.fillRoundRect(x - 10,
                    y + h - 15,
                    w + 20,
                    325,
                    10,
                    10);
            g2.fillRoundRect(x + w / 4,
                    y + h + 325 - 10,
                    w / 2,
                    w - 10,
                    5,
                    5);
            //left side wings
            int x1 = 30, y1 = y + 300 / 3 - 45;
            int w1 = 50, h1 = 10;
            int w2 = 10, h2 = 50;
            g.fillRoundRect(x1, y1, w1, h1, 10, 10);
            g.fillRoundRect(x1 + h2 - w2, y1, w2, h2, 10, 10);
            g.fillPolygon(new int[]{x1, x1 + w1 - 5, x1 + w1 - 7},
                    new int[]{y1 + 7, y1 + w2 / 2, y1 + h2},
                    3);
            int x2 = 30, y2 = y1 + 300 / 3;
            g.fillRoundRect(x2, y2, w1, h1, 10, 10);
            g.fillRoundRect(x2 + h2 - w2, y2, w2, h2, 10, 10);
            g.fillPolygon(new int[]{x2, x2 + w1 - 5, x2 + w1 - 7},
                    new int[]{y2 + 7, y2 + w2 / 2, y2 + h2},
                    3);
            int y3 = y2 + 300 / 3;
            g.fillRoundRect(x2, y3, w1, h1, 10, 10);
            g.fillRoundRect(x2 + h2 - w2, y3, w2, h2, 10, 10);
            g.fillPolygon(new int[]{x2, x2 + w1 - 5, x2 + w1 - 7},
                    new int[]{y3 + 7, y3 + w2 / 2, y3 + h2},
                    3);
            //right side wings
            int x3 = x2 + w + w - 7;
            g.fillRoundRect(x3 - 7, y3, w1 + 7, h1, 10, 10);
            g.fillRoundRect(x3 - 7, y3, w2, h2 - 1, 10, 10);
            g.fillPolygon(new int[]{x3 + w1, x3 - 5, x3 - 3},
                    new int[]{y3 + 7, y3 + w2 / 2, y3 + h2},
                    3);
            g.fillRoundRect(x3 - 7, y2, w1 + 7, h1, 10, 10);
            g.fillRoundRect(x3 - 7, y2, w2, h2 - 1, 10, 10);
            g.fillPolygon(new int[]{x3 + w1, x3 - 5, x3 - 3},
                    new int[]{y2 + 7, y2 + w2 / 2, y2 + h2},
                    3);
            g.fillRoundRect(x3 - 7, y1, w1 + 7, h1, 10, 10);
            g.fillRoundRect(x3 - 7, y1, w2, h2 - 1, 10, 10);
            g.fillPolygon(new int[]{x3 + w1, x3 - 5, x3 - 3},
                    new int[]{y1 + 7, y1 + w2 / 2, y1 + h2},
                    3);
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