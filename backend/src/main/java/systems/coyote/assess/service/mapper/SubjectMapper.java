package systems.coyote.assess.service.mapper;

import systems.coyote.assess.domain.Question;
import systems.coyote.assess.domain.Subject;
import systems.coyote.assess.service.dto.SubjectDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Mapper for {@link Subject} and {@link SubjectDto}
 */
@Mapper(componentModel = "spring")
@DecoratedWith(SubjectMapperDecorator.class)
@Service
public interface SubjectMapper {

    List<SubjectDto> questionsToSubjectsDto(List<Question> questions);

    SubjectDto toDto(Subject subject);

}
