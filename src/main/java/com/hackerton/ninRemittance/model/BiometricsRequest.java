package com.hackerton.ninRemittance.model;

public class BiometricsRequest {
    private String machineAddress;
    private String userName;
    private String password;
    private String orgid;
    private String nin;
    private String fingerStringInBase64;
    private String pos;

    public String getMachineAddress() {
        return machineAddress;
    }

    public void setMachineAddress(String machineAddress) {
        this.machineAddress = machineAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getFingerStringInBase64() {
        return fingerStringInBase64;
    }

    public void setFingerStringInBase64(String fingerStringInBase64) {
        this.fingerStringInBase64 = fingerStringInBase64;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
