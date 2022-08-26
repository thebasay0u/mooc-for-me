package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean _isOn;

    public TemperatureSensor() {
        this._isOn = false;

    }

    @Override
    public boolean isOn() {

        return this._isOn;
    }

    @Override
    public void setOn() {
        this._isOn = true;

    }

    @Override
    public void setOff() {
        this._isOn = false;

    }

    @Override
    public int read() {
        // # int number = random.nextInt(max - min) + min
        if (!this.isOn())
            throw new IllegalStateException();
        int min = -30;
        int max = 30;
        Random randy = new Random();
        int reading = randy.nextInt(max - min) + min;
        return reading;

    }

}
