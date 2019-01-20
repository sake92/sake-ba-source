
// javac Matrix.java
// java  Matrix
public class Matrix {

    public static void main(String[] args) {
    
        int[][] brStanaraPoStanovima = { 
          {1, 2, 3, 4}, // prvi red (sprat)
          {5, 6, 2}     // drugi red (sprat)
        };
        
        for (int i = 0; i < brStanaraPoStanovima.length; ++i) {
          int brStanaraSprata = 0;
          for(int j = 0; j < brStanaraPoStanovima[i].length; ++j) {
            brStanaraSprata += brStanaraPoStanovima[i][j];
          }
          System.out.println("Br. stanara sprata " + i + " je: " + brStanaraSprata);
        }
    }
}
