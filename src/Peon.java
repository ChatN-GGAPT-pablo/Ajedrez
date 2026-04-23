import java.util.Scanner;

public class Peon extends Pieza{

    public Peon(String nombrePieza, String color, int numeroPieza) {
        super(nombrePieza, color, numeroPieza);
    }

String colorString = this.getColor();




    @Override
    public String toString() {
        return "P" + this.getColor() + this.getNumeroPieza() ;
    }

    @Override
    public void posiblesMovimiento(int iActual, int jActual) {
        /**if (Main.getTurno().equals("B")){
            if (primerMovimientoPeon == true ){
                System.out.println("Qué prefieres, que se mueva 1 o 2 posiciones");
                Scanner sc = new Scanner(System.in);
                int decision = sc.nextInt();
                    if (decision == 1){
                        int iResultante = iActual;
                        int jResultante = jActual + 1;
                }else{
                        int iResultante = iActual;
                        int jResultante = jActual + 2;
                    }
            }
        }else{
            int iResultante = iActual;
            int jResultante = jActual + 1;

        }
         **/
    }

}

