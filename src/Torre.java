import java.util.Scanner;


public class Torre extends Pieza{
    Scanner sc = new Scanner(System.in);
    public Torre(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }



    @Override
    public String toString() {
        return "T" + this.getColor() + this.getNumeroPieza();
    }



    @Override
    public void posiblesMovimientos(Pieza p) {
        //Hacer comprobaciones de si se puede mover
        if (!hayJaque()){

            boolean ARRIBA = false;
            boolean DERECHA = false;
            boolean ABAJO = false;
            boolean IZQUIERDA = false;

            for (int z = 1; z <= p.getI(); z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ()];

                if (casilla != null) {
                    if (!casilla.getColor().equals(p.getColor())) {
                        ARRIBA = true;
                    }
                    break;
                } else {
                    ARRIBA = true;
                    break;
                }
            }

            for (int z = 1; z <= 7 - p.getJ(); z++) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() + z];

                if (casilla != null) {
                    if (!casilla.getColor().equals(p.getColor())) {
                        DERECHA = true;
                    }
                    break;
                } else {
                    DERECHA = true;
                    break;
                }
            }

            for (int z = 1; z <= 7 - p.getI(); z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ()];

                if (casilla != null) {
                    if (!casilla.getColor().equals(p.getColor())) {
                        ABAJO = true;
                    }
                    break;
                } else {
                    ABAJO = true;
                    break;
                }
            }

            for (int z = 1; z <= p.getJ(); z++) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() - z];

                if (casilla != null) {
                    if (!casilla.getColor().equals(p.getColor())) {
                        IZQUIERDA = true;
                    }
                    break;
                } else {
                    IZQUIERDA = true;
                    break;
                }
            }


            if (!ARRIBA && !DERECHA && !ABAJO && !IZQUIERDA) {
                System.out.println("No hay movimientos disponibles");
                return;
            }

            int decision;

            while (true){
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

                decision = sc.nextInt();

                if (decision == 1 && ARRIBA) {
                    break;
                } else if (decision == 2 && DERECHA) {
                    break;
                } else if (decision == 3 && ABAJO) {
                    break;
                } else if (decision == 4 && IZQUIERDA) {
                    break;
                } else {
                    System.out.println("Repite decisión");
                }
            }

                if (decision == 1 && ARRIBA){
                    System.out.println("Cuantas hacia arriba?" );
                    int capeada = (p.getI());


                    int maximo = 0;
                    for (int z = 1; z <= capeada ; z++){
                        if (Main.tablero[p.getI()-z][p.getJ()] != null){

                            if (!(Main.tablero[p.getI()-z][p.getJ()].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");

                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }

                    }

                    int movARRIBA = sc.nextInt();

                    while (movARRIBA < 1 || movARRIBA > maximo ){
                        System.out.println("Te sales del rango de movs permitidos, repite.");
                        movARRIBA = sc.nextInt();
                    }

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

                int maximo = 0;
                for (int z = 1; z <= capeada ; z++){
                    if (Main.tablero[p.getI()][p.getJ()+ z] != null){

                        if (!(Main.tablero[p.getI()][p.getJ()+z].getColor().equals(p.getColor()))){
                            System.out.println(z + "casillas");
                            maximo = z;

                        }
                        break;
                    }else{
                        System.out.println(z + "casillas");
                        maximo = z;
                    }

                }
                int movDERECHA = sc.nextInt();

                while (movDERECHA < 1 || movDERECHA > maximo){
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDERECHA = sc.nextInt();
                }
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

                int maximo = 0;
                for (int z = 1; z <= capeada ; z++){
                    if (Main.tablero[p.getI()+ z][p.getJ()] != null){

                        if (!(Main.tablero[p.getI()+z][p.getJ()].getColor().equals(p.getColor()))){
                            System.out.println(z + "casillas");
                            maximo = z;

                        }
                        break;
                    }else{
                        System.out.println(z + "casillas");
                        maximo = z;
                    }

                }
                int movABAJO = sc.nextInt();

                while (movABAJO < 1 || movABAJO > maximo){
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movABAJO = sc.nextInt();
                }
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

                int maximo = 0;
                for (int z = 1; z <= capeada ; z++){
                    if (Main.tablero[p.getI()][p.getJ()-z] != null){

                        if (!(Main.tablero[p.getI()][p.getJ()-z].getColor().equals(p.getColor()))){
                            System.out.println(z + "casillas");
                            maximo = z;

                        }
                        break;
                    }else{
                        System.out.println(z + "casillas");
                        maximo = z;
                    }

                }
                int movIZQUIERDA = sc.nextInt();

                while (movIZQUIERDA < 1  || movIZQUIERDA > maximo){
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movIZQUIERDA = sc.nextInt();
                }
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
