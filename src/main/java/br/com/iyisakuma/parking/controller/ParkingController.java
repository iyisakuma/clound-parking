package br.com.iyisakuma.parking.controller;

import br.com.iyisakuma.parking.dto.ParkingDTO;
import br.com.iyisakuma.parking.controller.mapper.ParkingMapper;
import br.com.iyisakuma.parking.dto.ParkingCreateDTO;
import br.com.iyisakuma.parking.model.Parking;
import br.com.iyisakuma.parking.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    @PostMapping("/{id}")
    public ResponseEntity<ParkingDTO> exit(@PathVariable String id,  UriComponentsBuilder uriBuilder){
        parkingService.exit(id);
        return ResponseEntity.ok().build();
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

    @DeleteMapping("/{id}")
    public ResponseEntity<ParkingDTO> deleteById(@PathVariable String id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> deleteById(@PathVariable String id, @RequestBody ParkingCreateDTO dto, UriComponentsBuilder uriBuilder){
        Parking parking = parkingService.update(id, parkingMapper.toParkingCreate(dto)) ;
        return ResponseEntity.ok().body(parkingMapper.toParkingDTO(parking));
    }
    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto, UriComponentsBuilder uriBuilder){
        var parking = parkingMapper.toParkingCreate(dto);
        parking = parkingService.save(parking);
        return ResponseEntity.created(uriBuilder.path("/parkings/{id}").buildAndExpand(parking.getId()).toUri()).body(
                parkingMapper.toParkingDTO(parking)
        );
    }




}
