package com.cliffconsulting.travel.entity.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="hotel")
public class Hotel implements Serializable { 

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="hotel_id")
    private Long hotelId;  

    @Column(name="hotel_nm")
    private String name;

    @Column(name="hotel_address")
    private String address;

    @Column(name="city")    
    private String city;

    @Column(name="phone")    
    private String phone;

    @Column(name="stars")    
    private Integer stars;

    public Hotel() {
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return String.format("Hotel[hotelId=%s, name=%s, address=%s, city=%s, phone=%s, stars=%s]",
            hotelId, name, address, city, phone, stars);
    }
}  

