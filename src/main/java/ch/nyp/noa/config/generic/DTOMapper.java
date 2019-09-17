package ch.nyp.noa.config.generic;

import java.util.List;
import java.util.Set;

public interface DTOMapper<DM, DTO> {

    DM fromDTO(DTO dto);

    List<DM> fromDTOs(List<DTO> dtos);

    Set<DM> fromDTOs(Set<DTO> dtos);

    DTO toDTO(DM dm);

    List<DTO> toDTOs(List<DM> dms);

    Set<DTO> toDTOs(Set<DM> dms);

}
