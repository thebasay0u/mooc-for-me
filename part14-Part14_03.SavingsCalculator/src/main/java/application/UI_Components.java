package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

public class UI_Components {

    public UI_Components() {

    }

    public Slider getSavingsSlider() {
        return createSavingsSlider();
    }

    public Slider getInterestSlider() {
        return createInterestSlider();
    }

    private Slider createSavingsSlider() {
        Slider slider = new Slider();
        slider.setPadding(new Insets(1, 2, 3, 3));
        slider.setMaxWidth(UI_Constants.LAYOUT_WIDTH);
        slider.setShowTickMarks(true);
        slider.setMin(25);
        slider.setMax(250);

        slider.setMinorTickCount(3);
        slider.setShowTickLabels(true);

        slider.setSnapToTicks(false);
        slider.setMajorTickUnit(25);

        slider.setLabelFormatter(new StringConverter<Double>() {

            @Override
            public String toString(Double object) {
                // TODO Auto-generated method stub

                Double newData = new Double(object);

                int value = newData.intValue();
                return String.valueOf(value);
            }

            @Override
            public Double fromString(String string) {
                // TODO Auto-generated method stub
                return Double.parseDouble(string);
            }

        });

        return slider;
    }

    private Slider createInterestSlider() {
        Slider slider = new Slider();
        slider.setPadding(new Insets(1, 2, 3, 3));
        slider.setMaxWidth(UI_Constants.LAYOUT_WIDTH);
        slider.setShowTickMarks(true);
        slider.setMin(0);
        slider.setMax(10);
        slider.setMinorTickCount(3);
        slider.setShowTickLabels(false);

        slider.setMajorTickUnit(2);
        slider.setSnapToTicks(false);

        slider.setLabelFormatter(new StringConverter<Double>() {

            @Override
            public String toString(Double object) {
                // TODO Auto-generated method stub

                Double newData = new Double(object);

                int value = newData.intValue();
                return String.valueOf(value);
            }

            @Override
            public Double fromString(String string) {
                // TODO Auto-generated method stub
                return Double.parseDouble(string);
            }

        });

        return slider;
    }

}
