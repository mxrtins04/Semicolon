import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearRegressionTest {
    LinearRegression linearRegression;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        linearRegression = new LinearRegression();
        linearRegression.setLength(6);
    }

    @Test
    void arraysThatConatainsElementsCanBeLengthCanBeDetermined(){

        assertEquals(6,linearRegression.getvalueX().length);
        assertEquals(6,linearRegression.getValueY().length);
    }

    @Test
    void setTheValuesOfValueX(){
        int [] values={10,12,15,20,14,27};
        assertArrayEquals(values,linearRegression.setValueX(values));
        assertArrayEquals(values,linearRegression.setValueY(values));
    }

    @Test
    void findTheSumOfValuesInValueX(){
        int [] values={1,2,3,4,5,6};
        assertEquals(21,linearRegression.FindSumOfValuesOfAnArray(values));
    }

    @Test
    void findTheProductOfValuesInValueXOrY(){
        int [] values={1,2,3,4,5,6};
        assertEquals(720,linearRegression.productOfElementsInArray(values));
    }

    @Test
    void findTheSquareOfValuesInValueXAndY(){
        int [] values={1,2,3,4,5,6};
        int [] expected = {1,4,9,16,25,36};
        assertArrayEquals(expected,linearRegression.getSquaresOfNumbers(values));
    }

    @Test
    void  findTheSumOfSquareOfValuesInValueXAndY(){
        int [] values={1,2,3,4,5,6};
        int [] expected = {1,4,9,16,25,36};
        assertArrayEquals(expected,linearRegression.getSquaresOfNumbers(values));
        assertEquals(91,linearRegression.FindSumOfValuesOfAnArray(expected));
    }

    @Test
    void findTheProductOfValuesInValueXAndY( ){
        int [] values={1,2,3,4,5,6};
        int [] valuesY = {1,4,9,16,25,36};
        int [] expected = {1,8,27,64,125,216};
        assertArrayEquals(expected,linearRegression.getProductOfTwoArray( values,valuesY));

    }

    @Test
    void findTheSlopeOfValuesInXAndY(){
        linearRegression.setLength(4);
        int [] values={1,2,3,4};
        linearRegression.setValueX(values);
        int [] valuesY = {40,55,65,80};
        linearRegression.setValueY(valuesY);
        assertEquals(13,linearRegression.getSlopeOfTwoArrays());

    }

    @Test
    void findTheInterceptsofValuesInXAndY(){
        linearRegression.setLength(4);
        int [] values={1,2,3,4};
        linearRegression.setValueX(values);
        int [] valuesY = {40,55,65,80};
        linearRegression.setValueY(valuesY);
        assertEquals(27.5,linearRegression.getIntercepts(),1e-9);
    }

    @Test
    void findLinearRegrression(){
        linearRegression.setLength(4);
        int [] values={1,2,3,4};
        linearRegression.setValueX(values);
        int [] valuesY = {40,55,65,80};
        linearRegression.setValueY(valuesY);
        String expected = """
    X   Y   Yn
    1   40  40.5
    2   55  53.5
    3   65  66.5
    4   80  79.5
    """;
    }




}