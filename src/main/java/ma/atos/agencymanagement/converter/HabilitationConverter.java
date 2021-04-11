package ma.atos.agencymanagement.converter;

import ma.atos.agencymanagement.dto.HabilitationDTO;
import ma.atos.agencymanagement.model.Habilitation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HabilitationConverter {


    //from entity to dto
    public HabilitationDTO EntityToDto(Habilitation habilitation){
        ModelMapper mapper =new ModelMapper();

        return mapper.map(habilitation, HabilitationDTO.class);
    }


    //from dto to Entity
    public Habilitation DtoToENtity(HabilitationDTO DTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(DTO, Habilitation.class);
    }

    //From entity list to dto
    public List<HabilitationDTO> FromListHabilitionsToListHabilitationDto(List<Habilitation> h){
        ModelMapper mapper =new ModelMapper();
        return h.stream().map(this::EntityToDto).collect(Collectors.toList());
    }

    //From dto to entity list
    public List<Habilitation> FromListHabilitationdDtoToListHabilitations(List<HabilitationDTO> Dto){
        ModelMapper mapper =new ModelMapper();
        return Dto.stream().map(this::DtoToENtity).collect(Collectors.toList());

    }

}
