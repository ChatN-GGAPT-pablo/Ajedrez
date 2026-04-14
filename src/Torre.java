public class Torre extends Pieza{
    public Torre(String nombrePieza, String color, int numeroPieza) {
        super(nombrePieza, color, numeroPieza);
    }

    @Override
    public String toString() {
        return "T" + this.getColor() + this.getNumeroPieza();
    }
}
