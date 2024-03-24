package br.com.iyisakuma.parking.service;


import br.com.iyisakuma.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ParkingService {

    private static final Map<String, Parking> parkingMap = new HashMap<>();

    static{
        var id = getUUID();
        var parking = new Parking(id, "DMS-9999", "Celta", "Preto");
        parkingMap.put(id, parking);
    }


    public List<Parking> findAll(){
        return parkingMap.values().stream().toList();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
