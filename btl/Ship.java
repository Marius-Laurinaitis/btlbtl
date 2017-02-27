package verx.asd;
/**
 * Sets variables, updates hit array if shot is true .
 * 
 * @author (Marius Laurinaitis)
 * @version ( 25 02 2017)
 */


public abstract class Ship
{
 private int bowRow ;
 private int bowColumn ;
 private int length;
 private boolean horizontal ;
 private boolean []hit;
 private int indexPosition ;

    /**
     *  main ship constructor
     *  @param  length of the ship
     * @return none
     */
   public Ship (int length)
   {
       this.length = length;
       hit = new boolean [length];
            
        for (int i = 0; i < length; i++) 
        {
            hit[i]= false;      
         
        }
  
   }
    /**
     *  getter method for hit array
     *  @param  none
     * @return none
     */
    public boolean [] hitArray()
    {
     return hit ;
    }
    
         /**
     *  setter method for setting index position of the ship
     *  @param  Integer value of position
     * @return none
     */
     public void  position (int aa) {
        indexPosition= aa;
     
    }
       /**
     *  getter method of the position
     *  @param  none
     * @return none
     */
    public int positionPos () {
        
        return indexPosition ;
    }
  
        /**
     *  getter method of the bow row
     *  @param  none
     * @return Integer bow row
     */
    public int getBowRow () {
        return bowRow  ;
    }
    
       /**
     *  getter method for bow column
     *  @param  none
     * @return Integer bow column
     */
    public int getBowColumn() {
        return bowColumn  ;
    }
    
        /**
     *  getter method to check if ship horizontal
     *  @param  none
     * @return boolean horizontal
     */
   public boolean isHorizontal() {
        return horizontal;
    }
    
        /**
     *  getter method for the ship length
     *  @param  none
     * @return integer length
     */
    public int getLength ()
    { 
        return length;
    }
    
       /**
     *  abstract method
     *  @param  none
     * @return none
     */
    abstract  String getShipType ();
        
        /**
     *  setter method for bow row
     *  @param  Integer row
     * @return none
     */
    void setBowRow(int row) {
       bowRow = row;
    } 
    
          /**
     *  setter method for bow column
     *  @param  Integer column
     * @return none
     */
    void setBowColumn(int column) {
        bowColumn = column;
    }
    
            /**
     *  setter method for the horizontal ship
     *  @param  boolean horizontal
     * @return none
     */
    void setHorizontal ( boolean horizontal ) {
       this.horizontal =  horizontal ;   
    }
    
           /**
     *  updates hit array 
     *  @param  Integer column , Integer row
     * @return boolean shoot
     */
    boolean shootAt (int row , int column ) {
        boolean shoot = true;
        
          if ( isSunk())
                   {
                      return  false ;
                    }
          hit[indexPosition]=true;
         
        return shoot;
    }
    
            /**
     *  method for real ships . 
     *  @param  none
     * @return returns boolean true if ship is real , false otherwise
     */
    boolean isRealShip () {
        return false;
    }
    
           /**
     *  Checks if the ship has sunk
     *  @param  none
     * @return returns boolean 
     */
    public boolean isSunk ()
    {
       int check = 0;
      
      
          for ( int jj =0; jj <hit.length; jj++ )
                 {
                        
                if ( hit[ jj ]==true)
                  {
                    check++ ;
                  
                  }
                        
                                }   
           if ( check ==hit.length && isRealShip())
                  {
                     return true;
                                            
                  }
                                
      return false ;
    }

}