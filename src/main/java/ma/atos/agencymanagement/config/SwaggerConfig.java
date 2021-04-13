package ma.atos.agencymanagement.config;

import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

/**
 * The Swagger Config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket postsApi() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2);

        docket.groupName("public-api")
                .apiInfo(apiInfo()).select().build();

        ModelRef errorModel = new ModelRef("RestApiExceptionModel");
        List<ResponseMessage> responseMessages = Arrays.asList(
                new ResponseMessageBuilder()
                        .code(400)
                        .message("Syntaxe de la requete  est erronée")
                        .responseModel(errorModel).build(),
                new ResponseMessageBuilder()
                        .code(401)
                        .message("Non autorisés")
                        .responseModel(errorModel).build(),
                new ResponseMessageBuilder()
                        .code(403)
                        .message("Accès refusé")
                        .responseModel(errorModel).build(),
                new ResponseMessageBuilder()
                        .code(404)
                        .message("Ressource non trouvée")
                        .responseModel(errorModel).build(),
                new ResponseMessageBuilder()
                        .code(500)
                        .message("Erreur interne du serveur")
                        .responseModel(errorModel).build());

        docket.globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages);

        return docket;
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("AGENCYMANAGEMENT API")
                .description("AgencyManagement API reference for developers")
                .termsOfServiceUrl("http://javainuse.com").license("AGENCYMANAGEMENT APP")
                .licenseUrl("agencymanagement@gmail.com").version("1.0").build();

    }

}
