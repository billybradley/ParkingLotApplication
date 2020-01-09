package com.enigma.dao;
import com.enigma.constant.MessageConstant;
import com.enigma.model.Car;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotDao {
    public static final BigDecimal firstHourFee = new BigDecimal(10);
    public static final BigDecimal nextHourFee = new BigDecimal(10);
    public static final Integer firstHours = 2;
    private Map<Integer, Car> parkingLots = new HashMap<>();
    private Integer capacity;
    public ParkingLotDao(Integer capacity) {
        this.capacity = capacity;
    }
    public ParkingLotDao() {
    }
    public Map<Integer, Car> getParkingLots() {
        return this.parkingLots;
    }
    public String createParkingLot(Integer capacity) {
        this.capacity =capacity;
        for (int i = 1; i <= capacity; i++) {
            parkingLots.put(i, null);
        }
        return String.format(MessageConstant.CREATE_NEW_PARKING_LOT_MSG, capacity);
    }

    public String parkingNewCar(Car car) {
        for (int i = 1; i <= this.capacity; i++) {
            if (parkingLots.get(i) == null) {
                parkingLots.put(i, car);
                return String.format(MessageConstant.PARKING_SUCCESS_MSG, i);
            }
        }
        return MessageConstant.PARKING_LOT_FULL_MSG;
    }
    public String  leave(Car car, Integer parkingTime){
        for (Map.Entry<Integer, Car> slot : getParkingLots().entrySet()) {
            if (!(slot.getValue() == null)){
                if (slot.getValue().getLicensePlate().equals(car.getLicensePlate())){
                    Car selectedCar = slot.getValue();
                    slot.setValue(null);
                    return  String.format(MessageConstant.LEAVE, selectedCar.getLicensePlate(), slot.getKey(), calculatedFee(parkingTime));
                }
            }
        }
        return String.format(MessageConstant.LEAVE, car.getLicensePlate());
    }

    private BigDecimal calculatedFee(Integer duration){
        if (duration<=firstHours){
            return firstHourFee;
        }
        return firstHourFee.add((BigDecimal.valueOf(duration-firstHours)).multiply(nextHourFee));
    }
    public Map<Integer, Car> status(){
        return getParkingLots();
    }

}