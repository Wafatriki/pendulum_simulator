package es.ulpgc.dis.presenter;

import es.ulpgc.dis.model.Pendulum;
import es.ulpgc.dis.view.PendulumPanel;

import java.util.Timer;
import java.util.TimerTask;


public class PendulumPresenter {
    private final PendulumPanel display;
    private final PendulumSimulator simulator;
    private Pendulum pendulum;
    private final Timer timer;
    private final int updateInterval;

    public PendulumPresenter(PendulumPanel display, PendulumSimulator simulator, Pendulum pendulum, int updateInterval) {
        this.display = display;
        this.simulator = simulator;
        this.pendulum = pendulum;
        this.updateInterval = updateInterval;
        this.timer = new Timer();
    }

    public void startSimulation() {
        timer.scheduleAtFixedRate(createTask(), 0, updateInterval);
    }

    private TimerTask createTask() {
        return new TimerTask() {
            @Override
            public void run() {
                refreshView();
            }
        };
    }

    private void refreshView() {
        pendulum = simulator.simulate(pendulum);
        double x = 400 + pendulum.L() * 200 * Math.sin(pendulum.theta());
        double y = 300 + pendulum.L() * 200 * Math.cos(pendulum.theta());
        display.updatePendulumPosition(x, y);
    }
}