public class Rey extends Pieza{
    public Rey(String nombrePieza, String color, int i, int j) {
        super(nombrePieza, color, i, j);
    }



    @Override
    public String toString() {
        return "R" + this.getColor();
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

        System.out.println("A donde quieres moverte");

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
    }
    }
}
