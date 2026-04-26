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

            if (iActual > 0){
                ARRIBA = true;
            }

            if (iActual > 0 && jActual < 8){
                ARRIBADERECHA = true;
            }

            if (jActual < 8){
                DERECHA = true;
            }

            if (iActual < 8 && jActual < 8){
                ABAJODERECHA = true;
            }

            if (iActual < 8){
                ABAJO = true;
            }

            if (iActual < 8 && jActual > 0){
                ABAJOIZQUIERDA = true;
            }

            if (jActual > 0){
                IZQUIERDA = true;
            }

            if (iActual > 0 && jActual > 0){
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
                int capeada = (iActual);
                for (int z = 1; z < capeada + 1; z++){
                    System.out.println(z + "casillas");
                }
                int movARRIBA = sc.nextInt();
                iActual -= movARRIBA;
            }

            if (decision == 2 && ARRIBADERECHA){
                int capeadoVertical = iActual;
                int capeadoHorizontal = 8-jActual;

                System.out.println("Cuantas casillas quieres moverte");
                if (capeadoVertical > capeadoHorizontal){
                    for (int z = 1; z < capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical < capeadoHorizontal){
                    for (int z = 1; z < capeadoVertical;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical == capeadoHorizontal){
                    for (int z = 1; z < capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }
                int movDiagonal = sc.nextInt();
                iActual -= movDiagonal;
                jActual += movDiagonal;
            }

            if (decision == 3 && DERECHA){
                System.out.println("Cuantas hacia la derecha?" );
                int capeada = (8-jActual );
                for (int z = 1; z < capeada + 1; z++){
                    System.out.println(z + "casillas");
                }
                int movDERECHA = sc.nextInt();
                jActual += movDERECHA;
            }

            if (decision == 4 && ABAJODERECHA){
                int capeadoVertical = iActual;
                int capeadoHorizontal = 8-jActual;

                System.out.println("Cuantas casillas quieres moverte");
                if (capeadoVertical > capeadoHorizontal){
                    for (int z = 1; z < capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical < capeadoHorizontal){
                    for (int z = 1; z < capeadoVertical;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical == capeadoHorizontal){
                    for (int z = 1; z < capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }
                int movDiagonal = sc.nextInt();
                iActual += movDiagonal;
                jActual += movDiagonal;
            }

            if (decision == 5 && ABAJO){
                System.out.println("Cuantas hacia abajo?" );
                int capeada = (8-iActual);
                for (int z = 1; z < capeada + 1; z++){
                    System.out.println(z + "casillas");
                }
                int movABAJO = sc.nextInt();
                iActual += movABAJO;
            }

            if (decision == 6 && ABAJOIZQUIERDA){
                int capeadoVertical = iActual;
                int capeadoHorizontal = 8-jActual;

                System.out.println("Cuantas casillas quieres moverte");
                if (capeadoVertical > capeadoHorizontal){
                    for (int z = 1; z < capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical < capeadoHorizontal){
                    for (int z = 1; z < capeadoVertical;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical == capeadoHorizontal){
                    for (int z = 1; z < capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }
                int movDiagonal = sc.nextInt();
                iActual += movDiagonal;
                jActual -= movDiagonal;
            }

            if (decision == 7 && IZQUIERDA){
                System.out.println("Cuantas hacia la izquierda?" );
                int capeada = (8-jActual);
                for (int z = 1; z < capeada + 1; z++){
                    System.out.println(z + "casillas");
                }
                int movIZQUIERDA = sc.nextInt();
                jActual -= movIZQUIERDA;
            }

            if (decision == 8 && ARRIBAIZQUIERDA){
                int capeadoVertical = iActual;
                int capeadoHorizontal = 8-jActual;

                System.out.println("Cuantas casillas quieres moverte");
                if (capeadoVertical > capeadoHorizontal){
                    for (int z = 1; z < capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical < capeadoHorizontal){
                    for (int z = 1; z < capeadoVertical;z++){
                        System.out.println(z + "casillas");
                    }
                }else if (capeadoVertical == capeadoHorizontal){
                    for (int z = 1; z < capeadoHorizontal;z++){
                        System.out.println(z + "casillas");
                    }
                }
                int movDiagonal = sc.nextInt();
                iActual -= movDiagonal;
                jActual -= movDiagonal;
            }


        }
    }
}
