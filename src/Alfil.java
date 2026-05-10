import java.util.Scanner;

public class Alfil extends Pieza{
    Scanner sc = new Scanner(System.in);
    public Alfil(Color color, int numeroPieza, int i, int j, boolean inmovil) {
        super(TipoPieza.ALFIL, color, numeroPieza, i, j, inmovil);
    }



    @Override
    public String toString() {
        return "A" + this.getColor().getSimbolo() + this.getNumeroPieza();
    }


    @Override
    public void posiblesMovimientos(Pieza p) {
        Pieza rey = Main.buscarRey(p.getColor());

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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
                    if (casilla.getColor() != p.getColor()) {
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
            p.setInmovil(true);
            return;
        }else{
            p.setInmovil(false);
        }


        int decision;
        while (true){
            System.out.println("Hacia dónde quieres mover?");
            System.out.println("0. Cancelar");


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

            decision = Main.comprobarScanner(sc);
            if (decision == 0){
                System.out.println("Movimiento cancelado");
                return;
            }
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
            System.out.println("0. Cancelar");

            capeadoVertical = p.getI();
            capeadoHorizontal = 7 - p.getJ();
            int maximo = 0;

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI()-z][p.getJ()+z] != null){
                        if (!(Main.tablero[p.getI()-z][p.getJ()+z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");
                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {

                for (int z = 1; z <= capeadoVertical; z++) {
                    if (Main.tablero[p.getI()-z][p.getJ()+z] != null){
                        if (!(Main.tablero[p.getI()-z][p.getJ()+z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");
                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI()-z][p.getJ()+z] != null){
                        if (!(Main.tablero[p.getI()-z][p.getJ()+z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");

                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            }


            int movDiagonal = Main.comprobarScanner(sc);

            if (movDiagonal == 0){
                System.out.println("Movimiento cancelado");
                return;
            }
            while (movDiagonal < 1 || movDiagonal > maximo){
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDiagonal = Main.comprobarScanner(sc);
                if (movDiagonal == 0){
                    System.out.println("Movimiento cancelado");
                    return;
                }
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

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    if( Main.hayJaqueMate(Main.getTurno())){
                        Main.mostrarTablero();
                        return;
                    }
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                    if (reyTurno.hayJaque()) {
                        System.out.println("Jaque");
                    }
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    if( Main.hayJaqueMate(Main.getTurno())){
                        Main.mostrarTablero();
                        return;
                    }
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                    if (reyTurno.hayJaque()) {
                        System.out.println("Jaque");
                    }
                }
            }
        }

        if (decision == 2 && ABAJODERECHA) {

            System.out.println("Cuantas casillas quieres moverte");
            System.out.println("0. Cancelar");

            capeadoVertical = 7 - p.getI();
            capeadoHorizontal = 7 - p.getJ();



            int maximo = 0;

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI()+z][p.getJ()+z] != null){
                        if (!(Main.tablero[p.getI()+z][p.getJ()+z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");
                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {

                for (int z = 1; z <= capeadoVertical; z++) {
                    if (Main.tablero[p.getI()+z][p.getJ()+z] != null){
                        if (!(Main.tablero[p.getI()+z][p.getJ()+z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");
                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI()+z][p.getJ()+z] != null){
                        if (!(Main.tablero[p.getI()+z][p.getJ()+z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");

                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            }
            int movDiagonal = Main.comprobarScanner(sc);

            if (movDiagonal == 0) {
                System.out.println("Movimiento cancelado");
                return;
            }
            while (movDiagonal < 1 || movDiagonal > maximo){
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDiagonal = Main.comprobarScanner(sc);

                if (movDiagonal == 0) {
                    System.out.println("Movimiento cancelado");
                    return;
                }
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

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    if( Main.hayJaqueMate(Main.getTurno())){
                        Main.mostrarTablero();
                        return;
                    }
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                    if (reyTurno.hayJaque()) {
                        System.out.println("Jaque");
                    }
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    if( Main.hayJaqueMate(Main.getTurno())){
                        Main.mostrarTablero();
                        return;
                    }
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                    if (reyTurno.hayJaque()) {
                        System.out.println("Jaque");
                    }
                }
            }
        }

        if (decision == 3 && ABAJOIZQUIERDA) {
            System.out.println("Cuantas casillas quieres moverte");
            System.out.println("0. Cancelar");

            capeadoVertical = 7 - p.getI();
            capeadoHorizontal = p.getJ();

            int maximo = 0;

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI()+z][p.getJ()-z] != null){
                        if (!(Main.tablero[p.getI()+z][p.getJ()-z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");
                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {

                for (int z = 1; z <= capeadoVertical; z++) {
                    if (Main.tablero[p.getI()+z][p.getJ()-z] != null){
                        if (!(Main.tablero[p.getI()+z][p.getJ()-z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");
                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI()+z][p.getJ()-z] != null){
                        if (!(Main.tablero[p.getI()+z][p.getJ()-z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");

                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            }

            int movDiagonal = Main.comprobarScanner(sc);

            if (movDiagonal == 0) {
                System.out.println("Movimiento cancelado");
                return;
            }

            while (movDiagonal < 1 || movDiagonal > maximo){
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDiagonal = Main.comprobarScanner(sc);

                if (movDiagonal == 0) {
                    System.out.println("Movimiento cancelado");
                    return;
                }
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

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    if( Main.hayJaqueMate(Main.getTurno())){
                        Main.mostrarTablero();
                        return;
                    }
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                    if (reyTurno.hayJaque()) {
                        System.out.println("Jaque");
                    }
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    if( Main.hayJaqueMate(Main.getTurno())){
                        Main.mostrarTablero();
                        return;
                    }
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                    if (reyTurno.hayJaque()) {
                        System.out.println("Jaque");
                    }
                }
            }
        }

        if (decision == 4 && ARRIBAIZQUIERDA) {
            System.out.println("Cuantas casillas quieres moverte");
            System.out.println("0. Cancelar");


            capeadoVertical = p.getI();
            capeadoHorizontal = p.getJ();

            int maximo = 0;

            if (capeadoVertical > capeadoHorizontal) {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI()-z][p.getJ()-z] != null){
                        if (!(Main.tablero[p.getI()-z][p.getJ()-z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");
                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            } else if (capeadoVertical < capeadoHorizontal) {

                for (int z = 1; z <= capeadoVertical; z++) {
                    if (Main.tablero[p.getI()-z][p.getJ()-z] != null){
                        if (!(Main.tablero[p.getI()-z][p.getJ()-z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");
                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            } else {
                for (int z = 1; z <= capeadoHorizontal; z++) {
                    if (Main.tablero[p.getI()-z][p.getJ()-z] != null){
                        if (!(Main.tablero[p.getI()-z][p.getJ()-z].getColor().equals(p.getColor()))){
                            System.out.println(z + " casillas");

                            maximo = z;
                        }
                        break;
                    }else{
                        System.out.println(z + " casillas");
                        maximo = z;
                    }
                }
            }

            int movDiagonal = Main.comprobarScanner(sc);

            if (movDiagonal == 0) {
                System.out.println("Movimiento cancelado");
                return;
            }

            while (movDiagonal < 1 || movDiagonal > maximo){
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDiagonal = Main.comprobarScanner(sc);

                if (movDiagonal == 0) {
                    System.out.println("Movimiento cancelado");
                    return;
                }
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

            if (rey.hayJaque()) {
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            } else {
                if (piezaComida != null) {
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    if( Main.hayJaqueMate(Main.getTurno())){
                        Main.mostrarTablero();
                        return;
                    }
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                    if (reyTurno.hayJaque()) {
                        System.out.println("Jaque");
                    }
                } else {
                    System.out.println("Pieza movida.");
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    if( Main.hayJaqueMate(Main.getTurno())){
                        Main.mostrarTablero();
                        return;
                    }
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                    if (reyTurno.hayJaque()) {
                        System.out.println("Jaque");
                    }
                }
            }
        }

    }

    @Override
    public boolean comprobarMovimientos(Pieza p) {
        Pieza rey = Main.buscarRey(p.getColor());

        boolean ARRIBADERECHA = false;
        boolean ABAJODERECHA = false;
        boolean ABAJOIZQUIERDA = false;
        boolean ARRIBAIZQUIERDA = false;

        int capeadoVertical = p.getI();
        int capeadoHorizontal = 7 - p.getJ();

        // ARRIBA DERECHA
        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - z;
                int jProvisional = p.getJ() + z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ARRIBADERECHA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - z;
                int jProvisional = p.getJ() + z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ARRIBADERECHA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() + z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - z;
                int jProvisional = p.getJ() + z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ARRIBADERECHA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        }

        // ABAJO DERECHA
        capeadoVertical = 7 - p.getI();
        capeadoHorizontal = 7 - p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + z;
                int jProvisional = p.getJ() + z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ABAJODERECHA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + z;
                int jProvisional = p.getJ() + z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ABAJODERECHA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() + z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + z;
                int jProvisional = p.getJ() + z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ABAJODERECHA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        }

        // ABAJO IZQUIERDA
        capeadoVertical = 7 - p.getI();
        capeadoHorizontal = p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + z;
                int jProvisional = p.getJ() - z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ABAJOIZQUIERDA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + z;
                int jProvisional = p.getJ() - z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ABAJOIZQUIERDA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() + z][p.getJ() - z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + z;
                int jProvisional = p.getJ() - z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ABAJOIZQUIERDA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        }

        // ARRIBA IZQUIERDA
        capeadoVertical = p.getI();
        capeadoHorizontal = p.getJ();

        if (capeadoVertical > capeadoHorizontal) {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - z;
                int jProvisional = p.getJ() - z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ARRIBAIZQUIERDA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        } else if (capeadoVertical < capeadoHorizontal) {
            for (int z = 1; z <= capeadoVertical; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - z;
                int jProvisional = p.getJ() - z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ARRIBAIZQUIERDA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        } else {
            for (int z = 1; z <= capeadoHorizontal; z++) {
                Pieza casilla = Main.tablero[p.getI() - z][p.getJ() - z];

                if (casilla != null && casilla.getColor() == p.getColor()) {
                    break;
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - z;
                int jProvisional = p.getJ() - z;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    ARRIBAIZQUIERDA = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                if (casilla != null) {
                    break;
                }
            }
        }

        if (!ARRIBADERECHA && !ABAJODERECHA && !ABAJOIZQUIERDA && !ARRIBAIZQUIERDA) {
            return false;
        }
        return true;
    }
}
