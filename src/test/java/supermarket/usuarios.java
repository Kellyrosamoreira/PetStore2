package supermarket;


// 2 - Bibliotecas


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;

// 3 - Classes
public class usuarios {
    String uri = "https://serverest.dev/usuarios/";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test(priority = 1)  // Identifica o método ou função como um teste para o TestNG
    public void incluiruser() throws IOException {
        String jsonBody = lerJson("db/supermarket.json");

        // Sintaxe Gherkin
        // Dado - Quando - Então
        // Given - When - Then

        given() // Dado
                .contentType("application/json") // comum em API REST - antigas era "text/xml"
                .log().all()
                .body(jsonBody)
        .when()  // Quando
                .post(uri)
        .then()  // Então
                .log().all()
                //.statusCode(201)
                .statusCode(400)
               // .body("name", is("Kelly Gutlich"))
                //.body("email", is("teste@kelly.com"))
                //.body("email", is("teste@kelly.com"))
                //.body("password", is("teste12"))

        ;

    }
}

