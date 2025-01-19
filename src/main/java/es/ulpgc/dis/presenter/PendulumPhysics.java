package es.ulpgc.dis.presenter;

import es.ulpgc.dis.model.Pendulum;

public class PendulumPhysics {
    private static final int THETA = 0;
    private static final int OMEGA = 1;

    public static double[] rungeKutta(Pendulum pendulum, double timeStep) {
        double k1Theta = timeStep * pendulum.omega();
        double k1Omega = timeStep * calculateAcceleration(pendulum.theta(), pendulum.g(), pendulum.L());
        double k2Theta = timeStep * (pendulum.omega() + k1Omega / 2.0);
        double k2Omega = timeStep * calculateAcceleration(pendulum.theta() + k1Theta / 2.0, pendulum.g(), pendulum.L());
        double k3Theta = timeStep * (pendulum.omega() + k2Omega / 2.0);
        double k3Omega = timeStep * calculateAcceleration(pendulum.theta() + k2Theta / 2.0, pendulum.g(), pendulum.L());
        double k4Theta = timeStep * (pendulum.omega() + k3Omega);
        double k4Omega = timeStep * calculateAcceleration(pendulum.theta() + k3Theta, pendulum.g(), pendulum.L());

        double newTheta = pendulum.theta() + (k1Theta + 2 * k2Theta + 2 * k3Theta + k4Theta) / 6.0;
        double newOmega = pendulum.omega() + (k1Omega + 2 * k2Omega + 2 * k3Omega + k4Omega) / 6.0;

        return new double[]{newTheta, newOmega};
    }

    private static double calculateAcceleration(double theta, double g, double L) {
        return (g / L) * Math.sin(theta);
    }
}