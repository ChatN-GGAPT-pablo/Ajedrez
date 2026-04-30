import java.util.Scanner;

public class Alfil extends Pieza{
    Scanner sc = new Scanner(System.in);
    public Alfil(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }



    @Override
    public String toString() {
        return "A" + this.getColor() + this.getNumeroPieza();
    }


    @Override
    public void posiblesMovimientos(Pieza p) {
        if (!hayJaque()) {

            boolean ARRIBADERECHA = false;
            boolean ABAJODERECHA = false;
            boolean ABAJOIZQUIERDA = false;
            boolean ARRIBAIZQUIERDA = false;

            int capeadoVertical = p.getI();
            int capeadoHorizontal = 7 - p.getJ();

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ARRIBADERECHA = true;
                        }
                        break;
                    } else {
                        ARRIBADERECHA = true;
                        break;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {
                for (int z = 1; z <= capeadoVertical; z++) {
                    Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ARRIBADERECHA = true;
                        }
                        break;
                    } else {
                        ARRIBADERECHA = true;
                        break;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ARRIBADERECHA = true;
                        }
                        break;
                    } else {
                        ARRIBADERECHA = true;
                        break;
                    }
                }
            }

            capeadoVertical = 7 - p.getI();
            capeadoHorizontal = 7 - p.getJ();

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ABAJODERECHA = true;
                        }
                        break;
                    } else {
                        ABAJODERECHA = true;
                        break;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {
                for (int z = 1; z <= capeadoVertical; z++) {
                    Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ABAJODERECHA = true;
                        }
                        break;
                    } else {
                        ABAJODERECHA = true;
                        break;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ABAJODERECHA = true;
                        }
                        break;
                    } else {
                        ABAJODERECHA = true;
                        break;
                    }
                }
            }

            capeadoVertical = 7 - p.getI();
            capeadoHorizontal = p.getJ();

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ABAJOIZQUIERDA = true;
                        }
                        break;
                    } else {
                        ABAJOIZQUIERDA = true;
                        break;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {
                for (int z = 1; z <= capeadoVertical; z++) {
                    Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ABAJOIZQUIERDA = true;
                        }
                        break;
                    } else {
                        ABAJOIZQUIERDA = true;
                        break;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ABAJOIZQUIERDA = true;
                        }
                        break;
                    } else {
                        ABAJOIZQUIERDA = true;
                        break;
                    }
                }
            }

            capeadoVertical = p.getI();
            capeadoHorizontal = p.getJ();

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ARRIBAIZQUIERDA = true;
                        }
                        break;
                    } else {
                        ARRIBAIZQUIERDA = true;
                        break;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {
                for (int z = 1; z <= capeadoVertical; z++) {
                    Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ARRIBAIZQUIERDA = true;
                        }
                        break;
                    } else {
                        ARRIBAIZQUIERDA = true;
                        break;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                    if (casilla != null) {
                        if (!casilla.getColor().equals(p.getColor())) {
                            ARRIBAIZQUIERDA = true;
                        }
                        break;
                    } else {
                        ARRIBAIZQUIERDA = true;
                        break;
                    }
                }
            }

            if (!ARRIBADERECHA && !ABAJODERECHA && !ABAJOIZQUIERDA && !ARRIBAIZQUIERDA) {
                System.out.println("No hay movimientos disponibles");
                return;
            }


            int decision;
            while (true){
                System.out.println("Hacia dónde quieres mover?");

                if (ARRIBADERECHA) {
                    System.out.println("1. Arriba derecha");
                }

                if (ABAJODERECHA) {
                    System.out.println("2. Abajo derecha");
                }

                if (ABAJOIZQUIERDA) {
                    System.out.println("3. Abajo izquierda");
                }

                if (ARRIBAIZQUIERDA) {
                    System.out.println("4. Arriba izquierda");
                }

                decision = sc.nextInt();
                if (decision == 1 && ARRIBADERECHA) {
                    break;
                } else if (decision == 2 && ABAJODERECHA) {
                    break;
                } else if (decision == 3 && ABAJOIZQUIERDA) {
                    break;
                } else if (decision == 4 && ARRIBAIZQUIERDA) {
                    break;
                } else {
                    System.out.println("Opción no válida, repite.");
                }
            }








            if (decision == 1 && ARRIBADERECHA) {
                System.out.println("Cuantas casillas quieres moverte");

                capeadoVertical = p.getI();
                capeadoHorizontal = 7 - p.getJ();
                int maximo = 0;

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI()-z][p.getJ()+z] != null){
                            if (!(Main.tablero[p.getI()-z][p.getJ()+z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else if (capeadoVertical < capeadoHorizontal) {

                    for (int z = 1; z <= capeadoVertical; z++) {
                        if (Main.tablero[p.getI()-z][p.getJ()+z] != null){
                            if (!(Main.tablero[p.getI()-z][p.getJ()+z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI()-z][p.getJ()+z] != null){
                            if (!(Main.tablero[p.getI()-z][p.getJ()+z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");

                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                }


                int movDiagonal = sc.nextInt();

                while (movDiagonal < 1 || movDiagonal > maximo){
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDiagonal = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - movDiagonal;
                int jProvisional = p.getJ() + movDiagonal;

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

            if (decision == 2 && ABAJODERECHA) {

                System.out.println("Cuantas casillas quieres moverte");

                capeadoVertical = 7 - p.getI();
                capeadoHorizontal = 7 - p.getJ();



                int maximo = 0;

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI()+z][p.getJ()+z] != null){
                            if (!(Main.tablero[p.getI()+z][p.getJ()+z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else if (capeadoVertical < capeadoHorizontal) {

                    for (int z = 1; z <= capeadoVertical; z++) {
                        if (Main.tablero[p.getI()+z][p.getJ()+z] != null){
                            if (!(Main.tablero[p.getI()+z][p.getJ()+z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI()+z][p.getJ()+z] != null){
                            if (!(Main.tablero[p.getI()+z][p.getJ()+z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");

                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                }
                int movDiagonal = sc.nextInt();

                while (movDiagonal < 1 || movDiagonal > maximo){
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDiagonal = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + movDiagonal;
                int jProvisional = p.getJ() + movDiagonal;

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

            if (decision == 3 && ABAJOIZQUIERDA) {
                System.out.println("Cuantas casillas quieres moverte");

                capeadoVertical = 7 - p.getI();
                capeadoHorizontal = p.getJ();

                int maximo = 0;

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI()+z][p.getJ()-z] != null){
                            if (!(Main.tablero[p.getI()+z][p.getJ()-z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else if (capeadoVertical < capeadoHorizontal) {

                    for (int z = 1; z <= capeadoVertical; z++) {
                        if (Main.tablero[p.getI()+z][p.getJ()-z] != null){
                            if (!(Main.tablero[p.getI()+z][p.getJ()-z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI()+z][p.getJ()-z] != null){
                            if (!(Main.tablero[p.getI()+z][p.getJ()-z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");

                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                }

                int movDiagonal = sc.nextInt();

                while (movDiagonal < 1 || movDiagonal > maximo){
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDiagonal = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + movDiagonal;
                int jProvisional = p.getJ() - movDiagonal;

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

            if (decision == 4 && ARRIBAIZQUIERDA) {
                System.out.println("Cuantas casillas quieres moverte");

                capeadoVertical = p.getI();
                capeadoHorizontal = p.getJ();

                int maximo = 0;

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI()-z][p.getJ()-z] != null){
                            if (!(Main.tablero[p.getI()-z][p.getJ()-z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else if (capeadoVertical < capeadoHorizontal) {

                    for (int z = 1; z <= capeadoVertical; z++) {
                        if (Main.tablero[p.getI()-z][p.getJ()-z] != null){
                            if (!(Main.tablero[p.getI()-z][p.getJ()-z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI()-z][p.getJ()-z] != null){
                            if (!(Main.tablero[p.getI()-z][p.getJ()-z].getColor().equals(p.getColor()))){
                                System.out.println(z + "casillas");

                                maximo = z;
                            }
                            break;
                        }else{
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                }

                int movDiagonal = sc.nextInt();

                while (movDiagonal < 1 || movDiagonal > maximo){
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDiagonal = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - movDiagonal;
                int jProvisional = p.getJ() - movDiagonal;

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
        }
    }
}
