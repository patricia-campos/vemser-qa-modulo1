package aceitacao;

import aceitacao.dto.*;
import aceitacao.service.PessoaService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PessoaAceitacao {


    PessoaService pessoaService = new PessoaService();

    // MASSA DE DADOS PARA O SERVICE
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }


    //==================================================================================================================
    //                                                 POST
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 4 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void adicionarPessoaComSucesso() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/pessoa.json");

        // Adição:
        PessoaDTO resultService = pessoaService.adicionarPessoaComSucesso(jsonBody);

        // Validações:
        Assert.assertEquals(resultService.getNome(), "Gabriel Luppi");
        Assert.assertEquals(resultService.getDataNascimento(), "2003-12-08");
        Assert.assertEquals(resultService.getCpf(), "56448825002");
        Assert.assertEquals(resultService.getEmail(), "gabriel.luppi@dbccompany.com.br");

        // Exclusão:
        pessoaService.deletarPessoaComSucesso(Integer.parseInt(resultService.getIdPessoa()));
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 4 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void adicionarPessoaSemSucesso() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/pessoasemsucesso.json");
        Object status = 400;
        List<String> errors = new ArrayList<>(List.of("nome: must not be blank"));

        // Adição:
        ResponseErroDTO resultService = pessoaService.adicionarPessoaSemSucesso(jsonBody);

        // Validações:
        Assert.assertEquals(resultService.getStatus(), status);
        Assert.assertEquals(resultService.getErrors(), errors);
    }

    //==================================================================================================================
    //                                                 PUT
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 1 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void editarPessoaComSucesso() throws IOException {

        // Adição:
        PessoaDTO resulService = adicionarPessoaJson();

        // Leitura da massa de dados:
        String jsonBody = lerJson("src/test/resources/data/pessoaEditada.json");

        PessoaDTO resultService = pessoaService.editarPessoaComSucesso(Integer.parseInt(resulService.getIdPessoa()), jsonBody);

        // Validações:
        Assert.assertEquals(resultService.getNome(), "Gabriel Looping");
        Assert.assertEquals(resultService.getDataNascimento(), "2003-12-08");
        Assert.assertEquals(resultService.getCpf(), "56448825002");
        Assert.assertEquals(resultService.getEmail(), "gabriel.luppi@dbccompany.com.br");

        // Exclusão:
        pessoaService.deletarPessoaComSucesso(Integer.parseInt(resultService.getIdPessoa()));
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 1 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void putPessoaSemSucesso() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/pessoasemsucesso.json");
        Object status = 400;
        List<String> errors = new ArrayList<>(List.of("nome: must not be blank"));

        // Adição:
        PessoaDTO resulService = adicionarPessoaJson();

        ResponseErroDTO resultService = pessoaService.editarPessoaSemSucesso(Integer.parseInt(resulService.getIdPessoa()), jsonBody);

        // Validações:
        Assert.assertEquals(resultService.getStatus(), status);
        Assert.assertEquals(resultService.getErrors(), errors);
    }

    //==================================================================================================================
    //                                                 DELETE
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 2 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void deletarPessoaComSucesso() throws IOException {

        // Adição:
        PessoaDTO resulService = adicionarPessoaJson();

        Response resultService = pessoaService.deletarPessoaComSucesso(Integer.parseInt(resulService.getIdPessoa()));

        // Validação:
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 2 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void deletarPessoaSemSucesso() throws IOException {

        Response resultService = pessoaService.deletarPessoaSemSucesso(45455444);

        // Validação:
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    //==================================================================================================================
    //                                          GET | pessoas - paginado
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 3 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void consultarPessoaPaginadaComSucesso() throws IOException {

        PessoaPaginadaDTO resultService = pessoaService.consultarPessoaPaginadaComSucesso(0, 20);

        // Validação:
        Assert.assertEquals(resultService.getPage(), "0");
        Assert.assertEquals(resultService.getSize(), "20");
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 3 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void consultarPessoaPaginadaSemSucesso() {

        Response resultService = pessoaService.consultarPessoaPaginadaSemSucesso(0, 0);

        // Validação:
        Assert.assertEquals(resultService.getStatusCode(), 500);
    }

    //==================================================================================================================
    //                                              GET | pessoa por cpf
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 5 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void consultarPessoaCpfComSucesso() throws IOException {

        PessoaDTO resultService = pessoaService.consultarPessoaCpfComSucesso("15626852018");

        // Validação:
        Assert.assertEquals(resultService.getNome(), "gabriel");
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 5 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: Falha na aplicação. O resultado não existe e ainda asssim retorna 200.

    @Test
    public void consultarPessoaCpfSemSucesso() {

        Response resultService = pessoaService.consultarPessoaCpfSemSucesso("00000000000");

        // Validação:
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    //==================================================================================================================
    //                                           GET | relatório pessoa
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 6 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void consultarPessoaRelatorioComSucesso() throws IOException {

        // Adição:
        PessoaDTO resulService = adicionarPessoaJson();

        PessoaRelatorioDTO[] resultService = pessoaService.consultarPessoaRelatorioComSucesso(Integer.parseInt(resulService.getIdPessoa()));

        // Validação:
        Assert.assertEquals(resultService[0].getNomePessoa(), "Gabriel Luppi");
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 6 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: Falha na aplicação. O resultado não existe e ainda asssim retorna 200.

    @Test
    public void consultarPessoaRelatorioSemSucesso() {

        Response resultService = pessoaService.consultarPessoaRelatorioSemSucesso(0);

        // Validação:
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    //==================================================================================================================
    //                                              GET | lista completa
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 7 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    // Teste realizado com a busca por parâmetro (idPessoa):
    @Test
    public void consultarPessoaCompletaComSucesso() throws IOException {

        PessoaDTO resultService = adicionarPessoaJson();

        PessoaCompletaDTO[] resulService = pessoaService.consultarPessoaCompletaComSucesso(Integer.parseInt(resultService.getIdPessoa()));

        //PessoaCompletaDTO[] resultService = pessoaService.consultarPessoaCompletaComSucesso(1);

        // Validação:
        Assert.assertEquals(resulService[0].getNome(), "Gabriel Luppi");
    }

    // Teste realizado com a busca sem o parâmetro:
    @Test
    public void consultarPessoaCompComSucesso() throws IOException {

        PessoaCompletaDTO[] resultService = pessoaService.consultarPessoaCompletaComSucesso();

        // Validação
        Assert.assertEquals(resultService[0].getNome(), "Gabriel Luppi");
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 7 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void consultarPessoaCompletaSemSucesso() {

        Response resultService = pessoaService.consultarPessoaCompletaSemSucesso(0);

        //Validação:
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    //==================================================================================================================
    //                                            GET | lista com endereços
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 8 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    // Teste realizado com a busca por parâmetro (idPessoa):
    @Test
    public void consultarPessoaEnderecoComSucesso() throws IOException {

        PessoaEnderecoDTO[] resultService = pessoaService.consultarPessoaEnderecoComSucesso(4);

        // Validação:
        Assert.assertEquals(resultService[0].getNome(), "Harry Potter");
    }

    // Teste realizado com a busca sem parâmetro:
    @Test
    public void consultarPessoaEndComSucesso() throws IOException {

        PessoaEnderecoDTO[] resultService = pessoaService.consultarPessoaEnderecoComSucesso();

        // Validação:
        Assert.assertEquals(resultService[0].getNome(), "Eduardo Miranda");
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 8 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void consultarPessoaEnderecoSemSucesso() {

        Response resultService = pessoaService.consultarPessoaEnderecoSemSucesso(0);

        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    //==================================================================================================================
    //                                              GET | lista com contatos
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 9 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    // Teste realizado com a busca por parâmetro (idPessoa):
    @Test
    public void consultarPessoaContatoComSucesso() throws IOException {

        PessoaContatoDTO[] resultService = pessoaService.consultarPessoaContatoComSucesso(4);

        // Validação:
        Assert.assertEquals(resultService[0].getNome(), "Harry Potter");
    }

    // Teste realizado com a busca sem parâmetro:
    @Test
    public void consultarPessoaContComSucesso() throws IOException {

        PessoaContatoDTO[] resultService = pessoaService.consultarPessoaContatoComSucesso();

        // Validação:
        Assert.assertEquals(resultService[0].getNome(), "Gabriel Luppi");
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 9 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void consultarPessoaContatoSemSucesso() {

        Response resultService = pessoaService.consultarPessoaContatoSemSucesso(0);

        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    //==================================================================================================================
    //                                        GET | lista pessoas por nome
    //==================================================================================================================
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 11 | pessoa-controller
    // CENÁRIO: COM SUCESSO
    // RESULTADO DO TESTE: OK

    @Test
    public void consultarPessoaNomeComSucesso() throws IOException {

        PessoaDTO[] resultService = pessoaService.consultarPessoaNomeComSucesso("Gabriel");

        // Validação:
        Assert.assertEquals(resultService[2].getNome(), "gabriel");
    }

    //------------------------------------------------------------------------------------------------------------------
    // PERMISSÃO TESTADA: Admin
    // ENDPOINT: 11 | pessoa-controller
    // CENÁRIO: SEM SUCESSO
    // RESULTADO DO TESTE: Falha na aplicação. O resultado não existe e ainda asssim retorna 200.

    @Test
    public void consultarPessoaNomeSemSucesso() {

        Response resultService = pessoaService.consultarPessoaNomeSemSucesso("00000000000");

        // Validação:
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }


    //==================================================================================================================
    //                                              MÉTODOS AUXILIARES
    //==================================================================================================================
    public PessoaDTO adicionarPessoaJson() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/pessoa.json");

        return pessoaService.adicionarPessoaComSucesso(jsonBody);
    }
}
