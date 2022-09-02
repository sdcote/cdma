package systems.coyote.assess.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Swagger Configuration
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("PublicAPI")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI cdmAssessmentAPI() {
        return new OpenAPI()
                .info(new Info().title("CDM Assessment API")
                        .description("Continuous Delivery Maturity Assessment")
                        .version("v0.0.1")
                        .contact(new Contact().name("Coyote Systems").email("coyotesys.gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("CDM Assessment Wiki Documentation")
                        .url("https://github.com/sdcote/assess/"));
    }

}
