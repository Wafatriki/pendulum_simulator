package es.ulpgc.dis.view;

import javax.swing.*;
import java.awt.*;


public class PendulumPanel extends JPanel {

    private final int originX = 400; // Coordenada X del centro de la bola amarilla
    private final int originY = 300; // Coordenada Y del centro de la bola amarilla (centro de la pantalla)
    private double pendulumX;
    private double pendulumY;

    public PendulumPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
    }

    public void updatePendulumPosition(double x, double y) {
        this.pendulumX = x;
        this.pendulumY = y;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawPendulum(g2d);
    }

    private void drawPendulum(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(originX - 10, originY - 10, 20, 20);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(originX, originY, (int) pendulumX, (int) pendulumY);
        g2d.setColor(Color.ORANGE);
        g2d.fillOval((int) pendulumX - 10, (int) pendulumY - 10, 20, 20);
    }
}