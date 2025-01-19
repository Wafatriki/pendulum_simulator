package es.ulpgc.dis;

import es.ulpgc.dis.presenter.PendulumPresenter;
import es.ulpgc.dis.presenter.PendulumSimulator;
import es.ulpgc.dis.model.Pendulum;
import es.ulpgc.dis.view.PendulumPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final Pendulum pendulum = new Pendulum(1, 1, -9.8, Math.PI / 4, 0.0);
        final PendulumSimulator simulator = new PendulumSimulator(0.001);
        final PendulumPanel display = new PendulumPanel();

        int updateInterval = (int) (1000 * 0.001);
        final PendulumPresenter presenter = new PendulumPresenter(display, simulator, pendulum, updateInterval);

        initializeFrame(display);
        presenter.startSimulation();
    }

    private static void initializeFrame(PendulumPanel display) {
        JFrame frame = new JFrame("Pendulum Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}