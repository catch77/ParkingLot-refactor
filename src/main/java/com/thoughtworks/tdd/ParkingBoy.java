package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(String car) throws ParkException {
        for (int i = 0; i < parkingLotList.size(); i++) {
            if (parkingLotList.get(i).getCarList().size()<parkingLotList.get(i).getCapacity()) {
                Ticket ticket = parkingLotList.get(i).park(car, parkingLotList.get(i));
                return ticket;
            }
        }
        return null;
    }

    public String fetch(Ticket ticket) throws ParkException {
        if (ticket == null) return null;
        return ticket.getParkingLot().fetch(ticket);
    }



}
