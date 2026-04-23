public class Dama extends Pieza{
    public Dama(String nombrePieza, String color) {
        super(nombrePieza, color);
    }

    @Override
    public void posiblesMovimiento(int iActual, int jActual) {

    }

    @Override
    public String toString() {
        return "D" + this.getColor();
    }
}
