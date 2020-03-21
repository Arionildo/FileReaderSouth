package br.com.south.filereadersouth.service;

import br.com.south.filereadersouth.entity.Vendedor;
import br.com.south.filereadersouth.repository.VendedorRepository;

public class VendedorService {

    private static final VendedorRepository DADOS_VENDEDOR = new VendedorRepository();

    public static void salvar(Vendedor vendedor) {
        DADOS_VENDEDOR.salvar(vendedor);
    }

    public static int getTotalVendedores() {
        return DADOS_VENDEDOR.getTotalVendedores();
    }

    public static Vendedor findVendedorByNome(String nome) {
        return DADOS_VENDEDOR.findVendedorByNome(nome);
    }

    public static void limparLista() {
        DADOS_VENDEDOR.limparLista();
    }
}
