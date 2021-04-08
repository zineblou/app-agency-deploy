package ma.atos.agencymanagement.converter;

import ma.atos.agencymanagement.dto.ManagerDTO;
import ma.atos.agencymanagement.model.Manager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ManagerConverter {

    public ManagerDTO FromManagerToManagerDto(Manager Manager){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(Manager, ManagerDTO.class);
    }

    public Manager FromManagerDtoToManager(ManagerDTO ManagerDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(ManagerDTO, Manager.class);
    }

    public List<ManagerDTO> FromListManagersToListManagersDto(List<Manager> managers){
        ModelMapper mapper =new ModelMapper();
        return managers.stream().map(this::FromManagerToManagerDto).collect(Collectors.toList());
    }

    public List<Manager> FromListManagersDtoToListManagers(List<ManagerDTO> managersDto){
        ModelMapper mapper =new ModelMapper();
        return managersDto.stream().map(this::FromManagerDtoToManager).collect(Collectors.toList());

    }
}
