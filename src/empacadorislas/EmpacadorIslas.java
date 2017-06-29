package empacadorislas;

public class EmpacadorIslas {

 public static void main(String args[]) {
  //creacion del medio
  Medio.getInstance(4, 4);

  //creacion de las entidades
  Entidades.getInstance(new char[] {
   'z',
   '1',
   'T',
   'L'
  });

  //creacion del algoritmo genetico
  Genetico empacador = new Genetico();
  empacador.correr(30, 30, (float) 2 / 3);
 }
}