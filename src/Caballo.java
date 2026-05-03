import java.util.Scanner;

public class Caballo extends Pieza{
    Scanner sc = new Scanner(System.in);
    public Caballo(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }



    @Override
    public String toString() {
        return "C" + this.getColor() + this.getNumeroPieza();
    }

    //if(!puedeMover()){


    @Override
    public void posiblesMovimientos(Pieza p) {

        Pieza rey = Main.buscarRey(p.getColor());



        boolean ARRIBADERECHA = false;
        boolean DERECHAARRIBA = false;
        boolean DERECHAABAJO = false;
        boolean ABAJODERECHA = false;
        boolean ABAJOIZQUIERDA = false;
        boolean IZQUIERDAABAJO = false;
        boolean IZQUIERDAARRIBA = false;
        boolean ARRIBAIZQUIERDA = false;

        if (p.getI() - 2 >= 0 && p.getJ() + 1 <= 7) {
            Pieza casilla = Main.tablero[p.getI() - 2][p.getJ() + 1];

            if (casilla == null || !(casilla.getColor().equals(p.getColor()))) {
                ARRIBADERECHA = true;
            }
        }

        if (p.getI() - 1 >= 0 && p.getJ() + 2 <= 7) {
            Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() + 2];

            if (casilla == null || !(casilla.getColor().equals(p.getColor()))) {
                DERECHAARRIBA = true;
            }
        }

        if (p.getI() + 1 <= 7 && p.getJ() + 2 <= 7) {
            Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() + 2];

            if (casilla == null || !(casilla.getColor().equals(p.getColor()))) {
                DERECHAABAJO = true;
            }
        }

        if (p.getI() + 2 <= 7 && p.getJ() + 1 <= 7) {
            Pieza casilla = Main.tablero[p.getI() + 2][p.getJ() + 1];

            if (casilla == null || !(casilla.getColor().equals(p.getColor()))) {
                ABAJODERECHA = true;
            }
        }

        if (p.getI() + 2 <= 7 && p.getJ() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI() + 2][p.getJ() - 1];

            if (casilla == null || !(casilla.getColor().equals(p.getColor()))) {
                ABAJOIZQUIERDA = true;
            }
        }

        if (p.getI() + 1 <= 7 && p.getJ() - 2 >= 0) {
            Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() - 2];

            if (casilla == null || !(casilla.getColor().equals(p.getColor()))) {
                IZQUIERDAABAJO = true;
            }
        }

        if (p.getI() - 1 >= 0 && p.getJ() - 2 >= 0) {
            Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() - 2];

            if (casilla == null || !(casilla.getColor().equals(p.getColor()))) {
                IZQUIERDAARRIBA = true;
            }
        }

        if (p.getI() - 2 >= 0 && p.getJ() - 1 >= 0) {
            Pieza casilla = Main.tablero[p.getI() - 2][p.getJ() - 1];

            if (casilla == null || !(casilla.getColor().equals(p.getColor()))) {
                ARRIBAIZQUIERDA = true;
            }
        }


        if (!ARRIBADERECHA && !DERECHAARRIBA && !DERECHAABAJO && !ABAJODERECHA &&
                !ABAJOIZQUIERDA && !IZQUIERDAABAJO && !IZQUIERDAARRIBA && !ARRIBAIZQUIERDA) {
            System.out.println("No hay movimientos disponibles");
            Main.setPiezaAMover(Main.mostrarPiezas());
            Main.piezaAMover.posiblesMovimientos(Main.piezaAMover);
            return;
        }

        int decision;
        while (true){
            System.out.println("Hacia donde quieres moverte:");

            if ( ARRIBADERECHA){
                System.out.println("1. Arriba-Derecha");
            }

            if (DERECHAARRIBA){
                System.out.println("2. Derecha-Arriba");
            }

            if(DERECHAABAJO){
                System.out.println("3. Derecha-Abajo");
            }

            if (ABAJODERECHA){
                System.out.println("4. Abajo-Derecha");
            }

            if(ABAJOIZQUIERDA){
                System.out.println("5. Abajo-Izquierda");
            }

            if(IZQUIERDAABAJO){
                System.out.println("6. Izquierda-Abajo");
            }

            if (IZQUIERDAARRIBA){
                System.out.println("7. Izquierda-Arriba");
            }

            if (ARRIBAIZQUIERDA){
                System.out.println("8. Arriba-Izquierda");
            }


            decision = sc.nextInt();

            if (decision == 1 && ARRIBADERECHA) {
                break;
            } else if (decision == 2 && DERECHAARRIBA) {
                break;
            } else if (decision == 3 && DERECHAABAJO) {
                break;
            } else if (decision == 4 && ABAJODERECHA) {
                break;
            } else if (decision == 5 && ABAJOIZQUIERDA) {
                break;
            } else if (decision == 6 && IZQUIERDAABAJO) {
                break;
            } else if (decision == 7 && IZQUIERDAARRIBA) {
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

        if (decision == 1 && ARRIBADERECHA){
            iProvisional = p.getI()-2;
            jProvisional = p.getJ()+1;
        }else if (decision == 2 && DERECHAARRIBA){
            iProvisional = p.getI()-1;
            jProvisional = p.getJ()+2;
        }else if (decision == 3 && DERECHAABAJO){
            iProvisional = p.getI()+1;
            jProvisional = p.getJ()+2;
        }else if (decision == 4 && ABAJODERECHA){
            iProvisional = p.getI()+2;
            jProvisional = p.getJ()+1;
        }else if (decision == 5 && ABAJOIZQUIERDA){
            iProvisional = p.getI()+2;
            jProvisional = p.getJ()-1;
        }else if (decision == 6 && IZQUIERDAABAJO){
            iProvisional = p.getI()+1;
            jProvisional = p.getJ()-2;
        }else if (decision == 7 && IZQUIERDAARRIBA){
            iProvisional = p.getI()-1;
            jProvisional = p.getJ()-2;
        }else if (decision == 8 && ARRIBAIZQUIERDA){
            iProvisional = p.getI()-2;
            jProvisional = p.getJ()-1;
        }

        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

        if (piezaComida != null && piezaComida.getColor().equals(p.getColor())){
            System.out.println("No te puedes comer una pieza de tu color");
            return;
        }

        Main.tablero[iOriginal][jOriginal] = null;
        Main.tablero[iProvisional][jProvisional] = p;

        p.setI(iProvisional);
        p.setJ(jProvisional);

        if (rey.hayJaque()){
            Main.tablero[iOriginal][jOriginal] = p;
            Main.tablero[iProvisional][jProvisional] = piezaComida;

            p.setI(iOriginal);
            p.setJ(jOriginal);

            System.out.println("Movimiento ilegal");
        }else{
            if (piezaComida != null){
                System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                Main.cambiarTurno();
            }else{
                System.out.println("Pieza movida.");
                Main.cambiarTurno();
            }
        }

    }
}

