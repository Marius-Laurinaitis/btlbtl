package verx.asd;

import java.util.Arrays;
/**
 * Write a description of class Submarine here.
 * 
 * @author (Marius Laurinaitis)
 * @version ( 25 02 2017)
 */
public class Submarine extends Ship
{

    /**
     *  constructor of Submarine
     *  @param  none
     * @return none
     */
    public Submarine()
    {
        super (1);
  
}

 /**
     *  overrided method 
     *  @param  none
     * @return returns String Submarine
     */
  @Override
     String getShipType () {
         
         
    return "Submarine";
    
}


 /**
     *  overrided method 
     *  @param  none
     * @return returns true 
     */
     @Override
  boolean isRealShip () {
        
       
        
        return true;
    }

 
   
    
    
}


