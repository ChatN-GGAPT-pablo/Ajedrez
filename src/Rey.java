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
    if (!hayJaque()){
        boolean ARRIBA = false;
        boolean ARRIBADERECHA = false;
        boolean DERECHA = false;
        boolean ABAJODERECHA = false;
        boolean ABAJO = false;
        boolean ABAJOIZQUIERDA = false;
        boolean IZQUIERDA = false;
        boolean ARRIBAIZQUIERDA = false;

        if (p.getI() > 0){
            ARRIBA = true;
        }

        if (p.getI() > 0 && p.getJ() < 8){
            ARRIBADERECHA = true;
        }

        if (p.getJ() < 8){
            DERECHA = true;
        }

        if (p.getI() < 8 && p.getJ() < 8){
            ABAJODERECHA = true;
        }

        if (p.getI() < 8){
            ABAJO = true;
        }

        if (p.getI() < 8 && p.getJ() > 0){
            ABAJOIZQUIERDA = true;
        }

        if (p.getJ() > 0){
            IZQUIERDA = true;
        }

        if (p.getI() > 0 && p.getJ() > 0){
            ARRIBAIZQUIERDA = true;
        }

        System.out.println("A donde quieres moverte");

        if (ARRIBA){
            System.out.println("1. Arriba");
        }

        if (ARRIBADERECHA){
            System.out.println("2. Arriba derecha");
        }

        if (DERECHA){
            System.out.println("3. Derecha");
        }

        if (ABAJODERECHA){
            System.out.println("4. Abajo derecha");
        }

        if (ABAJO){
            System.out.println("5. Abajo");
        }

        if (ABAJOIZQUIERDA){
            System.out.println("6. Abajo izquierda");
        }

        if (IZQUIERDA){
            System.out.println("7. Izquierda");
        }

        if (ARRIBAIZQUIERDA){
            System.out.println("8. Arriba izquierda");
        }


        Scanner sc = new Scanner(System.in);
        int decision = sc.nextInt();

        if (decision == 1 && ARRIBA){
            p.setI(p.getI()-1);
        }

        if (decision == 2 && ARRIBADERECHA){
            p.setI(p.getI()-1);
            p.setJ(p.getJ()+1);
        }

        if (decision == 3 && DERECHA){
            p.setJ(p.getJ()+1);
        }

        if (decision == 4 && ABAJODERECHA){
            p.setI(p.getI()+1);
            p.setJ(p.getJ()+1);
        }

        if (decision == 5 && ABAJO){
            p.setI(p.getI()+1);
        }

        if (decision == 6 && ABAJOIZQUIERDA){
            p.setI(p.getI()+1);
            p.setJ(p.getJ()-1);
        }

        if (decision == 7 && IZQUIERDA){
            p.setJ(p.getJ()-1);
        }

        if (decision == 8 && ARRIBAIZQUIERDA){
            p.setI(p.getI()-1);
            p.setJ(p.getJ()-1);
        }


        }
    }
}
