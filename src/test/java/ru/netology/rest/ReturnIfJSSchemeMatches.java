package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ReturnIfJSSchemeMatches {    @Test
void shouldReturnDemoAccounts() {
    // Given - When - Then
    // Предусловия
    given()
            .baseUri("http://localhost:9999/api/v1")
            // Выполняемые действия
            .when()
            .get("/demo/accounts")
            // Проверка соответствия переменной схеме
            .then()
            .statusCode(200)
            // static import для JsonSchemaValidator.matchesJsonSchemaInClasspath
            .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
    ;
}
}