import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class_Parameters {
    

    private Mathematics rez = new Mathematics();

    @BeforeMethod
    public void setUpClass(){
        rez.setResult(0);
        System.out.println("Before Class");
    }

    @Test
    @Parameters({"x","y"})
    public void testAddDDT(int x, int y) {
        rez.add(x,y);
        Assert.assertEquals(rez.getResult(),x+y);
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("After Class");
    }
}
