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
    public ManagerDTO fromManagerToManagerDto(Manager manager){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(manager, ManagerDTO.class);
    }


    //From Manager dto to Manager entity
    public Manager fromManagerDtoToManager(ManagerDTO managerDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(managerDTO, Manager.class);
    }

    //From Manager entity list to Manager dto list
    public List<ManagerDTO> fromListManagersToListManagersDto(List<Manager> managers){

        return managers.stream().map(this::fromManagerToManagerDto).collect(Collectors.toList());
    }


    //From Manager dto list to Manager list
    public List<Manager> fromListManagersDtoToListManagers(List<ManagerDTO> managersDto){

        return managersDto.stream().map(this::fromManagerDtoToManager).collect(Collectors.toList());

    }
}
