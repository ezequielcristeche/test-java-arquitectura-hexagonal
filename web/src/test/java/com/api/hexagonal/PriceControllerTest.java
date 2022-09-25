package com.api.hexagonal;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql({"/sql/brands.sql", "/sql/prices.sql"})
public class PriceControllerTest {

    @LocalServerPort
    private int port;
    private static final String url = "http://localhost";

    @BeforeEach
    void init() {
        RestAssured.baseURI = url;
        RestAssured.port = port;
    }


    @Test
    void Should_Get_Price_When_Day_14_Hour_10() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/peticion_dia_14_hora_10.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then().statusCode(200)
                .body("product_id", equalTo(35455))
                .body("brand_id", equalTo(1))
                .body("price_list", equalTo(1))
                .body("start_date", equalTo("2020-06-14T00:00:00"))
                .body("end_date", equalTo("2020-12-31T23:59:59"))
                .body("price", equalTo(35.5f));
    }

    @Test
    void Should_Get_Price_When_Day_14_Hour_16() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/peticion_dia_14_hora_16.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then().statusCode(200)
                .body("product_id", equalTo(35455))
                .body("brand_id", equalTo(1))
                .body("price_list", equalTo(2))
                .body("start_date", equalTo("2020-06-14T15:00:00"))
                .body("end_date", equalTo("2020-06-14T18:30:00"))
                .body("price", equalTo(25.45f));
    }

    @Test
    void Should_Get_Price_When_Day_14_Hour_21() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/peticion_dia_14_hora_21.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then().statusCode(200)
                .body("product_id", equalTo(35455))
                .body("brand_id", equalTo(1))
                .body("price_list", equalTo(1))
                .body("start_date", equalTo("2020-06-14T00:00:00"))
                .body("end_date", equalTo("2020-12-31T23:59:59"))
                .body("price", equalTo(35.5f));
    }

    @Test
    void Should_Get_Price_When_Day_15_Hour_10() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/peticion_dia_15_hora_10.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then().statusCode(200)
                .body("product_id", equalTo(35455))
                .body("brand_id", equalTo(1))
                .body("price_list", equalTo(3))
                .body("start_date", equalTo("2020-06-15T00:00:00"))
                .body("end_date", equalTo("2020-06-15T11:00:00"))
                .body("price", equalTo(30.50f));
    }

    @Test
    void Should_Get_Price_When_Day_16_Hour_21() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/peticion_dia_16_hora_21.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then().statusCode(200)
                .body("product_id", equalTo(35455))
                .body("brand_id", equalTo(1))
                .body("price_list", equalTo(4))
                .body("start_date", equalTo("2020-06-15T16:00:00"))
                .body("end_date", equalTo("2020-12-31T23:59:59"))
                .body("price", equalTo(38.95f));
    }

    @Test
    void Should_Throw_DomainNotFoundException_When_Brand_Does_Not_Exist() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/brandid_no_existente.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then()
                .assertThat()
                .statusCode(404)
                .body("errors[0].message", is("No existe una marca con id: 2"));

    }

    @Test
    void Should_Throw_DomainNotFoundException_When_ProductId_Does_Not_Exist() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/productid_no_existente.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then()
                .assertThat()
                .statusCode(404)
                .body("errors[0].message", is("No se encuentra el precio a aplicar para la " +
                        "fecha: 2020-06-16T21:00:00.090, producto: 1111, marca: 1"));
    }

    @Test
    void Should_Throw_MethodArgumentNotValidException_When_BrandId_Is_Null() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/brandid_nulo.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then()
                .assertThat()
                .statusCode(400)
                .body("errors[0].message", is("el campo brand_id no puede ser nulo"));
    }

    @Test
    void Should_Throw_MethodArgumentNotValidException_When_ProductId_Is_Null() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/productid_nulo.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then()
                .assertThat()
                .statusCode(400)
                .body("errors[0].message", is("el campo product_id no puede ser nulo"));
    }

    @Test
    void Should_Throw_MethodArgumentNotValidException_When_ApplicationDate_Is_Null() {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(new File("src/test/resources/json/application_date_nulo.json"))
                .header("Authorization", "???")
                .when()
                .post(url + "/api/hexagonal/prices")
                .then()
                .assertThat()
                .statusCode(400)
                .body("errors[0].message", is("el campo application_date no puede ser nulo"));
    }


}
