package ma.atos.agencymanagement.converter;

import ma.atos.agencymanagement.dto.AgencyDTO;
import ma.atos.agencymanagement.model.Agency;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AgencyConverter {

    public AgencyDTO FromAgencyToAgencyDto(Agency agency){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(agency, AgencyDTO.class);
    }

    public Agency FromAgencyDtoToAgency(AgencyDTO AgencyDTO){
        ModelMapper mapper =new ModelMapper();
        return mapper.map(AgencyDTO, Agency.class);
    }

    public List<AgencyDTO> FromListAgencysToListAgencysDto(List<Agency> Agencies){
        ModelMapper mapper =new ModelMapper();
        return Agencies.stream().map(this::FromAgencyToAgencyDto).collect(Collectors.toList());
    }

    public List<Agency> FromListAgencysDtoToListAgencys(List<AgencyDTO> AgenciesDto){
        ModelMapper mapper =new ModelMapper();
        return AgenciesDto.stream().map(this::FromAgencyDtoToAgency).collect(Collectors.toList());

    }

}
