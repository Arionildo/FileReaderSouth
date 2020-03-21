package br.com.south.filereadersouth.service;

import br.com.south.filereadersouth.entity.Venda;
import br.com.south.filereadersouth.repository.VendaRepository;

public class VendaService {

    private static final VendaRepository DADOS_VENDA = new VendaRepository();

    public static void salvar(Venda venda) {
        DADOS_VENDA.salvar(venda);
    }

    public static int getIdMaiorVenda() {
        return DADOS_VENDA.getMaiorVenda();
    }

    public static String getNomeVendedorMenorVenda() {
        return DADOS_VENDA.getNomeVendedorMenorVenda();
    }

    public static void limparLista() {
        DADOS_VENDA.limparLista();
    }
}
