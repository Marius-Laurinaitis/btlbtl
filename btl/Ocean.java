package verx.asd;

/**
 * Places ships on the Ocean on predefined conditions, shoots at the Ocean , prints map of the Ocean , .
 * 
 * @author (Marius Laurinaitis) 
 * @version (25 02 201)
 */

import java.util.Random;

public class Ocean
{
private Ship [][]ships = new Ship [10][10];
private int shotsFired;
private int hitCount ;
private int shipsSunk ;
private Ship flotila [] = {new Battleship (),new Cruiser(),new Cruiser(), new Destroyer (),new Destroyer (),new Destroyer (), new Submarine(), new Submarine(),new Submarine(),new Submarine() };
private boolean placed = false;
Random random = new Random();
private int pos;
private EmptySea misss = new EmptySea () ;
     /**
     *  Constructor of the Ocean
     *  @param  none
     * @return none
     */
 public  Ocean () {
   
                for ( int i =0; i <ships.length ; i++ )
                    {
         
         
                            for ( int j =0; j <ships.length; j++ )
                            {
                                ships[i][j] = new EmptySea();
    
                            }
                            hitCount = 0;
                            shipsSunk = 0;
                            shotsFired = 0;
                     }

    }
    
        /**
     *  passes values to  place(Ship flotila ) function 
     *  @param  none
     * @return none
     */
public void placeAllShipsRandomly()
     {
         for ( int jj =0; jj <flotila.length; jj++ )
         {    
            place ( flotila [jj]) ;
        }
     }
          
     /**
     * Places ships from array flotila on the Ocean
     * @param single ship of flotila array
     * @return none
     */
     
    public  void place(Ship flotila )
{
   do
   {
            flotila.setBowRow(random.nextInt(10));
       int i = flotila.getBowRow ();
         flotila.setBowColumn(random.nextInt(10));
        int j = flotila.getBowColumn(); 
        boolean dir = random.nextBoolean() ;
         placed = false;  
     //checking first point(initial point of the ship) .
    if ( pointCheck ( i, j))
    
       {
          int n = 0;
          for ( int m =0; m <flotila.getLength (); m++ )
            {
                // if horizontal we set horizontal value and place ships on the ocean
             
              if (dir)
               {
                  if ( (j+flotila.getLength ()<ships.length+1))
                   
                    if (pointCheck ( i, j+flotila.getLength()) || i==j&&j==9)
                    {
                       ships [i][j+m] =  flotila ;
                       flotila.setHorizontal (true);
                       placed = true;  
                    }   
                }
                // if vertical
                else   
                {
                   if (i+flotila.getLength ()<ships.length+1)
                       
                       if (pointCheck ( i+flotila.getLength(), j)|| i==j&&j==9  )
                      {   
                       ships [i+m][j] = flotila;
                       flotila.setHorizontal (false);
                       placed = true; 
                      
                       }
                
                }
            }
             
      } 
  }
          while(!placed==true);
     
 }
    
     /**
     *  Function calculates coordinates position relatively to ship start position which  has index 0
     *   @param  row and column  coordinates of the ship
     * @return   returs integer from 0 to 3
     * 
     */
      public  int  indexPositions  ( int row, int column  )
    {

          if (  ships [row][column].isHorizontal())
              {
                 for (int ii =0 ; ii <ships[row][column].getLength(); ii++ )
                     {
                       if (  (column-ii)==0 ) 
                             {
                                 pos = ii ;
                                 return pos;
                              }
                         else if ( (ships [row][column-ii-1] instanceof EmptySea))
                           {
                              pos = ii ;
                              return pos;
                            } 
                             // else if ( (ships [row][column] instanceof EmptySea))
                             // {
                              //    return 0;
                              //  }

                      }
                            
               }
                else 
                        for (int ii =0 ; ii <ships[row][column].getLength(); ii++ )
                       {
                                if (  (row-ii)==0 ) 
                                {
                                      pos = ii ;
                                     return pos;
                                }
                                else if ( (ships [row-ii-1][column] instanceof EmptySea))
                                {
                               
                                 pos = ii ;
                                return pos;
                            } 
                           // else if ( (ships [row][column] instanceof EmptySea))
                            //  {
                              //    return 0;
                              //  }
                       }                    
        return pos ;  
    }
    
    
     /**
     *  checking first rectangle  positions for ship placing 
     *  @param  n and m coordinates of the Ocean
     * @return  return the boolean value
     */
     boolean extraPoints (int n, int m ) 
     {
         boolean point = false;
                  //check for first row
             if ((n==0) && (m>0) && (m<9) )
                {   
                   if ((ships [n][m])instanceof EmptySea&(ships [n][m-1]instanceof EmptySea)&&ships [n][m+1]instanceof EmptySea&&ships [n+1][m-1]instanceof EmptySea&&
                   ships [n+1][m]instanceof EmptySea&&ships [n+1][m+1]instanceof EmptySea)
                {
                    point = true;   
                }
            }
                       //check for bottom row
             if ((n==9)&& (m>0 ) && (m<9) )
                {   
                   if ((ships [n][m])instanceof EmptySea&(ships [n][m-1]instanceof EmptySea)&&ships [n][m+1]instanceof EmptySea&&ships [n-1][m-1]instanceof EmptySea&&
                   ships [n-1][m]instanceof EmptySea&&ships [n-1][m+1]instanceof EmptySea)
                {
                    point = true;       
                }
            }
            //first column
                    if ((m==0)&& (n>0 ) && (n<9) )
                {   
                   if ((ships [n][m])instanceof EmptySea&(ships [n-1][m]instanceof EmptySea)&&ships [n+1][m]instanceof EmptySea&&ships [n-1][m+1]instanceof EmptySea&&
                   ships [n+1][m+1]instanceof EmptySea&&ships [n][m+1]instanceof EmptySea)
                {
                    point = true;      
                }
            } 
            //last column
                    if ((m==9)&& (n>0 ) && (n<9) )
              {
                    
                   if ((ships [n][m])instanceof EmptySea&(ships [n-1][m]instanceof EmptySea)&&ships [n+1][m]instanceof EmptySea&&ships [n-1][m-1]instanceof EmptySea&&
                   ships [n+1][m-1]instanceof EmptySea&&ships [n][m-1]instanceof EmptySea)
                {
                    point = true;      
                }
            }
            ////top left corner
              if ((m==0)&& (n==0 )  )
                {
                   if ((ships [n][m])instanceof EmptySea&&(ships [n][m+1]instanceof EmptySea)&&(ships [n+1][m]instanceof EmptySea)&&(ships [n+1][m+1]instanceof EmptySea))
                {
                    point = true;       
                }
                }  
            ////top right corner
              if ((m==9)&& (n==0 )  )
                {
                   if ((ships [n][m])instanceof EmptySea&&(ships [n][m-1]instanceof EmptySea)&&(ships [n+1][m]instanceof EmptySea)&&(ships [n+1][m-1]instanceof EmptySea))
                {
                    point = true;     
               }
                }     
            ////bottom left corner
              if ((m==0)&& (n==9)  )
                {
                   if ((ships [n][m])instanceof EmptySea&&(ships [n][m+1]instanceof EmptySea)&&(ships [n-1][m]instanceof EmptySea)&&(ships [n-1][m+1]instanceof EmptySea))
                {
                    point = true;        
                }
                }
                      ////bottom right corner
              if ((m==9)&& (n==9)  )
               {
                   if ((ships [n][m])instanceof EmptySea&&(ships [n][m-1]instanceof EmptySea)&&(ships [n-1][m]instanceof EmptySea)&&(ships [n-1][m-1]instanceof EmptySea))
                {
                    point = true;      
                }
            }   
           return point;
       }
       
           
           
      /**
     *  checks initial placing point  and later vertical or horizontal placing points of the ship to the ocean
     *   parts of comparing objects is for vertical/horizontal placing 
     *  @param  n and m coordinates of the Ocean
     * @return  return the boolean value
     */
      public boolean pointCheck (int n, int m ) 
    {
              boolean point = false;
            if (extraPoints(n,m))
            {
                 point = true; 
            } 
            if ((n>0) && (m>0) && (n<9) && (m<9)  )
            {  
              if ( (ships [n][m])instanceof EmptySea&& 
              ((ships [n][m-1].equals(ships[n][m]))  ||(ships [n][m-1]instanceof EmptySea)) &&
              (ships [n][m+1])instanceof EmptySea&&
              ships [n+1][m-1]instanceof EmptySea&&
              ships [n+1][m+1]instanceof EmptySea&&
              ships [n-1][m+1]instanceof EmptySea&&
              ships [n-1][m-1]instanceof EmptySea&&
              ships [n+1][m] instanceof EmptySea& ((ships [n-1][m].equals(ships[n][m])) || (ships [n-1][m] instanceof EmptySea )  ))
              {
              point = true;
            }    
        } 
            return point;
     }
          
        
     /**
     *  checks if the coordinates contains ship or not
     *  @param  n and m coordinates of the Ocean
     * @return  return the boolean value
     */
   public boolean isOccupied ( int row, int column )
    {
        boolean answer = false;
         if (ships [row][column]instanceof Ship )
            {
             answer = true ;
            }
            return answer ; 
   }
   
        /**
     *  checks if at supplied coordinates ship has sunk
     *  @param  n and m coordinates of the ship
     * @return  return the boolean value
     */
    public boolean hasSunkShipAt (int row, int column )
    {
          
               if ( ships[row][column].isSunk())
               {
                 setShipSunk (1);
                }
                  
      return    ships [row][column].isSunk();
    }
                  
     /**
     *  shoots at the Ocean updates shots fired and hit counts 
     *  @param  n and m coordinates of the Ocean
     * @return  returns the boolean value
     */
    public boolean shootAt (int row, int column )
    {
        boolean shot = false;
        
           shotsFired ++; 
        
         //if shooting at EmptySea
        if ( ships [row][column] instanceof EmptySea )
        {
            ships [row][column] = misss;
           
        }
        
               if ( ! ships [row][column].shootAt(row,column ))
                   {
                      return  false ;
                    }
        
        
                      
          
           if ( ships [row][column]instanceof Ship )
        {
            ships [row][column].position (indexPositions( row,column )) ;
            ships [row][column].shootAt (row , column ) ;
              if (  ships [row][column].isRealShip())
                {
                  hitCount++;
                }
            shot = true;
         }
                        
     
  
       return shot;
    }
   
     /**
     *  gets shots fired
     *  @param  none
     * @return  returns shots fired
     */
    public int getShotsFired()  {
      return  shotsFired;
    }
    
     /**
     *  gets hits
     *  @param  none
     * @return returns hits
     */
    public int getHitCount () {
        return hitCount;
    }
    
     /**
     *  gets ship type at the Ocean 
     *  @param row and column coordinates of the Ocean 
     * @return  returns String which is type of the ship
     */
    public String getShipTypeAt ( int row, int column ) 
    {
        String type  = " " ;     
           for ( int j =0; j <flotila.length; j++ )
           {
               if(ships[row][column].equals(flotila[j]) )
               {
                  type = flotila[j].getShipType ();
               }
           }
       return type;
    }
    
    
  /**
     *  gets ships sunk
     *  @param  none
     * @return returns Integer ships sunk
     */
    public int getShipsSunk () {
        return shipsSunk;
    }
    
      /**
     *  sets the value of sunk ships
     *  @param  Integer value of 1
     * @return none
     */
    public void setShipSunk ( int ship) {
        
        shipsSunk =    shipsSunk + ship;
    }
    
    
     /**
     *  prints the Ocean
     *  @param  none
     * @return none
     */
   public void print ()
  {
        System.out.print( " " );
           for ( int m =0; m <10; m++ )
        { 
             System.out.print( m );
        }   
       System.out.println(); 
      for ( int i =0; i <10 ; i++ )
      {
        System.out.print( i );
        for ( int j =0; j <10; j++ )
        {
                //emptysea filled
             if (  ships [i][j] instanceof EmptySea &&  !ships [i][j].equals( misss) )
            {
                  System.out.print( "." ) ;
                   
            }
            // if we miss 
            else  if ( ships [i][j].equals( misss) )
            
            {
                    System.out.print( "-")   ;  
            }
               //hit ship print
               if (ships [i][j].isRealShip() && ships [i][j].hitArray()[ indexPositions(i,j)]==true && ( !ships [i][j].isSunk())   )                    
                      {
                     System.out.print( "S")   ;
                                          
                    }
                       // sunk ship print
               if ( ships [i][j].isSunk() &&ships [i][j].isRealShip() )
                       {
                             System.out.print( "X")   ;    
                     }
                     // real ships printed as "."
            if ( ships [i][j].isRealShip() && ships [i][j].hitArray()[ indexPositions(i,j)]==false )
            {
              System.out.print("O" )  ;
             }                              
         }
           System.out.println(  ); 
      }
  }
  
     /**
     *  checks if game is over
     *  @param  none
     * @return returns boolean value
     */
    public boolean isGameOver () {
        if(shipsSunk==10)
        return true;
        return false; 
    }
    
    
}
