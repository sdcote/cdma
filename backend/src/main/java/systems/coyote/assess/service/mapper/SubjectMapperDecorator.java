package systems.coyote.assess.service.mapper;

import systems.coyote.assess.domain.Question;
import systems.coyote.assess.domain.Subject;
import systems.coyote.assess.service.dto.QuestionDto;
import systems.coyote.assess.service.dto.SubjectDto;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A decorator for the mapper for {@link Subject} and {@link SubjectDto}
 * for custom methods
 */
public abstract class SubjectMapperDecorator implements SubjectMapper {

    @Autowired
    @Qualifier("delegate")
    private SubjectMapper delegate;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<SubjectDto> questionsToSubjectsDto(List<Question> questions) {
        Assert.notNull(questions, "Cannot map a null list of questions to a list of subject dtos");

        Multimap<Subject, Question> multimap = Multimaps.index(questions, Question::getSubject);

        return multimap.keySet().stream().map(subject -> {

            SubjectDto subjectDto = delegate.toDto(subject);

            List<QuestionDto> questionsDtos = multimap.get(subject).stream()
                    .map(question -> questionMapper.questionToQuestionDto(question)).collect(Collectors.toList());

            subjectDto.addQuestions(questionsDtos);
            return subjectDto;

        }).collect(Collectors.toList());
    }

}
