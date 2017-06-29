package empacadorislas;

import java.util.Random;

//algoritmo genetico
public class Genetico { //empacador a la tetris
 //atributos
 Solucion[] soluciones;
 //parametros
 int N;
 int padres;

 //ejecucion del algoritmo
 void correr(int generaciones, int N, float padres) {
  //parametros
  this.N = N;
  this.padres = (int)((float) N * padres);

  //inicializacion de la primera generacion
  inicializacion();

  //evaluacion
  evaluacion();

  //seleccion
  seleccion();

  //impresion de prueba
  System.out.println("---poblacion inicial---");
  soluciones[0].imprimir();

  for (int g = 0; g < generaciones; g++) {
   //cruce genetico
   cruce();

   //mutacion
   mutacion();

   //evaluacion
   evaluacion();

   //seleccion
   seleccion();

   //impresion de prueba
   System.out.println("---generacion " + (g + 1) + "---");
   soluciones[0].imprimir();

   //convergencia
   if (convergencia())
    break;
  }
 }

 //inicializacion de la primera generacion
 void inicializacion() {
  soluciones = new Solucion[N];
  for (int n = 0; n < N; n++)
   soluciones[n] = new Solucion();
 }

 //evaluacion
 void evaluacion() {
  for (int n = 0; n < N; n++)
   soluciones[n].evaluar();
 }

 //seleccion
 void seleccion() {
  for (int fondo = N - 1; fondo > 0; fondo--)
   for (int n = 0; n < fondo; n++)
    if (soluciones[n].aptitud > soluciones[n + 1].aptitud) {
     Solucion temp = soluciones[n];
     soluciones[n] = soluciones[n + 1];
     soluciones[n + 1] = temp;
    }
  int sum = 0;
  for (int i = 1; i <= padres; i++)
   sum += i;
  for (int n = padres - 1; n >= 0; n--)
   soluciones[n].probrep = (float) 100 / sum * (padres - n);
 }

 //cruce genetico
 void cruce() {
  for (int n = padres; n < N; n++) {
   Random rand = Aleatorio.getInstance();
   int a = 0;
   int b = 0;
   while (a == b) {
    float r, acum;

    r = (float) rand.nextInt(10000 * 100 + 1) / 10000;
    acum = 0;
    for (int p = padres - 1; p >= 0; p--) {
     acum += soluciones[p].probrep;
     if (acum > r) {
      a = p;
      break;
     }
    }
    r = (float) rand.nextInt(10000 * 100 + 1) / 10000;
    acum = 0;
    for (int p = padres - 1; p >= 0; p--) {
     acum += soluciones[p].probrep;
     if (acum > r) {
      b = p;
      break;
     }
    }
   }
   soluciones[n].cruzar(soluciones[a], soluciones[b]);
  }
 }

 //mutacion
 void mutacion() {
  for (int n = padres; n < N; n++)
   soluciones[n].mutar();
 }

 //convergencia
 boolean convergencia() {
  //convergencia
  if (soluciones[0].aptitud == soluciones[padres - 1].aptitud)
   return true;
  return false;
 }
}