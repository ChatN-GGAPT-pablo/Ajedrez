import java.util.Arrays;

public class Main{
    public static void main(String[] args){


        Pieza[][] tablero = new Pieza[8][8];
        final int tamanio = tablero.length;

        //peones blancos
        for (int i = 0; i < tamanio; i++){
            tablero[6][i] = new Peon("Peón","B", i+1);
        }
        //peones negros
        for (int i = 0; i < tamanio; i++){
            tablero[1][i] = new Peon("Peón","N", i+1);
        }

        //Torres blancas
        tablero[7][0]= new Torre("Torre", "B", 1);
        tablero[7][7]= new Torre("Torre", "B", 2);
        //Torres negras
        tablero[0][0]= new Torre("Torre", "N", 1);
        tablero[0][7]= new Torre("Torre", "N", 2);

        //Caballos blancos
        tablero[7][1]= new Caballo("Caballo", "B", 1);
        tablero[7][6]= new Caballo("Caballo", "B", 2);

        //Caballos negros
        tablero[0][1]= new Caballo("Caballo", "N", 1);
        tablero[0][6]= new Caballo("Caballo", "N", 2);

        //Alfiles blancos
        tablero[7][2]= new Alfil("Alfil", "B", 1);
        tablero[7][5]= new Alfil("Alfil", "B", 2);

        //Alfiles negros
        tablero[0][2]= new Alfil("Alfil", "N", 1);
        tablero[0][5]= new Alfil("Alfil", "N", 2);

        //Dama blanca
        tablero[7][3]= new Dama("Dama", "B");

        //Dama blanca
        tablero[0][3]= new Dama("Dama", "N");

        //Rey blanco
        tablero[7][4]= new Rey("Rey", "B");

        //Rey blanco
        tablero[0][4]= new Rey("Rey", "N");





        System.out.println("________________________________________________________________________________________________");
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("|   " + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    " +  tablero[0][0] + "    |"  );
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("________________________________________________________________________________________________");
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("|   " + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    " +  tablero[0][0] + "    |"  );
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("________________________________________________________________________________________________");
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("|   " + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    " +  tablero[0][0] + "    |"  );
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("________________________________________________________________________________________________");
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("|   " + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    " +  tablero[0][0] + "    |"  );
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("________________________________________________________________________________________________");
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("|   " + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    " +  tablero[0][0] + "    |"  );
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("________________________________________________________________________________________________");
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("|   " + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    " +  tablero[0][0] + "    |"  );
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("________________________________________________________________________________________________");
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("|   " + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    " +  tablero[0][0] + "    |"  );
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("________________________________________________________________________________________________");
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("|   " + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    "   + tablero[0][0] + "    |    " +  tablero[0][0] + "    |"  );
        System.out.println("|   " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
        System.out.println("________________________________________________________________________________________________");


        System.out.println();
        System.out.println();
        System.out.println();
        for(int i = 0; i < tamanio; i++){
            System.out.println();
            for (int l = 0; l < 12*tamanio;l++){
                System.out.print("_");

            }
            System.out.println();
            System.out.println("|    " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );
            System.out.print("|    ");

            for (int j = 0; j < tamanio; j++){
                if (!(tablero[i][j] == null)){
                    if(tablero[i][j].getNombrePieza().equals("Dama") || tablero[i][j].getNombrePieza().equals("Rey")){
                        System.out.print(tablero[i][j]);
                        String lineas ="     |    ";
                        System.out.print(lineas);
                    }else{
                        System.out.print(tablero[i][j]);
                        String lineas ="    |    ";
                        System.out.print(lineas);
                    }



                }else{


                    System.out.print("nul");
                    String lineas ="    |    ";
                    System.out.print(lineas);

                }




            }
            System.out.println();
            System.out.print("|    " + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    "   + "   " + "    |    " +  "   " + "    |"  );

        }
        System.out.println();
        System.out.println("________________________________________________________________________________________________");



        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < tamanio; i++){

            System.out.println(Arrays.toString(tablero[i]));
        }

        //Hacer un tablero más bonito
        System.out.println(tablero[0][0]);

    }
}