package Programa;

import java.util.Scanner;

/**
 * Juan trabaja en una carpintería en la cual puede trabajar de 8 a 10 horas al día 
 * de lunes a viernes y máximo 12 horas entre sábado y domingo. Si trabaja 8 horas al día, 
 * el sueldo es de $20 x hora, sin embargo, si trabaja 10 horas o más el sueldo sube a $25 x hora
 * y si trabaja en fin de semana el sueldo es de $30 x hora, pero si excede las 12 horas se le
 * paga a 25 x hora el excedente de horas. Si Juan trabaja más de 40 horas a la semana recibe 
 * una bonificación extra del 10%.
 * >= 8 y <10 hrs x 5 dias = (<= 40 hrs) sueldo normal $20 x hora.
 * >= 10 hrs x 5 dias = (>= 50 hrs) sueldo normal $25 x hora
 * 8 hrs x 5 dias = (40 hrs + 12 hrs (syd) >= 52 hrs > 12 hrs {s y d} = $25 ) sueldo normal $30 x hora.
 * > 40 hrs = $10% al sueldo.
**/

public class Carpinteria
{
  private static Scanner leer;
  
  private static int sueldo1 = 20;
  private static int sueldo2 = 25;
  private static int sueldo3 = 30;
  private static int excedente_Horas = 25;
  private static int bonificacion_Extra = 10;
  private static double sueldo, IVA;
  private static int contador;
  private static boolean bandera;
  
  private static String [] dias_Semana = { "DOMINGO..", "LUNES....", "MARTES...", "MIERCOLES", "JUEVES...", "VIERNES..", "SABADO..." };
  private static int arreglo_Dias [] = new int[7];
  
  public static void main(String[] yo)
  {
    leer = new Scanner(System.in);
    
    for(int x = 0; x < dias_Semana.length; x++)
    {
      System.out.print("Introduce la cantidad de horas del dia " + dias_Semana[x] + ": ");
      arreglo_Dias[x] = leer.nextInt();
      
      contador += arreglo_Dias[x];
    }
    
    if(arreglo_Dias[0] == 0 && arreglo_Dias[6] == 0) //Lúnes a viérnes
    {
      //>= 8 y <10 hrs x 5 dias = (<= 40 hrs) sueldo normal $20 x hora.
      if((arreglo_Dias[1] + arreglo_Dias[2] + arreglo_Dias[3] + arreglo_Dias[4] + arreglo_Dias[5]) < 50)
         sueldo = (contador * sueldo1);
      else
          //>= 10 hrs x 5 dias = (>= 50 hrs) sueldo normal $25 x hora
          if((arreglo_Dias[1] + arreglo_Dias[2] + arreglo_Dias[3] + arreglo_Dias[4] + arreglo_Dias[5]) >= 50)
             sueldo = (contador * sueldo2);
    }
    else //Lúnes a Dómingo
    {
      //8 hrs x 5 dias = (40 hrs + 12 hrs (syd) >= 52 hrs > 12 hrs {s y d} = $25 ) sueldo normal $30 x hora.
      if( (arreglo_Dias[1] + arreglo_Dias[2] + arreglo_Dias[3] + arreglo_Dias[4] + arreglo_Dias[5]) + (arreglo_Dias[0] + arreglo_Dias[6]) <= 52)
           sueldo = (contador * sueldo3);
      else
          if( (arreglo_Dias[1] + arreglo_Dias[2] + arreglo_Dias[3] + arreglo_Dias[4] + arreglo_Dias[5]) + (arreglo_Dias[0] + arreglo_Dias[6]) > 52)
              sueldo = (52 * sueldo3) + (contador - 52) * excedente_Horas;
    }
    
    if(arreglo_Dias[0] == 0 && arreglo_Dias[6] == 0) //Lúnes a viérnes
    {
      //> 40 hrs = $10% al sueldo.
      if( (arreglo_Dias[1] + arreglo_Dias[2] + arreglo_Dias[3] + arreglo_Dias[4] + arreglo_Dias[5]) > 40 && (arreglo_Dias[1] + arreglo_Dias[2] + arreglo_Dias[3] + arreglo_Dias[4] + arreglo_Dias[5]) < 50)
      {
        IVA = ((double)bonificacion_Extra / 100) * sueldo;
        sueldo += IVA;
      }
    }
    
    //Informamos al usuario los resultados:
    System.out.print("\nEl salario final por las horas trabajadas fue de: $" + sueldo + " pesos.");
  }
}