package com.enigma.service;
import com.enigma.constant.CommandConstant;
import com.enigma.constant.MessageConstant;
import com.enigma.dao.ParkingLotDao;
import com.enigma.model.Car;
import java.util.List;
import java.util.Map;

public class CommandService {
    private ParkingLotDao parkingLotDao = new ParkingLotDao();
    public void commandParse(List<String> commands) {
        for (String commandLine : commands) {
            switch (commandLine.split(" ")[0]) {
                case CommandConstant.CREATE_PARKING_LOT:
                    Integer capacity = Integer.parseInt(commandLine.substring(19));
                    System.out.println(parkingLotDao.createParkingLot(capacity));
                    break;
                case CommandConstant.PARKING:
                    String numberPlateIn = commandLine.substring(5);
                    Car car = new Car(numberPlateIn);
                    System.out.println(parkingLotDao.parkingNewCar(car));
                    break;
                case CommandConstant.LEAVE:
                    String numberPlateOut = commandLine.substring(6, 19);
                    Integer parkingTime = Integer.parseInt(commandLine.substring(20));
                    try {
                        String leave = parkingLotDao.leave(new Car(numberPlateOut), parkingTime);
                        System.out.println(leave);
                        break;
                    }catch (Exception e){
                        System.out.format(MessageConstant.PLATE_NUMBER_NOT_REGISTERED, numberPlateOut);
                    break;
                    }
                case CommandConstant.STATUS:
                    System.out.println(MessageConstant.STATUS_MESSAGE);
                    for (Map.Entry<Integer, Car> currentParkingLot : parkingLotDao.status().entrySet()) {
                        if (currentParkingLot.getValue()!=null) {
                            System.out.println(currentParkingLot.getKey() + ". " + currentParkingLot.getValue());
                        }

                    }
                    break;
              }


        }
    }
}
