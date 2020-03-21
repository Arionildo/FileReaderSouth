package br.com.south.filereadersouth.repository;

import java.util.HashMap;

import br.com.south.filereadersouth.entity.Vendedor;

public class VendedorRepository {

    private HashMap<String, Vendedor> vendedores = new HashMap<>();

    public void salvar(Vendedor vendedor) {
        vendedores.put(vendedor.getCpf(), vendedor);
    }

    public Vendedor findVendedorByNome(String nome) {
        return vendedores.get(nome);
    }

    public int getTotalVendedores() {
        return vendedores.size();
    }

    public void limparLista() {
        vendedores.clear();
    }
}
