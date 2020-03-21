package br.com.south.filereadersouth.repository;

import java.util.HashMap;

import br.com.south.filereadersouth.entity.Cliente;

public class ClienteRepository {

    private HashMap<String, Cliente> clientes = new HashMap<>();

    public void salvar(Cliente cliente) {
        clientes.put(cliente.getCnpj(), cliente);
    }

    public int getTotalClientes() {
        return clientes.size();
    }

    public void limparLista() {
        clientes.clear();
    }
}
