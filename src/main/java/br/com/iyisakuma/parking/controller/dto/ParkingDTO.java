package br.com.iyisakuma.parking.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {
    private String id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryTime;
    private LocalDateTime exitTIme;
    private BigDecimal Bill;
}
