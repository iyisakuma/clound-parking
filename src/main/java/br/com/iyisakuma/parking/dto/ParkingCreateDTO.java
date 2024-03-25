package br.com.iyisakuma.parking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ParkingCreateDTO {
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryTime;
}
