public abstract class Pieza implements Movible {

    private String nombrePieza;
    private String color;
    private int numeroPieza;
    boolean reyPeligro = false;
    int i;
    int j;
    /**
     * Constructor para rey y reina pq solo hay uno de cada y no necesitan "numero"
     * @param nombrePieza
     * @param color
     */
    public Pieza(String nombrePieza, String color, int i, int j) {
        this.nombrePieza = nombrePieza;
        this.color = color;
        this.i = i;
        this.j = j;
    }

    /**
     * Constructor para el resto de piezas
     * @param nombrePieza
     * @param color
     * @param numeroPieza
     */
    public Pieza(String nombrePieza, String color, int numeroPieza, int i, int j) {
        this.nombrePieza = nombrePieza;
        this.color = color;
        this.numeroPieza = numeroPieza;
        this.i = i;
        this.j = j;
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

    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }
    public void setJ(int j) {
        this.j = j;
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



    @Override
    public abstract void posiblesMovimiento(Pieza p);
}
