package es.ulpgc.dis.model;

import java.util.ArrayList;
import java.util.List;

public class PendulumData {

    private final List<Double> time = new ArrayList<>();
    private final List<Double> theta = new ArrayList<>();
    private final List<Double> omega = new ArrayList<>();

    public void addData(double t, double thetaValue, double omegaValue) {
        time.add(t);
        theta.add(thetaValue);
        omega.add(omegaValue);
    }

    public List<Double> getTime() {
        return new ArrayList<>(time);
    }

    public List<Double> getTheta() {
        return new ArrayList<>(theta);
    }

    public List<Double> getOmega() {
        return new ArrayList<>(omega);
    }
}