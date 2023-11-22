enum Direcao {

    IN("in"), OUT("out");

    final String value;

    private Direcao(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}