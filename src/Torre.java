import java.util.Scanner;


public class Torre extends Pieza{
    Scanner sc = new Scanner(System.in);
    public Torre(Color color, int numeroPieza, int i, int j, boolean Inmovil) {
        super(TipoPieza.TORRE, color, numeroPieza, i, j, Inmovil);
    }



    @Override
    public String toString() {
        return "T" + this.getColor().getSimbolo() + this.getNumeroPieza();
    }




    @Override
    public void posiblesMovimientos(Pieza p) {

        Pieza rey = Main.buscarRey(p.getColor());
        //Hacer comprobaciones de si se puede mover
        boolean ARRIBA = false;
        boolean DERECHA = false;
        boolean ABAJO = false;
        boolean IZQUIERDA = false;

        for (int z = 1; z <= p.getI(); z++) {
            Pieza casilla = Main.tablero[p.getI() - z][p.getJ()];

            if (casilla != null) {
                if (casilla.getColor() != p.getColor()) {
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
                if (casilla.getColor() != p.getColor()) {
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
                if (casilla.getColor() != p.getColor()) {
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
                if (casilla.getColor() != p.getColor()) {
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
            p.setInmovil(true);
            return;
        }else{
            p.setInmovil(false);
        }

        int decision;

        while (true){
            System.out.println("Hacia donde quieres moverte:");
            System.out.println("0. Cancelar");

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

            decision = Main.comprobarScanner(sc);

            if (decision == 0){
                System.out.println("Movimiento cancelado");
                return;
            }
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
            System.out.println("0. Cancelar");
            int capeada = (p.getI());


            int maximo = 0;
            for (int z = 1; z <= capeada ; z++){
                if (Main.tablero[p.getI()-z][p.getJ()] != null){

                    if (!(Main.tablero[p.getI()-z][p.getJ()].getColor().equals(p.getColor()))){
                        System.out.println(z + " casillas");

                        maximo = z;
                    }
                    break;
                }else{
                    System.out.println(z + " casillas");
                    maximo = z;
                }

            }

            int movARRIBA = Main.comprobarScanner(sc);

            if (movARRIBA == 0){
                System.out.println("Movimiento cancelado");
                return;
            }
            while (movARRIBA < 1 || movARRIBA > maximo ){
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movARRIBA = Main.comprobarScanner(sc);
                if (movARRIBA == 0){
                    System.out.println("Movimiento cancelado");
                    return;
                }
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

            if (rey.hayJaque()){
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            }else{
                if (piezaComida != null){
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    p.setPrimerMovimiento2OEnroque(true);
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }else{
                    System.out.println("Pieza movida.");
                    p.setPrimerMovimiento2OEnroque(true);
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }
            }
        }

        if (decision == 2 && DERECHA){
            System.out.println("Cuantas hacia la derecha?" );
            System.out.println("0. Cancelar");
            int capeada = (7-p.getJ() );

            int maximo = 0;
            for (int z = 1; z <= capeada ; z++){
                if (Main.tablero[p.getI()][p.getJ()+ z] != null){

                    if (!(Main.tablero[p.getI()][p.getJ()+z].getColor().equals(p.getColor()))){
                        System.out.println(z + " casillas");
                        maximo = z;

                    }
                    break;
                }else{
                    System.out.println(z + " casillas");
                    maximo = z;
                }

            }
            int movDERECHA = Main.comprobarScanner(sc);

            if (movDERECHA == 0){
                System.out.println("Movimiento cancelado");
                return;
            }
            while (movDERECHA < 1 || movDERECHA > maximo){
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movDERECHA = Main.comprobarScanner(sc);
                if (movDERECHA == 0){
                    System.out.println("Movimiento cancelado");
                    return;
                }
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

            if (rey.hayJaque()){
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            }else{
                if (piezaComida != null){
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    p.setPrimerMovimiento2OEnroque(true);
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }else{
                    System.out.println("Pieza movida.");
                    p.setPrimerMovimiento2OEnroque(true);
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }
            }
        }

        if (decision == 3 && ABAJO){
            System.out.println("Cuantas hacia abajo?" );
            System.out.println("0. Cancelar");
            int capeada = (7-p.getI());

            int maximo = 0;
            for (int z = 1; z <= capeada ; z++){
                if (Main.tablero[p.getI()+ z][p.getJ()] != null){

                    if (!(Main.tablero[p.getI()+z][p.getJ()].getColor().equals(p.getColor()))){
                        System.out.println(z + " casillas");
                        maximo = z;

                    }
                    break;
                }else{
                    System.out.println(z + " casillas");
                    maximo = z;
                }

            }
            int movABAJO = Main.comprobarScanner(sc);

            if (movABAJO == 0){
                System.out.println("Movimiento cancelado");
                return;
            }

            while (movABAJO < 1 || movABAJO > maximo){
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movABAJO = Main.comprobarScanner(sc);
                if (movABAJO == 0){
                    System.out.println("Movimiento cancelado");
                    return;
                }
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

            if (rey.hayJaque()){
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            }else{
                if (piezaComida != null){
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    p.setPrimerMovimiento2OEnroque(true);
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }else{
                    System.out.println("Pieza movida.");
                    p.setPrimerMovimiento2OEnroque(true);
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }
            }
        }

        if (decision == 4 && IZQUIERDA){
            System.out.println("Cuantas hacia la izquierda?" );
            System.out.println("0. Cancelar");
            int capeada = (p.getJ());

            int maximo = 0;
            for (int z = 1; z <= capeada ; z++){
                if (Main.tablero[p.getI()][p.getJ()-z] != null){

                    if (!(Main.tablero[p.getI()][p.getJ()-z].getColor().equals(p.getColor()))){
                        System.out.println(z + " casillas");
                        maximo = z;

                    }
                    break;
                }else{
                    System.out.println(z + " casillas");
                    maximo = z;
                }

            }
            int movIZQUIERDA = Main.comprobarScanner(sc);

            if (movIZQUIERDA == 0){
                System.out.println("Movimiento cancelado");
                return;
            }
            while (movIZQUIERDA < 1  || movIZQUIERDA > maximo){
                System.out.println("Te sales del rango de movs permitidos, repite.");
                movIZQUIERDA = Main.comprobarScanner(sc);

                if (movIZQUIERDA == 0){
                    System.out.println("Movimiento cancelado");
                    return;
                }
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

            if (rey.hayJaque()){
                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);

                System.out.println("Movimiento ilegal");
            }else{
                if (piezaComida != null){
                    System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    p.setPrimerMovimiento2OEnroque(true);
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }else{
                    System.out.println("Pieza movida.");
                    p.setPrimerMovimiento2OEnroque(true);
                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
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

        boolean ARRIBA = false;
        boolean DERECHA = false;
        boolean ABAJO = false;
        boolean IZQUIERDA = false;

        for (int z = 1; z <= p.getI(); z++) {
            Pieza casilla = Main.tablero[p.getI() - z][p.getJ()];

            if (casilla != null) {
                if (casilla.getColor() == p.getColor()) {
                    break;
                }
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI() - z;
            int jProvisional = p.getJ();

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (!rey.hayJaque()) {
                ARRIBA = true;
            }

            Main.tablero[iOriginal][jOriginal] = p;
            Main.tablero[iProvisional][jProvisional] = piezaComida;

            p.setI(iOriginal);
            p.setJ(jOriginal);

            if (casilla != null) {
                break;
            }
        }

        for (int z = 1; z <= 7 - p.getJ(); z++) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() + z];

            if (casilla != null) {
                if (casilla.getColor() == p.getColor()) {
                    break;
                }

            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI();
            int jProvisional = p.getJ() + z;

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (!rey.hayJaque()) {
                DERECHA = true;
            }

            Main.tablero[iOriginal][jOriginal] = p;
            Main.tablero[iProvisional][jProvisional] = piezaComida;

            p.setI(iOriginal);
            p.setJ(jOriginal);

            if (casilla != null) {
                break;
            }
        }

        for (int z = 1; z <= 7 - p.getI(); z++) {
            Pieza casilla = Main.tablero[p.getI() + z][p.getJ()];

            if (casilla != null) {
                if (casilla.getColor() == p.getColor()) {
                    break;
                }
            }

            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI() + z;
            int jProvisional = p.getJ();

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (!rey.hayJaque()) {
                ABAJO = true;
            }

            Main.tablero[iOriginal][jOriginal] = p;
            Main.tablero[iProvisional][jProvisional] = piezaComida;

            p.setI(iOriginal);
            p.setJ(jOriginal);

            if (casilla != null) {
                break;
            }
        }

        for (int z = 1; z <= p.getJ(); z++) {
            Pieza casilla = Main.tablero[p.getI()][p.getJ() - z];

            if (casilla != null) {
                if (casilla.getColor() == p.getColor()) {
                    break;
                }
            }
            int iOriginal = p.getI();
            int jOriginal = p.getJ();

            int iProvisional = p.getI();
            int jProvisional = p.getJ() - z;

            Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

            Main.tablero[iOriginal][jOriginal] = null;
            Main.tablero[iProvisional][jProvisional] = p;

            p.setI(iProvisional);
            p.setJ(jProvisional);

            if (!rey.hayJaque()) {
                IZQUIERDA = true;
            }

            Main.tablero[iOriginal][jOriginal] = p;
            Main.tablero[iProvisional][jProvisional] = piezaComida;

            p.setI(iOriginal);
            p.setJ(jOriginal);

            if (casilla != null) {
                break;
            }
        }


        if (!ARRIBA && !DERECHA && !ABAJO && !IZQUIERDA) {
            return false;
            }
        return true;
    }
}
