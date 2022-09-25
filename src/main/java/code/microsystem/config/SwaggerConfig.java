//package code.microsystem.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//
//
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableWebMvc
//public class SwaggerConfig implements WebMvcConfigurer{  
//	
//	@Bean
//	public Docket postApi() {
//		return new Docket(DocumentationType.SWAGGER_2).groupName("medico").select()
//				
//				.paths(regex("/api/v1.*")).build();
//	
//		
//
//}
//
//	private ApiInfo getApiInfo() {
//		
//		return new ApiInfoBuilder().title("Online Medico Ngo")
//				.description("Online Medico Ngo API Documentation").version("1.0").build();
//	}
//}
// 