package verx.asd;


/**
 * Write a description of class OceanTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */




import org.junit.Test;
import static org.junit.Assert.*;


public class    OceanTest {
Ocean test = new Ocean() ;
    @Test
    public void test_1() {
        fail("Not yet implemented");
    }

   
    
    @Test(expected = IndexOutOfBoundsException.class) 
    public void  shootAt( )
    {
           assertEquals(IndexOutOfBoundsException.class , test.shootAt(-1,-1) ) ;
         
    }
  
       
    @Test(expected = IndexOutOfBoundsException.class) 
    public void  shootAt1( )
    {
           assertEquals(IndexOutOfBoundsException.class , test.shootAt(10,10) ) ;
         
    }
   @Test
    public void  shootAt2( )
    {
           assertEquals(false , test.shootAt(1,1 ) ) ;
         
    }
      @Test
    public void  shootAt3( )
    {
           assertEquals(true , test.shootAt(1,1 ) ) ;
         
    }
    

}


