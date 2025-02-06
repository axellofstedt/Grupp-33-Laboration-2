import java.awt.*;
import java.util.Stack;

// Två näst sista punkterna på uppgift 2 är man lite tvehågsen på
// Behöver TESTER, lägg till throws på loadcar och tilt ig

public class CarTransportTruck extends Car {
    boolean flatbedUp = false;
    Stack<Car> loadedCars = new Stack<>();

    protected CarTransportTruck() {
        super(2, Color.blue, 999, "Lorry");
    }

    public void tiltFlatbed (boolean tilt) {
        if (getCurrentSpeed() == 0) {
            flatbedUp = tilt;
        }
    }

    public void loadCar(Car car) {
        if (flatbedUp &&
                Math.abs(car.x - x) <= 5 && Math.abs(car.y - y) <= 0.5 &&
                !(car instanceof CarTransportTruck) && loadedCars.size() <= 15) {
            loadedCars.push(car);
        }
    }

    public void disengageCar() {
        if (flatbedUp) {
            Car car = loadedCars.pop();
            car.x -= 5;
            car.y -= 0.5;
        }
    }

    @Override
    public void move() {
        super.move();
        for (Car car: loadedCars) {
            car.x = x;
            car.y = y;
        }
    }

    @Override
    protected double speedFactor() {
        return 1;
    }
}