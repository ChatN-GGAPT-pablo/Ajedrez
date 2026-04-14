public class Caballo extends Pieza{
    public Caballo(String nombrePieza, String color, int numeroPieza) {
        super(nombrePieza, color, numeroPieza);
    }

    @Override
    public String toString() {
        return "C" + this.getColor() + this.getNumeroPieza();
    }
}
