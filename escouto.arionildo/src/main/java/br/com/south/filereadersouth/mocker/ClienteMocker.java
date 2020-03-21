package br.com.south.filereadersouth.mocker;

import br.com.south.filereadersouth.entity.Cliente;

public class ClienteMocker extends GenericMocker {
	public static final Cliente ENTITY = Cliente.builder()
			.area(TEXTO)
			.cnpj(TEXTO)
			.id(NUMERO)
			.nome(TEXTO)
			.build();
}
