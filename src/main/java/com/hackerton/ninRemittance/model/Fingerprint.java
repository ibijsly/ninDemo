package com.hackerton.ninRemittance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "edge_fingerprint")
public class Fingerprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDetails userDetails;

    @Column(name="photo0", nullable = false, columnDefinition = "LONGBLOB")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private byte[] photo0;

    @Column(name="photo1", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo1;

    @Column(name="photo2", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo2;

    @Column(name="photo3", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo3;

    @Column(name="photo4", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo4;

    @Column(name="photo5", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo5;

    @Column(name="photo6", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo6;

    @Column(name="photo7", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo7;

    @Column(name="photo8", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo8;

    @Column(name="photo9", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo9;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public byte[] getPhoto0() {
        return photo0;
    }

    public void setPhoto0(byte[] photo0) {
        this.photo0 = photo0;
    }

    public byte[] getPhoto1() {
        return photo1;
    }

    public void setPhoto1(byte[] photo1) {
        this.photo1 = photo1;
    }

    public byte[] getPhoto2() {
        return photo2;
    }

    public void setPhoto2(byte[] photo2) {
        this.photo2 = photo2;
    }

    public byte[] getPhoto3() {
        return photo3;
    }

    public void setPhoto3(byte[] photo3) {
        this.photo3 = photo3;
    }

    public byte[] getPhoto4() {
        return photo4;
    }

    public void setPhoto4(byte[] photo4) {
        this.photo4 = photo4;
    }

    public byte[] getPhoto5() {
        return photo5;
    }

    public void setPhoto5(byte[] photo5) {
        this.photo5 = photo5;
    }

    public byte[] getPhoto6() {
        return photo6;
    }

    public void setPhoto6(byte[] photo6) {
        this.photo6 = photo6;
    }

    public byte[] getPhoto7() {
        return photo7;
    }

    public void setPhoto7(byte[] photo7) {
        this.photo7 = photo7;
    }

    public byte[] getPhoto8() {
        return photo8;
    }

    public void setPhoto8(byte[] photo8) {
        this.photo8 = photo8;
    }

    public byte[] getPhoto9() {
        return photo9;
    }

    public void setPhoto9(byte[] photo9) {
        this.photo9 = photo9;
    }
}
