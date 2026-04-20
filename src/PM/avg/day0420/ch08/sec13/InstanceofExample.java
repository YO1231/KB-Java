package PM.avg.day0420.ch08.sec13;

public class InstanceofExample {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        ride(taxi);
        System.out.println();
        ride(bus);
    }

    private static void ride(Vehicle vehicle) {
        if (vehicle instanceof Bus b) {
            b.checkFare();
        }
        vehicle.run();

        /* if(vehicle instanceof Bus) {
            vehicle.run();
            ((Bus) vehicle).checkFare();
        } else if (vehicle instanceof Taxi) {
            vehicle.run();
        } */
    }
}
