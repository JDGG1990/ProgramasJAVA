package Programa;

import java.util.Scanner;

class Rectangulo
{
  private static Scanner leer;
  private static int base, altura, area;
  
  public static void main(String[] yo)
  {
    //Area = Base x Altura
    leer = new Scanner(System.in);
    
    System.out.print("Introduce la Base: ");
    base = leer.nextInt();
    
    System.out.print("Introduce la Altura: ");
    altura = leer.nextInt();
    
    area = base * altura;
    
    System.out.print("El área del rectángulo es: " + area);
  }
}
