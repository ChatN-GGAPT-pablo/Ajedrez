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

            if (p.getI() - 2 > 0 && p.getJ() + 1 < 8){
                ARRIBADERECHA = true;
            }
            if (p.getI() - 1 > 0 && p.getJ() + 2 < 8){
                DERECHAARRIBA = true;
            }
            if (p.getI() + 1 < 8 && p.getJ() + 2 < 8){
                DERECHAABAJO = true;
            }
            if (p.getI() + 2 < 8 && p.getJ() + 1 < 8){
                ABAJODERECHA = true;
            }
            if (p.getI() + 2 < 8 && p.getJ() - 1 > 0){
                ABAJOIZQUIERDA = true;
            }
            if (p.getI() + 1 < 8 && p.getJ() - 2 > 0){
                IZQUIERDAABAJO = true;
            }
            if (p.getI() - 1 > 0 && p.getJ() - 2 > 0){
                IZQUIERDAARRIBA = true;
            }
            if (p.getI() - 2 > 0 && p.getJ() - 1 > 0){
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
            if (decision == 1 && ARRIBADERECHA){
                p.setI(p.getI()-2);
                p.setJ(p.getI()+1);
            }else if (decision == 2 && DERECHAARRIBA){
                p.setI(p.getI()-1);
                p.setJ(p.getI()+2);
            }else if (decision == 3 && DERECHAABAJO){
                p.setI(p.getI()+1);
                p.setJ(p.getI()+2);
            }else if (decision == 4 && ABAJODERECHA){
                p.setI(p.getI()+2);
                p.setJ(p.getI()+1);
            }else if (decision == 5 && ABAJOIZQUIERDA){
                p.setI(p.getI()+2);
                p.setJ(p.getI()-1);
            }else if (decision == 6 && IZQUIERDAABAJO){
                p.setI(p.getI()+1);
                p.setJ(p.getI()-2);
            }else if (decision == 7 && IZQUIERDAARRIBA){
                p.setI(p.getI()-1);
                p.setJ(p.getI()-2);
            }else if (decision == 8 && ARRIBAIZQUIERDA){
                p.setI(p.getI()-2);
                p.setJ(p.getI()-1);
            }
        }
    }
}

