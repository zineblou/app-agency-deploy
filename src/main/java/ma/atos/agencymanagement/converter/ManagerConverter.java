package ma.atos.agencymanagement.converter;

import ma.atos.agencymanagement.dto.ManagerDTO;
import ma.atos.agencymanagement.model.Manager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ManagerConverter {


    //From Manager entity to Manager dto
    public ManagerDTO FromManagerToManagerDto(Manager manager){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(manager, ManagerDTO.class);
    }


    //From Manager dto to Manager entity
    public Manager FromManagerDtoToManager(ManagerDTO managerDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(managerDTO, Manager.class);
    }

    //From Manager entity list to Manager dto list
    public List<ManagerDTO> FromListManagersToListManagersDto(List<Manager> managers){
        ModelMapper mapper =new ModelMapper();
        return managers.stream().map(this::FromManagerToManagerDto).collect(Collectors.toList());
    }


    //From Manager dto list to Manager list
    public List<Manager> FromListManagersDtoToListManagers(List<ManagerDTO> managersDto){
        ModelMapper mapper =new ModelMapper();
        return managersDto.stream().map(this::FromManagerDtoToManager).collect(Collectors.toList());

    }
}
