package com.enigma.dao;

import com.enigma.constant.MessageConstant;
import com.enigma.model.Car;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ParkingLotDaoTest {

    @Test
    public void createParkingLot_Should_Create_ParkingLot_with_Given_Capacity() {
        Integer givenCapacity = 1;
        String expectedResult = String.format(MessageConstant.CREATE_NEW_PARKING_LOT_MSG, givenCapacity);
        String actualResult = new ParkingLotDao().createParkingLot(1);
        assertEquals(expectedResult,actualResult);

    }

    @Test
    public void parkingNewCar_should_return_Success_when_Park() {
        Car car = new Car("BM 9922 AC");
        ParkingLotDao parkingLotDao = new ParkingLotDao();
        parkingLotDao.createParkingLot(1);
        String actualResult = parkingLotDao.parkingNewCar(car);
        String expectResult = String.format(MessageConstant.PARKING_SUCCESS_MSG,1);
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void parkingNewCar_Should_throw_exception_When_ParkingLot_isFull(){
        String expectedResult = String.format(MessageConstant.PARKING_LOT_FULL_MSG);
        ParkingLotDao parkingLotDao = new ParkingLotDao(1);
            Car car1 = new Car("BB 1233 AC");
            Car car2 = new Car("BA 6161 JB");
        parkingLotDao.parkingNewCar(car1);
        String actualResult = parkingLotDao.parkingNewCar(car2);
        assertEquals(expectedResult,actualResult);
    }
//        @Test
//        public void leave_should_not_able_when_car_park_same_licensePlate(){
//        Car myCar = new Car("B 168O SS");
//        ParkingLotDao parkingLotDao = new ParkingLotDao(1);
//        parkingLotDao.createParkingLot();
//        parkingLotDao.parkingNewCar(myCar);
//        parkingLotDao.leave(myCar,2);
//
//    }
}