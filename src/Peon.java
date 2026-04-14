public class Peon extends Pieza{

    public Peon(String nombrePieza, String color, int numeroPieza) {
        super(nombrePieza, color, numeroPieza);
    }

String colorString = this.getColor();




    @Override
    public String toString() {
        return "P" + this.getColor() + this.getNumeroPieza() ;
    }
}

