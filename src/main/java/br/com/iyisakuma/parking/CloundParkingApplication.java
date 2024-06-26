package br.com.iyisakuma.parking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Parking API", version = "2.0", description = "Projeto de api desenvolvido junto com a dio"))
@SecurityScheme(name = "javainuseapi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class CloundParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloundParkingApplication.class, args);
	}

}
