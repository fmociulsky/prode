package io.fercha.prode.entity;

public enum FaseEnum {
    FECHA1("Fecha 1"),
    FECHA2("Fecha 2"),
    FECHA3("Fecha 3"),
    FECHA4("Fecha 4"),
    FECHA5("Fecha 5"),
    FECHA6("Fecha 6"),
    OCTAVOS("Octavos de Fina"),
    CUARTOS("Cuartos  de Final"),
    SEMIS("Semifinal"),
    FINAL("Final");

    private final String value;

    FaseEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
