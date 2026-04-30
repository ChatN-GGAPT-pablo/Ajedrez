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

        if (!hayJaque()) {

            boolean ARRIBA = false;
            boolean ARRIBADERECHA = false;
            boolean DERECHA = false;
            boolean ABAJODERECHA = false;
            boolean ABAJO = false;
            boolean ABAJOIZQUIERDA = false;
            boolean IZQUIERDA = false;
            boolean ARRIBAIZQUIERDA = false;

            if (p.getI() > 0) {
                ARRIBA = true;
            }

            if (p.getI() > 0 && p.getJ() < 7) {
                ARRIBADERECHA = true;
            }

            if (p.getJ() < 7) {
                DERECHA = true;
            }

            if (p.getI() < 7 && p.getJ() < 7) {
                ABAJODERECHA = true;
            }

            if (p.getI() < 7) {
                ABAJO = true;
            }

            if (p.getI() < 7 && p.getJ() > 0) {
                ABAJOIZQUIERDA = true;
            }

            if (p.getJ() > 0) {
                IZQUIERDA = true;
            }

            if (p.getI() > 0 && p.getJ() > 0) {
                ARRIBAIZQUIERDA = true;
            }

            Scanner sc = new Scanner(System.in);

            int decision;

            while (true) {
                System.out.println("Hacia donde quieres moverte:");

                if (ARRIBA) {
                    System.out.println("1. Arriba");
                }

                if (ARRIBADERECHA) {
                    System.out.println("2. Arriba derecha");
                }

                if (DERECHA) {
                    System.out.println("3. Derecha");
                }

                if (ABAJODERECHA) {
                    System.out.println("4. Abajo derecha");
                }

                if (ABAJO) {
                    System.out.println("5. Abajo");
                }

                if (ABAJOIZQUIERDA) {
                    System.out.println("6. Abajo izquierda");
                }

                if (IZQUIERDA) {
                    System.out.println("7. Izquierda");
                }

                if (ARRIBAIZQUIERDA) {
                    System.out.println("8. Arriba izquierda");
                }

                decision = sc.nextInt();

                if (decision == 1 && ARRIBA) {
                    break;
                } else if (decision == 2 && ARRIBADERECHA) {
                    break;
                } else if (decision == 3 && DERECHA) {
                    break;
                } else if (decision == 4 && ABAJODERECHA) {
                    break;
                } else if (decision == 5 && ABAJO) {
                    break;
                } else if (decision == 6 && ABAJOIZQUIERDA) {
                    break;
                } else if (decision == 7 && IZQUIERDA) {
                    break;
                } else if (decision == 8 && ARRIBAIZQUIERDA) {
                    break;
                } else {
                    System.out.println("Opción no válida, repite.");
                }
            }

            if (decision == 1 && ARRIBA) {
                System.out.println("Cuantas hacia arriba?");
                int capeada = p.getI();

                int maximo = 0;

                for (int z = 1; z <= capeada; z++) {
                    if (Main.tablero[p.getI() - z][p.getJ()] != null) {

                        if (!(Main.tablero[p.getI() - z][p.getJ()].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }

                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }

                int movARRIBA = sc.nextInt();

                while (movARRIBA < 1 || movARRIBA > maximo) {
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movARRIBA = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - movARRIBA;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida.");
                    }
                }
            }

            if (decision == 2 && ARRIBADERECHA) {
                System.out.println("Cuantas casillas quieres moverte");

                int capeadoVertical = p.getI();
                int capeadoHorizontal = 7 - p.getJ();

                int maximo = 0;

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI() - z][p.getJ() + z] != null) {
                            if (!(Main.tablero[p.getI() - z][p.getJ() + z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else if (capeadoVertical < capeadoHorizontal) {
                    for (int z = 1; z <= capeadoVertical; z++) {
                        if (Main.tablero[p.getI() - z][p.getJ() + z] != null) {
                            if (!(Main.tablero[p.getI() - z][p.getJ() + z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI() - z][p.getJ() + z] != null) {
                            if (!(Main.tablero[p.getI() - z][p.getJ() + z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                }

                int movDiagonal = sc.nextInt();

                while (movDiagonal < 1 || movDiagonal > maximo) {
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDiagonal = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - movDiagonal;
                int jProvisional = p.getJ() + movDiagonal;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida.");
                    }
                }
            }

            if (decision == 3 && DERECHA) {
                System.out.println("Cuantas hacia la derecha?");
                int capeada = 7 - p.getJ();

                int maximo = 0;

                for (int z = 1; z <= capeada; z++) {
                    if (Main.tablero[p.getI()][p.getJ() + z] != null) {

                        if (!(Main.tablero[p.getI()][p.getJ() + z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }

                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }

                int movDERECHA = sc.nextInt();

                while (movDERECHA < 1 || movDERECHA > maximo) {
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDERECHA = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ() + movDERECHA;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida.");
                    }
                }
            }

            if (decision == 4 && ABAJODERECHA) {
                System.out.println("Cuantas casillas quieres moverte");

                int capeadoVertical = 7 - p.getI();
                int capeadoHorizontal = 7 - p.getJ();

                int maximo = 0;

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI() + z][p.getJ() + z] != null) {
                            if (!(Main.tablero[p.getI() + z][p.getJ() + z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else if (capeadoVertical < capeadoHorizontal) {
                    for (int z = 1; z <= capeadoVertical; z++) {
                        if (Main.tablero[p.getI() + z][p.getJ() + z] != null) {
                            if (!(Main.tablero[p.getI() + z][p.getJ() + z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI() + z][p.getJ() + z] != null) {
                            if (!(Main.tablero[p.getI() + z][p.getJ() + z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                }

                int movDiagonal = sc.nextInt();

                while (movDiagonal < 1 || movDiagonal > maximo) {
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDiagonal = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + movDiagonal;
                int jProvisional = p.getJ() + movDiagonal;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida.");
                    }
                }
            }

            if (decision == 5 && ABAJO) {
                System.out.println("Cuantas hacia abajo?");
                int capeada = 7 - p.getI();

                int maximo = 0;

                for (int z = 1; z <= capeada; z++) {
                    if (Main.tablero[p.getI() + z][p.getJ()] != null) {

                        if (!(Main.tablero[p.getI() + z][p.getJ()].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }

                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }

                int movABAJO = sc.nextInt();

                while (movABAJO < 1 || movABAJO > maximo) {
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movABAJO = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + movABAJO;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida.");
                    }
                }
            }

            if (decision == 6 && ABAJOIZQUIERDA) {
                System.out.println("Cuantas casillas quieres moverte");

                int capeadoVertical = 7 - p.getI();
                int capeadoHorizontal = p.getJ();

                int maximo = 0;

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI() + z][p.getJ() - z] != null) {
                            if (!(Main.tablero[p.getI() + z][p.getJ() - z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else if (capeadoVertical < capeadoHorizontal) {
                    for (int z = 1; z <= capeadoVertical; z++) {
                        if (Main.tablero[p.getI() + z][p.getJ() - z] != null) {
                            if (!(Main.tablero[p.getI() + z][p.getJ() - z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI() + z][p.getJ() - z] != null) {
                            if (!(Main.tablero[p.getI() + z][p.getJ() - z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                }

                int movDiagonal = sc.nextInt();

                while (movDiagonal < 1 || movDiagonal > maximo) {
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDiagonal = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + movDiagonal;
                int jProvisional = p.getJ() - movDiagonal;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida.");
                    }
                }
            }

            if (decision == 7 && IZQUIERDA) {
                System.out.println("Cuantas hacia la izquierda?");
                int capeada = p.getJ();

                int maximo = 0;

                for (int z = 1; z <= capeada; z++) {
                    if (Main.tablero[p.getI()][p.getJ() - z] != null) {

                        if (!(Main.tablero[p.getI()][p.getJ() - z].getColor().equals(p.getColor()))) {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }

                        break;
                    } else {
                        System.out.println(z + "casillas");
                        maximo = z;
                    }
                }

                int movIZQUIERDA = sc.nextInt();

                while (movIZQUIERDA < 1 || movIZQUIERDA > maximo) {
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movIZQUIERDA = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ() - movIZQUIERDA;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida.");
                    }
                }
            }

            if (decision == 8 && ARRIBAIZQUIERDA) {
                System.out.println("Cuantas casillas quieres moverte");

                int capeadoVertical = p.getI();
                int capeadoHorizontal = p.getJ();

                int maximo = 0;

                if (capeadoVertical > capeadoHorizontal) {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI() - z][p.getJ() - z] != null) {
                            if (!(Main.tablero[p.getI() - z][p.getJ() - z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else if (capeadoVertical < capeadoHorizontal) {
                    for (int z = 1; z <= capeadoVertical; z++) {
                        if (Main.tablero[p.getI() - z][p.getJ() - z] != null) {
                            if (!(Main.tablero[p.getI() - z][p.getJ() - z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                } else {
                    for (int z = 1; z <= capeadoHorizontal; z++) {
                        if (Main.tablero[p.getI() - z][p.getJ() - z] != null) {
                            if (!(Main.tablero[p.getI() - z][p.getJ() - z].getColor().equals(p.getColor()))) {
                                System.out.println(z + "casillas");
                                maximo = z;
                            }
                            break;
                        } else {
                            System.out.println(z + "casillas");
                            maximo = z;
                        }
                    }
                }

                int movDiagonal = sc.nextInt();

                while (movDiagonal < 1 || movDiagonal > maximo) {
                    System.out.println("Te sales del rango de movs permitidos, repite.");
                    movDiagonal = sc.nextInt();
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - movDiagonal;
                int jProvisional = p.getJ() - movDiagonal;

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getNombrePieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida.");
                    }
                }
            }
        }
    }}

