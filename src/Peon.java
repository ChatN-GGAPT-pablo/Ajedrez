import java.util.Scanner;

public class Peon extends Pieza{

    public Peon(String nombrePieza, String color, int numeroPieza, int i, int j) {
        super(nombrePieza, color, numeroPieza, i, j);
    }

String colorString = this.getColor();




    @Override
    public String toString() {
        return "P" + this.getColor() + this.getNumeroPieza() ;
    }

    @Override
    public void posiblesMovimiento(Pieza p) {
        if (Main.getTurno().equals("B")){
            if (p.getI() == 6 ){
                System.out.println("Qué prefieres, que se mueva 1 o 2 posiciones");
                Scanner sc = new Scanner(System.in);
                int decision = sc.nextInt();
                    if (decision == 1){
                        int iResultante = p.getI() - 1;
                        int jResultante = p.getJ();
                }else{
                        int iResultante = p.getI() - 2;
                        int jResultante = p.getJ();
                    }
            }
            else{
                if (((Main.tablero[p.getI() - 1][p.getJ() + 1])!= null) || ((Main.tablero[p.getI() - 1][p.getJ() - 1]) != null)){

                    System.out.println();
                }
                System.out.println();
            }
        }else{
            int iResultante = p.getI();
            int jResultante = p.getJ() + 1;

        }

    }

}

