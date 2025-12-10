public class LinearRegression {

    private int [] valueX;
    private int [] valueY;
    private double intercepts;
    private double  slope;

    public int[] getvalueX() {
        return valueX;
    }

    public void setLength( int numberOfDataSet){
        valueX = new int [numberOfDataSet];
        valueY=  new int [numberOfDataSet];
    }

    public int[] getValueY() {
        return valueY;
    }

    public int[] setValueX(int[] values) {
        return valueX=values;
    }

    public int[] setValueY(int[] values) {
        return valueY=values;
    }

    public int FindSumOfValuesOfAnArray(int[] values) {
        int sum=0;
        for(int number:values){
            sum+=number;
        }
        return sum;
    }

    public int productOfElementsInArray(int[] values) {
        int product=1;
        for(int number:values){
            product*=number;
        }
        return product;
    }


    public int[] getSquaresOfNumbers(int[] values) {
        int count=0;
        int product = 2;
        int [] newArray=new int [values.length];
        for(int number:values){
            product=number*number;
            newArray[count++]=product;
        }
        return newArray;
    }

    public int[] getProductOfTwoArray(int[] values, int[] valuesY) {
        int [] newValue = new int [values.length];
        int sum = 0;
        int count = 0;
        for(int number:values){
            sum = valuesY[count]*number;
            newValue[count++]=sum;
        }
        return newValue;

    }

    public double getSlopeOfTwoArrays() {
        int sumOfY = FindSumOfValuesOfAnArray(valueY);
        int sumOfX = FindSumOfValuesOfAnArray(valueX);
        int sum = sumOfY*sumOfX;
        int[] product = getProductOfTwoArray(valueX,valueY);
        int productSum =FindSumOfValuesOfAnArray(product);
        int [] squareX = getSquaresOfNumbers(valueX);
        int sumX=FindSumOfValuesOfAnArray(valueX);
        int squareSumX = sumX*sumX;
        int squareXSum = FindSumOfValuesOfAnArray(squareX);
        return  (double) ((this.valueX.length * productSum) - sum) /((this.valueX.length*squareXSum)-squareSumX);
    }

    public double getIntercepts() {
        int sumOfY = FindSumOfValuesOfAnArray(valueY);
        int sumOfX = FindSumOfValuesOfAnArray(valueX);
        return (sumOfY-(getSlopeOfTwoArrays()*sumOfX))/(valueX.length);


    }

    public void getLinearExpression() {
        StringBuilder linearRegression = new StringBuilder();
        linearRegression.append(String.format("X\tY\tYn%n"));
        for(int i=0;i<valueX.length;i++){
            double bestFit = (getSlopeOfTwoArrays()*valueX[i])+getIntercepts();
            linearRegression.append(String.format("%s\t%s\t%s%n",valueX[i],valueY[i],bestFit));
        }
        IO.println(linearRegression.toString());
    }
}