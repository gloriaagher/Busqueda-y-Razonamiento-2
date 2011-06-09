import java.awt.* ;
import java.applet.* ;

// Ruth Gloria Aguilar Hernandez
// Matricula 200339
// Tarea - 2 - Sudoku

public class Tarea2Sudoku extends Applet implements Runnable
{
    protected Button vista[][] ;
    protected int sudoku[][] ;
    
 //Creando el modelo
   protected void creandoSudoku()
   {
      sudoku = new int[9][9] ;

      // Cuadros vacios
      for( int renglon = 0; renglon < 9; renglon++ )
         for( int columna = 0; columna < 9; columna++ )
            sudoku[renglon][columna] = 0 ;

      // Valores del Sudoku tarea
      sudoku[0][1] = 1 ;
      sudoku[0][4] = 7 ;
      sudoku[0][5] = 3 ;
      sudoku[0][8] = 4 ;

      sudoku[1][5] = 6 ;
      sudoku[1][6] = 1 ;
      sudoku[1][7] = 5 ;
      
      sudoku[3][4] = 6 ;
      sudoku[3][6] = 2 ;
      
      sudoku[4][0] = 7 ;
      sudoku[4][1] = 8 ;
      sudoku[4][2] = 1 ;
      sudoku[4][7] = 9 ;
      
      sudoku[5][2] = 5 ;
      sudoku[5][8] = 7 ;
      
      sudoku[6][5] = 9 ;
      sudoku[6][6] = 8 ;
      
      sudoku[7][0] = 6 ;
      sudoku[7][3] = 8 ;
      sudoku[7][6] = 5 ;
      
      sudoku[8][2] = 4 ;
      sudoku[8][7] = 2 ;
      sudoku[8][8] = 6 ;

   }

   protected void CreacionVista()
   {
      setLayout( new GridLayout(9,9) ) ;

      vista = new Button[9][9] ;

         for( int renglon = 0; renglon < 9; renglon++ )
         for( int columna = 0; columna < 9; columna++ )
         {
            vista[renglon][columna]  = new Button() ;
            add( vista[renglon][columna] ) ;
         }
   }

// Actualiza en cada cambio 
   protected void VistaActualizada()
   {
      for( int renglon = 0; renglon < 9; renglon++ )
         for( int columna = 0; columna < 9; columna++ )
            if( sudoku[renglon][columna] != 0 )
               vista[renglon][columna].setLabel( String.valueOf(sudoku[renglon][columna]) ) ;
            else
               vista[renglon][columna].setLabel( "" ) ;
   }

 // Para el applet 
   public void init()
   {
      creandoSudoku() ;
      CreacionVista() ;
      VistaActualizada() ;
   }

// Checa el numero con la fila
   protected boolean Comprobarfila( int renglon, int num )
   {
      for( int columna = 0; columna < 9; columna++ )
         if( sudoku[renglon][columna] == num )
            return false ;

      return true ;
   }

// Checa el numero con la columna 
   protected boolean Comprobarcol( int columna, int num )
   {
      for( int renglon = 0; renglon < 9; renglon++ )
         if( sudoku[renglon][columna] == num )
            return false ;

      return true ;
   }

// Chaca el numero con los anexos 
   protected boolean comprobarVecinos( int renglon, int columna, int num )
   {
      renglon = (renglon / 3) * 3 ;
      columna = (columna / 3) * 3 ;

      for( int ren = 0; ren < 3; ren++ )
         for( int col = 0; col < 3; col++ )
         if( sudoku[renglon+ren][columna+col] == num )
            return false ;

      return true ;
   }

  // Inicia al applet 
   public void start()
   {
      (new Thread(this)).start() ;
   }

   public void run()
   {
      try
      {
         // Para poder ver la posicion inicial --->
         Thread.sleep( 1000 ) ;

         solucion( 0, 0 ) ;
      }
      catch( Exception e )
      {
      }
   }

  // Funcion recursiva para resolver el numero de la casilla
   public void solucion( int renglon, int columna ) throws Exception
   {
      // Si termina imprime 
      if( renglon > 8 )
         throw new Exception( "La solucion ya ha sido encontrada!!" ) ;

      // Si una casilla no esta vacia, entonces continua con la siguiente
      if( sudoku[renglon][columna] != 0 )
         next( renglon, columna ) ;
      else
      {
         // Encontrando el numero ideal 
         for( int num = 1; num < 10; num++ )
         {
            if( Comprobarfila(renglon,num) && Comprobarcol(columna,num) && comprobarVecinos(renglon,columna,num) )
            {
               sudoku[renglon][columna] = num ;
               VistaActualizada() ;

               // Hay que verlo
               Thread.sleep( 1000 ) ;

               // Llamada recursiva a la siguiente casilla
               next( renglon, columna ) ;
            }
         }

         // Si el numero no coincide borra el anterior para encontrar una nueva solucion
         sudoku[renglon][columna] = 0 ;
         VistaActualizada() ;
      }
   }

   // Se llama a solucion para la siguiente casilla
   public void next( int renglon, int columna ) throws Exception
   {
      if( columna < 8 )
         solucion( renglon, columna + 1 ) ;
      else
         solucion( renglon + 1, 0 ) ;
   }
}
