package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class AlarmTest {

    @Test
    public void alarmOn_when_value_too_low() {
        //Arrange
        PressureSensor sensor = probe(16.0);
        Alarm alarm = new Alarm(sensor);
        //Act
        alarm.check();
        //Assert
        assertTrue(alarm.isAlarmOn());
    }

    private PressureSensor probe(Double value, Double... values) {
        PressureSensor sensor = mock(PressureSensor.class);
        when(sensor.probepsiPresureValue()).thenReturn(value,values);
        return sensor;
    }

    @Test
    public void alarmOn_when_value_too_high() {
        //Arrange
        PressureSensor sensor = probe(22.0);
        Alarm alarm = new Alarm(sensor);
        //Act
        alarm.check();
        //Assert
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void alarmOff_when_value_in_safety_range() {
        //Arrange
        PressureSensor sensor = probe(19.0);
        Alarm alarm = new Alarm(sensor);
        //Act
        alarm.check();
        //Assert
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void alarm_stay_on_when_activate_at_once() {
        //Arrange
        PressureSensor sensor = probe(25.0,19.0);
        Alarm alarm = new Alarm(sensor);
        //Act
        alarm.check();
        assertTrue(alarm.isAlarmOn());

        alarm.check();
        assertTrue(alarm.isAlarmOn());

    }

}
