package br.com.south.filereadersouth.service;

import org.junit.Test;

import br.com.south.filereadersouth.mocker.VendedorMocker;

public class VendedorServiceTest {

    @Test
    public void givenVendedorThenTotalVendedores(){
    	VendedorService.salvar(VendedorMocker.ENTITY);
        VendedorService.getTotalVendedores();
        VendedorService.limparLista();
    }
}
