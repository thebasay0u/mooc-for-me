package application;

public class StandardSensor implements Sensor {
    private int _reading;

    public StandardSensor(int reading) {
        this._reading = reading;
    }

    @Override
    public boolean isOn() {

        return true;
    }

    @Override
    public void setOn() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setOff() {
        // TODO Auto-generated method stub

    }

    @Override
    public int read() {
        return this._reading;
    }

}
