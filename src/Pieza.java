public abstract class Pieza implements Movible {

    private String nombrePieza;
    private String color;
    private int numeroPieza;
    boolean reyPeligro = false;
    int i;
    int j;

    /**
     * Constructor para rey y reina pq solo hay uno de cada y no necesitan "numero"
     *
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
     *
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



    public boolean hayJaqueARRIBA() {

        int iPieza = this.getI() - 1;
        int jPieza = this.getJ();

        //Vertical
        while (iPieza >= 0) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || (casilla.getNombrePieza().equals("Torre"))) {
                        return true;
                    }
                }
                return false;
            }
            iPieza--;
        }
        return false;

    }

    public boolean hayJaqueARRIBADERECHA() {

        int iPieza = this.getI() - 1;
        int jPieza = this.getJ() +1;

        //Horizontal
        while (jPieza <=8  && iPieza >=0) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || (casilla.getNombrePieza().equals("Alfil"))) {
                        return true;
                    }
                }
                return false;
            }
            iPieza--;
            jPieza++;
        }
        return false;
    }

    public boolean hayJaqueDERECHA() {

        int iPieza = this.getI();
        int jPieza = this.getJ() + 1;

        //Horizontal
        while (jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || (casilla.getNombrePieza().equals("Torre"))) {
                        return true;
                    }
                }
                return false;
            }
            jPieza++;
        }
        return false;
    }

    public boolean hayJaqueABAJODERECHA() {

        int iPieza = this.getI() + 1;
        int jPieza = this.getJ() + 1;

        //Horizontal
        while (jPieza <=8  && iPieza >=0) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || (casilla.getNombrePieza().equals("Alfil"))) {
                        return true;
                    }
                }
                return false;
            }
            iPieza++;
            jPieza++;
        }
        return false;
    }

    public boolean hayJaqueABAJO() {

        int iPieza = this.getI() + 1;
        int jPieza = this.getJ();

        //Vertical
        while (iPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || (casilla.getNombrePieza().equals("Torre"))) {
                        return true;
                    }
                }
                return false;
            }
            iPieza++;
        }
        return false;
    }

    public boolean hayJaqueABAJOIZQUIERDA() {

        int iPieza = this.getI() + 1;
        int jPieza = this.getJ() - 1;

        //Horizontal
        while (jPieza <=8  && iPieza >=0) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || (casilla.getNombrePieza().equals("Alfil"))) {
                        return true;
                    }
                }
                return false;
            }
            iPieza++;
            jPieza--;
        }
        return false;
    }

    public boolean hayJaqueIZQUIERDA() {

        int iPieza = this.getI();
        int jPieza = this.getJ() - 1;

        //Horizontal
        while (jPieza >= 0) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || (casilla.getNombrePieza().equals("Torre"))) {
                        return true;
                    }
                }
                return false;
            }
            jPieza--;
        }
        return false;
    }

    public boolean hayJaqueARRIBAIZQUIERDA() {

        int iPieza = this.getI() - 1;
        int jPieza = this.getJ() - 1;

        //Horizontal
        while (jPieza <=8  && iPieza >=0) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || (casilla.getNombrePieza().equals("Alfil"))) {
                        return true;
                    }
                }
                return false;
            }
            iPieza--;
            jPieza--;
        }
        return false;
    }




    public boolean hayJaqueCaballoARRIBADERECHA(){
        int iPieza = this.getI() - 2;
        int jPieza = this.getJ() + 1;

        Pieza casilla = Main.tablero[iPieza][jPieza];

        if (!(casilla.getColor().equals(this.getColor()))) {
            if (casilla.getNombrePieza().equals("Caballo") ) {
                return true;
            }
        }
        return false;
    }

    public boolean hayJaqueCaballoDERECHAARRIBA(){
        int iPieza = this.getI() - 1;
        int jPieza = this.getJ() + 2;

        Pieza casilla = Main.tablero[iPieza][jPieza];

        if (!(casilla.getColor().equals(this.getColor()))) {
            if (casilla.getNombrePieza().equals("Caballo") ) {
                return true;
            }
        }
        return false;
    }

    public boolean hayJaqueCaballoDERECHAABAJO(){
        int iPieza = this.getI() +1;
        int jPieza = this.getJ() + 2;

        Pieza casilla = Main.tablero[iPieza][jPieza];

        if (!(casilla.getColor().equals(this.getColor()))) {
            if (casilla.getNombrePieza().equals("Caballo") ) {
                return true;
            }
        }
        return false;
    }

    public boolean hayJaqueCaballoABAJODERECHA(){
        int iPieza = this.getI() + 2;
        int jPieza = this.getJ() + 1;

        Pieza casilla = Main.tablero[iPieza][jPieza];

        if (!(casilla.getColor().equals(this.getColor()))) {
            if (casilla.getNombrePieza().equals("Caballo") ) {
                return true;
            }
        }
        return false;
    }

    public boolean hayJaqueCaballoABAJOIZQUIERDA(){
        int iPieza = this.getI() + 2;
        int jPieza = this.getJ() - 1;

        Pieza casilla = Main.tablero[iPieza][jPieza];

        if (!(casilla.getColor().equals(this.getColor()))) {
            if (casilla.getNombrePieza().equals("Caballo") ) {
                return true;
            }
        }
        return false;
    }

    public boolean hayJaqueCaballoIZQUIERDAABAJO(){
        int iPieza = this.getI() + 1;
        int jPieza = this.getJ() - 2;

        Pieza casilla = Main.tablero[iPieza][jPieza];

        if (!(casilla.getColor().equals(this.getColor()))) {
            if (casilla.getNombrePieza().equals("Caballo") ) {
                return true;
            }
        }
        return false;
    }

    public boolean hayJaqueCaballoIZQUIERDAARRIBA(){
        int iPieza = this.getI() - 1;
        int jPieza = this.getJ() - 2;

        Pieza casilla = Main.tablero[iPieza][jPieza];

        if (!(casilla.getColor().equals(this.getColor()))) {
            if (casilla.getNombrePieza().equals("Caballo") ) {
                return true;
            }
        }
        return false;
    }

    public boolean hayJaqueCaballoARRIBAARRIBA(){
        int iPieza = this.getI() - 2;
        int jPieza = this.getJ() - 1;

        Pieza casilla = Main.tablero[iPieza][jPieza];

        if (!(casilla.getColor().equals(this.getColor()))) {
            if (casilla.getNombrePieza().equals("Caballo") ) {
                return true;
            }
        }
        return false;
    }


    public boolean hayJaque(){
        return hayJaqueARRIBA() ||
                hayJaqueARRIBADERECHA() ||
                hayJaqueDERECHA() ||
                hayJaqueABAJODERECHA() ||
                hayJaqueABAJO() ||
                hayJaqueABAJOIZQUIERDA() ||
                hayJaqueIZQUIERDA() ||
                hayJaqueARRIBAIZQUIERDA() ||


                hayJaqueCaballoARRIBADERECHA() ||
                hayJaqueCaballoDERECHAARRIBA() ||
                hayJaqueCaballoDERECHAABAJO() ||
                hayJaqueCaballoABAJODERECHA() ||
                hayJaqueCaballoABAJOIZQUIERDA() ||
                hayJaqueCaballoIZQUIERDAABAJO() ||
                hayJaqueCaballoIZQUIERDAARRIBA() ||
                hayJaqueCaballoARRIBAARRIBA()


                //Falta para peones
                ;
    }










@Override
public void posiblesMovimiento(Pieza p) {

}
}
