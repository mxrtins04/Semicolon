import java.util.Scanner;

public class TriangleArea{
public static void main (String[ ] args){
Scanner input = new Scanner(System.in);
System.out.print("Enter Triangle points i.e x1 y1 x2 y2 x3 y3: ");
double x1 = input.nextDouble();
double y1 = input.nextDouble();
double x2 = input.nextDouble();
double y2 = input.nextDouble();
double x3 = input.nextDouble();
double y3= input.nextDouble();

// Finding the length of each side of the triangle from the the points given using pythagoras theorem(i.e the square root of (x2 - x1)^2 + (y2 - y1)^2)//
double a1 = (x2 - x1) * (x2 - x1);
double b1 = (y2 - y1) * (y2 - y1);

double sum1 = a1 + b1;
double s1 = Math.sqrt(sum1);

double a2 = (x3 - x2) * (x3 - x2);
double b2 = (y3 - y2) * (y3 - y2);

double sum2 = a2 + b2;
double s2 = Math.sqrt(sum2);

double a3 = (x1 - x3) * (x1 - x3);
double b3 = (y1 - y3) * (y1 - y3);

double sum3 = a3 + b3;
double s3 = Math.sqrt(sum3);

double S = (s1 + s2 + s3) / 2;

double area = Math.sqrt(S * (S - s1) * (S - s2) * (S - s3) );

System.out.printf("The area of the triangle is %f%n", area);

}}
