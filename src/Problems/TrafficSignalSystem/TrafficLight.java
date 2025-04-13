package Problems.TrafficSignalSystem;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight {
    private final String id;
    private TrafficSignal signal;
    private final List<Road> observers = new ArrayList<>();
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;

    public TrafficLight(String id, int redDuration, int yellowDuration, int greenDuration) {
        this.id = id;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
    }

    public synchronized void changeSignal(TrafficSignal signal) {
        this.signal = signal;
        notifyRoads();
    }

    public String getId() {
        return id;
    }

    public TrafficSignal getSignal() {
        return signal;
    }

    public void setSignal(TrafficSignal signal) {
        this.signal = signal;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public void registerObserver(Road road) {
        observers.add(road);
    }

    // observer pattern
    private void notifyRoads() {
        for (Road road : observers) {
            road.onSignalChange(this.signal);
        }
    }

}
