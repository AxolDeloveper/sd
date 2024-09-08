import java.util.*;





public class BoatDockSimulation {
    private Queue<Passenger> passengersQueue;
    private Map<String, Integer> passengerArrivalTimes; // Среднее время прибытия пассажиров
    private Map<String, Integer> boatArrivalTimes;      // Среднее время прибытия катеров
    private Random random;

    public BoatDockSimulation() {
        passengersQueue = new LinkedList<>();
        passengerArrivalTimes = new HashMap<>();
        boatArrivalTimes = new HashMap<>();
        random = new Random();
    }


    public void setArrivalTimes(String timeOfDay, int passengerTime, int boatTime) {
        passengerArrivalTimes.put(timeOfDay, passengerTime);
        boatArrivalTimes.put(timeOfDay, boatTime);
    }


    public void simulatePassengerArrival(int currentTime, String timeOfDay) {
        int interval = passengerArrivalTimes.get(timeOfDay);
        if (random.nextInt(interval) == 0) {
            passengersQueue.add(new Passenger(currentTime));
        }
    }


    public void simulateBoatArrival(int currentTime, String timeOfDay) {
        int interval = boatArrivalTimes.get(timeOfDay);
        if (random.nextInt(interval) == 0) {
            int capacity = random.nextInt(10) + 1;
            boat boat = new boat(capacity, random.nextBoolean());
            boardPassengers(boat);
        }
    }


    public void boardPassengers(boat boat) {
        int availableSeats = boat.getCapacity();
        while (!passengersQueue.isEmpty() && availableSeats > 0) {
            Passenger passenger = passengersQueue.poll();
            System.out.println("Passenger boarded. Arrival time: " + passenger.getArrivalTime());
            availableSeats--;
        }
    }
}