package verx.asd;
/**
 * Write a description of class EmptySea here.
 * 
 * @author (Marius Laurinaitis)
 * @version ( 25 02 2017)
 */
public class EmptySea extends Ship
{
   
     /**
     *  Constructor of EmptySea
     *  @param  none
     * @return none
     */
 public EmptySea()  
  {
     super (1);
     
 }
 
 
 
 /**
     *  overrided method 
     *  @param  none
     * @return returns String EmptySea
     */
  @Override
    public String getShipType () {
         
         
    return "EmptySea";
    
}

  @Override
   public  boolean shootAt ( int row, int column) {
         
         
    return false;
    
}


 @Override
    public boolean isSunk () {
         
         
    return false;
    
}


 /**
     *  overrided method 
     *  @param  none
     * @return true
     */
@Override
  boolean isRealShip () {
        
        return false;
    }
}
