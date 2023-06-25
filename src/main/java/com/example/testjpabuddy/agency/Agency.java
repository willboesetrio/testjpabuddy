package com.example.testjpabuddy.agency;

import javax.persistence.*;

@Entity
@Table(name = "AGENCY")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 60)
    private String name;

    @Column(name = "EIN", length = 20)
    private String ein;

    @Column(name = "ADDRESS1", nullable = false, length = 100)
    private String address1;
    @Column(name = "ADDRESS2", length = 100)
    private String address2;

    @Column(name = "CITY", nullable = false, length = 30)
    private String city;

    @Column(name = "ST", nullable = false, length = 2)
    private String st;

    @Column(name = "ZIP", nullable = false, length = 10)
    private String zip;

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

}