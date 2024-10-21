package com.pluralsight;

public class Reservation {

    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;
    private double price;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {


        if (roomType.equalsIgnoreCase("Double Size")) {
            price = 124;
        } else if (roomType.equalsIgnoreCase("King Size")) {
            price = 139;

        } else {
            System.out.println("Invalid Room.");
            return 0;
        }

        if (isWeekend) {
            price = price * 110 / 100;
        }

        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }


    public double getReservationTotal() {

        return price * numberOfNights;
    }

}