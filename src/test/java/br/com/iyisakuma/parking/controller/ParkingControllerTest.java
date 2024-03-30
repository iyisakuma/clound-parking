package br.com.iyisakuma.parking.controller;

import br.com.iyisakuma.parking.dto.ParkingCreateDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest {

    @LocalServerPort
    private int randomPort;
    @BeforeEach
    void setUp() {
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllCheckResult() {
        RestAssured.given()
                .when()
                .get("/parkings")
                .then()
                .statusCode(200);

    }

    @Test
    void whenCreateThenCheckIsCreated(){
//        var createdDTO = new ParkingCreateDTO();
//        createdDTO.setColor("Amarelo");
//        createdDTO.setModel("Brasilia");
//
//        RestAssured
//                .given()
//                .when()
//                .body(createdDTO)
//                .contentType("application/json")
//                .post("/parkings")
//                .then()
//                .statusCode(HttpStatus.CREATED.value());




    }

}