package br.com.iyisakuma.parking.service;


import br.com.iyisakuma.parking.model.Parking;
import br.com.iyisakuma.parking.model.ParkingRepository;
import br.com.iyisakuma.parking.model.exception.ParkingNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private static final Map<Integer, BigDecimal> parkingPrices = new HashMap<>();


    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }


    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    public Parking save(Parking parking) {
        parking.setId(getUUID());
        parking.setEntryTime(LocalDateTime.now());
        parkingRepository.save(parking);
        return parking;
    }

    public void delete(String id) {
        Parking parking = findById(id);
        parkingRepository.delete(parking);
    }

    public Parking update(String id, Parking parkingWithChanges) {
        Parking parking = findById(id);
        if (!parking.getColor().equals(parkingWithChanges.getColor()))
            parking.setColor(parking.getColor());
        return parkingRepository.save(parking);
    }

    public void exit(String id) {
        Parking parking = findById(id);
        parking.setExitTIme(LocalDateTime.now());
        int hour = parking.getExitTIme().getHour() - parking.getEntryTime().getHour();
        BigDecimal bill = parkingPrices.getOrDefault(hour, new BigDecimal(50));
        parking.setBill(bill);
        parkingRepository.save(parking);
    }
}
