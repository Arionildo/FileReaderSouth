package br.com.south.filereadersouth.mocker;

import java.util.Arrays;
import java.util.List;

import br.com.south.filereadersouth.entity.Item;

public class ItemMocker extends GenericMocker {
	public static final Item ENTITY = Item.builder()
			.id(NUMERO)
			.quantidade(VALOR)
			.valor(VALOR)
			.build();
	
	public static final List<Item> ENTITIES = Arrays.asList(ENTITY);
}
