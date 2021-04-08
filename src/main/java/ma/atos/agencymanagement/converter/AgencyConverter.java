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
    public AgencyDTO FromAgencyToAgencyDto(Agency agency){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(agency, AgencyDTO.class);
    }

    //From Dto to agency entity
    public Agency FromAgencyDtoToAgency(AgencyDTO agencyDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(agencyDTO, Agency.class);
    }

    //From agency list to agency Dto
    public List<AgencyDTO> FromListAgencysToListAgencysDto(List<Agency> agencies){
        ModelMapper mapper =new ModelMapper();
        return agencies.stream().map(this::FromAgencyToAgencyDto).collect(Collectors.toList());
    }

    //From dto agency list to agency entity
    public List<Agency> FromListAgencysDtoToListAgencys(List<AgencyDTO> agenciesDto){
        ModelMapper mapper =new ModelMapper();
        return agenciesDto.stream().map(this::FromAgencyDtoToAgency).collect(Collectors.toList());

    }

}
