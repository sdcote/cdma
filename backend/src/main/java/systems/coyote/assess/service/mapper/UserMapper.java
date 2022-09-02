package systems.coyote.assess.service.mapper;

import systems.coyote.assess.domain.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

/**
 * Mapper for {@link User}
 */
@Mapper(componentModel = "spring")
@Service
public interface UserMapper {

    User toEntityFromId(Long id);

}
