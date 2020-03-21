package br.com.south.filereadersouth.enumeration;

public enum TipoLinha {

    VENDEDOR("001"),
    CLIENTE("002"),
    VENDA("003");

    private String codigo;

    TipoLinha(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
