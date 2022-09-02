## Running from the command line

    mvn spring-boot:run


## Actuator
Spring boot actuator is used to provide basic observability. There are loads of endpoints you can use to monitor the instance.
```
http://localhost:8080/actuator
```
Of particular interest is the list of all the endpoints you can get with the `\actuator\mappings` endpoint.
## H2 Console

```
http://localhost:8080/h2-console
```


## Open API - Swagger

This project uses Springdoc for OpenAPI support. See the [Springdoc documentation](https://springdoc.org/#Introduction) for more information.

We can simply access the API documentation at:

    http://localhost:8080/swagger-ui.html

OpenAPI descriptions will be available at the path /v3/api-docs by default:

    http://localhost:8080/v3/api-docs/

To use a custom path, we can indicate in the application.properties file:
```yml
springdoc:
  api-docs:
    path: /api-docs
```
