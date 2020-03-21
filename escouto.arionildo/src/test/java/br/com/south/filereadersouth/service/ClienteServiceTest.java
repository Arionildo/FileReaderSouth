package br.com.south.filereadersouth.service;

import org.junit.Assert;
import org.junit.Test;

import br.com.south.filereadersouth.mocker.ClienteMocker;

public class ClienteServiceTest {

    @Test
    public void givenClienteThenSalvar(){
        ClienteService.salvar(ClienteMocker.ENTITY);
        Assert.assertEquals(1, ClienteService.getTotalClientes());
        ClienteService.limparLista();
    }
}
