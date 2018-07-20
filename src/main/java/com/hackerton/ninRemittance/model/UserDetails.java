package com.hackerton.ninRemittance.model;

import javax.persistence.*;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String middleName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Column(name="photo", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] photo;

    @Transient
    private String pix;

    private String nin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    //    private String birthCountry;
//    private String birthDate;
//    private String birthLga;
//    private String birthState;
//    private String centralId;
//    private String educationalLevel;
//    private String email;
//    private String employmentStatus;
//
//    private String firstName;
//    private String gender;
//    private String height;
//    private String maidenName
//    private String maritalStatus;
//    private String middleName;
//
//    private String nin;
//    private String nok_address1;
//    private String nok_address2;
//    private String nok_firstname;
//    private String nok_lga;
//    private String nok_middlename;
//    private String nok_postalcode;
//    private String nok_state;
//    private String nok_surname;
//    private String nok_town;
//
//    private String nspokenlang;
//    private String ospokenlang;
//    private String othername;
//    private String pfirstname;
//    private String photo;
//

}
