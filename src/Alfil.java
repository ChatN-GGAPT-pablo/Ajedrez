import java.util.Scanner;

public class Alfil extends Pieza{
    public Alfil(String nombrePieza, String color, int numeroPieza) {
        super(nombrePieza, color, numeroPieza);
    }



    @Override
    public String toString() {
        return "A" + this.getColor() + this.getNumeroPieza();
    }

    @Override
    public void posiblesMovimiento(int iActual, int jActual) {
            if (!hayJaque()){


                boolean ARRIBADERECHA = false;
                boolean ABAJODERECHA = false;
                boolean ABAJOIZQUIERDA = false;
                boolean ARRIBAIZQUIERDA = false;

                if (iActual > 0 && jActual < 8){
                    ARRIBADERECHA = true;
                }

                if (iActual < 8 && jActual < 8){
                    ABAJODERECHA = true;
                }

                if (iActual < 8 && jActual > 0){
                    ABAJOIZQUIERDA = true;
                }

                if (iActual > 0 && jActual > 0){
                    ARRIBAIZQUIERDA = true;
                }




                System.out.println("Hacia dónde quieres mover?");

                if (ARRIBADERECHA){
                    System.out.println("1. Arriba derecha");

                }

                if (ABAJODERECHA){
                    System.out.println("2. Abajo derecha");
                }

                if (ABAJOIZQUIERDA){
                    System.out.println("3. Abajo izquierda");
                }

                if (ARRIBAIZQUIERDA){
                    System.out.println("4. Arriba izquierda");
                }

                Scanner sc = new Scanner(System.in);
                int decision = sc.nextInt();

                if (decision == 1 && ARRIBADERECHA){
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

                if (decision == 2 && ABAJODERECHA){
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

                if (decision == 3 && ABAJOIZQUIERDA){
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

                if (decision == 4 && ARRIBAIZQUIERDA){
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
