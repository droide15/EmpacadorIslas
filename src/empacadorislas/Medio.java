package empacadorislas;

//medio en el que son evaluadas las soluciones
public class Medio { //tablero
 private static Medio instance;
 //dimensiones
 int largo;
 int ancho;


 //constructores
 private Medio() {}

 private Medio(int largo, int ancho) {
  this.largo = largo;
  this.ancho = ancho;
 }


 public static Medio getInstance(int largo, int ancho) {
  instance = new Medio(largo, ancho);
  return instance;
 }

 public static Medio getInstance() {
  if (instance == null) {
   instance = new Medio();
  }
  return instance;
 }
}