import java.util.Scanner;

public class Rey extends Pieza {
    Scanner sc = new Scanner(System.in);

    public Rey(String nombrePieza, String color, int i, int j, boolean inmovil) {
        super(nombrePieza, color, i, j, inmovil);
    }


    @Override
    public String toString() {
        return "R" + this.getColor();
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

        boolean ENROQUECORTO = false;
        boolean ENROQUELARGO = false;

        if (p.getI() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI() - 1][p.getJ()];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ARRIBA = true;
            }
        }

        if (p.getI() - 1 >= 0 && p.getJ() + 1 < 8) {
            Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() + 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ARRIBADERECHA = true;
            }
        }

        if (p.getJ() + 1 < 8) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() + 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                DERECHA = true;
            }
        }

        if (p.getI() + 1 < 8 && p.getJ() + 1 < 8) {
            Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() + 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ABAJODERECHA = true;
            }
        }

        if (p.getI() + 1 < 8) {
            Pieza casilla = Main.tablero[p.getI() + 1][p.getJ()];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ABAJO = true;
            }
        }

        if (p.getI() + 1 < 8 && p.getJ() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() - 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ABAJOIZQUIERDA = true;
            }
        }

        if (p.getJ() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() - 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                IZQUIERDA = true;
            }
        }

        if (p.getI() - 1 >= 0 && p.getJ() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() - 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ARRIBAIZQUIERDA = true;
            }
        }


//Enroque blanco
        if (p.getColor().equals("B") && !p.primerMovimiento2OEnroque && !rey.hayJaque()) {

            // Enroque corto blanco: rey en [7][4], torre en [7][7]
            if (p.getI() == 7 && p.getJ() == 4) {
                Pieza torreCorta = Main.tablero[7][7];

                if (torreCorta != null &&
                        torreCorta.getNombrePieza().equals("Torre") &&
                        torreCorta.getColor().equals("B") &&
                        !torreCorta.primerMovimiento2OEnroque &&
                        Main.tablero[7][5] == null &&
                        Main.tablero[7][6] == null) {

                    Main.tablero[7][4] = null;
                    Main.tablero[7][5] = p;

                    p.setI(7);
                    p.setJ(5);

                    if (!p.hayJaque()) {
                        Main.tablero[7][5] = null;
                        Main.tablero[7][6] = p;

                        p.setI(7);
                        p.setJ(6);

                        if (!p.hayJaque()) {
                            ENROQUECORTO = true;
                        }
                    }

                    Main.tablero[7][4] = p;
                    Main.tablero[7][5] = null;
                    Main.tablero[7][6] = null;

                    p.setI(7);
                    p.setJ(4);
                }

                Pieza torreLarga = Main.tablero[7][0];

                if (torreLarga != null &&
                        torreLarga.getNombrePieza().equals("Torre") &&
                        torreLarga.getColor().equals("B") &&
                        !torreLarga.primerMovimiento2OEnroque &&
                        Main.tablero[7][1] == null &&
                        Main.tablero[7][2] == null &&
                        Main.tablero[7][3] == null) {

                    Main.tablero[7][4] = null;
                    Main.tablero[7][3] = p;

                    p.setI(7);
                    p.setJ(3);

                    if (!p.hayJaque()) {
                        Main.tablero[7][3] = null;
                        Main.tablero[7][2] = p;

                        p.setI(7);
                        p.setJ(2);

                        if (!p.hayJaque()) {
                            ENROQUELARGO = true;
                        }
                    }

                    Main.tablero[7][4] = p;
                    Main.tablero[7][3] = null;
                    Main.tablero[7][2] = null;

                    p.setI(7);
                    p.setJ(4);
                }
            }
        }
//Enroque negro
        if (p.getColor().equals("N") && !p.primerMovimiento2OEnroque && !rey.hayJaque()) {

            // Enroque corto negro: rey en [0][4], torre en [0][7]
            if (p.getI() == 0 && p.getJ() == 4) {
                Pieza torreCorta = Main.tablero[0][7];

                if (torreCorta != null &&
                        torreCorta.getNombrePieza().equals("Torre") &&
                        torreCorta.getColor().equals("N") &&
                        !torreCorta.primerMovimiento2OEnroque &&
                        Main.tablero[0][5] == null &&
                        Main.tablero[0][6] == null) {

                    Main.tablero[0][4] = null;
                    Main.tablero[0][5] = p;

                    p.setI(0);
                    p.setJ(5);

                    if (!p.hayJaque()) {
                        Main.tablero[0][5] = null;
                        Main.tablero[0][6] = p;

                        p.setI(0);
                        p.setJ(6);

                        if (!p.hayJaque()) {
                            ENROQUECORTO = true;
                        }
                    }

                    Main.tablero[0][4] = p;
                    Main.tablero[0][5] = null;
                    Main.tablero[0][6] = null;

                    p.setI(0);
                    p.setJ(4);
                }

                Pieza torreLarga = Main.tablero[0][0];

                if (torreLarga != null &&
                        torreLarga.getNombrePieza().equals("Torre") &&
                        torreLarga.getColor().equals("N") &&
                        !torreLarga.primerMovimiento2OEnroque &&
                        Main.tablero[0][1] == null &&
                        Main.tablero[0][2] == null &&
                        Main.tablero[0][3] == null) {

                    Main.tablero[0][4] = null;
                    Main.tablero[0][3] = p;

                    p.setI(0);
                    p.setJ(3);

                    if (!p.hayJaque()) {
                        Main.tablero[0][3] = null;
                        Main.tablero[0][2] = p;

                        p.setI(0);
                        p.setJ(2);

                        if (!p.hayJaque()) {
                            ENROQUELARGO = true;
                        }
                    }

                    Main.tablero[0][4] = p;
                    Main.tablero[0][3] = null;
                    Main.tablero[0][2] = null;

                    p.setI(0);
                    p.setJ(4);
                }
            }
        }

        if (!ARRIBA && !ARRIBADERECHA && !DERECHA && !ABAJODERECHA &&
                !ABAJO && !ABAJOIZQUIERDA && !IZQUIERDA && !ARRIBAIZQUIERDA &&
                !ENROQUECORTO && !ENROQUELARGO) {
            System.out.println("No hay movimientos disponibles");
            p.setInmovil(true);
            return;
        }else{
            p.setInmovil(false);
        }


        int decision;

        while (true) {
            System.out.println("A donde quieres moverte");

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
            if (ENROQUECORTO) {
                System.out.println("9. Enroque corto");
            }

            if (ENROQUELARGO) {
                System.out.println("10. Enroque largo");
            }

            decision = sc.nextInt();

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
            } else if (decision == 9 && ENROQUECORTO) {
                break;
            } else if (decision == 10 && ENROQUELARGO) {
                break;
            }else {
                System.out.println("Repite decisión");
            }
        }

        int iOriginal = p.getI();
        int jOriginal = p.getJ();

        int iProvisional = p.getI();
        int jProvisional = p.getJ();

        if (decision == 1 && ARRIBA) {
            iProvisional = p.getI() - 1;
            jProvisional = p.getJ();
        }

        if (decision == 2 && ARRIBADERECHA) {
            iProvisional = p.getI() - 1;
            jProvisional = p.getJ() + 1;
        }

        if (decision == 3 && DERECHA) {
            iProvisional = p.getI();
            jProvisional = p.getJ() + 1;
        }

        if (decision == 4 && ABAJODERECHA) {
            iProvisional = p.getI() + 1;
            jProvisional = p.getJ() + 1;
        }

        if (decision == 5 && ABAJO) {
            iProvisional = p.getI() + 1;
            jProvisional = p.getJ();
        }

        if (decision == 6 && ABAJOIZQUIERDA) {
            iProvisional = p.getI() + 1;
            jProvisional = p.getJ() - 1;
        }

        if (decision == 7 && IZQUIERDA) {
            iProvisional = p.getI();
            jProvisional = p.getJ() - 1;
        }

        if (decision == 8 && ARRIBAIZQUIERDA) {
            iProvisional = p.getI() - 1;
            jProvisional = p.getJ() - 1;
        }


        if (decision == 9 && ENROQUECORTO) {

    // Comprobar columna 5 por posible jaque
            Main.tablero[p.getI()][4] = null;
            Main.tablero[p.getI()][5] = p;

            p.setI(p.getI());
            p.setJ(5);

            if (rey.hayJaque()) {
                Main.tablero[p.getI()][4] = p;
                Main.tablero[p.getI()][5] = null;

                p.setI(p.getI());
                p.setJ(4);

                System.out.println("Movimiento ilegal, el rey pasaría por jaque");
                return;
            }


            Main.tablero[p.getI()][4] = p;
            Main.tablero[p.getI()][5] = null;

            p.setI(p.getI());
            p.setJ(4);

            Pieza torre = Main.tablero[p.getI()][7];

            Main.tablero[p.getI()][4] = null;
            Main.tablero[p.getI()][7] = null;

            Main.tablero[p.getI()][6] = p;
            Main.tablero[p.getI()][5] = torre;

            p.setI(p.getI());
            p.setJ(6);

            torre.setI(p.getI());
            torre.setJ(5);

            if (rey.hayJaque()) {
                Main.tablero[p.getI()][4] = p;
                Main.tablero[p.getI()][7] = torre;
                Main.tablero[p.getI()][6] = null;
                Main.tablero[p.getI()][5] = null;

                p.setI(p.getI());
                p.setJ(4);

                torre.setI(p.getI());
                torre.setJ(7);

                System.out.println("Movimiento ilegal");
            } else {
                p.primerMovimiento2OEnroque = true;
                torre.primerMovimiento2OEnroque = true;

                System.out.println("Enroque corto realizado.");
                Main.ultimaPieza(p);
                Main.cambiarTurno();
            }

            return;
        }
        if (decision == 10 && ENROQUELARGO) {

    // Comprobar columna 3 por posible jaque
            Main.tablero[p.getI()][4] = null;
            Main.tablero[p.getI()][3] = p;

            p.setI(p.getI());
            p.setJ(3);

            if (rey.hayJaque()) {
                Main.tablero[p.getI()][4] = p;
                Main.tablero[p.getI()][3] = null;

                p.setI(p.getI());
                p.setJ(4);

                System.out.println("Movimiento ilegal, el rey pasaría por jaque");
                return;
            }


            Main.tablero[p.getI()][4] = p;
            Main.tablero[p.getI()][3] = null;

            p.setI(p.getI());
            p.setJ(4);

            Pieza torre = Main.tablero[p.getI()][0];

            Main.tablero[p.getI()][4] = null;
            Main.tablero[p.getI()][0] = null;

            Main.tablero[p.getI()][2] = p;
            Main.tablero[p.getI()][3] = torre;

            p.setI(p.getI());
            p.setJ(2);

            torre.setI(p.getI());
            torre.setJ(3);

            if (rey.hayJaque()) {
                Main.tablero[p.getI()][4] = p;
                Main.tablero[p.getI()][0] = torre;
                Main.tablero[p.getI()][2] = null;
                Main.tablero[p.getI()][3] = null;

                p.setI(p.getI());
                p.setJ(4);

                torre.setI(p.getI());
                torre.setJ(0);

                System.out.println("Movimiento ilegal");
            } else {
                p.primerMovimiento2OEnroque = true;
                torre.primerMovimiento2OEnroque = true;

                System.out.println("Enroque largo realizado.");
                Main.ultimaPieza(p);
                Main.cambiarTurno();
            }

            return;
        }

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
                System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                p.primerMovimiento2OEnroque = true;
                Main.ultimaPieza(p);
                Main.cambiarTurno();
            } else {
                System.out.println("Pieza movida.");
                Main.ultimaPieza(p);
                p.primerMovimiento2OEnroque = true;
                Main.cambiarTurno();
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
        boolean ENROQUECORTO = false;
        boolean ENROQUELARGO = false;

        if (p.getI() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI() - 1][p.getJ()];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ARRIBA = true;
            }
        }

        if (p.getI() - 1 >= 0 && p.getJ() + 1 < 8) {
            Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() + 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ARRIBADERECHA = true;
            }
        }

        if (p.getJ() + 1 < 8) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() + 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                DERECHA = true;
            }
        }

        if (p.getI() + 1 < 8 && p.getJ() + 1 < 8) {
            Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() + 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ABAJODERECHA = true;
            }
        }

        if (p.getI() + 1 < 8) {
            Pieza casilla = Main.tablero[p.getI() + 1][p.getJ()];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ABAJO = true;
            }
        }

        if (p.getI() + 1 < 8 && p.getJ() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() - 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ABAJOIZQUIERDA = true;
            }
        }

        if (p.getJ() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() - 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                IZQUIERDA = true;
            }
        }

        if (p.getI() - 1 >= 0 && p.getJ() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() - 1];
            if (casilla == null || !casilla.getColor().equals(p.getColor())) {
                ARRIBAIZQUIERDA = true;
            }
        }

// Enroque blanco
        if (p.getColor().equals("B") && !p.primerMovimiento2OEnroque && !p.hayJaque()) {

            if (p.getI() == 7 && p.getJ() == 4) {
                Pieza torreCorta = Main.tablero[7][7];

                if (torreCorta != null &&
                        torreCorta.getNombrePieza().equals("Torre") &&
                        torreCorta.getColor().equals("B") &&
                        !torreCorta.primerMovimiento2OEnroque &&
                        Main.tablero[7][5] == null &&
                        Main.tablero[7][6] == null) {

                    Main.tablero[7][4] = null;
                    Main.tablero[7][5] = p;
                    p.setI(7);
                    p.setJ(5);

                    if (!p.hayJaque()) {
                        Main.tablero[7][5] = null;
                        Main.tablero[7][6] = p;
                        p.setI(7);
                        p.setJ(6);

                        if (!p.hayJaque()) {
                            ENROQUECORTO = true;
                        }
                    }

                    Main.tablero[7][4] = p;
                    Main.tablero[7][5] = null;
                    Main.tablero[7][6] = null;
                    p.setI(7);
                    p.setJ(4);
                }

                Pieza torreLarga = Main.tablero[7][0];

                if (torreLarga != null &&
                        torreLarga.getNombrePieza().equals("Torre") &&
                        torreLarga.getColor().equals("B") &&
                        !torreLarga.primerMovimiento2OEnroque &&
                        Main.tablero[7][1] == null &&
                        Main.tablero[7][2] == null &&
                        Main.tablero[7][3] == null) {

                    Main.tablero[7][4] = null;
                    Main.tablero[7][3] = p;
                    p.setI(7);
                    p.setJ(3);

                    if (!p.hayJaque()) {
                        Main.tablero[7][3] = null;
                        Main.tablero[7][2] = p;
                        p.setI(7);
                        p.setJ(2);

                        if (!p.hayJaque()) {
                            ENROQUELARGO = true;
                        }
                    }

                    Main.tablero[7][4] = p;
                    Main.tablero[7][3] = null;
                    Main.tablero[7][2] = null;
                    p.setI(7);
                    p.setJ(4);
                }
            }
        }

// Enroque negro
        if (p.getColor().equals("N") && !p.primerMovimiento2OEnroque && !p.hayJaque()) {

            if (p.getI() == 0 && p.getJ() == 4) {
                Pieza torreCorta = Main.tablero[0][7];

                if (torreCorta != null &&
                        torreCorta.getNombrePieza().equals("Torre") &&
                        torreCorta.getColor().equals("N") &&
                        !torreCorta.primerMovimiento2OEnroque &&
                        Main.tablero[0][5] == null &&
                        Main.tablero[0][6] == null) {

                    Main.tablero[0][4] = null;
                    Main.tablero[0][5] = p;
                    p.setI(0);
                    p.setJ(5);

                    if (!p.hayJaque()) {
                        Main.tablero[0][5] = null;
                        Main.tablero[0][6] = p;
                        p.setI(0);
                        p.setJ(6);

                        if (!p.hayJaque()) {
                            ENROQUECORTO = true;
                        }
                    }

                    Main.tablero[0][4] = p;
                    Main.tablero[0][5] = null;
                    Main.tablero[0][6] = null;
                    p.setI(0);
                    p.setJ(4);
                }

                Pieza torreLarga = Main.tablero[0][0];

                if (torreLarga != null &&
                        torreLarga.getNombrePieza().equals("Torre") &&
                        torreLarga.getColor().equals("N") &&
                        !torreLarga.primerMovimiento2OEnroque &&
                        Main.tablero[0][1] == null &&
                        Main.tablero[0][2] == null &&
                        Main.tablero[0][3] == null) {

                    Main.tablero[0][4] = null;
                    Main.tablero[0][3] = p;
                    p.setI(0);
                    p.setJ(3);

                    if (!p.hayJaque()) {
                        Main.tablero[0][3] = null;
                        Main.tablero[0][2] = p;
                        p.setI(0);
                        p.setJ(2);

                        if (!p.hayJaque()) {
                            ENROQUELARGO = true;
                        }
                    }

                    Main.tablero[0][4] = p;
                    Main.tablero[0][3] = null;
                    Main.tablero[0][2] = null;
                    p.setI(0);
                    p.setJ(4);
                }
            }
        }



        if (!ARRIBA && !ARRIBADERECHA && !DERECHA && !ABAJODERECHA &&
                !ABAJO && !ABAJOIZQUIERDA && !IZQUIERDA && !ARRIBAIZQUIERDA &&
                !ENROQUECORTO && !ENROQUELARGO) {
            return false;
        }
        return true;
    }
}