package empacadorislas;

import java.util.Random;


//cromosoma
public class Cromosoma { //posicion compuesta por X y Y
 //posiciones
 int x;
 int y;

 //constructor
 public Cromosoma(Entidad pieza) {
  Random rand = Aleatorio.getInstance();
  Medio tablero = Medio.getInstance();
  x = rand.nextInt(tablero.ancho - pieza.ancho + 1);
  y = rand.nextInt(tablero.largo - pieza.largo + 1);
 }
}