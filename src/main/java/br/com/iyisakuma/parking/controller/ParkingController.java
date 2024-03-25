package br.com.iyisakuma.parking.controller;

import br.com.iyisakuma.parking.dto.ParkingDTO;
import br.com.iyisakuma.parking.controller.mapper.ParkingMapper;
import br.com.iyisakuma.parking.dto.ParkingCreateDTO;
import br.com.iyisakuma.parking.model.Parking;
import br.com.iyisakuma.parking.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/parkings")
public class ParkingController {


    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll(){
        var parkings = parkingService.findAll();
        return ResponseEntity.ok(parkingMapper.listOfParkingDTO(parkings));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> save(@RequestBody ParkingCreateDTO dto){
        var parking = parkingMapper.toParkingCreate(dto);
        parking = parkingService.save(parking);
        return ResponseEntity.created(URI.create("/parkings/" + parking.getId())).body(
                parkingMapper.toParkingDTO(parking)
        );
    }
}
