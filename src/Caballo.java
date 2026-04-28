import java.util.Scanner;

public class Caballo extends Pieza{
    public Caballo(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }



    @Override
    public String toString() {
        return "C" + this.getColor() + this.getNumeroPieza();
    }

    //if(!puedeMover()){


    @Override
    public void posiblesMovimiento(Pieza p) {
        if (!hayJaque()){

            boolean ARRIBADERECHA = false;
            boolean DERECHAARRIBA = false;
            boolean DERECHAABAJO = false;
            boolean ABAJODERECHA = false;
            boolean ABAJOIZQUIERDA = false;
            boolean IZQUIERDAABAJO = false;
            boolean IZQUIERDAARRIBA = false;
            boolean ARRIBAIZQUIERDA = false;

            if (p.getI() - 2 >= 0 && p.getJ() + 1 <= 7){
                ARRIBADERECHA = true;
            }
            if (p.getI() - 1 >= 0 && p.getJ() + 2 <= 7){
                DERECHAARRIBA = true;
            }
            if (p.getI() + 1 <= 7 && p.getJ() + 2 <= 7){
                DERECHAABAJO = true;
            }
            if (p.getI() + 2 <= 7 && p.getJ() + 1 <= 7){
                ABAJODERECHA = true;
            }
            if (p.getI() + 2 <= 7 && p.getJ() - 1 >= 0){
                ABAJOIZQUIERDA = true;
            }
            if (p.getI() + 1 <= 7 && p.getJ() - 2 >= 0){
                IZQUIERDAABAJO = true;
            }
            if (p.getI() - 1 >= 0 && p.getJ() - 2 >= 0){
                IZQUIERDAARRIBA = true;
            }
            if (p.getI() - 2 >= 0 && p.getJ() - 1 >= 0){
                ARRIBAIZQUIERDA = true;
            }

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



            Scanner sc = new Scanner(System.in);
            int decision = sc.nextInt();



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

            if (hayJaque()){
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            }else{
                if (piezaComida != null){
                    System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                }else{
                    System.out.println("Pieza movida.");
                }
            }
        }
    }
}

