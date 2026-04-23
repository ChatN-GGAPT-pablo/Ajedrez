import java.util.Scanner;

public class Caballo extends Pieza{
    public Caballo(String nombrePieza, String color, int numeroPieza) {
        super(nombrePieza, color, numeroPieza);
    }



    @Override
    public String toString() {
        return "C" + this.getColor() + this.getNumeroPieza();
    }

    //if(!puedeMover()){


    @Override
    public void posiblesMovimiento(int iActual, int jActual) {
        if (!hayJaque()){



            boolean ARRIBADERECHA = false;
            boolean DERECHAARRIBA = false;
            boolean DERECHAABAJO = false;
            boolean ABAJODERECHA = false;
            boolean ABAJOIZQUIERDA = false;
            boolean IZQUIERDAABAJO = false;
            boolean IZQUIERDAARRIBA = false;
            boolean ARRIBAIZQUIERDA = false;

            if (iActual - 2 > 0 && jActual + 1 < 8){
                ARRIBADERECHA = true;
            }
            if (iActual - 1 > 0 && jActual + 2 < 8){
                DERECHAARRIBA = true;
            }
            if (iActual + 1 < 8 && jActual + 2 < 8){
                DERECHAABAJO = true;
            }
            if (iActual + 2 < 8 && jActual + 1 < 8){
                ABAJODERECHA = true;
            }
            if (iActual + 2 < 8 && jActual - 1 > 0){
                ABAJOIZQUIERDA = true;
            }
            if (iActual + 1 < 8 && jActual - 2 > 0){
                IZQUIERDAABAJO = true;
            }
            if (iActual - 1 > 0 && jActual - 2 > 0){
                IZQUIERDAARRIBA = true;
            }
            if (iActual - 2 > 0 && jActual -1 > 0){
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
                iActual -=2;
                jActual +=1;
            }else if (decision == 2 && DERECHAARRIBA){
                iActual -=1;
                jActual +=2;
            }else if (decision == 3 && DERECHAABAJO){
                iActual +=1;
                jActual +=2;
            }else if (decision == 4 && ABAJODERECHA){
                iActual +=2;
                jActual +=1;
            }else if (decision == 5 && ABAJOIZQUIERDA){
                iActual +=2;
                jActual -=1;
            }else if (decision == 6 && IZQUIERDAABAJO){
                iActual +=1;
                jActual -=2;
            }else if (decision == 7 && IZQUIERDAARRIBA){
                iActual -=1;
                jActual -=2;
            }else if (decision == 8 && ARRIBAIZQUIERDA){
                iActual -=2;
                jActual -=1;
            }
        }
    }
}

