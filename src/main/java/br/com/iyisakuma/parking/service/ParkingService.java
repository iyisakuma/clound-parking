package br.com.iyisakuma.parking.service;


import br.com.iyisakuma.parking.model.Parking;
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

    private static final Map<String, Parking> parkingMap = new HashMap<>();
    private static final Map<Integer, BigDecimal> parkingPrices = new HashMap<>();

    static{
        var id1 = getUUID();
        var id2 = getUUID();
        var parking1 = new Parking(id1, "DMS-9999", "Celta", "Preto");
        var parking2 = new Parking(id2, "???-????", "X","Azul");
        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);

        parkingPrices.put(1, new BigDecimal(10));
        parkingPrices.put(2, new BigDecimal(15));
        parkingPrices.put(3, new BigDecimal(20));
    }


    public List<Parking> findAll(){
        return parkingMap.values().stream().toList();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if(parking == null){
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking save(Parking parking) {
        parking.setId(getUUID());
        parking.setEntryTime(LocalDateTime.now());
        parkingMap.put(parking.getId(), parking);
        return parking;
    }

    public void delete(String id) {
        Parking parking = findById(id);
        parkingMap.remove(parking.getId());
    }

    public Parking update(String id, Parking parkingWithChanges) {
        Parking parking = findById(id);
        if (!parking.getColor().equals(parkingWithChanges.getColor()))
            parking.setColor(parking.getColor());
        return parkingMap.put(id, parking);
    }

    public void exit(String id) {
        Parking parking = findById(id);
        parking.setExitTIme(LocalDateTime.now());
        int hour =   parking.getExitTIme().getHour() - parking.getEntryTime().getHour();
        BigDecimal bill = parkingPrices.getOrDefault(hour, new BigDecimal(50));
        parking.setBill(bill);
        parkingMap.put(id, parking);
    }
}
