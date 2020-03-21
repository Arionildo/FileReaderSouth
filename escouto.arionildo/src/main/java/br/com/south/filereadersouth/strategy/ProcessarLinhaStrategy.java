package br.com.south.filereadersouth.strategy;

public interface ProcessarLinhaStrategy {
	void processar(String[] campos);
	boolean validar(String[] campos);
}
