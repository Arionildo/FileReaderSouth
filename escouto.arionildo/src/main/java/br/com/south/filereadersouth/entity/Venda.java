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
public class Venda {

    private int id;
    private List<Item> listaItem;
    private double valor;
    private Vendedor vendedor;
    private String nomeVendedor;

    public void addItem(Item item) {
        listaItem.add(item);
        valor += item.valorTotal();
    }
}
