package com.example.mani.mek3;

import java.io.Serializable;

public class BookingDetail implements Serializable{

    private int booking_id;
    private int company_id;
    private String model_name, licence_plate_no,address,boolking_time,duraion;
    private boolean payment_confirmation;
    private double fare;



    public BookingDetail(int booking_id, int company_id, String model_name, String licence_plate_no, String address,
                         String boolking_time, String duraion, boolean payment_confirmation, double fare) {

        this.booking_id = booking_id;
        this.company_id = company_id;

        this.model_name = model_name;
        this.licence_plate_no = licence_plate_no;
        this.address = address;
        this.boolking_time = boolking_time;
        this.duraion = duraion;
        this.payment_confirmation = payment_confirmation;
        this.fare = fare;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public int getCompany_id() {
        return company_id;
    }
    public String getModel_name() {
        return model_name;
    }

    public String getLicence_plate_no() {
        return licence_plate_no;
    }

    public String getAddress() {
        return address;
    }

    public String getBoolking_time() {
        return boolking_time;
    }

    public String getDuraion() {
        return duraion;
    }

    public boolean isPayment_confirmation() {
        return payment_confirmation;
    }

    public double getFare() {
        return fare;
    }
}
