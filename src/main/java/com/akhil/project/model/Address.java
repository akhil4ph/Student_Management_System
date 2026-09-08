package com.akhil.project.model;

import java.time.LocalDate;

public class Address {
    private int addId;
    private int studentId;
    private String lane;
    private int pincode;
    private int houseNo;
    private String district;
    private String state;
    private LocalDate crdate = LocalDate.now();

    public Address(int addId, String district, int houseNo, String lane, int pincode, String state, int studentId) {
        this.addId = addId;
        this.district = district;
        this.houseNo = houseNo;
        this.lane = lane;
        this.pincode = pincode;
        this.state = state;
        this.studentId = studentId;
    }

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getCrdate() {
        return crdate;
    }

    public void setCrdate(LocalDate crdate) {
        this.crdate = crdate;
    }

    @Override
    public String toString() {
        return "Address [addId=" + addId + ", studentId=" + studentId + ", lane=" + lane + ", pincode=" + pincode
                + ", houseNo=" + houseNo + ", district=" + district + ", state=" + state + ", crdate=" + crdate + "]";
    }

    
}
