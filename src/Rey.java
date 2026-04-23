public class Rey extends Pieza{
    public Rey(String nombrePieza, String color) {
        super(nombrePieza, color);
    }

    @Override
    public void posiblesMovimiento(int iActual, int jActual) {

    }

    @Override
    public String toString() {
        return "R" + this.getColor();
    }


}
