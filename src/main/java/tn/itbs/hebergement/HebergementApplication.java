package tn.itbs.hebergement;

import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.itbs.hebergement.entities.AppRole;
import tn.itbs.hebergement.entities.AppUser;
import tn.itbs.hebergement.service.AccountService;

@SpringBootApplication
@EnableSwagger2
public class HebergementApplication implements CommandLineRunner {
	@Autowired
	//private AccountService accountService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HebergementApplication.class, args);
	}
	/*@Bean
	public BCryptPasswordEncoder GetBCPE() {
		return new BCryptPasswordEncoder();
	}*/
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/v1/*/*"))
				.apis(RequestHandlerSelectors.basePackage("tn.itbs.hebergement"))
				.build()
				.apiInfo(apiDetails());
				
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
		  "Hébergement  hôtelier",
		  "Documentation d'un Web Service pour hébergement hôtelier",
		  "1.0.1",
		  "Private License",
		  new springfox.documentation.service.Contact("Dali Chtioui",null,"dalichtioui123@gmail.com"),
		  "API License",
		  null,
		  Collections.emptyList());
		  
	}

	@Override
	public void run(String... args) throws Exception {
		/*accountService.saveUser(new AppUser (null,"user","1234",null));
		accountService.saveUser(new AppUser(null,"admin","1234",null));
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));

		accountService.addRoleToUser("user"	,"USER");
		accountService.addRoleToUser("admin","ADMIN");
		accountService.addRoleToUser("admin","USER");*/


		
		
		
	}
}
