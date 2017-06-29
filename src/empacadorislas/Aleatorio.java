package empacadorislas;

//numeros aleatorios
import java.util.Random;


public class Aleatorio {
 private static Aleatorio instance;
 Random rand;

 //constructores
 private Aleatorio() {
  rand = new Random();
 }

 public static Random getInstance() {
  if (instance == null) {
   instance = new Aleatorio();
  }
  return instance.rand;
 }
}