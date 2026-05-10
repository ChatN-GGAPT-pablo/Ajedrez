/**
 * Interfaz movible, con métodos posiblesMovimientos y comprobarMovimientos para todas las piezas
 */
public interface Movible {
    /**
     * Estos son los posibles movimientos que cada pieza pudiera hacer
     * @param p
     */
    void posiblesMovimientos(Pieza p);

    /**
     * Este metodo comprueba qué movimientos puede hacer en cada turno
     * @param p
     * @return
     */
    boolean comprobarMovimientos(Pieza p);
}


