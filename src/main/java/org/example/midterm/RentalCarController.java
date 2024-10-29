package org.example.midterm;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import org.example.midterm.cars.EconomyCar;
import org.example.midterm.cars.PremiumCar;
import org.example.midterm.cars.StandardCar;
import org.example.midterm.enums.CarType;

public class RentalCarController {

    @FXML
    private Label topLabel;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField rentalPeriodField;
    @FXML
    private TextField membershipDurationField;
    @FXML
    private RadioButton economyRadio;
    @FXML
    private RadioButton standardRadio;
    @FXML
    private RadioButton premiumRadio;
    @FXML
    private Button calculateButton;
    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        ToggleGroup carTypeGroup = new ToggleGroup();
        economyRadio.setToggleGroup(carTypeGroup);
        standardRadio.setToggleGroup(carTypeGroup);
        premiumRadio.setToggleGroup(carTypeGroup);

        economyRadio.setSelected(true);

        calculateButton.setOnAction(e -> calculateFee());
    }

    private void calculateFee() {
        try {
            int rentalPeriod = Integer.parseInt(rentalPeriodField.getText());
            int membershipDuration = Integer.parseInt(membershipDurationField.getText());

            CarType carType;

            if (economyRadio.isSelected()) {
                carType = CarType.ECONOMY;
            } else if (standardRadio.isSelected()) {
                carType = CarType.STANDARD;
            } else {
                carType = CarType.PREMIUM;
            }

            RentalCar rentalCar;

            switch (carType) {
                case ECONOMY:
                    rentalCar = new EconomyCar(rentalPeriod, membershipDuration);
                    break;
                case STANDARD:
                    rentalCar = new StandardCar(rentalPeriod, membershipDuration);
                    break;
                case PREMIUM:
                    rentalCar = new PremiumCar(rentalPeriod, membershipDuration);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + carType);
            }

            double rentalFee = rentalCar.calculateRentalFee();
            resultLabel.setText("Арендная плата: $" + rentalFee);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Пожалуйста, введите корректные числа для периода аренды и срока членства.");
        }
    }
}
