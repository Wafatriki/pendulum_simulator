package es.ulpgc.dis.presenter;

import es.ulpgc.dis.model.Pendulum;

public class PendulumSimulator {
    private final double timeStep;

    public PendulumSimulator(double timeStep) {
        this.timeStep = timeStep;
    }

    public Pendulum simulate(Pendulum pendulum) {
        double[] newParameters = PendulumPhysics.rungeKutta(pendulum, timeStep);
        return new Pendulum(pendulum.L(), pendulum.r(), pendulum.g(), newParameters[0], newParameters[1]);
    }
}