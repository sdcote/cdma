package systems.coyote.assess.repository.dao;

import java.util.List;

import systems.coyote.assess.domain.UserResponse;

/**
 * User Response Dao
 */
public interface UserResponseDao {

  /**
   * Add a new responses of the user
   *
   * @param userResponses entities to save
   * @return an array of the number of rows affected by each statement
   * @throws DaoException             if there is an sql exception
   * @throws IllegalArgumentException if any given argument is invalid
   */
  int[] addUserResponses(List<UserResponse> userResponses);

  /**
   * Update responses of the user
   *
   * @param userResponses entities to save
   * @return an array of the number of rows affected by each statement
   * @throws DaoException             if there is an sql exception
   * @throws IllegalArgumentException if any given argument is invalid
   */
  int[] updateUserResponses(List<UserResponse> userResponses);

  /**
   * Find the responses for the provided questions and user
   *
   * @param userId       user who responded
   * @param questionsIds questions that the user may responded
   * @return list of responses
   * @throws DaoException             if there is an sql exception
   * @throws IllegalArgumentException if any given argument is invalid
   */
  List<UserResponse> findResponsesOfUserByUserIdAndQuestionIds(Long userId, List<Long> questionsIds);
}
