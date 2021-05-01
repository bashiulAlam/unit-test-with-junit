import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {

    //region Main Method Test

    //output constant
    private static final String validTriangle = "This is a triangle.";
    private static final String inValidTriangle = "This is not a triangle.";

    //system method for invoking main
    public static boolean invokeMethod(String a, String b, String c, String output) {
        String input = a + "\n" + b + "\n" + c + "\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {};
        Demo.main(args);

        String consoleOutput = "Enter side 1: " + System.getProperty("line.separator");
        consoleOutput += "Enter side 2: " + System.getProperty("line.separator");
        consoleOutput += "Enter side 3: " + System.getProperty("line.separator");
        consoleOutput += output + System.getProperty("line.separator");

        return consoleOutput.equals(outputStream.toString());
    }

    //Test cases for main method
    @Test
    public void mainMethodEquilateralTriangleTest() {
        Assert.assertTrue(invokeMethod("1", "1", "1", validTriangle));
    }

    @Test
    public void mainMethodIsoscelesTriangleTest() {
        Assert.assertTrue(invokeMethod("6", "5", "5", validTriangle));
    }

    @Test
    public void mainMethodRightTriangleTest() {
        Assert.assertTrue(invokeMethod("3", "4", "5", validTriangle));
    }

    @Test
    public void mainMethodValidTriangleTest_1() {
        Assert.assertTrue(invokeMethod("5", "7", "3", validTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_1() {
        Assert.assertTrue(invokeMethod("5", "7", "20", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_2() {
        Assert.assertTrue(invokeMethod("5", "7", "-20", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_3() {
        Assert.assertTrue(invokeMethod("0", "0", "0", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_4() {
        Assert.assertTrue(invokeMethod("10", "20", "0", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_5() {
        Assert.assertTrue(invokeMethod("-5", "-7", "-20", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_6() {
        Assert.assertTrue(invokeMethod("10", "15", "-20", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_7() {
        Assert.assertTrue(invokeMethod("1", "2", "3", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_8() {
        Assert.assertTrue(invokeMethod("1", "2", "4", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_9() {
        Assert.assertTrue(invokeMethod("1", "6", "3", inValidTriangle));
    }

    @Test
    public void mainMethodInvalidTriangleTest_10() {
        Assert.assertTrue(invokeMethod("10", "2", "3", inValidTriangle));
    }

    //endregion

    //region isTriangle() Method Test

    //Test cases for isTriangle() method
    @Test
    public void checkEquilateralTriangle_1() {
        Assert.assertTrue(Demo.isTriangle(5, 5, 5));
    }

    @Test
    public void checkEquilateralTriangle_2() {
        Assert.assertTrue(Demo.isTriangle(0.020833333333333332, 0.020833333333333332, 0.020833333333333332));
    }

    @Test
    public void checkIsoscelesTriangle() {
        Assert.assertTrue(Demo.isTriangle(5, 5, 6));
    }

    @Test
    public void checkRightTriangle() {
        Assert.assertTrue(Demo.isTriangle(3, 4, 5));
    }

    @Test
    public void checkValidTriangle_1() {
        Assert.assertTrue(Demo.isTriangle(5, 7, 3));
    }

    @Test
    public void checkValidTriangle_2() {
        Assert.assertTrue(Demo.isTriangle(13.5, 7.62, 11.377));
    }

    @Test
    public void checkValidTriangle_3() {
        Assert.assertTrue(Demo.isTriangle(1.52232323, 1.2565656565, 1.2484848484));
    }

    @Test
    public void checkInvalidTriangle_1() {
        Assert.assertFalse(Demo.isTriangle(5, 7, 20));
    }

    @Test
    public void checkInvalidTriangle_2() {
        Assert.assertFalse(Demo.isTriangle(5, 7, -20));
    }

    @Test
    public void checkInvalidTriangle_3() {
        Assert.assertFalse(Demo.isTriangle(0, 0, 0));
    }

    @Test
    public void checkInvalidTriangle_4() {
        Assert.assertFalse(Demo.isTriangle(10, 20, 0));
    }

    @Test
    public void checkInvalidTriangle_5() {
        Assert.assertFalse(Demo.isTriangle(-10, -20, -15));
    }

    @Test
    public void checkInvalidTriangle_6() {
        Assert.assertFalse(Demo.isTriangle(10, -20, 15));
    }

    @Test
    public void checkInvalidTriangle_7() {
        Assert.assertFalse(Demo.isTriangle(-0.020833333333333332, -0.020833333333333332, 0.020833333333333332));
    }

    @Test
    public void checkInvalidTriangle_8() {
        Assert.assertFalse(Demo.isTriangle(1, 2, 3));
    }

    @Test
    public void checkInvalidTriangle_9() {
        Assert.assertFalse(Demo.isTriangle(1, 2, 4));
    }

    @Test
    public void checkInvalidTriangle_10() {
        Assert.assertFalse(Demo.isTriangle(1, 6, 3));
    }

    @Test
    public void checkInvalidTriangle_11() {
        Assert.assertFalse(Demo.isTriangle(10, 2, 3));
    }

    //endregion
}
