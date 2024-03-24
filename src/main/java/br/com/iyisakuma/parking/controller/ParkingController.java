package br.com.iyisakuma.parking.controller;

import br.com.iyisakuma.parking.controller.dto.ParkingDTO;
import br.com.iyisakuma.parking.controller.mapper.ParkingMapper;
import br.com.iyisakuma.parking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("parking")
public class ParkingController {


    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingDTO> findAll(){
        var parkings = parkingService.findAll();
        return parkingMapper.listOfParkingDTO(parkings);
    }
}