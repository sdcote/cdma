package systems.coyote.assess.repository.dao;

import java.util.List;

import systems.coyote.assess.domain.Question;

/**
 * Question dao
 */
public interface QuestionDao {

  /**
   * find all questions with their subjects
   *
   * @return a list of the questions with subjects
   * @throws DaoException if there is an sql exception
   */
  List<Question> findAllQuestionsAndSubjects();

  /**
   * Returns the list of ids of the not found questions using ids
   *
   * @param questionsIds ids of the questions to check
   * @return a list of the ids of the not found questions
   * @throws DaoException             if there is an sql exception
   * @throws IllegalArgumentException if any given argument is invalid
   */
  List<Long> findNonExistingQuestionsByQuestionsIds(List<Long> questionsIds);
}
