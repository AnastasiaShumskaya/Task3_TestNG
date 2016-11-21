import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;

public class Class_DataProvider {


    private Mathematics rez = new Mathematics();

    @DataProvider(name = "someData")
    public Object[][] dataSet() {
        return new Object[][] {
                { 1, 7 },
                { 2, 3 },
                { 3, 0 },
                { 4, -1 }
        };
    }

    @BeforeMethod
    public void setUpClass() {
        rez.setResult(0);
    }

    @Test(dataProvider = "someData", dependsOnMethods = "testDivideDDT", alwaysRun=true)
    public void testAddDDT(int x, int y) {
        rez.add(x,y);
        Assert.assertEquals(rez.getResult(),x+y);
    }
    @Test(dataProvider = "someData", dependsOnMethods = "testAddDDT", alwaysRun=true)
    public void testDeductDDT(int x, int y) {
        rez.setResult(1);
        rez.deduct(x, y);
        Assert.assertEquals(rez.getResult(), x-y);
    }

    @Test(dataProvider = "someData", dependsOnMethods = "testDeductDDT", alwaysRun=true)
    public void testMultiplyDDT(int x, int y) {
        rez.multiply(x, y);
        Assert.assertEquals( rez.getResult(), x*y);
    }

    @Test(dataProvider = "someData", alwaysRun=true)
    public void testDivideDDT(int x, int y) {
        rez.divide(x,y);
        Assert.assertEquals(rez.getResult(), x/y);
    }

    @AfterClass
    public static void tearDownClass() {
    }
}