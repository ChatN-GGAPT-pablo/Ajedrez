import java.util.Scanner;

public class Dama extends Pieza{
    public Dama(String nombrePieza, String color, int i, int j) {
        super(nombrePieza, color, i, j);
    }



    @Override
    public String toString() {
        return "D" + this.getColor();
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

            if (p.getI() > 0 && p.getJ() < 7){
                ARRIBADERECHA = true;
            }

            if (p.getJ() < 7){
                DERECHA = true;
            }

            if (p.getI() < 7 && p.getJ() < 7){
                ABAJODERECHA = true;
            }

            if (p.getI() < 7){
                ABAJO = true;
            }

            if (p.getI() < 7 && p.getJ() > 0){
                ABAJOIZQUIERDA = true;
            }

            if (p.getJ() > 0){
                IZQUIERDA = true;
            }

            if (p.getI() > 0 && p.getJ() > 0){
                ARRIBAIZQUIERDA = true;
            }


            System.out.println("Hacia donde quieres moverte:");

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
                System.out.println("Cuantas hacia arriba?" );
                int capeada = (p.getI());
                for (int z = 1; z < capeada + 1; z++){
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

            if (decision == 2 && ARRIBADERECHA){
                int capeadoVertical = p.getI();
                int capeadoHorizontal = 7-p.getJ();

                System.out.println("Cuantas casillas quieres moverte");
                if (capeadoVertical > capeadoHorizontal){
                    for (int z = 1; z <= capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical < capeadoHorizontal){
                    for (int z = 1; z <= capeadoVertical;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical == capeadoHorizontal){
                    for (int z = 1; z <= capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }
                int movDiagonal = sc.nextInt();
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - movDiagonal;
                int jProvisional = p.getJ() + movDiagonal;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())){
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

            if (decision == 3 && DERECHA){
                System.out.println("Cuantas hacia la derecha?" );
                int capeada = (7-p.getJ() );
                for (int z = 1; z < capeada + 1; z++){
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

            if (decision == 4 && ABAJODERECHA){
                int capeadoVertical = 7-p.getI();
                int capeadoHorizontal = 7-p.getJ();

                System.out.println("Cuantas casillas quieres moverte");
                if (capeadoVertical > capeadoHorizontal){
                    for (int z = 1; z <= capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical < capeadoHorizontal){
                    for (int z = 1; z <= capeadoVertical;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical == capeadoHorizontal){
                    for (int z = 1; z <= capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }
                int movDiagonal = sc.nextInt();
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + movDiagonal;
                int jProvisional = p.getJ() + movDiagonal;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())){
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

            if (decision == 5 && ABAJO){
                System.out.println("Cuantas hacia abajo?" );
                int capeada = (7-p.getI());
                for (int z = 1; z < capeada + 1; z++){
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

            if (decision == 6 && ABAJOIZQUIERDA){
                int capeadoVertical = 7-p.getI();
                int capeadoHorizontal = p.getJ();

                System.out.println("Cuantas casillas quieres moverte");
                if (capeadoVertical > capeadoHorizontal){
                    for (int z = 1; z <= capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical < capeadoHorizontal){
                    for (int z = 1; z <= capeadoVertical;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical == capeadoHorizontal){
                    for (int z = 1; z <= capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }
                int movDiagonal = sc.nextInt();
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + movDiagonal;
                int jProvisional = p.getJ() - movDiagonal;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())){
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

            if (decision == 7 && IZQUIERDA){
                System.out.println("Cuantas hacia la izquierda?" );
                int capeada = (p.getJ());
                for (int z = 1; z < capeada + 1; z++){
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

            if (decision == 8 && ARRIBAIZQUIERDA){
                int capeadoVertical = p.getI();
                int capeadoHorizontal = p.getJ();

                System.out.println("Cuantas casillas quieres moverte");
                if (capeadoVertical > capeadoHorizontal){
                    for (int z = 1; z <= capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical < capeadoHorizontal){
                    for (int z = 1; z <= capeadoVertical;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical == capeadoHorizontal){
                    for (int z = 1; z <= capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }
                int movDiagonal = sc.nextInt();

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - movDiagonal;
                int jProvisional = p.getJ() - movDiagonal;

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
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + "comida.");
                    }else{
                        System.out.println("Pieza movida. ");
                    }
                    }

                }
            }
        }
}

