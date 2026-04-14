public class Alfil extends Pieza{
    public Alfil(String nombrePieza, String color, int numeroPieza) {
        super(nombrePieza, color, numeroPieza);
    }

    @Override
    public String toString() {
        return "A" + this.getColor() + this.getNumeroPieza();
    }
}
