package verx.asd;
/**
 * Write a description of class Cruiser here.
 * 
 * @author (Marius Laurinaitis)
 * @version ( 25 02 2017)
 */
public class Cruiser extends Ship
{
 
     /**
     *  constructor of Cruiser 
     *  @param  none
     * @return none
     */
    public Cruiser()
    {
       
         super (3);
     
    }

     /**
     *  overrided method 
     *  @param  none
     * @return returns String Cruiser
     */
  @Override
     String getShipType () {
         
         
    return "Cruiser";
    
}

 /**
     *  overrided method 
     *  @param  none
     * @return returns boolean true
     */
@Override
  boolean isRealShip () {
        
       
        
        return true;
    }
}
