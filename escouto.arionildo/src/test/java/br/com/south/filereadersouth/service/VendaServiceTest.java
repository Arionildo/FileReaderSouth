package br.com.south.filereadersouth.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.south.filereadersouth.entity.Item;
import br.com.south.filereadersouth.entity.Venda;
import br.com.south.filereadersouth.mocker.VendedorMocker;

public class VendaServiceTest {

    @Test
    public void givenDuasVendasThenMaiorMenor(){
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, 3, 20.0));
        itens.add(new Item(2, 5, 200.0));
        itens.add(new Item(3, 3, 60.0));
		Venda venda = new Venda(1,itens, 520.0, VendedorMocker.ENTITY, "Teste1");

        List<Item> itens2 = new ArrayList<>();
        itens2.add(new Item(1, 3, 20.0));
        itens2.add(new Item(2, 3, 200.0));
        itens2.add(new Item(3, 5, 200.0));
        itens2.add(new Item(4, 3, 60.0));
        Venda venda2 = new Venda(2,itens2, 620.0, VendedorMocker.ENTITY, "Teste2");

        VendaService.salvar(venda);

        VendaService.salvar(venda2);

        Assert.assertEquals(2, VendaService.getIdMaiorVenda());

        Assert.assertEquals("Teste1", VendaService.getNomeVendedorMenorVenda());
        VendaService.limparLista();
    }
}
