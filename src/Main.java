import java.util.*;

public class Main{
    static Color turno = Color.BLANCO;

    public static Color getTurno(){
        return turno;
    }

    public void setTurno(Color turno) {
        Main.turno = turno;
    }


    public static int iActual = 0;
    public static int jActual = 0;

    static Pieza[][] tablero = new Pieza[8][8];
    static final int tamanio = tablero.length;






    //Listas piezas blancas para mostrar
    static ArrayList<Pieza> peonesBDisponibles = new ArrayList<>();
    static ArrayList<Pieza> alfilesBDisponibles = new ArrayList<>();
    static ArrayList<Pieza> caballosBDisponibles = new ArrayList<>();
    static ArrayList<Pieza> torresBDisponibles = new ArrayList<>();
    static ArrayList<Pieza> damasBDisponibles = new ArrayList<>();
    static ArrayList<Pieza> reyBDisponible = new ArrayList<>();


    //Listas piezas negras para mostrar
    static ArrayList<Pieza> peonesNDisponibles = new ArrayList<>();
    static ArrayList<Pieza> alfilesNDisponibles = new ArrayList<>();
    static ArrayList<Pieza> caballosNDisponibles = new ArrayList<>();
    static ArrayList<Pieza> torresNDisponibles = new ArrayList<>();
    static ArrayList<Pieza> damasNDisponibles = new ArrayList<>();
    static ArrayList<Pieza> reyNDisponible = new ArrayList<>();
    /**
     * Comparador de piezas para ordenar en las listas que se muestran
     */
    public static class ComparadorNumeroPieza implements Comparator<Pieza> {

        public int compare(Pieza p1, Pieza p2){
            return (p1.getNumeroPieza() - p2.getNumeroPieza());
        }

    }

    public static void a(Pieza p){
        System.out.println(p.getI()+p.getJ());
    }
    public static void mostrarTablero(){
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < tamanio; i++) {
            System.out.println();
            for (int l = 0; l < 12 * tamanio; l++) {
                System.out.print("_");
            }
            System.out.println();
            System.out.println("|    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |");
            System.out.print("|    ");
            for (int j = 0; j < tamanio; j++) {
                if (!(tablero[i][j] == null)) {
                    System.out.print(tablero[i][j]);

                    if (tablero[i][j].toString().length() == 2) {
                        String lineas = "     |    ";
                        System.out.print(lineas);
                    } else if (tablero[i][j].toString().length() == 3) {
                        String lineas = "    |    ";
                        System.out.print(lineas);
                    } else if (tablero[i][j].toString().length() == 4) {
                        String lineas = "   |    ";
                        System.out.print(lineas);
                    }
                } else {
                    System.out.print("   ");
                    String lineas = "    |    ";
                    System.out.print(lineas);
                }
            }
            System.out.println();
            System.out.print("|    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |    " + "   " + "    |");
        }
        System.out.println();
        System.out.println("________________________________________________________________________________________________");

        }
    public static Pieza mostrarPiezas(){
        Scanner sc = new Scanner(System.in);

        //Listas piezas blancas para mostrar
        peonesBDisponibles.clear();
        alfilesBDisponibles.clear();
        caballosBDisponibles.clear();
        torresBDisponibles.clear();
        damasBDisponibles.clear();
        reyBDisponible.clear();




        boolean peonB = false;
        boolean alfilB = false;
        boolean caballoB = false;
        boolean torreB = false;
        boolean damaB = false;
        boolean reyB = false;


        //Listas piezas negras para mostrar
        peonesNDisponibles.clear();
        alfilesNDisponibles.clear();
        caballosNDisponibles.clear();
        torresNDisponibles.clear();
        damasNDisponibles.clear();
        reyNDisponible.clear();

        boolean peonN = false;
        boolean alfilN = false;
        boolean caballoN = false;
        boolean torreN = false;
        boolean damaN = false;
        boolean reyN = false;

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (!(tablero[i][j] == null)) {
                    Pieza p = tablero[i][j];
                    if (tablero[i][j].getTipoPieza() == TipoPieza.PEON && tablero[i][j].getColor() == Color.BLANCO){
                        if(p.comprobarMovimientos(p)){
                            peonesBDisponibles.add(tablero[i][j]);
                        }
                    } else if (tablero[i][j].getTipoPieza() == TipoPieza.ALFIL && tablero[i][j].getColor() == Color.BLANCO){
                         if(p.comprobarMovimientos(p)) {
                             alfilesBDisponibles.add(tablero[i][j]);
                         }
                    } else if (tablero[i][j].getTipoPieza() == TipoPieza.CABALLO && tablero[i][j].getColor() == Color.BLANCO){
                         if(p.comprobarMovimientos(p)) {
                             caballosBDisponibles.add(tablero[i][j]);
                         }
                    } else if (tablero[i][j].getTipoPieza() == TipoPieza.TORRE && tablero[i][j].getColor() == Color.BLANCO){
                         if(p.comprobarMovimientos(p)) {
                             torresBDisponibles.add(tablero[i][j]);
                         }
                    } else if (tablero[i][j].getTipoPieza() == TipoPieza.DAMA && tablero[i][j].getColor() == Color.BLANCO){
                         if(p.comprobarMovimientos(p)) {
                             damasBDisponibles.add(tablero[i][j]);
                         }
                    }else if (tablero[i][j].getTipoPieza() == TipoPieza.REY  && tablero[i][j].getColor() == Color.BLANCO){
                         if (p.comprobarMovimientos(p)) {
                             reyBDisponible.add(tablero[i][j]);
                        }
                    }

                }
            }
        }

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (!(tablero[i][j] == null)) {
                    Pieza p = tablero[i][j];
                    if (tablero[i][j].getTipoPieza() == TipoPieza.PEON && tablero[i][j].getColor() == Color.NEGRO) {
                        if (p.comprobarMovimientos(p)) {
                            peonesNDisponibles.add(tablero[i][j]);
                        }
                    } else if (tablero[i][j].getTipoPieza() == TipoPieza.ALFIL && tablero[i][j].getColor() == Color.NEGRO) {
                        if (p.comprobarMovimientos(p)) {
                            alfilesNDisponibles.add(tablero[i][j]);
                        }
                    } else if (tablero[i][j].getTipoPieza() == TipoPieza.CABALLO && tablero[i][j].getColor() == Color.NEGRO) {
                        if (p.comprobarMovimientos(p)) {
                            caballosNDisponibles.add(tablero[i][j]);
                        }
                    } else if (tablero[i][j].getTipoPieza() == TipoPieza.TORRE && tablero[i][j].getColor() == Color.NEGRO) {
                        if (p.comprobarMovimientos(p)) {
                            torresNDisponibles.add(tablero[i][j]);
                        }
                    } else if (tablero[i][j].getTipoPieza() == TipoPieza.DAMA && tablero[i][j].getColor() == Color.NEGRO) {
                        if (p.comprobarMovimientos(p)) {
                            damasNDisponibles.add(tablero[i][j]);
                        }
                    }else if (tablero[i][j].getTipoPieza() == TipoPieza.REY  && tablero[i][j].getColor() == Color.NEGRO) {
                        if (p.comprobarMovimientos(p)) {
                            reyNDisponible.add(tablero[i][j]);
                        }
                    }
                }
            }
        }
        if (getTurno() == Color.BLANCO){
            System.out.println("Qué grupo de piezas quieres seleccionar?");

            if (peonesBDisponibles.size() != 0){
                System.out.println("1. Peones blancos disponibles: ");
                peonesBDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(peonesBDisponibles);
                peonB = true;
            }

            if (torresBDisponibles.size() != 0){
                System.out.println("2. Torres blancas disponibles: ");
                torresBDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(torresBDisponibles);
                torreB = true;
            }

            if (caballosBDisponibles.size() != 0){
                System.out.println("3. Caballos blancos disponibles: ");
                caballosBDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(caballosBDisponibles);
                caballoB = true;
            }

            if (alfilesBDisponibles.size() != 0){
                System.out.println("4. Alfiles blancos disponibles: ");
                alfilesBDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(alfilesBDisponibles);
                alfilB = true;
            }

            if (damasBDisponibles.size() != 0){
                System.out.println("5. Dama blanca disponible: ");
                damasBDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(damasBDisponibles);
                damaB = true;
            }

            if (reyBDisponible.size() != 0){
                System.out.println("6. Rey blanco disponible: ");
                reyBDisponible.sort(new ComparadorNumeroPieza());
                System.out.println(reyBDisponible);
                reyB = true;
            }
            int decision = sc.nextInt();

            if (decision == 1 && peonB){

                ArrayList<Pieza> peones = new ArrayList<>();
                for (int i = 0; i < peonesBDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + peonesBDisponibles.get(i));
                    peones.add(peonesBDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + peones.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > peones.size()){
                    System.out.println("Opción inválida.");
                }
                System.out.println(peones.get(opcion-1));
                return (peones.get(opcion-1));
            }

            if (decision == 2 && torreB){

                ArrayList<Pieza> torres = new ArrayList<>();
                for (int i = 0; i < torresBDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + torresBDisponibles.get(i));
                    torres.add(torresBDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + torres.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > torres.size()){
                    System.out.println("Opción inválida.");
                }
                return (torres.get(opcion-1));
            }

            if (decision == 3 && caballoB){

                ArrayList<Pieza> caballos = new ArrayList<>();
                for (int i = 0; i < caballosBDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + caballosBDisponibles.get(i));
                    caballos.add(caballosBDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + caballos.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > caballos.size()){
                    System.out.println("Opción inválida.");
                }
                return (caballos.get(opcion-1));
            }

            if (decision == 4 && alfilB){

                ArrayList<Pieza> alfiles = new ArrayList<>();
                for (int i = 0; i < alfilesBDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + alfilesBDisponibles.get(i));
                    alfiles.add(alfilesBDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + alfiles.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > alfiles.size()){
                    System.out.println("Opción inválida.");
                }
                return (alfiles.get(opcion-1));
            }

            if (decision == 5 && damaB){

                ArrayList<Pieza> dama = new ArrayList<>();
                for (int i = 0; i < damasBDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + damasBDisponibles.get(i));
                    dama.add(damasBDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + dama.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > dama.size()){
                    System.out.println("Opción inválida.");
                }
                return (dama.get(opcion-1));
            }

            if (decision == 6 && reyB){

                ArrayList<Pieza> rey = new ArrayList<>();
                for (int i = 0; i < reyBDisponible.size(); i++ ){
                    System.out.println(i+1 + ". " + reyBDisponible.get(i));
                    rey.add(reyBDisponible.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + rey.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > rey.size()){
                    System.out.println("Opción inválida.");
                }
                return (rey.get(opcion-1));
            }

        }else{
            System.out.println("Qué grupo de piezas quieres seleccionar?");
            if (peonesNDisponibles.size() != 0){
                System.out.println("1. Peones negros disponibles: ");
                peonesNDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(peonesNDisponibles);
                peonN = true;
            }

            if (alfilesNDisponibles.size() != 0){
                System.out.println("2. Alfiles negros disponibles: ");
                alfilesNDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(alfilesNDisponibles);
                alfilN = true;
            }

            if (caballosNDisponibles.size() != 0){
                System.out.println("3. Caballos negros disponibles: ");
                caballosNDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(caballosNDisponibles);
                caballoN = true;
            }

            if (torresNDisponibles.size() != 0){
                System.out.println("4. Torres negras disponibles: ");
                torresNDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(torresNDisponibles);
                torreN = true;
            }

            if (damasNDisponibles.size() != 0){
                System.out.println("5. Dama negra disponible: ");
                damasNDisponibles.sort(new ComparadorNumeroPieza());
                System.out.println(damasNDisponibles);
                damaN = true;
            }

            if (reyNDisponible.size() != 0){
                System.out.println("6. Rey negro disponible: ");
                reyNDisponible.sort(new ComparadorNumeroPieza());
                System.out.println(reyNDisponible);
                reyN = true;
            }





            int decision = sc.nextInt();

            if (decision == 1 && peonN){

                ArrayList<Pieza> peones = new ArrayList<>();
                for (int i = 0; i < peonesNDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + peonesNDisponibles.get(i));
                    peones.add(peonesNDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + peones.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > peones.size()){
                    System.out.println("Opción inválida.");
                }
                return (peones.get(opcion-1));
            }

            if (decision == 2 && torreN){

                ArrayList<Pieza> torres = new ArrayList<>();
                for (int i = 0; i < torresNDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + torresNDisponibles.get(i));
                    torres.add(torresNDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + torres.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > torres.size()){
                    System.out.println("Opción inválida.");
                }
                return (torres.get(opcion-1));
            }

            if (decision == 3 && caballoN){

                ArrayList<Pieza> caballos = new ArrayList<>();
                for (int i = 0; i < caballosNDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + caballosNDisponibles.get(i));
                    caballos.add(caballosNDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + caballos.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > caballos.size()){
                    System.out.println("Opción inválida.");
                }
                return (caballos.get(opcion-1));
            }

            if (decision == 4 && alfilN){

                ArrayList<Pieza> alfiles = new ArrayList<>();
                for (int i = 0; i < alfilesNDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + alfilesNDisponibles.get(i));
                    alfiles.add(alfilesNDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + alfiles.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > alfiles.size()){
                    System.out.println("Opción inválida.");
                }
                return (alfiles.get(opcion-1));
            }

            if (decision == 5 && damaN){

                ArrayList<Pieza> dama = new ArrayList<>();
                for (int i = 0; i < damasNDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + damasNDisponibles.get(i));
                    dama.add(damasNDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + dama.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > dama.size()){
                    System.out.println("Opción inválida.");
                }
                return (dama.get(opcion-1));
            }

            if (decision == 6 && reyN){

                ArrayList<Pieza> rey = new ArrayList<>();
                for (int i = 0; i < reyNDisponible.size(); i++ ){
                    System.out.println(i+1 + ". " + reyNDisponible.get(i));
                    rey.add(reyNDisponible.get(i));
                }
                int opcion;
                System.out.println("Elige una opción entre 1 y " + rey.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > rey.size()){
                    System.out.println("Opción inválida.");
                }
                return (rey.get(opcion-1));
            }
        }
        return null;
    }

    public static String piezaSeleccionada(){

        System.out.println("Qué pieza quieres seleccionar?");
        Scanner sc = new Scanner(System.in);
        String piezaActual = sc.nextLine();

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {

                if (!(tablero[i][j] == null)){
                    if (tablero[i][j].toString().equals(piezaActual)){
                        System.out.println("Tu pieza está en la casilla: ");
                        System.out.println(i);
                        System.out.println(j);
                        iActual = i;
                        jActual = j;
                        break;
                    }
                }
            }
        }
        return piezaActual;
    }
    public static void cambiarTurno() {
        if (turno == Color.BLANCO) {
            turno = Color.NEGRO;
        } else {
            turno = Color.BLANCO;
        }
    }


    static Pieza piezaAMover = new Peon(Color.BLANCO,  1, 6, 0,false, false);

    public static Pieza getPiezaAMover() {
        return piezaAMover;
    }

    public static void setPiezaAMover(Pieza piezaAMover) {
        Main.piezaAMover = piezaAMover;
    }

    public static Pieza buscarRey(Color color){
        for (int i = 0; i < Main.tamanio; i++){
            for (int j = 0; j < Main.tamanio; j++){

                Pieza p = Main.tablero[i][j];

                if (p != null){
                    if (p.getTipoPieza() == TipoPieza.REY  && p.getColor() == color){
                        return p;
                    }
                }
            }
        }
        return null;
    }



    public static Pieza ultimaPieza(Pieza p){
        return p;
    }


    public static void main(String[] args) {
        //COnstructor piezas
        {
            //peones blancos

            Pieza PB1 = new Peon(Color.BLANCO,  1, 6, 0,false, false);
            Pieza PB2 = new Peon(Color.BLANCO,  2, 6, 1,false, false);
            Pieza PB3 = new Peon(Color.BLANCO,  3, 6, 2,false, false);
            Pieza PB4 = new Peon(Color.BLANCO,  4, 6, 3,false, false);
            Pieza PB5 = new Peon(Color.BLANCO,  5, 6, 4,false, false);
            Pieza PB6 = new Peon(Color.BLANCO,  6, 6, 5,false, false);
            Pieza PB7 = new Peon(Color.BLANCO,  7, 6, 6,false, false);
            Pieza PB8 = new Peon(Color.BLANCO,  8, 6, 7,false, false);

            tablero[6][0] = PB1;
            tablero[6][1] = PB2;
            tablero[6][2] = PB3;
            tablero[6][3] = PB4;
            tablero[6][4] = PB5;
            tablero[6][5] = PB6;
            tablero[6][6] = PB7;
            tablero[6][7] = PB8;


            //peones negros
            Pieza PN1 = new Peon(Color.NEGRO,  1, 1, 0,false, false);
            Pieza PN2 = new Peon(Color.NEGRO,  2, 1, 1,false, false);
            Pieza PN3 = new Peon(Color.NEGRO,  3, 1, 2,false, false);
            Pieza PN4 = new Peon(Color.NEGRO,  4, 1, 3,false, false);
            Pieza PN5 = new Peon(Color.NEGRO,  5, 1, 4,false, false);
            Pieza PN6 = new Peon(Color.NEGRO,  6, 1, 5,false, false);
            Pieza PN7 = new Peon(Color.NEGRO,  7, 1, 6,false, false);
            Pieza PN8 = new Peon(Color.NEGRO,  8, 1, 7,false, false);

            tablero[1][0] = PN1;
            tablero[1][1] = PN2;
            tablero[1][2] = PN3;
            tablero[1][3] = PN4;
            tablero[1][4] = PN5;
            tablero[1][5] = PN6;
            tablero[1][6] = PN7;
            tablero[1][7] = PN8;


            //Torres blancas

            Pieza TB1 = new Torre(Color.BLANCO,1, 7,0, true);
            Pieza TB2 = new Torre(Color.BLANCO,2,7,7,true);
            tablero[7][0] = TB1;
            tablero[7][7] = TB2;
            //Torres negras

            Pieza TN1 = new Torre(Color.NEGRO, 1,0,0, true);
            Pieza TN2 = new Torre(Color.NEGRO, 2,0,7, true);
            tablero[0][0] = TN1;
            tablero[0][7] = TN2;

            //Caballos blancos
            Pieza CB1 = new Caballo(Color.BLANCO, 1,7,1, false);
            Pieza CB2 = new Caballo(Color.BLANCO, 2,7,6, false);
            tablero[7][1] = CB1;
            tablero[7][6] = CB2;

            //Caballos negros
            Pieza CN1 = new Caballo(Color.NEGRO, 1,0,1, false);
            Pieza CN2 = new Caballo(Color.NEGRO, 2,0,6, false);
            tablero[0][1] = CN1;
            tablero[0][6] = CN2;

            //Alfiles blancos
            Pieza AB1 = new Alfil(Color.BLANCO, 1,7,2, true);
            Pieza AB2 = new Alfil(Color.BLANCO, 2,7,5, true);
            tablero[7][2] = AB1;
            tablero[7][5] = AB2;

            //Alfiles negros
            Pieza AN1 = new Alfil(Color.NEGRO, 1,0,2, true);
            Pieza AN2 = new Alfil(Color.NEGRO, 2,0,5, true);
            tablero[0][2] = AN1;
            tablero[0][5] =AN2;

            //Dama blanca
            Pieza DB = new Dama(Color.BLANCO,1,7,3, true);
            tablero[7][3] = DB;

            //Dama blanca
            Pieza DN = new Dama(Color.NEGRO,1,0,3, true);
            tablero[0][3] = DN;

            //Rey blanco
            Pieza RB = new Rey(Color.BLANCO,7,4, true);
            tablero[7][4] = RB;

            //Rey blanco
            Pieza RN = new Rey(Color.NEGRO,0,4, true);
            tablero[0][4] = RN;
        }


        //Hacer un tablero más bonito
        System.out.println(tablero[0][0]);



        while (true){
            mostrarTablero();

            Main.piezaAMover = mostrarPiezas();
            piezaAMover.posiblesMovimientos(piezaAMover);
        }










        //AÑADIR QUE QUIZAS UNA VARIABLE EN CADA PIEZA Y A LA HORA DE MOSTRAR LAS PIEZAS,
        //LAS PIEZAS QUE SEAN INCAPACES DE MOVERSE, QUE NO SE ENSEÑEN


    }
}





