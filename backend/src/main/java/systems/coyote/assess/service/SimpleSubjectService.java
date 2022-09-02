package systems.coyote.assess.service;

import systems.coyote.assess.domain.Question;
import systems.coyote.assess.repository.dao.QuestionDao;
import systems.coyote.assess.service.dto.SubjectDto;
import systems.coyote.assess.service.mapper.SubjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * A simple implementation for {@link SubjectService}
 */
@Service
public class SimpleSubjectService implements SubjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSubjectService.class);

    private final QuestionDao questionDao;
    private final SubjectMapper subjectMapper;

    public SimpleSubjectService(QuestionDao questionDao, SubjectMapper subjectMapper) {
        this.questionDao = questionDao;
        this.subjectMapper = subjectMapper;
    }

    /**
     * find all the subjects and their questions
     *
     * @return a list of the questions with subjects
     */
    @Override
    public List<SubjectDto> findAllSubjectsAndQuestions() {
        LOGGER.debug("Request to get all the subjects and the questions");

        List<Question> questions = questionDao.findAllQuestionsAndSubjects();

        if (questions != null) {
            return subjectMapper.questionsToSubjectsDto(questions);
        }

        return Collections.emptyList();
    }

}
