package br.com.iyisakuma.parking.controller.mapper;

import br.com.iyisakuma.parking.controller.dto.ParkingDTO;
import br.com.iyisakuma.parking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParkingMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public ParkingDTO parkingDTO(Parking parking){
        return modelMapper.map(parking, ParkingDTO.class);
    }
    
    public List<ParkingDTO> listOfParkingDTO(List<Parking> parkings){
        return parkings.stream().map(this::parkingDTO).toList();
    }
}

