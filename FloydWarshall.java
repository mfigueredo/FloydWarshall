import java.io.PrintStream;
import java.util.ArrayList;



public class FloydWarshall
{
  private static final int INFINITY = 9999999;
  int[][] d = null;
  
  //LIST OF MATRIX
  ArrayList<int[][]> D = new ArrayList();
  //LISTA DE MATRIZES DE PREDECESSORES
  ArrayList<int[][]> Shortest = new ArrayList();
  
  //CONSTRUTOR
  public FloydWarshall(int[][] paramArrayOfInt)
  {
    d = paramArrayOfInt;
  }
  

  //METODO PRINCIPAL PARA CALCULAR PESOS 
  public int[][] getFloyWarshall(int rows)
  {
      int n = rows;
      D.add(0, d);
      Shortest.add(buildShortestPath(0, rows));
      for(int k = 1 ; k<=n ; k++)
      {
          int[][] aux = new int[rows+1][rows+1];
          for (int i = 1; i<=n ; i++)
          {
              for(int j  = 1 ; j<=n ; j++)
              {
                  aux[i][j] = Math.min(D.get(k-1)[i][j], D.get(k-1)[i][k]+D.get(k-1)[k][j]);
              }
          }
          D.add(k, aux);
          Shortest.add(buildShortestPath(k, rows));
      }
  
      return D.get(n);
  }

  //METODO PARA CONSTRUIR MATRIZES DE PREDECESSORES
  public int[][] buildShortestPath(int k, int rows)
  {
      int n = rows;
      int[][] path = new int[rows+1][rows+1];
      if(k==0)
      {
          for (int i = 1; i<=n ; i++)
          {
              for(int j  = 1 ; j<=n ; j++)
              {
                  if(i==j || D.get(k)[i][j]==INFINITY)
                  {
                      path[i][j] = INFINITY;
                  }else{
                      path[i][j] = i;
                  }
              }
          }            
      }else{
          for (int i = 1; i<=n ; i++)
          {
              for(int j  = 1 ; j<=n ; j++)
              {
                  if(D.get(k-1)[i][j]<=D.get(k-1)[i][k]+D.get(k-1)[k][j])
                  {
                      path[i][j] = Shortest.get(k-1)[i][j];
                  }else{
                      path[i][j] = Shortest.get(k-1)[k][j];
                  }
              }
          }      
      }

      return path;

  }
  

  //METODO PARA VERIFICAR CICLOS NEGATIVOS
  public boolean isThereNegativeCicle(int size)
  {
    for (int i = 1; i <= size; i++)
    {
      if (D.get(size)[i][i] != 0)
      {
        return true;
      }
    }
    return false;
  }
  
  //METODO PARA MOSTRAR O CAMINHO MAIS CURTO ENTRE DOIS VERTICES
  public void printAllPairsShortestPath(int i, int j, int size)
  {
    if (i == j)
    {
      System.out.print(i + "->");
    } else if (Shortest.get(size)[i][j] != 9999999)
    {
      printAllPairsShortestPath(i, Shortest.get(size)[i][j], size);
      System.out.print(j + "->");
    }
  }
  
  //METODOS PARA RETORNAR LISTA DE MATRIZES
  public ArrayList<int[][]> getFloydWArrayList()
  {
    return this.D;
  }
  
  public ArrayList<int[][]> getShortestPath() {
    return this.Shortest;
  }
}