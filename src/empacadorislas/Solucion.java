package empacadorislas;

//solucion

import java.util.Random;

public class Solucion { //posiciones
 //lista de posiciones
 Cromosoma[] posiciones;
 //matriz de posiciones
 int[][] matriz;
 //numero de posiciones desocupadas
 int aptitud;
 //probabilidad de reproduccion
 float probrep;

 //constructor
 public Solucion() {
  Medio tablero = Medio.getInstance();
  Entidad[] piezas = Entidades.getInstance();
  posiciones = new Cromosoma[piezas.length];
  for (int i = 0; i < posiciones.length; i++)
   posiciones[i] = new Cromosoma(piezas[i]);
  matriz = new int[tablero.largo][tablero.ancho];
 }

 //evaluacion
 void evaluar() {
  Medio tablero = Medio.getInstance();
  Entidad[] piezas = Entidades.getInstance();
  int largo = tablero.largo;
  int ancho = tablero.ancho;

  for (int i = 0; i < largo; i++)
   for (int j = 0; j < ancho; j++)
    matriz[i][j] = 0;

  for (int m = 0; m < piezas.length; m++) {
   int x_ini = posiciones[m].x;
   int x_fin = x_ini + piezas[m].ancho - 1;
   int y_ini = posiciones[m].y;
   int y_fin = y_ini + piezas[m].largo - 1;

   for (int i = y_ini; i <= y_fin; i++)
    for (int j = x_ini; j <= x_fin; j++)
     matriz[i][j] = Math.max(matriz[i][j], piezas[m].matriz[i - y_ini][j - x_ini]);
  }

  aptitud = 0;
  for (int i = 0; i < largo; i++)
   for (int j = 0; j < ancho; j++)
    aptitud += (1 - (matriz[i][j] * 2 - 1)) / 2;
 }

 //cruce genetico
 void cruzar(Solucion A, Solucion B) {
  Random rand = Aleatorio.getInstance();
  for (int i = 0; i < posiciones.length; i++) {
   int x;
   int y;
   if (rand.nextInt(2) == 0) {
    x = A.posiciones[i].x;
    y = A.posiciones[i].y;
   } else {
    x = B.posiciones[i].x;
    y = B.posiciones[i].y;
   }
   posiciones[i].x = x;
   posiciones[i].y = y;
  }
 }

 //mutacion
 void mutar() {
  Medio tablero = Medio.getInstance();
  Entidad[] piezas = Entidades.getInstance();
  Random rand = Aleatorio.getInstance();
  for (int i = 0; i < posiciones.length; i++) {
   if (rand.nextInt(2 * 100 * posiciones.length) == 0) {
    int oldx = posiciones[i].x;
    int newx = oldx;
    while (oldx == newx)
     newx = rand.nextInt(tablero.ancho - piezas[i].ancho + 1);
   }
   if (rand.nextInt(2 * 100 * posiciones.length) == 0) {
    int oldy = posiciones[i].y;
    int newy = oldy;
    while (oldy == newy)
     newy = rand.nextInt(tablero.largo - piezas[i].largo + 1);
   }
  }
 }

 //impresion de prueba
 void imprimir() {
  Medio tablero = Medio.getInstance();
  Entidad[] piezas = Entidades.getInstance();
  int largo = tablero.largo;
  int ancho = tablero.ancho;
  int[][] matriz = new int[largo][ancho];

  System.out.println("****");
  for (int i = 0; i < largo; i++) {
   for (int j = 0; j < ancho; j++)
    if (this.matriz[i][j] == 0)
     System.out.print("O");
    else
     System.out.print("X");
   System.out.println("");
  }
  System.out.println("aptitud = " + aptitud);
  System.out.println("****");
  for (int m = 0; m < piezas.length; m++) {
   int x_ini = posiciones[m].x;
   int x_fin = x_ini + piezas[m].ancho - 1;
   int y_ini = posiciones[m].y;
   int y_fin = y_ini + piezas[m].largo - 1;

   for (int i = 0; i < largo; i++)
    for (int j = 0; j < ancho; j++)
     matriz[i][j] = 0;

   for (int i = y_ini; i <= y_fin; i++)
    for (int j = x_ini; j <= x_fin; j++)
     matriz[i][j] = piezas[m].matriz[i - y_ini][j - x_ini];

   System.out.println("----");
   for (int i = 0; i < largo; i++) {
    for (int j = 0; j < ancho; j++)
     if (matriz[i][j] == 0)
      System.out.print("O");
     else
      System.out.print("X");
    System.out.println("");
   }
  }
 }
}