package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class PessoaCompletaDTO {

    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String idPessoa;
    private List<ContatoDTO> contatos;
    private List<EnderecoDTO> enderecos;
}
