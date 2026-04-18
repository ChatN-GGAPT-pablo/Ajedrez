public abstract class Pieza {

    private String nombrePieza;
    private String color;
    private int numeroPieza;
    boolean reyPeligro = false;
    /**
     * Constructor para rey y reina pq solo hay uno de cada y no necesitan "numero"
     * @param nombrePieza
     * @param color
     */
    public Pieza(String nombrePieza, String color) {
        this.nombrePieza = nombrePieza;
        this.color = color;
    }

    /**
     * Constructor para el resto de piezas
     * @param nombrePieza
     * @param color
     * @param numeroPieza
     */
    public Pieza(String nombrePieza, String color, int numeroPieza) {
        this.nombrePieza = nombrePieza;
        this.color = color;
        this.numeroPieza = numeroPieza;
    }


    public String getNombrePieza() {
        return nombrePieza;
    }
    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroPieza() {
        return numeroPieza;
    }
    public void setNumeroPieza(int numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public boolean hayJaque(){
        if (reyPeligro){
            return true;
        }
        return false;
    }
    public boolean puedeMover(){
        if (hayJaque()){
            return false;
        }
        return false;
    }


}
