public class Rey extends Pieza{
    public Rey(String nombrePieza, String color) {
        super(nombrePieza, color);
    }

    @Override
    public String toString() {
        return "R" + this.getColor();
    }
}
