package Problems.TrafficSignalSystem;

import java.util.concurrent.ConcurrentHashMap;

public class TrafficController {
    public static TrafficController instance;
    private final ConcurrentHashMap<String, Road> roads;

    private TrafficController() {
        roads = new ConcurrentHashMap<>();
    }

    public static synchronized TrafficController getInstance() {
        if (instance == null) {
            return new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road) {
        roads.put(road.getId(), road);
    }

    public void removeRoad(String id) {
        roads.remove(id);
    }

    public void startTrafficControl() {
        for (Road road : roads.values()) {
            TrafficLight trafficLight = road.getTrafficLight();
            String roadName = road.getName(); // assuming Road has a getName() method

            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("[" + roadName + "] Signal is RED for " + trafficLight.getRedDuration() + " ms");
                        Thread.sleep(trafficLight.getRedDuration());

                        trafficLight.changeSignal(TrafficSignal.GREEN);
                        System.out.println("[" + roadName + "] Changed to GREEN for " + trafficLight.getGreenDuration() + " ms");
                        Thread.sleep(trafficLight.getGreenDuration());

                        trafficLight.changeSignal(TrafficSignal.YELLOW);
                        System.out.println("[" + roadName + "] Changed to YELLOW for " + trafficLight.getYellowDuration() + " ms");
                        Thread.sleep(trafficLight.getYellowDuration());

                        trafficLight.changeSignal(TrafficSignal.RED);
                        System.out.println("[" + roadName + "] Back to RED");

                    } catch (InterruptedException e) {
                        System.err.println("[" + roadName + "] Traffic control interrupted: " + e.getMessage());
                        Thread.currentThread().interrupt(); // good practice to re-interrupt
                    }
                }
            }).start();
        }
    }

    public void handleEmergency(String id) {
        Road road = roads.get(id);
        if (road != null) {
            road.getTrafficLight().setSignal(TrafficSignal.GREEN);
            /*
            other handle emergency logic
             */
        }
    }
}
