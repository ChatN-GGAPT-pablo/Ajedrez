import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
                    System.out.print("nul");
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
    public static void mostrarPiezas(){
            {
                //Listas piezas blancas para mostrar
                ArrayList<Pieza> peonesBDisponibles = new ArrayList<>();
                ArrayList<Pieza> alfilesBDisponibles = new ArrayList<>();
                ArrayList<Pieza> caballosBDisponibles = new ArrayList<>();
                ArrayList<Pieza> torresBDisponibles = new ArrayList<>();
                ArrayList<Pieza> damaBDisponible = new ArrayList<>();

                //Listas piezas negras para mostrar
                ArrayList<Pieza> peonesNDisponibles = new ArrayList<>();
                ArrayList<Pieza> alfilesNDisponibles = new ArrayList<>();
                ArrayList<Pieza> caballosNDisponibles = new ArrayList<>();
                ArrayList<Pieza> torresNDisponibles = new ArrayList<>();
                ArrayList<Pieza> damaNDisponible = new ArrayList<>();

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
                            }
                        }
                    }
                }
                if (getTurno().equals("B")){
                    System.out.println("Peones blancos disponibles: ");
                    System.out.println(peonesBDisponibles);
                    System.out.println("Alfiles blancos disponibles: ");
                    System.out.println(alfilesBDisponibles);
                    System.out.println("Caballos blancos disponibles: ");
                    System.out.println(caballosBDisponibles);
                    System.out.println("Torres blancas disponibles: ");
                    System.out.println(torresBDisponibles);
                    System.out.println("Dama blanca disponible: ");
                    System.out.println(damaBDisponible);
                }else{
                    System.out.println("Peones negros disponibles: ");
                    System.out.println(peonesNDisponibles);
                    System.out.println("Alfiles negros disponibles: ");
                    System.out.println(alfilesNDisponibles);
                    System.out.println("Caballos negros disponibles: ");
                    System.out.println(caballosNDisponibles);
                    System.out.println("Torres negras disponibles: ");
                    System.out.println(torresNDisponibles);
                    System.out.println("Dama negra disponible: ");
                    System.out.println(damaNDisponible);
                }


            }
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








    public static void main(String[] args) {
        //COnstructor piezas
        {
            //peones blancos
            for (int i = 0; i < tamanio; i++) {
                tablero[6][i] = new Peon("Peón", "B", i + 1, 6, i);
            }
            //peones negros
            for (int i = 0; i < tamanio; i++) {
                tablero[1][i] = new Peon("Peón", "N", i + 1,1, i);
            }

            //Torres blancas
            tablero[7][0] = new Torre("Torre", "B", 1, 7,0);
            tablero[7][7] = new Torre("Torre", "B", 2,7,7);
            //Torres negras
            tablero[0][0] = new Torre("Torre", "N", 1,0,0);
            tablero[0][7] = new Torre("Torre", "N", 2,0,7);

            //Caballos blancos
            tablero[7][1] = new Caballo("Caballo", "B", 1,7,1);
            tablero[7][6] = new Caballo("Caballo", "B", 2,7,6);

            //Caballos negros
            tablero[0][1] = new Caballo("Caballo", "N", 1,0,1);
            tablero[0][6] = new Caballo("Caballo", "N", 2,0,6);

            //Alfiles blancos
            tablero[7][2] = new Alfil("Alfil", "B", 1,7,2);
            tablero[7][5] = new Alfil("Alfil", "B", 2,7,5);

            //Alfiles negros
            tablero[0][2] = new Alfil("Alfil", "N", 1,0,2);
            tablero[0][5] = new Alfil("Alfil", "N", 2,0,5);

            //Dama blanca
            tablero[7][3] = new Dama("Dama", "B",7,3);

            //Dama blanca
            tablero[0][3] = new Dama("Dama", "N",0,3);

            //Rey blanco
            tablero[7][4] = new Rey("Rey", "B",7,4);

            //Rey blanco
            tablero[0][4] = new Rey("Rey", "N",0,4);
        }


        //Hacer un tablero más bonito
        System.out.println(tablero[0][0]);


        mostrarTablero();
        mostrarPiezas();





        piezaSeleccionada();

        //ahora seria, la pieza seleccionada ps mover y con el respectivo metodo de cada ficha


    }
}





