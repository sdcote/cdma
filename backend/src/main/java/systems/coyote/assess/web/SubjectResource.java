package systems.coyote.assess.web;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import systems.coyote.assess.service.SubjectService;
import systems.coyote.assess.service.dto.SubjectDto;

import java.util.List;


/**
 * Rest resource for subject entity
 */
@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectResource.class);

    private final SubjectService subjectService;

    public SubjectResource(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     * GET  /subjects : get all the find all the subjects and their questions.
     *
     * @return the ResponseEntity with status 200 (OK) and the list the subjects and their questions
     */
    @Timed
    @GetMapping
    public List<SubjectDto> findAllSubjectsAndQuestions() {
        LOGGER.debug("REST request to get all the subjects and the questions");
        return subjectService.findAllSubjectsAndQuestions();
    }

}
