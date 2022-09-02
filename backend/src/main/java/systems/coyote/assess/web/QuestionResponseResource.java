package systems.coyote.assess.web;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import systems.coyote.assess.domain.Question;
import systems.coyote.assess.domain.UserResponse;
import systems.coyote.assess.service.UserResponseService;
import systems.coyote.assess.service.dto.UserResponseForQuestionDto;
import systems.coyote.assess.service.dto.UserResponsesForQuestionListDto;

import javax.validation.Valid;
import java.util.List;

import static systems.coyote.assess.web.util.RestUtils.commaDelimitedListToLongList;


/**
 * Rest Resource for the entities {@link UserResponse} and {@link Question}
 */
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionResponseResource {

    /* because this example is not using Spring Security yet the user id is simply hardcoded */
    private static final Long USER_ID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionResponseResource.class);

    private final UserResponseService userResponseService;

    public QuestionResponseResource(UserResponseService userResponseService) {
        this.userResponseService = userResponseService;
    }


    /**
     * GET  /:questionsId/responses/me : Get the responses of the connected user for the provided questions
     *
     * @param questionsId a comma separated ids of the questions that the user responded
     * @return the ResponseEntity with status 200 (OK) and list of responses of the user
     * and the ResponseEntity with status 500 if the request body is invalid
     */
    @Timed
    @GetMapping("/{questionsId}/responses/me")
    public List<UserResponseForQuestionDto> getResponsesOfConnectUserForQuestions(@PathVariable("questionsId") String questionsId) {
        LOGGER.debug("REST request to get the responses of the connected user for the questions with ids {}", questionsId);
        return userResponseService.findResponsesOfUserForQuestions(USER_ID, commaDelimitedListToLongList(questionsId));
    }

    /**
     * POST  /responses/me : Save the responses of the connected user for the provided questions
     *
     * @param userResponseForQuestions questions ids and contents that the connected user entered
     * @return the ResponseEntity with status 200 (OK) and list of the saved responses of the user
     * and the ResponseEntity with status 500 if the request body is invalid
     */
    @Timed
    @PostMapping("/responses/me")
    public List<UserResponseForQuestionDto> saveResponsesOfConnectUserForQuestions(@Valid @RequestBody UserResponsesForQuestionListDto userResponseForQuestions) {
        LOGGER.debug("REST request to save the responses of the connected user for the questions {}", userResponseForQuestions);
        return userResponseService.saveResponsesOfUserForQuestions(USER_ID, userResponseForQuestions.getResponses());
    }

}
