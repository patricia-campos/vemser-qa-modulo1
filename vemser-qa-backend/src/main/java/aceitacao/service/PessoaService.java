package aceitacao.service;

import aceitacao.dto.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PessoaService {


    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX0FETUlOIiwiUk9MRV9NQVJLRVRJTkciXSwiaWF0IjoxNjU5ODAzODQ4LCJleHAiOjE2NTk4OTAyNDh9.4nYorsDyzRnWTl-pzfeZav_Wv-oS7z8EweOiXT11VpQ";

    String baseUrl = "http://dbc-pessoa-api.herokuapp.com/pessoa";


    //==================================================================================================================
    //                                                 POST
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 4 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    public PessoaDTO adicionarPessoaComSucesso(String jsonBody) {

        PessoaDTO result = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaDTO.class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 4 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    public ResponseErroDTO adicionarPessoaSemSucesso(String jsonBody) {

        ResponseErroDTO result = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseUrl)
                .then()
                .log().all() //
                .statusCode(400)
                .extract().as(ResponseErroDTO.class);

        return result;
    }

    //==================================================================================================================
    //                                                 PUT
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 1 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    public PessoaDTO editarPessoaComSucesso(Integer idPessoa, String jsonBody) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/" + idPessoa;

        PessoaDTO result = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaDTO.class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 1 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    public ResponseErroDTO editarPessoaSemSucesso(Integer idPessoa, String jsonBody) {
        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/" + idPessoa;

        ResponseErroDTO result = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(Url)
                .then()
                .log().all() //
                .statusCode(400)
                .extract().as(ResponseErroDTO.class);

        return result;
    }

    //==================================================================================================================
    //                                                 DELETE
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 2 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    public Response deletarPessoaComSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/" + idPessoa;

        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .delete(Url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 2 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    public Response deletarPessoaSemSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/" + idPessoa;


        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .delete(Url)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
        return result;
    }

    //==================================================================================================================
    //                                          GET | pessoas - paginado
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 3 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    public PessoaPaginadaDTO consultarPessoaPaginadaComSucesso(Integer pagina, Integer tamanhoDasPaginas) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa?pagina=" + pagina + "&tamanhoDasPaginas=" + tamanhoDasPaginas;

        PessoaPaginadaDTO result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaPaginadaDTO.class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 3 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    public Response consultarPessoaPaginadaSemSucesso(Integer pagina, Integer tamanhoDasPaginas) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa?pagina=" + pagina + "&tamanhoDasPaginas=" + tamanhoDasPaginas;

        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all()
                .statusCode(500)
                .extract().response();
        return result;
    }

    //==================================================================================================================
    //                                              GET | pessoa por cpf
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 5 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    public PessoaDTO consultarPessoaCpfComSucesso(String cpf) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/" + cpf + "/cpf";

        PessoaDTO result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaDTO.class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 5 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: Falha na aplicação. O resultado não existe e ainda asssim retorna 200.

    public Response consultarPessoaCpfSemSucesso(String cpf) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/" + cpf + "/cpf";

        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
        return result;
    }

    //==================================================================================================================
    //                                           GET | relatório pessoa
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 6 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    public PessoaRelatorioDTO[] consultarPessoaRelatorioComSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/relatorio?idPessoa=" + idPessoa;

        PessoaRelatorioDTO[] result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaRelatorioDTO[].class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 6 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: Falha na aplicação. O resultado não existe e ainda asssim retorna 200.

    public Response consultarPessoaRelatorioSemSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/relatorio?idPessoa=" + idPessoa;

        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
        return result;
    }

    //==================================================================================================================
    //                                              GET | lista completa
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 7 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    // Teste realizado com a busca por parâmetro (idPessoa):
    public PessoaCompletaDTO[] consultarPessoaCompletaComSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-completa?idPessoa=" + idPessoa;

        PessoaCompletaDTO[] result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaCompletaDTO[].class);

        return result;
    }

    // Teste realizado com a busca sem o parâmetro:
    public PessoaCompletaDTO[] consultarPessoaCompletaComSucesso() {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-completa";

        PessoaCompletaDTO[] result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaCompletaDTO[].class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 7 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    public Response consultarPessoaCompletaSemSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-com-enderecos?idPessoa=" + idPessoa;

        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
        return result;
    }

    //==================================================================================================================
    //                                            GET | lista com endereços
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 8 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    // Teste realizado com a busca por parâmetro (idPessoa):
    public PessoaEnderecoDTO[] consultarPessoaEnderecoComSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-com-enderecos?idPessoa=" + idPessoa;

        PessoaEnderecoDTO[] result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaEnderecoDTO[].class);

        return result;
    }

    // Teste realizado com a busca sem parâmetro:
    public PessoaEnderecoDTO[] consultarPessoaEnderecoComSucesso() {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-com-enderecos";

        PessoaEnderecoDTO[] result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaEnderecoDTO[].class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 8 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    public Response consultarPessoaEnderecoSemSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-com-enderecos?idPessoa=" + idPessoa;

        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
        return result;
    }

    //==================================================================================================================
    //                                              GET | lista com contatos
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 9 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    // Teste realizado com a busca por parâmetro (idPessoa):
    public PessoaContatoDTO[] consultarPessoaContatoComSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-com-contatos?idPessoa=" + idPessoa;

        PessoaContatoDTO[] result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaContatoDTO[].class);

        return result;
    }

    // Teste realizado com a busca sem parâmetro:
    public PessoaContatoDTO[] consultarPessoaContatoComSucesso() {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-com-contatos";

        PessoaContatoDTO[] result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaContatoDTO[].class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 9 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    public Response consultarPessoaContatoSemSucesso(Integer idPessoa) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/lista-com-contatos?idPessoa=" + idPessoa;

        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
        return result;
    }

    //==================================================================================================================
    //                                        GET | lista pessoas por nome
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 11 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    public PessoaDTO[] consultarPessoaNomeComSucesso(String nome) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/byname?nome=" + nome;

        PessoaDTO[] result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all() //
                .statusCode(200)
                .extract().as(PessoaDTO[].class);

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 11 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: Falha na aplicação. O resultado não existe e ainda asssim retorna 200.


    public Response consultarPessoaNomeSemSucesso(String nome) {

        String Url = "http://dbc-pessoa-api.herokuapp.com/pessoa/byname?nome=" + nome;


        Response result = given()
                .header("Authorization", token)
                .log().all()
                .when()
                .get(Url)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
        return result;
    }
}
