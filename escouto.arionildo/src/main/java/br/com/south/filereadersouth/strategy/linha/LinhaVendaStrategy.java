package br.com.south.filereadersouth.strategy.linha;

import static java.util.Objects.isNull;

import java.util.ArrayList;

import br.com.south.filereadersouth.entity.Item;
import br.com.south.filereadersouth.entity.Venda;
import br.com.south.filereadersouth.entity.Vendedor;
import br.com.south.filereadersouth.enumeration.TipoLinha;
import br.com.south.filereadersouth.service.VendaService;
import br.com.south.filereadersouth.service.VendedorService;
import br.com.south.filereadersouth.strategy.ProcessarLinhaStrategy;

public class LinhaVendaStrategy implements ProcessarLinhaStrategy {

	@Override
	public void processar(String[] campos) {
		if (validar(campos)) {
			String item = campos[2];
	        item = item.substring(1, item.length() - 2);
	        
	        Venda venda = buildVenda(campos);
	        String[] listaItem = item.split(",");
	        
	        addItens(venda, listaItem);
	        VendaService.salvar(venda);
		}
	}

	private void addItens(Venda venda, String[] listaItem) {
		for (String itemAtual : listaItem) {
		    String[] camposItem = itemAtual.split("-");
		    Item item = Item.builder()
		    		.id(Integer.valueOf(camposItem[0]))
		    		.quantidade(Double.valueOf(camposItem[1]))
		    		.valor(Double.valueOf(camposItem[2]))
		    		.build();
			venda.addItem(item);
		}
	}

	private Venda buildVenda(String[] campos) {
		String nomeVendedor = campos[3];
		Vendedor vendedor = VendedorService.findVendedorByNome(nomeVendedor);
		Venda venda = Venda.builder()
				.id(Integer.parseInt(campos[1]))
				.vendedor(vendedor)
				.nomeVendedor(nomeVendedor)
				.listaItem(new ArrayList<>())
				.build();
		return venda;
	}

	@Override
	public boolean validar(String[] campos) {
		if (isNull(campos) || campos.length == 0) {
			return false;
		}
		
		String tipoLinha = campos[0];
		return TipoLinha.VENDA.getCodigo().equals(tipoLinha);
	}

}
