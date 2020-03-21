package br.com.south.filereadersouth.mocker;

import br.com.south.filereadersouth.entity.Vendedor;

public class VendedorMocker extends GenericMocker {
	public static final Vendedor ENTITY = Vendedor.builder()
			.cpf(TEXTO)
			.id(NUMERO)
			.nome(TEXTO)
			.salario(VALOR)
			.vendas(VendaMocker.ENTITIES)
			.build();
}
