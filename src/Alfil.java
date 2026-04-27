import java.util.Scanner;

public class Alfil extends Pieza{
    public Alfil(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }



    @Override
    public String toString() {
        return "A" + this.getColor() + this.getNumeroPieza();
    }


    @Override
    public void posiblesMovimiento(Pieza p) {
        if (!hayJaque()) {

            boolean ARRIBADERECHA = false;
            boolean ABAJODERECHA = false;
            boolean ABAJOIZQUIERDA = false;
            boolean ARRIBAIZQUIERDA = false;

            if (p.getI() > 0 && p.getJ() < 7) {
                ARRIBADERECHA = true;
            }

            if (p.getI() < 7 && p.getJ() < 7) {
                ABAJODERECHA = true;
            }

            if (p.getI() < 7 && p.getJ() > 0) {
                ABAJOIZQUIERDA = true;
            }

            if (p.getI() > 0 && p.getJ() > 0) {
                ARRIBAIZQUIERDA = true;
            }

            System.out.println("Hacia dónde quieres mover?");

            if (ARRIBADERECHA) {
                System.out.println("1. Arriba derecha");
            }

            if (ABAJODERECHA) {
                System.out.println("2. Abajo derecha");
            }

            if (ABAJOIZQUIERDA) {
                System.out.println("3. Abajo izquierda");
            }

            if (ARRIBAIZQUIERDA) {
                System.out.println("4. Arriba izquierda");
            }

            Scanner sc = new Scanner(System.in);
            int decision = sc.nextInt();

            if (decision == 1 && ARRIBADERECHA) {
                int capeadoVertical = p.getI();
                int capeadoHorizontal = 7 - p.getJ();

                System.out.println("Cuantas casillas quieres moverte");

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        System.out.println(z + " casillas");
                    }
                } else if (capeadoVertical < capeadoHorizontal) {
                    for (int z = 1; z <= capeadoVertical; z++) {
                        System.out.println(z + " casillas");
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        System.out.println(z + " casillas");
                    }
                }

                int movDiagonal = sc.nextInt();

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

            if (decision == 2 && ABAJODERECHA) {
                int capeadoVertical = 7 - p.getI();
                int capeadoHorizontal = 7 - p.getJ();

                System.out.println("Cuantas casillas quieres moverte");

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        System.out.println(z + " casillas");
                    }
                } else if (capeadoVertical < capeadoHorizontal) {
                    for (int z = 1; z <= capeadoVertical; z++) {
                        System.out.println(z + " casillas");
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        System.out.println(z + " casillas");
                    }
                }

                int movDiagonal = sc.nextInt();

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

            if (decision == 3 && ABAJOIZQUIERDA) {
                int capeadoVertical = 7 - p.getI();
                int capeadoHorizontal = p.getJ();

                System.out.println("Cuantas casillas quieres moverte");

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        System.out.println(z + " casillas");
                    }
                } else if (capeadoVertical < capeadoHorizontal) {
                    for (int z = 1; z <= capeadoVertical; z++) {
                        System.out.println(z + " casillas");
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        System.out.println(z + " casillas");
                    }
                }

                int movDiagonal = sc.nextInt();

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

            if (decision == 4 && ARRIBAIZQUIERDA) {
                int capeadoVertical = p.getI();
                int capeadoHorizontal = p.getJ();

                System.out.println("Cuantas casillas quieres moverte");

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        System.out.println(z + " casillas");
                    }
                } else if (capeadoVertical < capeadoHorizontal) {
                    for (int z = 1; z <= capeadoVertical; z++) {
                        System.out.println(z + " casillas");
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        System.out.println(z + " casillas");
                    }
                }

                int movDiagonal = sc.nextInt();

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
}
