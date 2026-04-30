import java.util.Scanner;

public class Rey extends Pieza {
    Scanner sc = new Scanner(System.in);

    public Rey(String nombrePieza, String color, int i, int j) {
        super(nombrePieza, color, i, j);
    }


    @Override
    public String toString() {
        return "R" + this.getColor();
    }


    @Override
    public void posiblesMovimiento(Pieza p) {
        if (!hayJaque()) {

            boolean ARRIBA = false;
            boolean ARRIBADERECHA = false;
            boolean DERECHA = false;
            boolean ABAJODERECHA = false;
            boolean ABAJO = false;
            boolean ABAJOIZQUIERDA = false;
            boolean IZQUIERDA = false;
            boolean ARRIBAIZQUIERDA = false;

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

            if (!ARRIBA && !ARRIBADERECHA && !DERECHA && !ABAJODERECHA &&
                    !ABAJO && !ABAJOIZQUIERDA && !IZQUIERDA && !ARRIBAIZQUIERDA) {
                System.out.println("No hay movimientos disponibles");
                return;
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
                } else {
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

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                System.out.println("No te puedes comer una pieza de tu color");
                return;
            }

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                } else {
                    System.out.println("Pieza movida.");
                }
            }
        }
    }
}