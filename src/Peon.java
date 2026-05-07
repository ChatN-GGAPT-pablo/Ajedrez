import java.util.Scanner;

public class Peon extends Pieza{

    Scanner sc = new Scanner(System.in);
    public Peon(Color color, int numeroPieza, int i, int j, boolean primerMovimiento2OEnroque, boolean inmovil) {
        super(TipoPieza.PEON, color, numeroPieza, i, j, primerMovimiento2OEnroque, inmovil);
    }

    @Override
    public String toString() {
        return "P" + this.getColor().getSimbolo() + this.getNumeroPieza() ;
    }


    @Override
    public void posiblesMovimientos(Pieza p) {
        Pieza rey = Main.buscarRey(p.getColor());
        //BLANCOS
        if (p.getColor() == Color.BLANCO) {
            boolean moverprimera1 = false;
            boolean moverprimera2 = false;

            boolean mover = false;

            boolean arribaDerecha = false;
            boolean arribaIzquierda = false;

            boolean enPassantBlancoDerecha = false;
            boolean enPassantBlancoIzquierda = false;

            if (p.getI() - 1 >= 0 && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() + 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {

                        int iOriginal = p.getI();
                        int jOriginal = p.getJ();

                        int iProvisional = p.getI() - 1;
                        int jProvisional = p.getJ() + 1;

                        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                        Main.tablero[iOriginal][jOriginal] = null;
                        Main.tablero[iProvisional][jProvisional] = p;

                        p.setI(iProvisional);
                        p.setJ(jProvisional);

                        if (!rey.hayJaque()) {
                            arribaDerecha = true;
                        }

                        Main.tablero[iOriginal][jOriginal] = p;
                        Main.tablero[iProvisional][jProvisional] = piezaComida;

                        p.setI(iOriginal);
                        p.setJ(jOriginal);
                    }
                }
            }

            if (p.getI() - 1 >= 0 && p.getJ() - 1 >= 0) {
                Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() - 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {

                        int iOriginal = p.getI();
                        int jOriginal = p.getJ();

                        int iProvisional = p.getI() - 1;
                        int jProvisional = p.getJ() - 1;

                        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                        Main.tablero[iOriginal][jOriginal] = null;
                        Main.tablero[iProvisional][jProvisional] = p;

                        p.setI(iProvisional);
                        p.setJ(jProvisional);

                        if (!rey.hayJaque()) {
                            arribaIzquierda = true;
                        }

                        Main.tablero[iOriginal][jOriginal] = p;
                        Main.tablero[iProvisional][jProvisional] = piezaComida;

                        p.setI(iOriginal);
                        p.setJ(jOriginal);
                    }
                }
            }


            //En peassant derecha
            if (p.getI() == 3 && p.getColor() == Color.BLANCO && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() + 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        if (casilla.getPrimerMovimiento2OEnroque() && Main.getUltimaPiezaMovida() == casilla && casilla.getTipoPieza() == TipoPieza.PEON) {
                            int iOriginal = p.getI();
                            int jOriginal = p.getJ();

                            int iProvisional = p.getI() - 1;
                            int jProvisional = p.getJ() + 1;

                            Pieza piezaComida = Main.tablero[iOriginal][jOriginal + 1];

                            Main.tablero[iOriginal][jOriginal] = null;
                            Main.tablero[iOriginal][jOriginal + 1] = null;
                            Main.tablero[iProvisional][jProvisional] = p;

                            p.setI(iProvisional);
                            p.setJ(jProvisional);

                            if (!rey.hayJaque()) {
                                enPassantBlancoDerecha = true;
                            }

                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iOriginal][jOriginal + 1] = piezaComida;
                            Main.tablero[iProvisional][jProvisional] = null;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);
                        }

                    }
                }
            }


            //En peassant izquierda
            if (p.getI() == 3 && p.getColor() == Color.BLANCO && p.getJ() - 1 >= 0) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() - 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        if (casilla.getPrimerMovimiento2OEnroque() && Main.getUltimaPiezaMovida() == casilla && casilla.getTipoPieza() == TipoPieza.PEON) {
                            int iOriginal = p.getI();
                            int jOriginal = p.getJ();

                            int iProvisional = p.getI() - 1;
                            int jProvisional = p.getJ() - 1;

                            Pieza piezaComida = Main.tablero[iOriginal][jOriginal - 1];

                            Main.tablero[iOriginal][jOriginal] = null;
                            Main.tablero[iOriginal][jOriginal - 1] = null;
                            Main.tablero[iProvisional][jProvisional] = p;

                            p.setI(iProvisional);
                            p.setJ(jProvisional);

                            if (!rey.hayJaque()) {
                                enPassantBlancoIzquierda = true;
                            }

                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iOriginal][jOriginal - 1] = piezaComida;
                            Main.tablero[iProvisional][jProvisional] = null;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);
                        }

                    }
                }
            }


            if (p.getI() == 6 && ((Main.tablero[p.getI() - 1][p.getJ()] == null))) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - 1;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    moverprimera1 = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }
            if (p.getI() == 6 && ((Main.tablero[p.getI() - 2][p.getJ()] == null)) && moverprimera1) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - 2;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    moverprimera2 = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }

            if (((p.getI() - 1) >= 0) && (Main.tablero[p.getI() - 1][p.getJ()] == null)) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - 1;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    mover = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }


            if (p.getI() == 6) {

                if (!moverprimera1 && !moverprimera2 && !arribaDerecha && !arribaIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    p.setInmovil(true);
                    return;
                }


                int decision;
                while (true) {
                    System.out.println("Qué quieres hacer?");
                    System.out.println("0. Volver");

                    if (moverprimera1) {
                        System.out.println("1. Mover 1");
                    }
                    if (moverprimera2) {
                        System.out.println("2. Mover 2");
                    }
                    if (arribaDerecha) {
                        System.out.println("3. Comer derecha");
                    }
                    if (arribaIzquierda) {
                        System.out.println("4. comer izquierda");
                    }

                    decision = Main.comprobarScanner(sc);

                    if (decision == 0){
                        System.out.println("Movimiento cancelado.");
                        return;
                    }
                    if (decision == 1 && moverprimera1) {
                        break;
                    } else if (decision == 2 && moverprimera2) {
                        break;
                    } else if (decision == 3 && arribaDerecha) {
                        break;
                    } else if (decision == 4 && arribaIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }


                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && moverprimera1) {
                    iProvisional = (p.getI() - 1);
                } else if (decision == 2 && moverprimera2) {
                    iProvisional = (p.getI() - 2);
                    p.setPrimerMovimiento2OEnroque(true);
                } else if (decision == 3 && arribaDerecha) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 4 && arribaIzquierda) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() - 1);
                }
                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (rey.hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                        Main.ultimaPieza(p);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    } else {
                        System.out.println("Pieza movida.");
                        Main.ultimaPieza(p);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    }
                }


                //En Passant
            } else if (p.getI() == 3) {
                if (!mover && !arribaDerecha && !arribaIzquierda && !enPassantBlancoIzquierda && !enPassantBlancoDerecha) {
                    System.out.println("No hay movimientos disponibles");
                    p.setInmovil(true);
                    return;
                }

                int decision;
                while (true) {
                    System.out.println("Qué quieres hacer?");
                    System.out.println("0. Cancelar");
                    if (mover) {
                        System.out.println("1. Mover");
                    }
                    if (arribaDerecha) {
                        System.out.println("2. Comer derecha");
                    }
                    if (arribaIzquierda) {
                        System.out.println("3. comer izquierda");
                    }
                    if (enPassantBlancoDerecha) {
                        System.out.println("4. En Passant Derecha");
                    }
                    if (enPassantBlancoIzquierda) {
                        System.out.println("5. En Passant Izquierda");
                    }
                    decision = Main.comprobarScanner(sc);

                    if (decision == 0){
                        System.out.println("Movimiento cancelado");
                        return;
                    }
                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && arribaDerecha) {
                        break;
                    } else if (decision == 3 && arribaIzquierda) {
                        break;
                    } else if (decision == 4 && enPassantBlancoDerecha) {
                        break;
                    } else if (decision == 5 && enPassantBlancoIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();


                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (decision == 1 && mover) {
                    iProvisional = (p.getI() - 1);
                    piezaComida = Main.tablero[iProvisional][jProvisional];
                } else if (decision == 2 && arribaDerecha) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() + 1);
                    piezaComida = Main.tablero[iProvisional][jProvisional];
                } else if (decision == 3 && arribaIzquierda) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() - 1);
                    piezaComida = Main.tablero[iProvisional][jProvisional];
                } else if (decision == 4 && enPassantBlancoDerecha) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() + 1);
                    piezaComida = Main.tablero[iOriginal][jOriginal + 1];
                } else if (decision == 5 && enPassantBlancoIzquierda) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() - 1);
                    piezaComida = Main.tablero[iOriginal][jOriginal - 1];
                }


                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                if (decision == 4 && enPassantBlancoDerecha) {
                    Main.tablero[iOriginal][jOriginal + 1] = null;
                } else if (decision == 5 && enPassantBlancoIzquierda) {
                    Main.tablero[iOriginal][jOriginal - 1] = null;
                }

                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (rey.hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    if (decision == 4 && enPassantBlancoDerecha) {
                        Main.tablero[iProvisional][jProvisional] = null;
                        Main.tablero[iOriginal][jOriginal + 1] = piezaComida;
                    } else if (decision == 5 && enPassantBlancoIzquierda) {
                        Main.tablero[iProvisional][jProvisional] = null;
                        Main.tablero[iOriginal][jOriginal - 1] = piezaComida;
                    } else {
                        Main.tablero[iProvisional][jProvisional] = piezaComida;
                    }

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida");
                    }

                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }


                //Peón Promoción
            } else if (p.getI() == 1) {
                if (!mover && !arribaDerecha && !arribaIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    p.setInmovil(true);
                    return;
                }

                int decision;
                while (true) {
                    System.out.println("Qué quieres hacer?");
                    System.out.println("0. Cancelar");
                    if (mover) {
                        System.out.println("1. Mover");
                    }
                    if (arribaDerecha) {
                        System.out.println("2. Comer derecha");
                    }
                    if (arribaIzquierda) {
                        System.out.println("3. comer izquierda");
                    }
                    decision = Main.comprobarScanner(sc);

                    if (decision == 0){
                        System.out.println("Movimiento cancelado");
                        return;
                    }
                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && arribaDerecha) {
                        break;
                    } else if (decision == 3 && arribaIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && mover) {
                    iProvisional = (p.getI() - 1);
                } else if (decision == 2 && arribaDerecha) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 3 && arribaIzquierda) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() - 1);
                }
                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (rey.hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                        System.out.println("Promoción de peón");
                        System.out.println("A qué quieres promocionar?");

                        System.out.println("0. Cancelar");
                        System.out.println("1. Dama");
                        System.out.println("2. Torre");
                        System.out.println("3. Caballo");
                        System.out.println("4. Alfil");
                        int promocion = Main.comprobarScanner(sc);


                        if (promocion == 0) {
                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iProvisional][jProvisional] = piezaComida;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);

                            System.out.println("Promoción cancelada, Movimiento cancelado");
                            return;
                        }

                        while (promocion < 1 ||promocion > 4 ){
                            System.out.println("Promoción inválida");
                            promocion = Main.comprobarScanner(sc);

                            if (promocion == 0) {
                                Main.tablero[iOriginal][jOriginal] = p;
                                Main.tablero[iProvisional][jProvisional] = piezaComida;

                                p.setI(iOriginal);
                                p.setJ(jOriginal);

                                System.out.println("Promoción cancelada, Movimiento cancelado");
                                return;
                            }
                        }
                        Pieza piezaPromocionada = null;

                        if (promocion == 1) {
                            piezaPromocionada = new Dama( p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), getInmovil());
                        } else if (promocion == 2) {
                            piezaPromocionada = new Torre(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), getInmovil());
                        } else if (promocion == 3) {
                            piezaPromocionada = new Caballo(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), getInmovil());
                        } else if (promocion == 4) {
                            piezaPromocionada = new Alfil(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), getInmovil());
                        }

                        Main.tablero[p.getI()][p.getJ()] = piezaPromocionada;
                        Main.ultimaPieza(piezaPromocionada);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    } else {
                        System.out.println("Pieza movida.");
                        System.out.println("Promoción de peón");
                        System.out.println("A qué quieres promocionar?");

                        System.out.println("0. Cancelar");
                        System.out.println("1. Dama");
                        System.out.println("2. Torre");
                        System.out.println("3. Caballo");
                        System.out.println("4. Alfil");
                        int promocion = Main.comprobarScanner(sc);

                        if (promocion == 0) {
                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iProvisional][jProvisional] = piezaComida;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);

                            System.out.println("Promoción cancelada, Movimiento cancelado");
                            return;
                        }

                        while (promocion < 1 ||promocion > 4 ){
                            System.out.println("Promoción inválida");
                            promocion = Main.comprobarScanner(sc);
                            if (promocion == 0) {
                                Main.tablero[iOriginal][jOriginal] = p;
                                Main.tablero[iProvisional][jProvisional] = piezaComida;

                                p.setI(iOriginal);
                                p.setJ(jOriginal);

                                System.out.println("Promoción cancelada, Movimiento cancelado");
                                return;
                            }
                        }
                        Pieza piezaPromocionada = null;

                        if (promocion == 1) {
                            piezaPromocionada = new Dama(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), getInmovil());
                        } else if (promocion == 2) {
                            piezaPromocionada = new Torre(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), getInmovil());
                        } else if (promocion == 3) {
                            piezaPromocionada = new Caballo(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), getInmovil());
                        } else if (promocion == 4) {
                            piezaPromocionada = new Alfil(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), getInmovil());
                        }

                        Main.tablero[p.getI()][p.getJ()] = piezaPromocionada;
                        Main.ultimaPieza(piezaPromocionada);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    }
                }

            } else {

                if (!mover && !arribaDerecha && !arribaIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    p.setInmovil(true);
                    return;
                }

                int decision;
                while (true) {
                    System.out.println("Qué quieres hacer?");
                    System.out.println("0. Cancelar");
                    if (mover) {
                        System.out.println("1. Mover");
                    }
                    if (arribaDerecha) {
                        System.out.println("2. Comer derecha");
                    }
                    if (arribaIzquierda) {
                        System.out.println("3. comer izquierda");
                    }
                    decision = Main.comprobarScanner(sc);

                    if (decision == 0){
                        System.out.println("Movimiento cancelado");
                        return;
                    }
                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && arribaDerecha) {
                        break;
                    } else if (decision == 3 && arribaIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && mover) {
                    iProvisional = (p.getI() - 1);
                } else if (decision == 2 && arribaDerecha) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 3 && arribaIzquierda) {
                    iProvisional = (p.getI() - 1);
                    jProvisional = (p.getJ() - 1);
                }
                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (rey.hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                        Main.ultimaPieza(p);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    } else {
                        System.out.println("Pieza movida.");
                        Main.ultimaPieza(p);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    }
                }
            }


            //NEGROS
            //NEGROS
        } else {
            boolean moverprimera1 = false;
            boolean moverprimera2 = false;

            boolean mover = false;

            boolean abajoDerecha = false;
            boolean abajoIzquierda = false;

            boolean enPassantNegroDerecha = false;
            boolean enPassantNegroIzquierda = false;


            if (p.getI() + 1 < 8 && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() + 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        int iOriginal = p.getI();
                        int jOriginal = p.getJ();

                        int iProvisional = p.getI() + 1;
                        int jProvisional = p.getJ() + 1;

                        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                        Main.tablero[iOriginal][jOriginal] = null;
                        Main.tablero[iProvisional][jProvisional] = p;

                        p.setI(iProvisional);
                        p.setJ(jProvisional);

                        if (!rey.hayJaque()) {
                            abajoDerecha = true;
                        }

                        Main.tablero[iOriginal][jOriginal] = p;
                        Main.tablero[iProvisional][jProvisional] = piezaComida;

                        p.setI(iOriginal);
                        p.setJ(jOriginal);
                    }
                }
            }

            if (p.getI() + 1 < 8 && p.getJ() - 1 >= 0) {
                Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() - 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        int iOriginal = p.getI();
                        int jOriginal = p.getJ();

                        int iProvisional = p.getI() + 1;
                        int jProvisional = p.getJ() - 1;

                        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                        Main.tablero[iOriginal][jOriginal] = null;
                        Main.tablero[iProvisional][jProvisional] = p;

                        p.setI(iProvisional);
                        p.setJ(jProvisional);

                        if (!rey.hayJaque()) {
                            abajoIzquierda = true;
                        }

                        Main.tablero[iOriginal][jOriginal] = p;
                        Main.tablero[iProvisional][jProvisional] = piezaComida;

                        p.setI(iOriginal);
                        p.setJ(jOriginal);
                    }
                }
            }


            //En peassant derecha negro
            if (p.getI() == 4 && p.getColor() == Color.NEGRO && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() + 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        if (casilla.getPrimerMovimiento2OEnroque()
                                && Main.getUltimaPiezaMovida() == casilla
                                && casilla.getTipoPieza() == TipoPieza.PEON) {
                            int iOriginal = p.getI();
                            int jOriginal = p.getJ();

                            int iProvisional = p.getI() + 1;
                            int jProvisional = p.getJ() + 1;

                            Pieza piezaComida = Main.tablero[iOriginal][jOriginal + 1];

                            Main.tablero[iOriginal][jOriginal] = null;
                            Main.tablero[iOriginal][jOriginal + 1] = null;
                            Main.tablero[iProvisional][jProvisional] = p;

                            p.setI(iProvisional);
                            p.setJ(jProvisional);

                            if (!rey.hayJaque()) {
                                enPassantNegroDerecha = true;
                            }

                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iOriginal][jOriginal + 1] = piezaComida;
                            Main.tablero[iProvisional][jProvisional] = null;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);
                        }

                    }
                }
            }


            //En peassant izquierda negro
            if (p.getI() == 4 && p.getColor() == Color.NEGRO && p.getJ() - 1 >= 0) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() - 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        if (casilla.getPrimerMovimiento2OEnroque()
                                && Main.getUltimaPiezaMovida() == casilla
                                && casilla.getTipoPieza() == TipoPieza.PEON) {
                            int iOriginal = p.getI();
                            int jOriginal = p.getJ();

                            int iProvisional = p.getI() + 1;
                            int jProvisional = p.getJ() - 1;

                            Pieza piezaComida = Main.tablero[iOriginal][jOriginal - 1];

                            Main.tablero[iOriginal][jOriginal] = null;
                            Main.tablero[iOriginal][jOriginal - 1] = null;
                            Main.tablero[iProvisional][jProvisional] = p;

                            p.setI(iProvisional);
                            p.setJ(jProvisional);

                            if (!rey.hayJaque()) {
                                enPassantNegroIzquierda = true;
                            }

                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iOriginal][jOriginal - 1] = piezaComida;
                            Main.tablero[iProvisional][jProvisional] = null;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);
                        }

                    }
                }
            }


            if (p.getI() == 1 && ((Main.tablero[p.getI() + 1][p.getJ()] == null))) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + 1;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    moverprimera1 = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }
            if (p.getI() == 1 && ((Main.tablero[p.getI() + 2][p.getJ()] == null)) && moverprimera1) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + 2;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    moverprimera2 = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }

            if (((p.getI() + 1) < 8) && (Main.tablero[p.getI() + 1][p.getJ()] == null)) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + 1;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    mover = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }


            if (p.getI() == 1) {

                if (!moverprimera1 && !moverprimera2 && !abajoDerecha && !abajoIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    p.setInmovil(true);

                    return;
                }

                int decision;

                while (true) {
                    System.out.println("Qué quieres hacer?");
                    System.out.println("0. Cancelar");

                    if (moverprimera1) {
                        System.out.println("1. Mover 1");
                    }
                    if (moverprimera2) {
                        System.out.println("2. Mover 2");
                    }
                    if (abajoDerecha) {
                        System.out.println("3. Comer derecha");
                    }
                    if (abajoIzquierda) {
                        System.out.println("4. comer izquierda");
                    }

                    decision = Main.comprobarScanner(sc);

                    if (decision == 0){
                        System.out.println("Movimiento cancelado");
                        return;
                    }

                    if (decision == 1 && moverprimera1) {
                        break;
                    } else if (decision == 2 && moverprimera2) {
                        break;
                    } else if (decision == 3 && abajoDerecha) {
                        break;
                    } else if (decision == 4 && abajoIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }


                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && moverprimera1) {
                    iProvisional = (p.getI() + 1);
                } else if (decision == 2 && moverprimera2) {
                    iProvisional = (p.getI() + 2);
                    p.setPrimerMovimiento2OEnroque(true);
                } else if (decision == 3 && abajoDerecha) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 4 && abajoIzquierda) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() - 1);
                }
                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (rey.hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                        Main.ultimaPieza(p);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    } else {
                        System.out.println("Pieza movida.");
                        Main.ultimaPieza(p);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    }
                }

            } else if (p.getI() == 4) {
                if (!mover && !abajoDerecha && !abajoIzquierda && !enPassantNegroIzquierda && !enPassantNegroDerecha) {
                    System.out.println("No hay movimientos disponibles");
                    p.setInmovil(true);
                    return;
                }

                int decision;
                while (true) {
                    System.out.println("Qué quieres hacer?");
                    System.out.println("0. Cancelar");
                    if (mover) {
                        System.out.println("1. Mover");
                    }
                    if (abajoDerecha) {
                        System.out.println("2. Comer derecha");
                    }
                    if (abajoIzquierda) {
                        System.out.println("3. comer izquierda");
                    }
                    if (enPassantNegroDerecha) {
                        System.out.println("4. En Passant Derecha");
                    }
                    if (enPassantNegroIzquierda) {
                        System.out.println("5. En Passant Izquierda");
                    }
                    decision = Main.comprobarScanner(sc);

                    if (decision == 0){
                        System.out.println("Movimiento cancelado");
                        return;
                    }

                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && abajoDerecha) {
                        break;
                    } else if (decision == 3 && abajoIzquierda) {
                        break;
                    } else if (decision == 4 && enPassantNegroDerecha) {
                        break;
                    } else if (decision == 5 && enPassantNegroIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();


                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (decision == 1 && mover) {
                    iProvisional = (p.getI() + 1);
                    piezaComida = Main.tablero[iProvisional][jProvisional];
                } else if (decision == 2 && abajoDerecha) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() + 1);
                    piezaComida = Main.tablero[iProvisional][jProvisional];
                } else if (decision == 3 && abajoIzquierda) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() - 1);
                    piezaComida = Main.tablero[iProvisional][jProvisional];
                } else if (decision == 4 && enPassantNegroDerecha) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() + 1);
                    piezaComida = Main.tablero[iOriginal][jOriginal + 1];
                } else if (decision == 5 && enPassantNegroIzquierda) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() - 1);
                    piezaComida = Main.tablero[iOriginal][jOriginal - 1];
                }


                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                if (decision == 4 && enPassantNegroDerecha) {
                    Main.tablero[iOriginal][jOriginal + 1] = null;
                } else if (decision == 5 && enPassantNegroIzquierda) {
                    Main.tablero[iOriginal][jOriginal - 1] = null;
                }

                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (rey.hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    if (decision == 4 && enPassantNegroDerecha) {
                        Main.tablero[iProvisional][jProvisional] = null;
                        Main.tablero[iOriginal][jOriginal + 1] = piezaComida;
                    } else if (decision == 5 && enPassantNegroIzquierda) {
                        Main.tablero[iProvisional][jProvisional] = null;
                        Main.tablero[iOriginal][jOriginal - 1] = piezaComida;
                    } else {
                        Main.tablero[iProvisional][jProvisional] = piezaComida;
                    }

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                    } else {
                        System.out.println("Pieza movida");
                    }

                    Main.ultimaPieza(p);
                    Main.cambiarTurno();
                    Main.hayJaqueMate(Main.getTurno());
                    Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                }


                //Peon promocion
            } else if (p.getI() == 6) {
                if (!mover && !abajoDerecha && !abajoIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    p.setInmovil(true);
                    return;
                }

                int decision;
                while (true) {
                    System.out.println("Qué quieres hacer?");
                    System.out.println("0. Cancelar");
                    if (mover) {
                        System.out.println("1. Mover");
                    }
                    if (abajoDerecha) {
                        System.out.println("2. Comer derecha");
                    }
                    if (abajoIzquierda) {
                        System.out.println("3. comer izquierda");
                    }
                    decision = Main.comprobarScanner(sc);

                    if (decision == 0){
                        System.out.println("Movimiento cancelado");
                        return;
                    }

                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && abajoDerecha) {
                        break;
                    } else if (decision == 3 && abajoIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && mover) {
                    iProvisional = (p.getI() + 1);
                } else if (decision == 2 && abajoDerecha) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 3 && abajoIzquierda) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() - 1);
                }
                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (rey.hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                        System.out.println("Promoción de peón");
                        System.out.println("A qué quieres promocionar?");

                        System.out.println("0. Cancelar");
                        System.out.println("1. Dama");
                        System.out.println("2. Torre");
                        System.out.println("3. Caballo");
                        System.out.println("4. Alfil");
                        int promocion = Main.comprobarScanner(sc);


                        if (promocion == 0) {
                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iProvisional][jProvisional] = piezaComida;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);

                            System.out.println("Promoción cancelada, Movimiento cancelado");
                            return;
                        }

                        while (promocion < 1 ||promocion > 4 ){
                            System.out.println("Promoción inválida");
                            promocion = Main.comprobarScanner(sc);
                            if (promocion == 0) {
                                Main.tablero[iOriginal][jOriginal] = p;
                                Main.tablero[iProvisional][jProvisional] = piezaComida;

                                p.setI(iOriginal);
                                p.setJ(jOriginal);

                                System.out.println("Promoción cancelada, Movimiento cancelado");
                                return;
                            }
                        }
                        Pieza piezaPromocionada = null;
                        if (promocion == 1) {
                            piezaPromocionada = new Dama(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), false);
                        } else if (promocion == 2) {
                            piezaPromocionada = new Torre(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(),false);
                        } else if (promocion == 3) {
                            piezaPromocionada = new Caballo(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), false);
                        } else if (promocion == 4) {
                            piezaPromocionada = new Alfil(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), false);
                        }

                        Main.tablero[p.getI()][p.getJ()] = piezaPromocionada;
                        Main.ultimaPieza(piezaPromocionada);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    } else {
                        System.out.println("Pieza movida.");
                        System.out.println("Promoción de peón");
                        System.out.println("A qué quieres promocionar?");

                        System.out.println("0. Cancelar");
                        System.out.println("1. Dama");
                        System.out.println("2. Torre");
                        System.out.println("3. Caballo");
                        System.out.println("4. Alfil");
                        int promocion = Main.comprobarScanner(sc);

                        if (promocion == 0) {
                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iProvisional][jProvisional] = piezaComida;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);

                            System.out.println("Promoción cancelada, Movimiento cancelado");
                            return;
                        }

                        while (promocion < 1 ||promocion > 4 ){
                            System.out.println("Promoción inválida");
                            promocion = Main.comprobarScanner(sc);
                            if (promocion == 0) {
                                Main.tablero[iOriginal][jOriginal] = p;
                                Main.tablero[iProvisional][jProvisional] = piezaComida;

                                p.setI(iOriginal);
                                p.setJ(jOriginal);

                                System.out.println("Promoción cancelada, Movimiento cancelado");
                                return;
                            }
                        }
                        Pieza piezaPromocionada = null;
                        if (promocion == 1) {
                            piezaPromocionada = new Dama(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), false);
                        } else if (promocion == 2) {
                            piezaPromocionada = new Torre(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), false);
                        } else if (promocion == 3) {
                            piezaPromocionada = new Caballo(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), false);
                        } else if (promocion == 4) {
                            piezaPromocionada = new Alfil(p.getColor(), p.getNumeroPieza() + 10, p.getI(), p.getJ(), false);
                        }

                        Main.tablero[p.getI()][p.getJ()] = piezaPromocionada;
                        Main.ultimaPieza(piezaPromocionada);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    }
                }

            } else {


                if (!mover && !abajoDerecha && !abajoIzquierda) {
                    System.out.println("No hay movimientos disponibles");
                    p.setInmovil(true);
                    return;
                }

                int decision;

                while (true) {
                    System.out.println("Qué quieres hacer?");
                    System.out.println("0. Cancelar");
                    if (mover) {
                        System.out.println("1. Mover");
                    }
                    if (abajoDerecha) {
                        System.out.println("2. Comer derecha");
                    }
                    if (abajoIzquierda) {
                        System.out.println("3. comer izquierda");
                    }
                    decision = Main.comprobarScanner(sc);

                    if (decision == 0){
                        System.out.println("Movimiento cancelado");
                        return;
                    }

                    if (decision == 1 && mover) {
                        break;
                    } else if (decision == 2 && abajoDerecha) {
                        break;
                    } else if (decision == 3 && abajoIzquierda) {
                        break;
                    } else {
                        System.out.println("Repite decisión");
                    }
                }

                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI();
                int jProvisional = p.getJ();

                if (decision == 1 && mover) {
                    iProvisional = (p.getI() + 1);
                } else if (decision == 2 && abajoDerecha) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() + 1);
                } else if (decision == 3 && abajoIzquierda) {
                    iProvisional = (p.getI() + 1);
                    jProvisional = (p.getJ() - 1);
                }

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                if (piezaComida != null && piezaComida.getColor().equals(p.getColor())) {
                    System.out.println("No te puedes comer una pieza de tu color");
                    return;
                }

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (rey.hayJaque()) {
                    Main.tablero[iOriginal][jOriginal] = p;
                    Main.tablero[iProvisional][jProvisional] = piezaComida;

                    p.setI(iOriginal);
                    p.setJ(jOriginal);

                    System.out.println("Movimiento ilegal");
                } else {
                    if (piezaComida != null) {
                        System.out.println("Pieza: " + piezaComida.getTipoPieza() + " comida.");
                        Main.ultimaPieza(p);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    } else {
                        System.out.println("Pieza movida.");
                        Main.ultimaPieza(p);
                        Main.cambiarTurno();
                        Main.hayJaqueMate(Main.getTurno());
                        Pieza reyTurno = Main.buscarRey(Main.getTurno());
                if (reyTurno.hayJaque()) {
                    System.out.println("Jaque");
                }
                    }
                }

            }
        }
    }

    /**
     * Comprobar movimientos de los peones para sus posibles movimientos, y si,
     * al supuesto movimiento, su rey queda en Jaque, no se puede
     * @param p
     * @return
     */
    @Override
    public boolean comprobarMovimientos(Pieza p) {
        Pieza rey = Main.buscarRey(p.getColor());
        if (p.getColor() == Color.BLANCO) {
            boolean moverprimera1 = false;
            boolean moverprimera2 = false;

            boolean mover = false;

            boolean arribaDerecha = false;
            boolean arribaIzquierda = false;

            boolean enPassantBlancoDerecha = false;
            boolean enPassantBlancoIzquierda = false;

            //ARRIBADERECHA BLANCO
            if (p.getI() - 1 >= 0 && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() + 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        int iOriginal = p.getI();
                        int jOriginal = p.getJ();

                        int iProvisional = p.getI() - 1;
                        int jProvisional = p.getJ() + 1;

                        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                        Main.tablero[iOriginal][jOriginal] = null;
                        Main.tablero[iProvisional][jProvisional] = p;

                        p.setI(iProvisional);
                        p.setJ(jProvisional);

                        if (!rey.hayJaque()) {
                            arribaDerecha = true;
                        }

                        Main.tablero[iOriginal][jOriginal] = p;
                        Main.tablero[iProvisional][jProvisional] = piezaComida;

                        p.setI(iOriginal);
                        p.setJ(jOriginal);
                    }
                }
            }

            //ARRIBAIZQUIERDA BLANCO
            if (p.getI() - 1 >= 0 && p.getJ() - 1 >= 0) {
                Pieza casilla = Main.tablero[p.getI() - 1][p.getJ() - 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        int iOriginal = p.getI();
                        int jOriginal = p.getJ();

                        int iProvisional = p.getI() - 1;
                        int jProvisional = p.getJ() - 1;

                        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                        Main.tablero[iOriginal][jOriginal] = null;
                        Main.tablero[iProvisional][jProvisional] = p;

                        p.setI(iProvisional);
                        p.setJ(jProvisional);

                        if (!rey.hayJaque()) {
                            arribaIzquierda = true;
                        }

                        Main.tablero[iOriginal][jOriginal] = p;
                        Main.tablero[iProvisional][jProvisional] = piezaComida;

                        p.setI(iOriginal);
                        p.setJ(jOriginal);
                    }
                }
            }


            //En peassant derecha BLANCO
            if (p.getI() == 3 && p.getColor() == Color.BLANCO && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() + 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        if (casilla.getPrimerMovimiento2OEnroque() && Main.getUltimaPiezaMovida() == casilla && casilla.getTipoPieza() == TipoPieza.PEON) {
                            int iOriginal = p.getI();
                            int jOriginal = p.getJ();

                            int iProvisional = p.getI() - 1;
                            int jProvisional = p.getJ() + 1;

                            Pieza piezaComida = Main.tablero[iOriginal][jOriginal + 1];

                            Main.tablero[iOriginal][jOriginal] = null;
                            Main.tablero[iOriginal][jOriginal + 1] = null;
                            Main.tablero[iProvisional][jProvisional] = p;

                            p.setI(iProvisional);
                            p.setJ(jProvisional);

                            if (!rey.hayJaque()) {
                                enPassantBlancoDerecha = true;
                            }

                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iOriginal][jOriginal + 1] = piezaComida;
                            Main.tablero[iProvisional][jProvisional] = null;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);
                        }

                    }
                }
            }

            //En peassant izquierda BLANCO
            if (p.getI() == 3 && p.getColor() == Color.BLANCO && p.getJ() - 1 >= 0) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() - 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        if (casilla.getPrimerMovimiento2OEnroque()
                                && Main.getUltimaPiezaMovida() == casilla
                                && casilla.getTipoPieza() == TipoPieza.PEON) {
                            int iOriginal = p.getI();
                            int jOriginal = p.getJ();

                            int iProvisional = p.getI() - 1;
                            int jProvisional = p.getJ() - 1;

                            Pieza piezaComida = Main.tablero[iOriginal][jOriginal - 1];

                            Main.tablero[iOriginal][jOriginal] = null;
                            Main.tablero[iOriginal][jOriginal - 1] = null;
                            Main.tablero[iProvisional][jProvisional] = p;

                            p.setI(iProvisional);
                            p.setJ(jProvisional);

                            if (!rey.hayJaque()) {
                                enPassantBlancoIzquierda = true;
                            }

                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iOriginal][jOriginal - 1] = piezaComida;
                            Main.tablero[iProvisional][jProvisional] = null;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);
                        }

                    }
                }
            }


            //MOVERPRIMERA1 BLANCO
            if (p.getI() == 6 && ((Main.tablero[p.getI() - 1][p.getJ()] == null))) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - 1;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    moverprimera1 = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }

            //MOVERPRIMERA2 BLANCO
            if (p.getI() == 6 && ((Main.tablero[p.getI() - 2][p.getJ()] == null)) && moverprimera1) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - 2;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    moverprimera2 = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }

            //MOVER BLANCO
            if (((p.getI() - 1) >= 0) && (Main.tablero[p.getI() - 1][p.getJ()] == null)) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() - 1;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    mover = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }


            //COMPROBACIONES DE CADA POSIBLE MOVIMIENTO BLANCO
            if (p.getI() == 6) {

                if (!moverprimera1 && !moverprimera2 && !arribaDerecha && !arribaIzquierda) {
                    return false;
                }
            }else if (p.getI() == 3) {
                if (!mover && !arribaDerecha && !arribaIzquierda && !enPassantBlancoIzquierda && !enPassantBlancoDerecha) {
                    return false;
                }
            }else {

                if (!mover && !arribaDerecha && !arribaIzquierda) {
                    return false;
                }
            }

        }else{
            //Negros

            boolean moverprimera1 = false;
            boolean moverprimera2 = false;

            boolean mover = false;

            boolean abajoDerecha = false;
            boolean abajoIzquierda = false;

            boolean enPassantNegroDerecha = false;
            boolean enPassantNegroIzquierda = false;


            //ABAJODERECHA NEGRO
            if (p.getI() + 1 < 8 && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() + 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        int iOriginal = p.getI();
                        int jOriginal = p.getJ();

                        int iProvisional = p.getI() + 1;
                        int jProvisional = p.getJ() + 1;

                        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                        Main.tablero[iOriginal][jOriginal] = null;
                        Main.tablero[iProvisional][jProvisional] = p;

                        p.setI(iProvisional);
                        p.setJ(jProvisional);

                        if (!rey.hayJaque()) {
                            abajoDerecha = true;
                        }

                        Main.tablero[iOriginal][jOriginal] = p;
                        Main.tablero[iProvisional][jProvisional] = piezaComida;

                        p.setI(iOriginal);
                        p.setJ(jOriginal);
                    }
                }
            }

            //ABAHOIZQUIERDA NEGRO
            if (p.getI() + 1 < 8 && p.getJ() - 1 >= 0) {
                Pieza casilla = Main.tablero[p.getI() + 1][p.getJ() - 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        int iOriginal = p.getI();
                        int jOriginal = p.getJ();

                        int iProvisional = p.getI() + 1;
                        int jProvisional = p.getJ() - 1;

                        Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                        Main.tablero[iOriginal][jOriginal] = null;
                        Main.tablero[iProvisional][jProvisional] = p;

                        p.setI(iProvisional);
                        p.setJ(jProvisional);

                        if (!rey.hayJaque()) {
                            abajoIzquierda = true;
                        }

                        Main.tablero[iOriginal][jOriginal] = p;
                        Main.tablero[iProvisional][jProvisional] = piezaComida;

                        p.setI(iOriginal);
                        p.setJ(jOriginal);
                    }
                }
            }


            //En peassant derecha NEGRO
            if (p.getI() == 4 && p.getColor() == Color.NEGRO && p.getJ() + 1 < 8) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() + 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        if (casilla.getPrimerMovimiento2OEnroque()
                                && Main.getUltimaPiezaMovida() == casilla
                                && casilla.getTipoPieza() == TipoPieza.PEON) {
                            int iOriginal = p.getI();
                            int jOriginal = p.getJ();

                            int iProvisional = p.getI() + 1;
                            int jProvisional = p.getJ() + 1;

                            Pieza piezaComida = Main.tablero[iOriginal][jOriginal + 1];

                            Main.tablero[iOriginal][jOriginal] = null;
                            Main.tablero[iOriginal][jOriginal + 1] = null;
                            Main.tablero[iProvisional][jProvisional] = p;

                            p.setI(iProvisional);
                            p.setJ(jProvisional);

                            if (!rey.hayJaque()) {
                                enPassantNegroDerecha = true;
                            }

                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iOriginal][jOriginal + 1] = piezaComida;
                            Main.tablero[iProvisional][jProvisional] = null;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);
                        }

                    }
                }
            }


            //En peassant izquierda NEGRO
            if (p.getI() == 4 && p.getColor() == Color.NEGRO && p.getJ() - 1 >= 0) {
                Pieza casilla = Main.tablero[p.getI()][p.getJ() - 1];
                if (casilla != null) {
                    if (!(casilla.getColor() == p.getColor())) {
                        if (casilla.getPrimerMovimiento2OEnroque()
                                && Main.getUltimaPiezaMovida() == casilla
                                && casilla.getTipoPieza() == TipoPieza.PEON) {
                            int iOriginal = p.getI();
                            int jOriginal = p.getJ();

                            int iProvisional = p.getI() + 1;
                            int jProvisional = p.getJ() - 1;

                            Pieza piezaComida = Main.tablero[iOriginal][jOriginal - 1];

                            Main.tablero[iOriginal][jOriginal] = null;
                            Main.tablero[iOriginal][jOriginal - 1] = null;
                            Main.tablero[iProvisional][jProvisional] = p;

                            p.setI(iProvisional);
                            p.setJ(jProvisional);

                            if (!rey.hayJaque()) {
                                enPassantNegroIzquierda = true;
                            }

                            Main.tablero[iOriginal][jOriginal] = p;
                            Main.tablero[iOriginal][jOriginal - 1] = piezaComida;
                            Main.tablero[iProvisional][jProvisional] = null;

                            p.setI(iOriginal);
                            p.setJ(jOriginal);
                        }

                    }
                }
            }


            //MOVERPRIMERA NEGRO
            if (p.getI() == 1 && ((Main.tablero[p.getI() + 1][p.getJ()] == null))) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + 1;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    moverprimera1 = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }

            //MOVERPRIMERA NEGRO
            if (p.getI() == 1 && ((Main.tablero[p.getI() + 2][p.getJ()] == null)) && moverprimera1) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + 2;
                int jProvisional = p.getJ();

                Pieza piezaComida = Main.tablero[iProvisional][jProvisional];

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    moverprimera2 = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = piezaComida;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }

            //MOVER NEGRO
            if (((p.getI() + 1) < 8) && (Main.tablero[p.getI() + 1][p.getJ()] == null)) {
                int iOriginal = p.getI();
                int jOriginal = p.getJ();

                int iProvisional = p.getI() + 1;
                int jProvisional = p.getJ();

                Main.tablero[iOriginal][jOriginal] = null;
                Main.tablero[iProvisional][jProvisional] = p;

                p.setI(iProvisional);
                p.setJ(jProvisional);

                if (!rey.hayJaque()) {
                    mover = true;
                }

                Main.tablero[iOriginal][jOriginal] = p;
                Main.tablero[iProvisional][jProvisional] = null;

                p.setI(iOriginal);
                p.setJ(jOriginal);
            }


            //COMPROBACIONES DE CADA POSIBLE MOVIMIENTO NEGRO
            if (p.getI() == 1) {

                if (!moverprimera1 && !moverprimera2 && !abajoDerecha && !abajoIzquierda) {
                    return false;
                }
            }else if (p.getI() == 4) {
                if (!mover && !abajoDerecha && !abajoIzquierda && !enPassantNegroIzquierda && !enPassantNegroDerecha) {
                    return false;
                }
            }else if (p.getI() == 6) {
                if (!mover && !abajoDerecha && !abajoIzquierda) {
                    return false;
                }
            }

        }
        return true;
    }
}









