package empacadorislas;

//algoritmo genetico
public class Genetico { //empacador a la tetris
 //atributos
 Isla isla;

 //ejecucion del algoritmo
 void correr(int generaciones, int N, float padres) {
  //inicializacion de las ISLA!?
  isla = new Isla(N, (int)((float) N * padres));
  
  //inicializacion de la primera generacion
  isla.inicializar();
  
  for (int g = 0; g < generaciones; g++) {
   isla.evaluarSig();

   //convergencia
   if (isla.converLocal())
    break;
  }
 }
}