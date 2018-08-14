import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class Main
{
  public static int[][] d = null;
  public static int size;
  
  public static void main(String[] args) {
    ArrayList<int[][]> floyd = null;
    ArrayList<int[][]> shortest = null;
    
    //READ THE GRAPH
    readMatrix(args[1]);
    
    //CREATE A FLOYDWARSHALL GRAPH
    FloydWarshall f = new FloydWarshall(d);
    
    //GET THE SIZES
    f.getFloyWarshall(size);
    
    //GET THE MATRIX AND SHORTEST PATHS
    floyd = f.getFloydWArrayList();
    shortest = f.getShortestPath();
    
    //VERIFY NEGATIVE CICLES
    if (!f.isThereNegativeCicle(size))
    {
      //COMMAND 1 TO SHOW LIST
      if (args[0].equals("1"))
      {
        prinMatrixList(floyd, shortest, size);
      }
      //COMMAND 2 TO SHOW RESULT
      else if (args[0].equals("2")) 
      {
        printResult(floyd.get(size), shortest.get(size), size);
      }
      //COMMAND 3 TO SHOW ALL POSSIBLE PATHS
      else if (args[0].equals("3"))
      {
        for (int i = 1; i <= size; i++)
        {
          for (int j = 1; j <= size; j++)
          {
            f.printAllPairsShortestPath(i, j, size);
            System.out.print("\n");
          }
        }
      }
    }
    else {
      System.out.println("Desculpe, existe um ou mais ciclos negativos no grafo.");
    }
  }
  



  // ##########################
  // ##########################
  // ######### FUNCOES ########
  // ######## AUXILIARES ######
  // ##########################



  //FUNCAO PARA LEITURA DO ARQUIVO
  public static void readMatrix(String paramString)
  {
    FileReader localFileReader = null;
    Object localObject = null;
    BufferedReader localBufferedReader = null;
    

    String path = paramString;
    

    try
    {
      localFileReader = new FileReader(path);
      localBufferedReader = new BufferedReader(localFileReader);
      
      size = Integer.parseInt(localBufferedReader.readLine());
      
      d = new int[size + 1][size + 1];
      


      int i = 1;
      String line; 
      while ((line = localBufferedReader.readLine()) != null)
      {
        String[] elements = line.split(" ");
        for (int j = 1; j <= size; j++) {
          if (elements[(j - 1)].equals("INF")) {
            d[i][j] = 9999999;
          } else {
            d[i][j] = Integer.parseInt(elements[(j - 1)]);
          }
        }
        
        i++;
      }
    }
    catch (Exception localException) {
      localException.printStackTrace();
    }
  }
  //FUNCAO PARA PRINTAR MATRIZES PRINCIPAIS
  public static void printResult(int[][] a, int[][] b, int size)
  {
    System.out.print("############## FLOYD WARSHALS WEIGTHS ##############");
    for (int i = 1; i <= size; i++)
    {
      System.out.print("\n");
      for (int j = 1; j <= size; j++)
      {
        if (a[i][j] == 9999999) {
          System.out.print(" ∞ ");
        } else {
          System.out.print(" " + a[i][j] + " ");
        }
      }
    }
    System.out.print("\n");
    System.out.print("############## SHORTEST PATH ##############");
    for (int i = 1; i <= size; i++)
    {
      System.out.print("\n");
      for (int j = 1; j <= size; j++)
      {
        if (b[i][j] == 9999999) {
          System.out.print(" NIL ");
        } else {
          System.out.print(" " + b[i][j] + " ");
        }
      }
    }
    System.out.print("\n");
  }
  //FUNCAO PARA MOSTRAR LISTA DE MATRIZES
  public static void prinMatrixList(ArrayList<int[][]> a, ArrayList<int[][]> b, int size)
  {
    System.out.print("############## FLOYD WARSHALS WEIGTHS ##############");
    for (int k = 1; k <= size; k++)
    {

      for (int i = 1; i <= size; i++)
      {
        System.out.print("\n");
        for (int j = 1; j <= size; j++)
        {
          if (a.get(k)[i][j] == 9999999) 
          {
            System.out.print(" ∞ ");
          } else {
            System.out.print(" " +a.get(k)[i][j] + " ");
          }
        }
      }
      System.out.print("\n");
    }
    System.out.print("############## SHORTEST PATH ##############");
    for (int k = 1; k <= size; k++)
    {

      for (int i = 1; i <= size; i++)
      {
        System.out.print("\n");
        for (int j = 1; j <= size; j++)
        {
          if (b.get(k)[i][j] == 9999999) 
          {
            System.out.print(" NIL ");
          } else {
            System.out.print(" " + b.get(k)[i][j] + " ");
          }
        }
      }
      System.out.print("\n");
    }
  }
}