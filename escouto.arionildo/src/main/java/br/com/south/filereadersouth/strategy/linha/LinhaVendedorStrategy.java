package br.com.south.filereadersouth.strategy.linha;

import static java.util.Objects.isNull;

import br.com.south.filereadersouth.entity.Vendedor;
import br.com.south.filereadersouth.enumeration.TipoLinha;
import br.com.south.filereadersouth.service.VendedorService;
import br.com.south.filereadersouth.strategy.ProcessarLinhaStrategy;

public class LinhaVendedorStrategy implements ProcessarLinhaStrategy {

	@Override
	public void processar(String[] campos) {
		if (validar(campos)) {
			Vendedor vendedor = Vendedor.builder()
					.id(Integer.parseInt(campos[0]))
					.cpf(campos[1])
					.nome(campos[2])
					.salario(Double.parseDouble(campos[3]))
					.build();
			VendedorService.salvar(vendedor);
		}
	}

	@Override
	public boolean validar(String[] campos) {
		if (isNull(campos) || campos.length == 0) {
			return false;
		}
		
		String tipoLinha = campos[0];
		return TipoLinha.VENDEDOR.getCodigo().equals(tipoLinha);
	}

}
