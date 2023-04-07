package com.altrahouse.rabbitmqmessagequeue.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginClass {

    private String loginId;
    private String authEmail;
    private String geoIpCountryName;
    private String geoIpCity;
    private String initiator;
    private int amount;

    public LoginClass(String authEmail, String geoIpCountryName, String geoIpCity, String initiator, int amount) {
        this.authEmail = authEmail;
        this.geoIpCountryName = geoIpCountryName;
        this.geoIpCity = geoIpCity;
        this.initiator = initiator;
        this.amount = amount;
    }
}

