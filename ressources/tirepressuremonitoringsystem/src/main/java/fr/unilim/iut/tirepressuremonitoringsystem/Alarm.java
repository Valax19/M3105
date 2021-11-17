package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{
    private final double lowPressureThreshold;
    private final double highPressureThreshold;

    PressureSensor sensor;
    boolean alarmOn;

    public Alarm(PressureSensor sensor){
        this.sensor = sensor;
        activateAlarm(false);
        this.lowPressureThreshold = 17;
        this.highPressureThreshold = 21;
    }

    public Alarm() {
        this(new PressureSensor());
    }

    public void check()
    {
        double psiPressureValue = sensor.probepsiPresureValue();

        if (isNotInSafetyRange(psiPressureValue))
        {
            activateAlarm(true);
        }
    }

    private void activateAlarm(boolean b) {
        alarmOn = b;
    }


    private boolean isNotInSafetyRange(double psiPressureValue) {
        return psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue;
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
