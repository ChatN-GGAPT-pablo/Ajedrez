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

            if (p.getJ() < 7){
                DERECHA = true;
            }

            if (p.getI() < 7){
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
                for (int z = 1; z <= capeada ; z++){
                    System.out.println(z + "casillas");
                }
                int movARRIBA = sc.nextInt();

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - movARRIBA;
                int jProvisional = p.getJ();

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

            if (decision == 2 && DERECHA){
                System.out.println("Cuantas hacia la derecha?" );
                int capeada = (7-p.getJ() );
                for (int z = 1; z <= capeada ; z++){
                    System.out.println(z + "casillas");
                }
                int movDERECHA = sc.nextInt();
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ() + movDERECHA;

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

            if (decision == 3 && ABAJO){
                System.out.println("Cuantas hacia abajo?" );
                int capeada = (7-p.getI());
                for (int z = 1; z <= capeada ; z++){
                    System.out.println(z + "casillas");
                }
                int movABAJO = sc.nextInt();
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + movABAJO;
                int jProvisional = p.getJ();

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

            if (decision == 4 && IZQUIERDA){
                System.out.println("Cuantas hacia la izquierda?" );
                int capeada = (p.getJ());
                for (int z = 1; z <= capeada ; z++){
                    System.out.println(z + "casillas");
                }
                int movIZQUIERDA = sc.nextInt();
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ() - movIZQUIERDA;

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
}
