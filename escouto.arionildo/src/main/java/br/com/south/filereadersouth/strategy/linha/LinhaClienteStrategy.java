package br.com.south.filereadersouth.strategy.linha;

import static java.util.Objects.isNull;

import br.com.south.filereadersouth.entity.Cliente;
import br.com.south.filereadersouth.enumeration.TipoLinha;
import br.com.south.filereadersouth.service.ClienteService;
import br.com.south.filereadersouth.strategy.ProcessarLinhaStrategy;

public class LinhaClienteStrategy implements ProcessarLinhaStrategy {

	@Override
	public void processar(String[] campos) {
		if (validar(campos)) {
			Cliente cliente = Cliente.builder()
					.id(Integer.parseInt(campos[0]))
					.cnpj(campos[1])
					.nome(campos[2])
					.area(campos[3])
					.build();
			ClienteService.salvar(cliente);
		}
	}

	@Override
	public boolean validar(String[] campos) {
		if (isNull(campos) || campos.length == 0) {
			return false;
		}
		
		String tipoLinha = campos[0];
		return TipoLinha.CLIENTE.getCodigo().equals(tipoLinha);
	}

}
