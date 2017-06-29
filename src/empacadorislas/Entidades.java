package empacadorislas;

public class Entidades {
 private static Entidades instance;

 Entidad[] piezas;

 //constructores
 private Entidades() {}

 private Entidades(char[] tipo_pieza) {
  piezas = new Entidad[tipo_pieza.length];
  for (int i = 0; i < tipo_pieza.length; i++)
   piezas[i] = new Entidad(tipo_pieza[i]);
 }

 public static Entidad[] getInstance(char[] tipo_pieza) {
  if (instance == null) {
   instance = new Entidades(tipo_pieza);
  }
  return instance.piezas;
 }

 public static Entidad[] getInstance() {
  if (instance == null) {
   instance = new Entidades();
  }
  return instance.piezas;
 }
}