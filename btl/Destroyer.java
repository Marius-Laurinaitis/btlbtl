package verx.asd;
import java.util.Arrays;
/**
 * Write a description of class Destroyer here.
 * 
 * @author (Marius Laurinaitis)
 * @version ( 25 02 2017)
 */
public class Destroyer extends Ship
{
   /**
     *  Destroyer constructor
     *  @param  none
     * @return none
     */
 public Destroyer()
  {
     super (2);
  }
 
   /**
     *  overrided method 
     *  @param  none
     * @return returns String Destroyer
     */
  @Override
     String getShipType () {  
    return "Destroyer";
}
    
   /**
     *  method which returns true if ship is real
     *  @param  none
     * @return boolean true
     */
  @Override
  boolean isRealShip () {
        return true;
    }

  
}
