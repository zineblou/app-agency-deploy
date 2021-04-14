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
    public HabilitationDTO entityToDto(Habilitation habilitation){
        ModelMapper mapper =new ModelMapper();

        return mapper.map(habilitation, HabilitationDTO.class);
    }


    //from dto to Entity
    public Habilitation dtoToENtity(HabilitationDTO dto){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(dto, Habilitation.class);
    }

    //From entity list to dto
    public List<HabilitationDTO> fromListHabilitionsToListHabilitationDto(List<Habilitation> h){

        return h.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    //From dto to entity list
    public List<Habilitation> fromListHabilitationdDtoToListHabilitations(List<HabilitationDTO> dto){

        return dto.stream().map(this::dtoToENtity).collect(Collectors.toList());

    }

}
