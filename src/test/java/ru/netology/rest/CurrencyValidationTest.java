package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.management.Query.or;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

public class CurrencyValidationTest {

    @Test
    void shouldReturnDemoAccountsCurrency() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                // специализированные проверки
                .contentType(ContentType.JSON)
                .body("[0].currency", anyOf (equalTo("USD"), equalTo("RUB")))
                //.body("[0].currency", equalTo("RUB"))

        ;
    }
}
