import java.awt.*;

// i tiltFlatbed - throw error om knasigt argument

public class Scania extends Car {
    private double flatbedAngle = 0;

    protected Scania() {
        super(2, Color.black, 1235, "Scania");
    }

    public void tiltFlatbed(double angle) {
        double new_angle = flatbedAngle + angle;
        if (new_angle <= 70 && 0 <= new_angle && getCurrentSpeed() == 0) {
            flatbedAngle = new_angle;
        }
    }

    public double getFlatbedAngle() {
        return flatbedAngle;
    }

    @Override
    public void startEngine() {
        if (flatbedAngle == 0) {
            super.startEngine();
        }
    }

    // You can increase speed by just calling gas
    // (without having used startEngine) for some reason
    // so gas has to be overridden too I think
    @Override
    public void gas(double amount) {
        if (flatbedAngle == 0) {
            super.gas(amount);
        }
    }

    @Override
    protected double speedFactor() {
        return 1;
    }
}