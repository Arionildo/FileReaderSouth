package br.com.south.filereadersouth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private int id;
    private double quantidade;
    private double valor;

    public double valorTotal() {
        return (quantidade * valor);
    }
}
