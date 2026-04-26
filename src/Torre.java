import java.util.Scanner;


public class Torre extends Pieza{
    public Torre(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }



    @Override
    public String toString() {
        return "T" + this.getColor() + this.getNumeroPieza();
    }



    @Override
    public void posiblesMovimiento(Pieza p) {
        //Hacer comprobaciones de si se puede mover
        if (!hayJaque()){

            boolean ARRIBA = false;
            boolean DERECHA = false;
            boolean ABAJO = false;
            boolean IZQUIERDA = false;

            if (p.getI() > 0){
                ARRIBA = true;
            }

            if (p.getJ() < 8){
                DERECHA = true;
            }

            if (p.getI() < 8){
                ABAJO = true;
            }

            if (p.getJ() > 0){
                IZQUIERDA = true;
            }


            System.out.println("Hacia donde quieres moverte:");

            if (ARRIBA){
                System.out.println("1. Arriba");
            }

            if (DERECHA){
                System.out.println("2. Derecha");
            }

            if (ABAJO){
                System.out.println("3. Abajo");
            }

            if (IZQUIERDA){
                System.out.println("4. Izquierda");
            }


            Scanner sc = new Scanner(System.in);
            int decision = sc.nextInt();
            if (decision == 1 && ARRIBA){
                System.out.println("Cuantas hacia arriba?" );
                int capeada = (p.getI());
                for (int z = 1; z < capeada + 1; z++){
                    System.out.println(z + "casillas");
                }
                int movARRIBA = sc.nextInt();
                p.setI(p.getI()- movARRIBA);
            }

            if (decision == 2 && DERECHA){
                System.out.println("Cuantas hacia la derecha?" );
                int capeada = (8-p.getJ() );
                for (int z = 1; z < capeada + 1; z++){
                    System.out.println(z + "casillas");
                }
                int movDERECHA = sc.nextInt();
                p.setJ(p.getJ()-movDERECHA);
            }

            if (decision == 3 && ABAJO){
                System.out.println("Cuantas hacia abajo?" );
                int capeada = (8-p.getI());
                for (int z = 1; z < capeada + 1; z++){
                    System.out.println(z + "casillas");
                }
                int movABAJO = sc.nextInt();
                p.setI(p.getI()+ movABAJO);
            }

            if (decision == 4 && IZQUIERDA){
                System.out.println("Cuantas hacia la izquierda?" );
                int capeada = (8-p.getJ());
                for (int z = 1; z < capeada + 1; z++){
                    System.out.println(z + "casillas");
                }
                int movIZQUIERDA = sc.nextInt();
                p.setJ(p.getJ()-movIZQUIERDA);
            }
        }

    }
}
