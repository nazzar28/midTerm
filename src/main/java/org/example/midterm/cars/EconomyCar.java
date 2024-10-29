package org.example.midterm.cars;

import org.example.midterm.RentalCar;
import org.example.midterm.enums.CarType;

public class EconomyCar extends RentalCar {
    public EconomyCar(int rentalPeriod, int membershipDuration) {
        super(membershipDuration, rentalPeriod, CarType.ECONOMY);
    }

    @Override
    public double calculateRentalFee() {
        double discountMultiplier = calculateDiscountMultiplier(getMemberShipDuration());
        return 500 * getRentalPeriod() * discountMultiplier;
    }

    private double calculateDiscountMultiplier(int membershipDuration) {
        if (membershipDuration >= 10) {
            return 0.5; // 50% скидка
        } else if (membershipDuration >= 5) {
            return 0.7; // 30% скидка
        } else if (membershipDuration >= 3) {
            return 0.8; // 20% скидка
        } else {
            return 0.9; // 10% скидка
        }
    }
}
