package br.com.alura.adopet.api.dto;

public record AtualizarTutorDto(Long id,
                                String nome,
                                String telefone,
                                String email) {
}
