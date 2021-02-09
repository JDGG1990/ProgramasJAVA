public class Animal
{
  public static void main(String[ ] args)
  {
    Animal a = new Perro();
    Animal b = new Gato();
    
    a.hacerSonido();
    b.hacerSonido();
  }
  
  public void hacerSonido()
  {
    System.out.println("Hace algun sonido...");
  }
}

class Gato extends Animal
{
  public void hacerSonido()
  {
    System.out.println("Maulla!");
  }
}

class Perro extends Animal
{
  public void hacerSonido()
  {
    System.out.println("Ladra!");
  }
}