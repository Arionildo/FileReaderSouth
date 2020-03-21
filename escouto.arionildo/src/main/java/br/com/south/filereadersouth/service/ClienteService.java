package br.com.south.filereadersouth.service;

import br.com.south.filereadersouth.entity.Cliente;
import br.com.south.filereadersouth.repository.ClienteRepository;

public class ClienteService {

    private static final ClienteRepository CLIENTE_REPOSITORY = new ClienteRepository();

    public static void salvar(Cliente cliente) {
        CLIENTE_REPOSITORY.salvar(cliente);
    }

    public static int getTotalClientes() {
        return CLIENTE_REPOSITORY.getTotalClientes();
    }

    public static void limparLista() {
        CLIENTE_REPOSITORY.limparLista();
    }
}
