package br.com.south.filereadersouth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private int id;
    private String cnpj;
    private String nome;
    private String area;
}
