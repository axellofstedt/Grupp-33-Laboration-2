// ska kunna skapa verkstad för EN specifik bil men också
// en verkstad för alla möjliga sorters bilar
// vet it hur man gör detta ÄN!
// keep on fighting you got it

import java.util.ArrayList;

public class AutoRepairShop<T extends Car> {
    private int maxCars;
    ArrayList<T> cars = new ArrayList<>();
    protected AutoRepairShop(int maxCars){

        // AutoRepairShop<T> cars = new AutoRepairShop<T>();

    }

    public void addCar(T car) {
        if (cars.size() < maxCars) {
            cars.add(car);
            return;
        }
        throw new InternalError("AutoRepairShop is full! Chill out!");
    }

    public static void main(String[] args) {
        AutoRepairShop<Volvo240> rs = new AutoRepairShop<>(100);
        rs.addCar(new Volvo240());
        rs.addCar(new Volvo240());
        // Dessa ger errors förty rs är av typen Volvo240
        // rs.addCar(new CarTransportTruck());
        // rs.addCar(new Saab95());

        // Denna AutoRepairShop tar vilka cars som helst
        AutoRepairShop<Car> rs2 = new AutoRepairShop<>(100);
        rs2.addCar(new Volvo240());
        rs2.addCar(new Saab95());


    }
}
