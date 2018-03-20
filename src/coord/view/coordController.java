package coord.view;

import coord.bl.checkBelonging;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class coordController {

    @FXML
    private TextField xField;
    @FXML
    private TextField yField;
    @FXML
    private Label answerLabel;

    public coordController() {
    }

    @FXML
    private void initialize() {
        answerLabel.setText("");
        xField.setText("0");
        yField.setText("0");
        answerLabel.setText("true");

        xField.setTextFormatter(doubleFormatter());
        xField.textProperty().addListener((observable, oldValue, newValue) -> {
            setAnswerLabel();
        });


        yField.setTextFormatter(doubleFormatter());
        yField.textProperty().addListener((observable, oldValue, newValue) -> {
            setAnswerLabel();
        });
    }

    private TextFormatter<Double> doubleFormatter() {
        Pattern pattern = Pattern.compile("-?(\\d*|\\d+\\.\\d{0,15})");

        UnaryOperator<TextFormatter.Change> filter = new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                return pattern.matcher(change.getControlNewText()).matches() ? change : null;
            }
        };

        StringConverter<Double> converter = new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                return object.toString();
            }

            @Override
            public Double fromString(String string) {
                return string.isEmpty() ? 0.0 : Double.valueOf(string);
            }
        };

        return new TextFormatter<>(converter, 0.0, filter);
    }

    private void setAnswerLabel() {
        double x, y;
        if (checkBelonging.correctData(xField.getText()) &&
                checkBelonging.correctData(yField.getText())) {
            x = (Double) xField.getTextFormatter().getValueConverter().fromString(xField.getText());
            y = (Double) yField.getTextFormatter().getValueConverter().fromString(yField.getText());

            if (checkBelonging.check(x, y))
                answerLabel.setText("true");
            else
                answerLabel.setText("false");

        } else {
            answerLabel.setText("Incorrect data");
        }
    }

}
