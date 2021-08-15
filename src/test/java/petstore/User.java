package petstore;


//Biblioteca


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

//Classes
public class User {
    // 3.1 - Atributos
    String uri = "https://petstore.swagger.io/v2/user/createWithList";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }


// 3.2 - Métodos e Funções
@Test(priority = 1)

    public void incluirUser() throws IOException {
    String jsonBody = lerJson("db/usuario.json");

    given() // Dado
            .contentType("application/json") // comum em API REST - antigas era "text/xml"
            .log().all()
            .body(jsonBody)
    .when()  // Quando
            .post(uri)
    .then()  // Então
            .log().all()
            .statusCode(200)
            .body("username", is("TesteKelly"))
            //.body("username", is("TesteKelly"))
            //.body("password", is("1234"))
            //.body("email", is("kelly@teste.com.br"))
           // .body("lastName", is("Gutlich"))

    ;


}


}