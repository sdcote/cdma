package systems.coyote.assess.service;

import java.util.List;

import systems.coyote.assess.service.dto.SubjectDto;

/**
 * Subject service
 */
public interface SubjectService {

  /**
   * find all the subjects and their questions
   *
   * @return a list of the questions with subjects
   */
  List<SubjectDto> findAllSubjectsAndQuestions();

}
