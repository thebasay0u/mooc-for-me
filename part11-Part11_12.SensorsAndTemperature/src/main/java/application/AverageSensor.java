package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> _sensors;
    private ArrayList<Integer> _readings;

    public AverageSensor() {
        this._sensors = new ArrayList<>();
        this._readings = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        for (Sensor s : this._sensors) {
            if (!s.isOn()) {
                return false;
            }

        }
        return true;
    }

    @Override
    public void setOn() {
        if (this._sensors.isEmpty())
            return;
        else {
            for (Sensor s : this._sensors) {
                if (!s.isOn()) {
                    s.setOn();

                }
            }
        }

    }

    @Override
    public void setOff() {

        if (this._sensors.isEmpty())
            return;
        else {
            for (Sensor s : this._sensors)
                if (s.isOn()) {
                    s.setOff();
                }
        }

    }

    @Override
    public int read() {
        int size = this._sensors.size();
        // int sumReadings = 0;
        if (size > 0) {
            int sumReadings = this._sensors.stream().map(sensor -> sensor.read()).reduce(0, (a, b) -> a + b);
            int average = sumReadings / size;
            this._readings.add(average);

            return average;

        } else {
            throw new IllegalStateException();
        }

    }

    public void addSensor(Sensor sensorToAdd) {

        this._sensors.add(sensorToAdd);

    }

    public List<Integer> readings() {
        return this._readings;

    }

}
