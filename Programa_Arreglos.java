package JAVA;

public class Programa_Arreglos
{
  private static int numbers [] = { 4, 5, 7, 3, 2, 1, 6, 8, 9, 0};
  
  private static int aux;
  
  public static void main(String[] yo)
  {
    for(int i = 0; i < numbers.length; i++)
    {
      //buscamos el mayor número
      for(int j = i + 1 ; j < numbers.length ; j++)
      {
        if(numbers[i] < numbers[j])
        {
          aux = numbers[i];
          numbers[i] = numbers[j];
          numbers[j] = aux;
        }
      }
    }
    
    //Mostrarlo ordenado.
    for(int num : numbers)
    {
      System.out.println(num);
    }
  }
}