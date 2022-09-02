package systems.coyote.assess.service;

import systems.coyote.assess.exception.QuestionNotFoundException;
import systems.coyote.assess.exception.UserNotFoundException;
import systems.coyote.assess.service.dto.UserResponseForQuestionDto;

import java.util.List;

/**
 * User Response Service
 */
public interface UserResponseService {

    /**
     * Find the responses for the provided questions and user
     *
     * @param userId       id of the user who responded
     * @param questionsIds ids of the questions that the user may respond
     * @return list of responses of the user
     * @throws UserNotFoundException     if no user was found
     * @throws QuestionNotFoundException if no question was found
     * @throws IllegalArgumentException  if any given argument is invalid
     */
    List<UserResponseForQuestionDto> findResponsesOfUserForQuestions(Long userId, List<Long> questionsIds);

    /**
     * Save the responses of the connected user for the provided questions
     *
     * @param userId                    id of the user who responded
     * @param userResponsesForQuestions questions ids and contents that the connected user entered
     * @return List of the saved responses of the user
     * @throws UserNotFoundException     if no user was found
     * @throws QuestionNotFoundException if no question was found
     * @throws IllegalArgumentException  if any given argument is invalid
     */
    List<UserResponseForQuestionDto> saveResponsesOfUserForQuestions(Long userId, List<UserResponseForQuestionDto> userResponsesForQuestions);
}
