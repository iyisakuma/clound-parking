package br.com.iyisakuma.parking.service;


import br.com.iyisakuma.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ParkingService {

    private static final Map<String, Parking> parkingMap = new HashMap<>();

    static{

        var id1 = getUUID();
        var id2 = getUUID();
        var parking1 = new Parking(id1, "DMS-9999", "Celta", "Preto");
        var parking2 = new Parking(id2, "???-????", "X","Azul");
        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);
    }


    public List<Parking> findAll(){
        return parkingMap.values().stream().toList();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking save(Parking parking) {
        parking.setId(getUUID());
        parking.setEntryTime(LocalDateTime.now());
        parkingMap.put(parking.getId(), parking);
        return parking;
    }
}
