package ma.atos.agencymanagement.converter;

import ma.atos.agencymanagement.dto.AgencyDTO;
import ma.atos.agencymanagement.model.Agency;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AgencyConverter {

    //From agency to agency dto
    public AgencyDTO fromAgencyToAgencyDto(Agency agency){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(agency, AgencyDTO.class);
    }

    //From Dto to agency entity
    public Agency fromAgencyDtoToAgency(AgencyDTO agencyDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(agencyDTO, Agency.class);
    }

    //From agency list to agency Dto
    public List<AgencyDTO> fromListAgencysToListAgencysDto(List<Agency> agencies){

        return agencies.stream().map(this::fromAgencyToAgencyDto).collect(Collectors.toList());
    }

    //From dto agency list to agency entity
    public List<Agency> fromListAgencysDtoToListAgencys(List<AgencyDTO> agenciesDto){

        return agenciesDto.stream().map(this::fromAgencyDtoToAgency).collect(Collectors.toList());

    }

}
