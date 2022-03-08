package com.example.jkrb.jkrb;

public class params {
    String pcc;
    String gps;
    String location;
    String status;
    String temp;
    String contact;

    public params() {
    }

    public params(String pcc, String gps, String location, String status, String temp, String contact) {
        this.pcc = pcc;
        this.gps = gps;
        this.location = location;
        this.status = status;
        this.temp = temp;
        this.contact = contact;
    }

    public String getPcc() {
        return pcc;
    }

    public void setPcc(String pcc) {
        this.pcc = pcc;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "params{" +
                "pcc='" + pcc + '\'' +
                ", gps='" + gps + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", temp='" + temp + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
