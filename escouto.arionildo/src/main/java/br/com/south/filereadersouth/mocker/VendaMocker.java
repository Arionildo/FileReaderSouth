package br.com.south.filereadersouth.mocker;

import java.util.Arrays;
import java.util.List;

import br.com.south.filereadersouth.entity.Venda;

public class VendaMocker extends GenericMocker {
	public static final Venda ENTITY = Venda.builder()
			.id(NUMERO)
			.listaItem(ItemMocker.ENTITIES)
			.nomeVendedor(TEXTO)
			.valor(VALOR)
			.vendedor(VendedorMocker.ENTITY)
			.build();
	
	public static final List<Venda> ENTITIES = Arrays.asList(ENTITY);
}
