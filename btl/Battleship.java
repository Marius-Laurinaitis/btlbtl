package verx.asd;

import java.util.Arrays;
/**
 * Write a description of class Battleship here.
 * 
 * @author (Marius Laurinaitis)
 * @version ( 25 02 2017)
 */
public class Battleship extends Ship
{
 /**
     *  Battleship constructor
     *  @param  none
     * @return none
     */
 public Battleship()
 {
       super (4);
 }
 
  /**
     *  overrided method 
     *  @param  none
     * @return returns String Battleship
     */
  @Override
     String getShipType () {  
    return "Battleship";
}


     /**
     *  overrided method 
     *  @param  none
     * @return boolean true
     */
 @Override
  boolean isRealShip () {
        return true;
    }
    
     
    
    
}
