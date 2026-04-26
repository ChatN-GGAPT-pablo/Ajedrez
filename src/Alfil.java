import java.util.Scanner;

public class Alfil extends Pieza{
    public Alfil(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }



    @Override
    public String toString() {
        return "A" + this.getColor() + this.getNumeroPieza();
    }

    @Override
    public void posiblesMovimiento(Pieza p) {
            if (!hayJaque()){

                boolean ARRIBADERECHA = false;
                boolean ABAJODERECHA = false;
                boolean ABAJOIZQUIERDA = false;
                boolean ARRIBAIZQUIERDA = false;

                if (p.getI() > 0 && p.getJ() < 8){
                    ARRIBADERECHA = true;
                }

                if (p.getI() < 8 && p.getJ() < 8){
                    ABAJODERECHA = true;
                }

                if (p.getI() < 8 && p.getJ() > 0){
                    ABAJOIZQUIERDA = true;
                }

                if (p.getI() > 0 && p.getJ() > 0){
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
                    int capeadoVertical = p.getI();
                    int capeadoHorizontal = 8-p.getJ();

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
                    p.setI(p.getI() - movDiagonal);
                    p.setJ(p.getJ() + movDiagonal);
                }

                if (decision == 2 && ABAJODERECHA){
                    int capeadoVertical = p.getI();
                    int capeadoHorizontal = 8-p.getJ();

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
                    p.setI(p.getI() + movDiagonal);
                    p.setJ(p.getJ() + movDiagonal);
                }

                if (decision == 3 && ABAJOIZQUIERDA){
                    int capeadoVertical = p.getI();
                    int capeadoHorizontal = 8-p.getJ();

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
                    p.setI(p.getI() + movDiagonal);
                    p.setJ(p.getJ() - movDiagonal);
                }

                if (decision == 4 && ARRIBAIZQUIERDA){
                    int capeadoVertical = p.getI();
                    int capeadoHorizontal = 8-p.getJ();

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
                    p.setI(p.getI() - movDiagonal);
                    p.setJ(p.getJ() - movDiagonal);
                }

            }
    }
}
