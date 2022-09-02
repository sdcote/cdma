package systems.coyote.assess.service.mapper;

import systems.coyote.assess.domain.Question;
import systems.coyote.assess.service.dto.QuestionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Mapper for {@link Question} and {@link QuestionDto}
 */
@Mapper(componentModel = "spring")
@Service
public interface QuestionMapper {

    QuestionDto questionToQuestionDto(Question question);

    @Mapping(source = "questionId", target = "id")
    Question questionIdToQuestion(Long questionId);

    List<Question> questionsIdsListToQuestionList(List<Long> questionsIds);

}
