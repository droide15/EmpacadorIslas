package empacadorislas;

//entidad que influencia la evaluacion
public class Entidad { //pieza de tetriz
 //dimensiones
 int largo;
 int ancho;

 //matriz de posiciones
 int[][] matriz;

 //constructor

 public Entidad(char tipo) {
  switch (tipo) {
   case 'T':
    largo = 2;
    ancho = 3;
    matriz = new int[largo][ancho];
    for (int i = 0; i < largo; i++)
     for (int j = 0; j < ancho; j++)
      matriz[i][j] = 0;
    matriz[0][0] = 1;
    matriz[0][1] = 1;
    matriz[0][2] = 1;
    matriz[1][1] = 1;
    break;
   case 'L':
    largo = 3;
    ancho = 2;
    matriz = new int[largo][ancho];
    for (int i = 0; i < largo; i++)
     for (int j = 0; j < ancho; j++)
      matriz[i][j] = 0;
    matriz[0][0] = 1;
    matriz[1][0] = 1;
    matriz[2][0] = 1;
    matriz[2][1] = 1;
    break;
   case 'z':
    largo = 2;
    ancho = 3;
    matriz = new int[largo][ancho];
    for (int i = 0; i < largo; i++)
     for (int j = 0; j < ancho; j++)
      matriz[i][j] = 0;
    matriz[0][0] = 1;
    matriz[0][1] = 1;
    matriz[1][1] = 1;
    matriz[1][2] = 1;
    break;
   case '1':
    largo = 3;
    ancho = 2;
    matriz = new int[largo][ancho];
    for (int i = 0; i < largo; i++)
     for (int j = 0; j < ancho; j++)
      matriz[i][j] = 0;
    matriz[0][1] = 1;
    matriz[1][0] = 1;
    matriz[1][1] = 1;
    matriz[2][1] = 1;
    break;
  }
 }
}