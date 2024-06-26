package br.com.iyisakuma.parking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Parking {

    @Id
    private String id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryTime;
    private LocalDateTime exitTIme;
    private BigDecimal Bill;

    public Parking(String id, String license, String model, String color) {
        this.id = id;
        this.license = license;
        this.model = model;
        this.color = color;
    }
}
