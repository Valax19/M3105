package fr.unilim.iut.kataparrot;

public class NorvegianParrot extends Parrot{

    protected static final double MAXIMUM_SPEED = 24.0;
    protected double voltage;
    protected boolean isNailed;

    public NorvegianParrot(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public double getSpeed() {
        return Math.min(MAXIMUM_SPEED, this.voltage * BASE_SPEED);
    }
}
