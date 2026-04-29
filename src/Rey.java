import java.util.Scanner;

public class Rey extends Pieza{
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





            if (p.getI() > 0) ARRIBA = true;
            if (p.getI() > 0 && p.getJ() < 7) ARRIBADERECHA = true;
            if (p.getJ() < 7) DERECHA = true;
            if (p.getI() < 7 && p.getJ() < 7) ABAJODERECHA = true;
            if (p.getI() < 7) ABAJO = true;
            if (p.getI() < 7 && p.getJ() > 0) ABAJOIZQUIERDA = true;
            if (p.getJ() > 0) IZQUIERDA = true;
            if (p.getI() > 0 && p.getJ() > 0) ARRIBAIZQUIERDA = true;



            System.out.println("A donde quieres moverte");

            if (ARRIBA) System.out.println("1. Arriba");
            if (ARRIBADERECHA) System.out.println("2. Arriba derecha");
            if (DERECHA) System.out.println("3. Derecha");
            if (ABAJODERECHA) System.out.println("4. Abajo derecha");
            if (ABAJO) System.out.println("5. Abajo");
            if (ABAJOIZQUIERDA) System.out.println("6. Abajo izquierda");
            if (IZQUIERDA) System.out.println("7. Izquierda");
            if (ARRIBAIZQUIERDA) System.out.println("8. Arriba izquierda");

            Scanner sc = new Scanner(System.in);
            int decision = sc.nextInt();

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
    }}
