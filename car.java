import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Car extends Frame implements Runnable {
    private int x = 0; // Initial x position of the car
    private int y = 300; // y position of the car

    public Car() {
        setTitle("Car Model");
        setSize(800, 600);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        Thread t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Draw the road
        g.setColor(Color.GRAY);
        g.fillRect(0, 200, getWidth(), 200);

        // Draw the body of the car with rounded corners
        g.setColor(Color.BLUE);
        g.fillRoundRect(x, y, 250, 60, 20, 20);

        // Draw the roof of the car with rounded corners
        g.setColor(Color.BLUE);
        g.fillOval(x + 50, y - 40, 150, 100);

        // Draw the windows of the car
        g.setColor(Color.BLACK);
        g.fillRect(x + 80, y - 20, 30, 20);
        g.fillRect(x + 135, y - 20, 30, 20);

        // Draw the wheels of the car
        g.setColor(Color.BLACK);
        g.fillOval(x + 40, y + 40, 40, 40);
        g.fillOval(x + 160, y + 40, 40, 40);
        // Draw alloy setup
        g.setColor(Color.WHITE);
        g.fillOval(x + 50, y + 50, 20, 20);
        g.fillOval(x + 170, y + 50, 20, 20);

        g.setColor(Color.white);
        g.fillOval(x + 220, y , 20, 15);
        // Draw trees
        drawTree(g, 100, 150);
        drawTree(g, 300, 150);
        drawTree(g, 500, 150);
        drawTree(g, 700, 150);
    }

    private void drawTree(Graphics g, int x, int y) {
        // Draw the trunk
        g.setColor(new Color(139, 69, 19)); // Brown color
        g.fillRect(x, y, 20, 50);

        // Draw the leaves
        g.setColor(Color.GREEN);
        g.fillOval(x - 30, y - 30, 80, 60);
    }


    @Override
    public void run() {
        while (true) {
            x += 5; // Move the car to the right
            if (x > getWidth()) {
                x = -200; // Reset the car position when it goes off screen
            }
            repaint();
            try {
                Thread.sleep(50); // Delay for smooth animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Car();
    }
}
