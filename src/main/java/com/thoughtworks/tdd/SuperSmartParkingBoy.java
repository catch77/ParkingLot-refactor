package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy {

    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket park(String car) throws ParkException {
        Optional<ParkingLot> parkingLotOptional = parkingLotList.stream().max(Comparator.comparingDouble(ParkingLot::getEmptyRate));
        ParkingLot parkingLot = parkingLotOptional.get();
        return parkingLot.park(car, parkingLot);
    }
}
