package org.example.midterm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.midterm.enums.CarType;

public abstract class RentalCar extends Application {
    private int rentalPeriod;
    private int memberShipDuration;
    private CarType carType;

    public RentalCar(int memberShipDuration, int rentalPeriod, CarType carType) {
        this.memberShipDuration = memberShipDuration;
        this.rentalPeriod = rentalPeriod;
        this.carType = carType;
    }

    public abstract double calculateRentalFee();

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public int getMemberShipDuration() {
        return memberShipDuration;
    }

    public void setMemberShipDuration(int memberShipDuration) {
        this.memberShipDuration = memberShipDuration;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RentalCarApp.fxml"));
        primaryStage.setTitle("Rental Car Fee Calculator");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
