import java.util.Scanner;

public class Dama extends Pieza{
    Scanner sc = new Scanner(System.in);
    public Dama(Color color, int numeroPieza, int i, int j, boolean inmovil) {
        super(TipoPieza.DAMA, color, numeroPieza, i, j, inmovil);
    }



    @Override
    public String toString() {
        return "D" + this.getColor().getSimbolo() + this.getNumeroPieza();
    }

    @Override
    public void posiblesMovimientos(Pieza p) {
        Pieza rey = Main.buscarRey(p.getColor());


        boolean ARRIBA = false;
        boolean ARRIBADERECHA = false;
        boolean DERECHA = false;
        boolean ABAJODERECHA = false;
        boolean ABAJO = false;
        boolean ABAJOIZQUIERDA = false;
        boolean IZQUIERDA = false;
        boolean ARRIBAIZQUIERDA = false;

        //COMPROBACIÓN ARRIBA
        for (int z = 1; z <= p.getI(); z++) {
            Pieza casilla = Main.tablero[p.getI() - z][p.getJ()];

            if (casilla != null) {
                if (!(casilla.getColor() == p.getColor())) {
                    ARRIBA = true;
                }
                break;
            } else {
                ARRIBA = true;
                break;
            }
        }

        //COMPROBACIÓN ARRIBADERECHA
        int capeadoVertical = p.getI();
        int capeadoHorizontal = 7 - p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBADERECHA = true;
                    }
                    break;
                } else {
                    ARRIBADERECHA = true;
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBADERECHA = true;
                    }
                    break;
                } else {
                    ARRIBADERECHA = true;
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBADERECHA = true;
                    }
                    break;
                } else {
                    ARRIBADERECHA = true;
                    break;
                }
            }
        }

        //COMPROBACIÓN DERECHA
        for (int z = 1; z <= 7 - p.getJ(); z++) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() + z];

            if (casilla != null) {
                if (!(casilla.getColor() == p.getColor())) {
                    DERECHA = true;
                }
                break;
            } else {
                DERECHA = true;
                break;
            }
        }

        //COMPROBACIÓN ABAJODERECHA
        capeadoVertical = 7 - p.getI();
        capeadoHorizontal = 7 - p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJODERECHA = true;
                    }
                    break;
                } else {
                    ABAJODERECHA = true;
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJODERECHA = true;
                    }
                    break;
                } else {
                    ABAJODERECHA = true;
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJODERECHA = true;
                    }
                    break;
                } else {
                    ABAJODERECHA = true;
                    break;
                }
            }
        }

        //COMPROBACIÓN ABAJO
        for (int z = 1; z <= 7 - p.getI(); z++) {
            Pieza casilla = Main.tablero[p.getI() + z][p.getJ()];

            if (casilla != null) {
                if (!(casilla.getColor() == p.getColor())) {
                    ABAJO = true;
                }
                break;
            } else {
                ABAJO = true;
                break;
            }
        }
        //COMPROBACIÓN ABAJOIZQUIERDA

        capeadoVertical = 7 - p.getI();
        capeadoHorizontal = p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJOIZQUIERDA = true;
                    }
                    break;
                } else {
                    ABAJOIZQUIERDA = true;
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJOIZQUIERDA = true;
                    }
                    break;
                } else {
                    ABAJOIZQUIERDA = true;
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJOIZQUIERDA = true;
                    }
                    break;
                } else {
                    ABAJOIZQUIERDA = true;
                    break;
                }
            }
        }

        //COMPROBACIÓN IZQUIERDA
        for (int z = 1; z <= p.getJ(); z++) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() - z];

            if (casilla != null) {
                if (!(casilla.getColor() == p.getColor())) {
                    IZQUIERDA = true;
                }
                break;
            } else {
                IZQUIERDA = true;
                break;
            }
        }

        //COMPROBACIÓN ARRIBAIZQUIERDA
        capeadoVertical = p.getI();
        capeadoHorizontal = p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBAIZQUIERDA = true;
                    }
                    break;
                } else {
                    ARRIBAIZQUIERDA = true;
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBAIZQUIERDA = true;
                    }
                    break;
                } else {
                    ARRIBAIZQUIERDA = true;
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBAIZQUIERDA = true;
                    }
                    break;
                } else {
                    ARRIBAIZQUIERDA = true;
                    break;
                }
            }
        }


        if (!ARRIBA && !ARRIBADERECHA && !DERECHA && !ABAJODERECHA &&
                !ABAJO && !ABAJOIZQUIERDA && !IZQUIERDA && !ARRIBAIZQUIERDA) {
            System.out.println("No hay movimientos disponibles");
            p.setInmovil(true);
            return;
        }else{
            p.setInmovil(false);
        }



        int decision;

        while (true) {
            System.out.println("Hacia donde quieres moverte:");

            if (ARRIBA) {
                System.out.println("1. Arriba");
            }

            if (ARRIBADERECHA) {
                System.out.println("2. Arriba derecha");
            }

            if (DERECHA) {
                System.out.println("3. Derecha");
            }

            if (ABAJODERECHA) {
                System.out.println("4. Abajo derecha");
            }

            if (ABAJO) {
                System.out.println("5. Abajo");
            }

            if (ABAJOIZQUIERDA) {
                System.out.println("6. Abajo izquierda");
            }

            if (IZQUIERDA) {
                System.out.println("7. Izquierda");
            }

            if (ARRIBAIZQUIERDA) {
                System.out.println("8. Arriba izquierda");
            }



            decision = Main.comprobarScanner(sc);

            if (decision == 1 && ARRIBA) {
                break;
            } else if (decision == 2 && ARRIBADERECHA) {
                break;
            } else if (decision == 3 && DERECHA) {
                break;
            } else if (decision == 4 && ABAJODERECHA) {
                break;
            } else if (decision == 5 && ABAJO) {
                break;
            } else if (decision == 6 && ABAJOIZQUIERDA) {
                break;
            } else if (decision == 7 && IZQUIERDA) {
                break;
            } else if (decision == 8 && ARRIBAIZQUIERDA) {
                break;
            } else {
                System.out.println("Opción no válida, repite.");
            }
        }

        if (decision == 1 && ARRIBA) {
            System.out.println("Cuantas hacia arriba?");
            int capeada = p.getI();

            int maximo = 0;

            for (int z = 1; z <= capeada; z++) {
                if (Main.tablero[p.getI() - z][p.getJ()] != null) {

                    if (!(Main.tablero[p.getI() - z][p.getJ()].getColor().equals(p.getColor()))) {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }

                    break;
                } else {
                    System.out.println(z + "casillas");
                    maximo = z;
                }
            }

            int movARRIBA = Main.comprobarScanner(sc);

            while (movARRIBA < 1 || movARRIBA > maximo) {
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movARRIBA = Main.comprobarScanner(sc);
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI() - movARRIBA;
            int jProvisional = p.getJ();

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                }
            }
        }

        if (decision == 2 && ARRIBADERECHA) {
            System.out.println("Cuantas casillas quieres moverte");

            capeadoVertical = p.getI();
            capeadoHorizontal = 7 - p.getJ();

            int maximo = 0;

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI() - z][p.getJ() + z] != null) {
                        if (!(Main.tablero[p.getI() - z][p.getJ() + z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {
                for (int z = 1; z <= capeadoVertical; z++) {
                    if (Main.tablero[p.getI() - z][p.getJ() + z] != null) {
                        if (!(Main.tablero[p.getI() - z][p.getJ() + z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI() - z][p.getJ() + z] != null) {
                        if (!(Main.tablero[p.getI() - z][p.getJ() + z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            }

            int movDiagonal = Main.comprobarScanner(sc);

            while (movDiagonal < 1 || movDiagonal > maximo) {
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDiagonal = Main.comprobarScanner(sc);
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI() - movDiagonal;
            int jProvisional = p.getJ() + movDiagonal;

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                }
            }
        }

        if (decision == 3 && DERECHA) {
            System.out.println("Cuantas hacia la derecha?");
            int capeada = 7 - p.getJ();

            int maximo = 0;

            for (int z = 1; z <= capeada; z++) {
                if (Main.tablero[p.getI()][p.getJ() + z] != null) {

                    if (!(Main.tablero[p.getI()][p.getJ() + z].getColor().equals(p.getColor()))) {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }

                    break;
                } else {
                    System.out.println(z + "casillas");
                    maximo = z;
                }
            }

            int movDERECHA = Main.comprobarScanner(sc);

            while (movDERECHA < 1 || movDERECHA > maximo) {
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDERECHA = Main.comprobarScanner(sc);
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI();
            int jProvisional = p.getJ() + movDERECHA;

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                }
            }
        }

        if (decision == 4 && ABAJODERECHA) {
            System.out.println("Cuantas casillas quieres moverte");

            capeadoVertical = 7 - p.getI();
            capeadoHorizontal = 7 - p.getJ();

            int maximo = 0;

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI() + z][p.getJ() + z] != null) {
                        if (!(Main.tablero[p.getI() + z][p.getJ() + z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {
                for (int z = 1; z <= capeadoVertical; z++) {
                    if (Main.tablero[p.getI() + z][p.getJ() + z] != null) {
                        if (!(Main.tablero[p.getI() + z][p.getJ() + z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI() + z][p.getJ() + z] != null) {
                        if (!(Main.tablero[p.getI() + z][p.getJ() + z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            }

            int movDiagonal = Main.comprobarScanner(sc);

            while (movDiagonal < 1 || movDiagonal > maximo) {
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDiagonal = Main.comprobarScanner(sc);
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI() + movDiagonal;
            int jProvisional = p.getJ() + movDiagonal;

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                }
            }
        }

        if (decision == 5 && ABAJO) {
            System.out.println("Cuantas hacia abajo?");
            int capeada = 7 - p.getI();

            int maximo = 0;

            for (int z = 1; z <= capeada; z++) {
                if (Main.tablero[p.getI() + z][p.getJ()] != null) {

                    if (!(Main.tablero[p.getI() + z][p.getJ()].getColor().equals(p.getColor()))) {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }

                    break;
                } else {
                    System.out.println(z + "casillas");
                    maximo = z;
                }
            }

            int movABAJO = Main.comprobarScanner(sc);

            while (movABAJO < 1 || movABAJO > maximo) {
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movABAJO = Main.comprobarScanner(sc);
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI() + movABAJO;
            int jProvisional = p.getJ();

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                }
            }
        }

        if (decision == 6 && ABAJOIZQUIERDA) {
            System.out.println("Cuantas casillas quieres moverte");

            capeadoVertical = 7 - p.getI();
            capeadoHorizontal = p.getJ();

            int maximo = 0;

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI() + z][p.getJ() - z] != null) {
                        if (!(Main.tablero[p.getI() + z][p.getJ() - z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {
                for (int z = 1; z <= capeadoVertical; z++) {
                    if (Main.tablero[p.getI() + z][p.getJ() - z] != null) {
                        if (!(Main.tablero[p.getI() + z][p.getJ() - z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI() + z][p.getJ() - z] != null) {
                        if (!(Main.tablero[p.getI() + z][p.getJ() - z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            }

            int movDiagonal = Main.comprobarScanner(sc);

            while (movDiagonal < 1 || movDiagonal > maximo) {
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDiagonal = Main.comprobarScanner(sc);
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI() + movDiagonal;
            int jProvisional = p.getJ() - movDiagonal;

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                }
            }
        }

        if (decision == 7 && IZQUIERDA) {
            System.out.println("Cuantas hacia la izquierda?");
            int capeada = p.getJ();

            int maximo = 0;

            for (int z = 1; z <= capeada; z++) {
                if (Main.tablero[p.getI()][p.getJ() - z] != null) {

                    if (!(Main.tablero[p.getI()][p.getJ() - z].getColor().equals(p.getColor()))) {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }

                    break;
                } else {
                    System.out.println(z + "casillas");
                    maximo = z;
                }
            }

            int movIZQUIERDA = Main.comprobarScanner(sc);

            while (movIZQUIERDA < 1 || movIZQUIERDA > maximo) {
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movIZQUIERDA = Main.comprobarScanner(sc);
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI();
            int jProvisional = p.getJ() - movIZQUIERDA;

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                }
            }
        }

        if (decision == 8 && ARRIBAIZQUIERDA) {
            System.out.println("Cuantas casillas quieres moverte");

            capeadoVertical = p.getI();
            capeadoHorizontal = p.getJ();

            int maximo = 0;

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI() - z][p.getJ() - z] != null) {
                        if (!(Main.tablero[p.getI() - z][p.getJ() - z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {
                for (int z = 1; z <= capeadoVertical; z++) {
                    if (Main.tablero[p.getI() - z][p.getJ() - z] != null) {
                        if (!(Main.tablero[p.getI() - z][p.getJ() - z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI() - z][p.getJ() - z] != null) {
                        if (!(Main.tablero[p.getI() - z][p.getJ() - z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }
            }

            int movDiagonal = Main.comprobarScanner(sc);

            while (movDiagonal < 1 || movDiagonal > maximo) {
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDiagonal = Main.comprobarScanner(sc);
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI() - movDiagonal;
            int jProvisional = p.getJ() - movDiagonal;

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                }
            }
        }


    }

    @Override
    public boolean comprobarMovimientos(Pieza p) {
        boolean ARRIBA = false;
        boolean ARRIBADERECHA = false;
        boolean DERECHA = false;
        boolean ABAJODERECHA = false;
        boolean ABAJO = false;
        boolean ABAJOIZQUIERDA = false;
        boolean IZQUIERDA = false;
        boolean ARRIBAIZQUIERDA = false;

        //COMPROBACIÓN ARRIBA
        for (int z = 1; z <= p.getI(); z++) {
            Pieza casilla = Main.tablero[p.getI() - z][p.getJ()];

            if (casilla != null) {
                if (!(casilla.getColor() == p.getColor())) {
                    ARRIBA = true;
                }
                break;
            } else {
                ARRIBA = true;
                break;
            }
        }

        //COMPROBACIÓN ARRIBADERECHA
        int capeadoVertical = p.getI();
        int capeadoHorizontal = 7 - p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBADERECHA = true;
                    }
                    break;
                } else {
                    ARRIBADERECHA = true;
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBADERECHA = true;
                    }
                    break;
                } else {
                    ARRIBADERECHA = true;
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBADERECHA = true;
                    }
                    break;
                } else {
                    ARRIBADERECHA = true;
                    break;
                }
            }
        }

        //COMPROBACIÓN DERECHA
        for (int z = 1; z <= 7 - p.getJ(); z++) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() + z];

            if (casilla != null) {
                if (!(casilla.getColor() == p.getColor())) {
                    DERECHA = true;
                }
                break;
            } else {
                DERECHA = true;
                break;
            }
        }

        //COMPROBACIÓN ABAJODERECHA
        capeadoVertical = 7 - p.getI();
        capeadoHorizontal = 7 - p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJODERECHA = true;
                    }
                    break;
                } else {
                    ABAJODERECHA = true;
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJODERECHA = true;
                    }
                    break;
                } else {
                    ABAJODERECHA = true;
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJODERECHA = true;
                    }
                    break;
                } else {
                    ABAJODERECHA = true;
                    break;
                }
            }
        }

        //COMPROBACIÓN ABAJO
        for (int z = 1; z <= 7 - p.getI(); z++) {
            Pieza casilla = Main.tablero[p.getI() + z][p.getJ()];

            if (casilla != null) {
                if (!(casilla.getColor() == p.getColor())) {
                    ABAJO = true;
                }
                break;
            } else {
                ABAJO = true;
                break;
            }
        }
        //COMPROBACIÓN ABAJOIZQUIERDA

        capeadoVertical = 7 - p.getI();
        capeadoHorizontal = p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJOIZQUIERDA = true;
                    }
                    break;
                } else {
                    ABAJOIZQUIERDA = true;
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJOIZQUIERDA = true;
                    }
                    break;
                } else {
                    ABAJOIZQUIERDA = true;
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ABAJOIZQUIERDA = true;
                    }
                    break;
                } else {
                    ABAJOIZQUIERDA = true;
                    break;
                }
            }
        }

        //COMPROBACIÓN IZQUIERDA
        for (int z = 1; z <= p.getJ(); z++) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() - z];

            if (casilla != null) {
                if (!(casilla.getColor() == p.getColor())) {
                    IZQUIERDA = true;
                }
                break;
            } else {
                IZQUIERDA = true;
                break;
            }
        }

        //COMPROBACIÓN ARRIBAIZQUIERDA
        capeadoVertical = p.getI();
        capeadoHorizontal = p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBAIZQUIERDA = true;
                    }
                    break;
                } else {
                    ARRIBAIZQUIERDA = true;
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBAIZQUIERDA = true;
                    }
                    break;
                } else {
                    ARRIBAIZQUIERDA = true;
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        ARRIBAIZQUIERDA = true;
                    }
                    break;
                } else {
                    ARRIBAIZQUIERDA = true;
                    break;
                }
            }
        }


        if (!ARRIBA && !ARRIBADERECHA && !DERECHA && !ABAJODERECHA &&
                !ABAJO && !ABAJOIZQUIERDA && !IZQUIERDA && !ARRIBAIZQUIERDA) {
            return false;
        }
        return  true;
    }
}

