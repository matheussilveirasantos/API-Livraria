package br.com.escola.biblioteca.dto;

public record GeneroResponseDTO(
    Long id,
    String nome,
    String sigla
)   {

    public static GeneroResponseDTO fromEntity(GeneroRequestDTO requestDTO, Long id) {
        return new GeneroResponseDTO(id, requestDTO.nome(), requestDTO.sigla());
    }

}
