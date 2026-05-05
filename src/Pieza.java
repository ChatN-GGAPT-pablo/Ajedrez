public abstract class Pieza implements Movible {

    private String nombrePieza;
    private String color;
    private int numeroPieza;
    int i;
    int j;
    boolean primerMovimiento2OEnroque = false;
    boolean inmovil = false;


    /**
     * Constructor para rey y reina pq solo hay uno de cada y no necesitan "numero"
     *
     * @param nombrePieza
     * @param color
     */
    public Pieza(String nombrePieza, String color, int i, int j, boolean inmovil) {
        this.nombrePieza = nombrePieza;
        this.color = color;
        this.i = i;
        this.j = j;
        this.inmovil = inmovil;
    }

    /**
     * Constructor para el resto de piezas
     *
     * @param nombrePieza
     * @param color
     * @param numeroPieza
     */
    public Pieza(String nombrePieza, String color, int numeroPieza, int i, int j, boolean inmovil) {
        this.nombrePieza = nombrePieza;
        this.color = color;
        this.numeroPieza = numeroPieza;
        this.i = i;
        this.j = j;
        this.inmovil = inmovil;
    }

    //Constructor Peon
    public Pieza(String nombrePieza, String color, int numeroPieza, int i, int j, boolean primerMovimiento2OEnroque, boolean inmovil) {
        this.nombrePieza = nombrePieza;
        this.color = color;
        this.numeroPieza = numeroPieza;
        this.i = i;
        this.j = j;
        this.primerMovimiento2OEnroque = primerMovimiento2OEnroque;
        this.inmovil = inmovil;
    }


    //Constructor Torres


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

    public boolean getPrimerMovimiento2OEnroque() {
        return primerMovimiento2OEnroque;
    }

    public void setPrimerMovimiento2OEnroque(boolean primerMovimiento) {
        this.primerMovimiento2OEnroque = primerMovimiento2OEnroque;
    }

    public boolean getInmovil() {
        return inmovil;
    }

    public void setInmovil(boolean inmovil) {
        this.inmovil = inmovil;
    }


    public boolean hayJaqueARRIBA() {

        int iPieza = this.getI() - 1;
        int jPieza = this.getJ();

        while (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || casilla.getNombrePieza().equals("Torre")) {
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
        int jPieza = this.getJ() + 1;

        while (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || casilla.getNombrePieza().equals("Alfil")) {
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

        while (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || casilla.getNombrePieza().equals("Torre")) {
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

        while (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || casilla.getNombrePieza().equals("Alfil")) {
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

        while (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || casilla.getNombrePieza().equals("Torre")) {
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

        while (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || casilla.getNombrePieza().equals("Alfil")) {
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

        while (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || casilla.getNombrePieza().equals("Torre")) {
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

        while (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {

            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Dama") || casilla.getNombrePieza().equals("Alfil")) {
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

    public boolean hayJaqueCaballoARRIBADERECHA() {

        int iPieza = this.getI() - 2;
        int jPieza = this.getJ() + 1;

        if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Caballo")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hayJaqueCaballoDERECHAARRIBA() {

        int iPieza = this.getI() - 1;
        int jPieza = this.getJ() + 2;

        if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Caballo")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hayJaqueCaballoDERECHAABAJO() {

        int iPieza = this.getI() + 1;
        int jPieza = this.getJ() + 2;

        if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Caballo")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hayJaqueCaballoABAJODERECHA() {

        int iPieza = this.getI() + 2;
        int jPieza = this.getJ() + 1;

        if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Caballo")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hayJaqueCaballoABAJOIZQUIERDA() {

        int iPieza = this.getI() + 2;
        int jPieza = this.getJ() - 1;

        if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Caballo")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hayJaqueCaballoIZQUIERDAABAJO() {

        int iPieza = this.getI() + 1;
        int jPieza = this.getJ() - 2;

        if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Caballo")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hayJaqueCaballoIZQUIERDAARRIBA() {

        int iPieza = this.getI() - 1;
        int jPieza = this.getJ() - 2;

        if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Caballo")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hayJaqueCaballoARRIBAIZQUIERDA() {

        int iPieza = this.getI() - 2;
        int jPieza = this.getJ() - 1;

        if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
            Pieza casilla = Main.tablero[iPieza][jPieza];

            if (casilla != null) {
                if (!(casilla.getColor().equals(this.getColor()))) {
                    if (casilla.getNombrePieza().equals("Caballo")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean hayJaquePeones() {

        if (this.getColor().equals("B")) {

            int iPieza = this.getI() - 1;
            int jPieza = this.getJ() - 1;

            if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
                Pieza casilla = Main.tablero[iPieza][jPieza];

                if (casilla != null) {
                    if (!(casilla.getColor().equals(this.getColor()))) {
                        if (casilla.getNombrePieza().equals("Peón")) {
                            return true;
                        }
                    }
                }
            }

            int iPieza2 = this.getI() - 1;
            int jPieza2 = this.getJ() + 1;

            if (iPieza2 >= 0 && iPieza2 < 8 && jPieza2 >= 0 && jPieza2 < 8) {
                Pieza casilla2 = Main.tablero[iPieza2][jPieza2];

                if (casilla2 != null) {
                    if (!(casilla2.getColor().equals(this.getColor()))) {
                        if (casilla2.getNombrePieza().equals("Peón")) {
                            return true;
                        }
                    }
                }
            }

            return false;

        } else {

            int iPieza = this.getI() + 1;
            int jPieza = this.getJ() - 1;

            if (iPieza >= 0 && iPieza < 8 && jPieza >= 0 && jPieza < 8) {
                Pieza casilla = Main.tablero[iPieza][jPieza];

                if (casilla != null) {
                    if (!(casilla.getColor().equals(this.getColor()))) {
                        if (casilla.getNombrePieza().equals("Peón")) {
                            return true;
                        }
                    }
                }
            }

            int iPieza2 = this.getI() + 1;
            int jPieza2 = this.getJ() + 1;

            if (iPieza2 >= 0 && iPieza2 < 8 && jPieza2 >= 0 && jPieza2 < 8) {
                Pieza casilla2 = Main.tablero[iPieza2][jPieza2];

                if (casilla2 != null) {
                    if (!(casilla2.getColor().equals(this.getColor()))) {
                        if (casilla2.getNombrePieza().equals("Peón")) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    public boolean hayJaque() {

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
                hayJaqueCaballoARRIBAIZQUIERDA() ||
                hayJaquePeones();
    }


    @Override
    public void posiblesMovimientos(Pieza p) {
    }
}


