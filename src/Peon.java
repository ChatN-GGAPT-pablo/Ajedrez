import java.util.Scanner;

public class Peon extends Pieza{

    Scanner sc = new Scanner(System.in);
    public Peon(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }

    @Override
    public String toString() {
        return "P" + this.getColor() + this.getNumeroPieza() ;
    }


    @Override
    public void posiblesMovimientos(Pieza p) {
        Pieza rey = Main.buscarRey(p.getColor());
        //BLANCOS
        if (Main.getTurno().equals("B")) {
            boolean moverprimera1 = false;
            boolean moverprimera2 = false;

            boolean mover = false;

            boolean arribaDerecha = false;
            boolean arribaIzquierda = false;

            if (p.getI() - 1 >= 0 && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() + 1];
                if (casilla != null){
                    if (!(casilla.getColor().equals(p.getColor()))){
                        arribaDerecha = true;
                    }
                }
            }

            if (p.getI() - 1 >= 0 && p.getJ() -1 >= 0 ){
                Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() - 1];
                if (casilla != null){
                    if (!(casilla.getColor().equals(p.getColor()))){
                        arribaIzquierda= true;
                    }
                }
            }





            if (p.getI() == 6 && ((Main.tablero[p.getI() - 1][p.getJ()] == null))) {
                moverprimera1 = true;
            }
            if (p.getI() == 6 && ((Main.tablero[p.getI() - 2][p.getJ()] == null)) && moverprimera1) {
                moverprimera2 = true;
            }

            if (((p.getI() - 1) >= 0) && (Main.tablero[p.getI() - 1][p.getJ()] == null)){
                mover =true;
            }



            if (p.getI() == 6){

                if (!moverprimera1 && !moverprimera2 && !arribaDerecha && !arribaIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    Main.setPiezaAMover(Main.mostrarPiezas());
                    Main.piezaAMover.posiblesMovimientos(Main.piezaAMover);
                    return;
                }


                int decision;
                while(true){
                    System.out.println("Qué quieres hacer?");

                    if (moverprimera1) {
                        System.out.println("1. Mover 1");
                    }
                    if (moverprimera2 ) {
                        System.out.println("2. Mover 2");
                    }
                    if (arribaDerecha){
                        System.out.println("3. Comer derecha");
                    }
                    if (arribaIzquierda){
                        System.out.println("4. comer izquierda");
                    }

                    decision = sc.nextInt();

                    if (decision == 1 && moverprimera1) {
                        break;
                    } else if (decision == 2 && moverprimera2) {
                        break;
                    } else if (decision == 3 && arribaDerecha) {
                        break;
                    } else if (decision == 4 && arribaIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }


                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && moverprimera1){
                    iProvisional = (p.getI() - 1);
                } else if (decision == 2 && moverprimera2) {
                    iProvisional = (p.getI() -2);
                } else if (decision == 3 && arribaDerecha) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 4 && arribaIzquierda) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() - 1);
                }
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
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                        Main.cambiarTurno();
                    }else{
                        System.out.println("Pieza movida.");
                        Main.cambiarTurno();
                    }
                }


                //Peón Promoción
            }else if (p.getI() == 1){
                if (!mover && !arribaDerecha && !arribaIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    Main.setPiezaAMover(Main.mostrarPiezas());
                    Main.piezaAMover.posiblesMovimientos(Main.piezaAMover);
                    return;
                }

                int decision;
                while(true){
                    System.out.println("Qué quieres hacer?");
                    if (mover){
                        System.out.println("1. Mover");
                    }
                    if (arribaDerecha){
                        System.out.println("2. Comer derecha");
                    }
                    if (arribaIzquierda){
                        System.out.println("3. comer izquierda");
                    }
                    decision = sc.nextInt();

                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && arribaDerecha) {
                        break;
                    } else if (decision == 3 && arribaIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && mover){
                    iProvisional = (p.getI() - 1);
                } else if (decision == 2 && arribaDerecha) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 3 && arribaIzquierda) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() - 1);
                }
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
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                        System.out.println("Promoción de peón");
                        System.out.println("A qué quieres promocionar?");

                        System.out.println("1. Dama");
                        System.out.println("2. Torre");
                        System.out.println("3. Caballo");
                        System.out.println("4. Alfil");
                        int promocion = sc.nextInt();

                        if (promocion == 1){
                            Main.tablero[getI()][getJ()] = new Dama("Dama", getColor(),Main.damasBDisponibles.size()+1, getI(), getJ());
                        }else if (promocion == 2){
                            Main.tablero[getI()][getJ()] = new Torre("Torre", getColor(),Main.torresBDisponibles.size()+1, getI(), getJ());
                        }else if (promocion == 3){
                            Main.tablero[getI()][getJ()] = new Caballo("Caballo", getColor(),Main.caballosBDisponibles.size()+1, getI(), getJ());
                        }else if (promocion == 4){
                            Main.tablero[getI()][getJ()] = new Alfil("Alfil", getColor(),Main.alfilesBDisponibles.size()+1, getI(), getJ());
                        }

                        Main.cambiarTurno();
                    }else{
                        System.out.println("Pieza movida.");
                        Main.cambiarTurno();
                    }
                }

            }else{

                if (!mover && !arribaDerecha && !arribaIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    Main.setPiezaAMover(Main.mostrarPiezas());
                    Main.piezaAMover.posiblesMovimientos(Main.piezaAMover);
                    return;
                }

                int decision;
                while(true){
                    System.out.println("Qué quieres hacer?");
                    if (mover){
                        System.out.println("1. Mover");
                    }
                    if (arribaDerecha){
                        System.out.println("2. Comer derecha");
                    }
                    if (arribaIzquierda){
                        System.out.println("3. comer izquierda");
                    }
                    decision = sc.nextInt();

                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && arribaDerecha) {
                        break;
                    } else if (decision == 3 && arribaIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && mover){
                    iProvisional = (p.getI() - 1);
                } else if (decision == 2 && arribaDerecha) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 3 && arribaIzquierda) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() - 1);
                }
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
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                        Main.cambiarTurno();
                    }else{
                        System.out.println("Pieza movida.");
                        Main.cambiarTurno();
                    }
                }
            }



















        //NEGROS
        }else{
            boolean moverprimera1 = false;
            boolean moverprimera2 = false;

            boolean mover = false;

            boolean abajoDerecha = false;
            boolean abajoIzquierda = false;


            if (p.getI() +1 < 8 && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() + 1];
                if (casilla != null){
                    if (!(casilla.getColor().equals(p.getColor()))){
                        abajoDerecha = true;
                    }
                }
            }

            if (p.getI() + 1 < 8 && p.getJ() -1 >= 0 ){
                Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() - 1];
                if (casilla != null){
                    if (!(casilla.getColor().equals(p.getColor()))){
                        abajoIzquierda= true;
                    }
                }
            }

            if (p.getI() == 1 && ((Main.tablero[p.getI() + 1][p.getJ()] == null))) {
                moverprimera1 = true;
            }
            if (p.getI() == 1 && ((Main.tablero[p.getI() + 2][p.getJ()] == null)) && moverprimera1) {
                moverprimera2 = true;
            }

            if (((p.getI() + 1) < 8) && (Main.tablero[p.getI() + 1][p.getJ()] == null )) {
                mover =true;
            }


            if (p.getI() == 1){

                if (!moverprimera1 && !moverprimera2 && !abajoDerecha && !abajoIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    Main.setPiezaAMover(Main.mostrarPiezas());
                    Main.piezaAMover.posiblesMovimientos(Main.piezaAMover);
                    return;
                }

                int decision;

                while(true){
                    System.out.println("Qué quieres hacer?");

                    if (moverprimera1) {
                        System.out.println("1. Mover 1");
                    }
                    if (moverprimera2) {
                        System.out.println("2. Mover 2");
                    }
                    if (abajoDerecha){
                        System.out.println("3. Comer derecha");
                    }
                    if (abajoIzquierda){
                        System.out.println("4. comer izquierda");
                    }

                    decision = sc.nextInt();

                    if (decision == 1 && moverprimera1) {
                        break;
                    } else if (decision == 2 && moverprimera2) {
                        break;
                    } else if (decision == 3 && abajoDerecha) {
                        break;
                    } else if (decision == 4 && abajoIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }


                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && moverprimera1){
                    iProvisional = (p.getI() + 1);
                } else if (decision == 2 && moverprimera2) {
                    iProvisional = (p.getI() +2);
                } else if (decision == 3 && abajoDerecha) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 4 && abajoIzquierda) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() - 1);
                }
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
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                        Main.cambiarTurno();
                    }else{
                        System.out.println("Pieza movida.");
                        Main.cambiarTurno();
                    }
                }

            }else{


                if (!mover && !abajoDerecha && !abajoIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    Main.setPiezaAMover(Main.mostrarPiezas());
                    Main.piezaAMover.posiblesMovimientos(Main.piezaAMover);
                    return;
                }

                int decision;

                while (true){
                    System.out.println("Qué quieres hacer?");
                    if (mover){
                        System.out.println("1. Mover");
                    }
                    if (abajoDerecha){
                        System.out.println("2. Comer derecha");
                    }
                    if (abajoIzquierda){
                        System.out.println("3. comer izquierda");
                    }
                    decision = sc.nextInt();

                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && abajoDerecha) {
                        break;
                    } else if (decision == 3 && abajoIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && mover){
                    iProvisional = (p.getI() + 1);
                } else if (decision == 2 && abajoDerecha) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 3 && abajoIzquierda) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() - 1);
                }

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
                    System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    Main.cambiarTurno();
                }else{
                    System.out.println("Pieza movida.");
                    Main.cambiarTurno();
                }
            }

            }
        }
    }
}






