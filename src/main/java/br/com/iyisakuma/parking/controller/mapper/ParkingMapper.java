package br.com.iyisakuma.parking.controller.mapper;

import br.com.iyisakuma.parking.dto.ParkingCreateDTO;
import br.com.iyisakuma.parking.dto.ParkingDTO;
import br.com.iyisakuma.parking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParkingMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public ParkingDTO toParkingDTO(Parking parking){
        return modelMapper.map(parking, ParkingDTO.class);
    }

    public Parking toParking(ParkingDTO dto){
        return modelMapper.map(dto, Parking.class);
    }
    public List<ParkingDTO> listOfParkingDTO(List<Parking> parkings){
        return parkings.stream().map(this::toParkingDTO).toList();
    }

    public Parking toParkingCreate(ParkingCreateDTO dto) {
        return  modelMapper.map(dto, Parking.class);
    }
}

