import org.testng.Assert;
import org.testng.annotations.*;

public class Class_1 {


    private Mathematics rez = new Mathematics();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        rez.setResult(0);
        System.out.println("Before Class");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        rez.setResult(0);
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDownMethod() {
        rez.setResult(0);
        System.out.println("After Method");
    }

    @BeforeTest
    public void setUpTest() {
        rez.setResult(0);
        System.out.println("Before Test");
    }

    @AfterTest
    public void tearDownTest(){
        System.out.println("After Test");
    }

    @Test(groups = {"smoke", "fast"})
    public void deduct() {
        rez.setResult(1);
        rez.deduct(4, 1);
        Assert.assertEquals(rez.getResult(),3);
    }

    @Test(timeOut = 1, groups = "fast")
    public void add() throws InterruptedException {
        Thread.sleep(1000);
        rez.add(20, 80);
        Assert.assertEquals(rez.getResult(), 100);
    }

    @Test(groups = "fast")
    public void multiply() {
        rez.multiply(2, 2);
        Assert.assertEquals(rez.getResult(), 4);
    }

    @Test(groups = "fast")
    public void divide() {
        rez.divide(6,3);
        Assert.assertEquals(rez.getResult(), 2);
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "fast")//check division by zeroarith
    public void divByZero() {
        rez.divide(1, 0);
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("After Class");
    }
}