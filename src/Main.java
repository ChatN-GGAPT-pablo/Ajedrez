import java.util.*;

public class Main{
    static String turno = "B";

    public static String getTurno(){
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }


    public static int iActual = 0;
    public static int jActual = 0;

    static Pieza[][] tablero = new Pieza[8][8];
    static final int tamanio = tablero.length;

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
                    if (tablero[i][j].getNombrePieza().equals("Dama") || tablero[i][j].getNombrePieza().equals("Rey")) {
                        System.out.print(tablero[i][j]);
                        String lineas = "     |    ";
                        System.out.print(lineas);
                    } else {
                        System.out.print(tablero[i][j]);
                        String lineas = "    |    ";
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
        ArrayList<Pieza> peonesBDisponibles = new ArrayList<>();
        ArrayList<Pieza> alfilesBDisponibles = new ArrayList<>();
        ArrayList<Pieza> caballosBDisponibles = new ArrayList<>();
        ArrayList<Pieza> torresBDisponibles = new ArrayList<>();
        ArrayList<Pieza> damaBDisponible = new ArrayList<>();
        ArrayList<Pieza> reyBDisponible = new ArrayList<>();


        boolean peonB = false;
        boolean alfilB = false;
        boolean caballoB = false;
        boolean torreB = false;
        boolean damaB = false;
        boolean reyB = false;



        //Listas piezas negras para mostrar
        ArrayList<Pieza> peonesNDisponibles = new ArrayList<>();
        ArrayList<Pieza> alfilesNDisponibles = new ArrayList<>();
        ArrayList<Pieza> caballosNDisponibles = new ArrayList<>();
        ArrayList<Pieza> torresNDisponibles = new ArrayList<>();
        ArrayList<Pieza> damaNDisponible = new ArrayList<>();
        ArrayList<Pieza> reyNDisponible = new ArrayList<>();


        boolean peonN = false;
        boolean alfilN = false;
        boolean caballoN = false;
        boolean torreN = false;
        boolean damaN = false;
        boolean reyN = false;

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (!(tablero[i][j] == null)) {

                    if (tablero[i][j].getNombrePieza().equals("Peón") && tablero[i][j].getColor().equals("B")){
                        peonesBDisponibles.add(tablero[i][j]);
                    } else if (tablero[i][j].getNombrePieza().equals("Alfil") && tablero[i][j].getColor().equals("B")){
                        alfilesBDisponibles.add(tablero[i][j]);
                    } else if (tablero[i][j].getNombrePieza().equals("Caballo") && tablero[i][j].getColor().equals("B")){
                        caballosBDisponibles.add(tablero[i][j]);
                    } else if (tablero[i][j].getNombrePieza().equals("Torre") && tablero[i][j].getColor().equals("B")){
                        torresBDisponibles.add(tablero[i][j]);
                    } else if (tablero[i][j].getNombrePieza().equals("Dama") && tablero[i][j].getColor().equals("B")){
                        damaBDisponible.add(tablero[i][j]);
                    }else if (tablero[i][j].getNombrePieza().equals("Rey") && tablero[i][j].getColor().equals("B")){
                        reyBDisponible.add(tablero[i][j]);
                    }

                }
            }
        }

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (!(tablero[i][j] == null)) {
                    if (tablero[i][j].getNombrePieza().equals("Peón") && tablero[i][j].getColor().equals("N")) {
                        peonesNDisponibles.add(tablero[i][j]);
                    } else if (tablero[i][j].getNombrePieza().equals("Alfil") && tablero[i][j].getColor().equals("N")) {
                        alfilesNDisponibles.add(tablero[i][j]);
                    } else if (tablero[i][j].getNombrePieza().equals("Caballo") && tablero[i][j].getColor().equals("N")) {
                        caballosNDisponibles.add(tablero[i][j]);
                    } else if (tablero[i][j].getNombrePieza().equals("Torre") && tablero[i][j].getColor().equals("N")) {
                        torresNDisponibles.add(tablero[i][j]);
                    } else if (tablero[i][j].getNombrePieza().equals("Dama") && tablero[i][j].getColor().equals("N")) {
                        damaNDisponible.add(tablero[i][j]);
                    }else if (tablero[i][j].getNombrePieza().equals("Rey") && tablero[i][j].getColor().equals("N")) {
                        reyNDisponible.add(tablero[i][j]);
                    }
                }
            }
        }
        if (getTurno().equals("B")){
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

            if (damaBDisponible.size() != 0){
                System.out.println("5. Dama blanca disponible: ");
                damaBDisponible.sort(new ComparadorNumeroPieza());
                System.out.println(damaBDisponible);
                damaB = true;
            }

            if (reyBDisponible.size() != 0){
                System.out.println("6. Rey blanca disponible: ");
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
                System.out.println("Elige una opcion entre 1 y " + peones.size());
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
                System.out.println("Elige una opcion entre 1 y " + torres.size());
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
                System.out.println("Elige una opcion entre 1 y " + caballos.size());
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
                System.out.println("Elige una opcion entre 1 y " + alfiles.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > alfiles.size()){
                    System.out.println("Opción inválida.");
                }
                return (alfiles.get(opcion-1));
            }

            if (decision == 5 && damaB){

                ArrayList<Pieza> dama = new ArrayList<>();
                for (int i = 0; i < damaBDisponible.size(); i++ ){
                    System.out.println(i+1 + ". " + damaBDisponible.get(i));
                    dama.add(damaBDisponible.get(i));
                }
                int opcion;
                System.out.println("Elige una opcion entre 1 y " + dama.size());
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
                System.out.println("Elige una opcion entre 1 y " + rey.size());
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

            if (damaNDisponible.size() != 0){
                System.out.println("5. Dama negra disponible: ");
                damaNDisponible.sort(new ComparadorNumeroPieza());
                System.out.println(damaNDisponible);
                damaN = true;
            }

            if (reyNDisponible.size() != 0){
                System.out.println("6. Rey negra disponible: ");
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
                System.out.println("Elige una opcion entre 1 y " + peones.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > peones.size()){
                    System.out.println("Opción inválida.");
                }
                return (peones.get(opcion-1));
            }

            if (decision == 2 && torreN){

                ArrayList<Pieza> alfiles = new ArrayList<>();
                for (int i = 0; i < alfilesNDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + alfilesNDisponibles.get(i));
                    alfiles.add(alfilesNDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opcion entre 1 y " + alfiles.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > alfiles.size()){
                    System.out.println("Opción inválida.");
                }
                return (alfiles.get(opcion-1));
            }

            if (decision == 3 && caballoN){

                ArrayList<Pieza> caballos = new ArrayList<>();
                for (int i = 0; i < caballosNDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + caballosNDisponibles.get(i));
                    caballos.add(caballosNDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opcion entre 1 y " + caballos.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > caballos.size()){
                    System.out.println("Opción inválida.");
                }
                return (caballos.get(opcion-1));
            }

            if (decision == 4 && alfilN){

                ArrayList<Pieza> torres = new ArrayList<>();
                for (int i = 0; i < torresNDisponibles.size(); i++ ){
                    System.out.println(i+1 + ". " + torresNDisponibles.get(i));
                    torres.add(torresNDisponibles.get(i));
                }
                int opcion;
                System.out.println("Elige una opcion entre 1 y " + torres.size());
                opcion = sc.nextInt();
                while(opcion < 1 || opcion > torres.size()){
                    System.out.println("Opción inválida.");
                }
                return (torres.get(opcion-1));
            }

            if (decision == 5 && damaN){

                ArrayList<Pieza> dama = new ArrayList<>();
                for (int i = 0; i < damaNDisponible.size(); i++ ){
                    System.out.println(i+1 + ". " + damaNDisponible.get(i));
                    dama.add(damaNDisponible.get(i));
                }
                int opcion;
                System.out.println("Elige una opcion entre 1 y " + dama.size());
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
                System.out.println("Elige una opcion entre 1 y " + rey.size());
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
        if (turno.equals("B")) {
            turno = "N";
        } else {
            turno = "B";
        }
    }


    static Pieza piezaAMover = new Peon("Peón", "B",  1, 6, 0);

    public static Pieza getPiezaAMover() {
        return piezaAMover;
    }

    public static void setPiezaAMover(Pieza piezaAMover) {
        Main.piezaAMover = piezaAMover;
    }

    public static Pieza buscarRey(String color){
        for (int i = 0; i < Main.tamanio; i++){
            for (int j = 0; j < Main.tamanio; j++){

                Pieza p = Main.tablero[i][j];

                if (p != null){
                    if (p.getNombrePieza().equals("Rey") && p.getColor().equals(color)){
                        return p;
                    }
                }
            }
        }
        return null;
    }



    public static void main(String[] args) {
        //COnstructor piezas
        {
            //peones blancos

            Pieza PB1 = new Peon("Peón", "B",  1, 6, 0);
            Pieza PB2 = new Peon("Peón", "B",  2, 6, 1);
            Pieza PB3 = new Peon("Peón", "B",  3, 6, 2);
            Pieza PB4 = new Peon("Peón", "B",  4, 6, 3);
            Pieza PB5 = new Peon("Peón", "B",  5, 6, 4);
            Pieza PB6 = new Peon("Peón", "B",  6, 6, 5);
            Pieza PB7 = new Peon("Peón", "B",  7, 6, 6);
            Pieza PB8 = new Peon("Peón", "B",  8, 6, 7);

            tablero[6][0] = PB1;
            tablero[6][1] = PB2;
            tablero[6][2] = PB3;
            tablero[6][3] = PB4;
            tablero[6][4] = PB5;
            tablero[6][5] = PB6;
            tablero[6][6] = PB7;
            tablero[6][7] = PB8;


            //peones negros
            Pieza PN1 = new Peon("Peón", "N",  1, 1, 0);
            Pieza PN2 = new Peon("Peón", "N",  2, 1, 1);
            Pieza PN3 = new Peon("Peón", "N",  3, 1, 2);
            Pieza PN4 = new Peon("Peón", "N",  4, 1, 3);
            Pieza PN5 = new Peon("Peón", "N",  5, 1, 4);
            Pieza PN6 = new Peon("Peón", "N",  6, 1, 5);
            Pieza PN7 = new Peon("Peón", "N",  7, 1, 6);
            Pieza PN8 = new Peon("Peón", "N",  8, 1, 7);

            tablero[1][0] = PN1;
            tablero[1][1] = PN2;
            tablero[1][2] = PN3;
            tablero[1][3] = PN4;
            tablero[1][4] = PN5;
            tablero[1][5] = PN6;
            tablero[1][6] = PN7;
            tablero[1][7] = PN8;


            //Torres blancas

            Pieza TB1 = new Torre("Torre", "B", 1, 7,0);
            Pieza TB2 = new Torre("Torre", "B", 2,7,7);
            tablero[7][0] = TB1;
            tablero[7][7] = TB2;
            //Torres negras

            Pieza TN1 = new Torre("Torre", "N", 1,0,0);
            Pieza TN2 = new Torre("Torre", "N", 2,0,7);
            tablero[0][0] = TN1;
            tablero[0][7] = TN2;

            //Caballos blancos
            Pieza CB1 = new Caballo("Caballo", "B", 1,7,1);
            Pieza CB2 = new Caballo("Caballo", "B", 2,7,6);
            tablero[7][1] = CB1;
            tablero[7][6] = CB2;

            //Caballos negros
            Pieza CN1 = new Caballo("Caballo", "N", 1,0,1);
            Pieza CN2 = new Caballo("Caballo", "N", 2,0,6);
            tablero[0][1] = CN1;
            tablero[0][6] = CN2;

            //Alfiles blancos
            Pieza AB1 = new Alfil("Alfil", "B", 1,7,2);
            Pieza AB2 = new Alfil("Alfil", "B", 2,7,5);
            tablero[7][2] = AB1;
            tablero[7][5] = AB2;

            //Alfiles negros
            Pieza AN1 = new Alfil("Alfil", "N", 1,0,2);
            Pieza AN2 = new Alfil("Alfil", "N", 2,0,5);
            tablero[0][2] = AN1;
            tablero[0][5] =AN2;

            //Dama blanca
            Pieza DB = new Dama("Dama", "B",7,3);
            tablero[7][3] = DB;

            //Dama blanca
            Pieza DN = new Dama("Dama", "N",0,3);
            tablero[0][3] = DN;

            //Rey blanco
            Pieza RB = new Rey("Rey", "B",7,4);
            tablero[7][4] = RB;

            //Rey blanco
            Pieza RN = new Rey("Rey", "N",0,4);
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





