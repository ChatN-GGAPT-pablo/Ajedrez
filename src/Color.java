public enum Color {
    BLANCO("B"),
    NEGRO("N");

    private final String simbolo;

    Color(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
