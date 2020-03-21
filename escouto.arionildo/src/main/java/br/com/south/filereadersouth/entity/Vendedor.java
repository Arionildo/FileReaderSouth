package br.com.south.filereadersouth.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {

    private int id;
    private String cpf;
    private String nome;
    private double salario;
    private List<Venda> vendas;

}
