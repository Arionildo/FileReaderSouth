package br.com.south.filereadersouth.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.south.filereadersouth.entity.Venda;

public class VendaRepository {

    List<Venda> vendas = new ArrayList<>();

    public void salvar(Venda venda) {
        vendas.add(venda);
    }

    public int getMaiorVenda() {
        int id = 0;
        double valorMaiorVenda = 0.0;
        for (Venda venda : vendas) {
            if (venda.getValor() > valorMaiorVenda) {
                valorMaiorVenda = venda.getValor();
                id = venda.getId();
            }
        }
        return id;
    }
    
    public String getNomeVendedorMenorVenda() {
    	if (vendas.isEmpty()) {
    		return null;
    	}
        String nome = vendas.get(0).getNomeVendedor();
        double menorValor = vendas.get(0).getValor();

        for (Venda venda : vendas) {
            if (venda.getValor() < menorValor) {
                nome = venda.getNomeVendedor();
            }
        }
        return nome;
    }

    public void limparLista() {
        vendas.clear();
    }
}
