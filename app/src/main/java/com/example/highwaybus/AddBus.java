package com.example.highwaybus;

public class AddBus {
    private String start_station;
    private String start_time;
    private String arriaval_time;
    private String end_town;
    private String bus_bumber;
    private String bus_contact;

    public AddBus() {
    }

    public AddBus(String start_station, String start_time, String arriaval_time, String end_town, String bus_bumber, String bus_contact) {
        this.start_station = start_station;
        this.start_time = start_time;
        this.arriaval_time = arriaval_time;
        this.end_town = end_town;
        this.bus_bumber = bus_bumber;
        this.bus_contact = bus_contact;
    }

    public String getStart_station() {
        return start_station;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getArriaval_time() {
        return arriaval_time;
    }

    public String getEnd_town() {
        return end_town;
    }

    public String getBus_bumber() {
        return bus_bumber;
    }

    public String getBus_contact() {
        return bus_contact;
    }
}
