/*
- Print the header: N N2 N3 N4
- Initialize n to 1
- While n is less than or equal to 5:
. Initialize nSquare and let it be equal to n * n
. Initialize nCube and let it be equal to n * n * n
. Initialize nR4 and let it be equal to n * n * n *n
. Print n, nSquare, nCube, and nR4 in one line
. Increase n by 1
*/

public class TabularOutput {
public static void main(String [] args) {
	System.out.println("N	N2	N3	N4");

	int n = 1;

	while (n <=5){
		int nSquare = n * n;
		int nCube = n * n * n;
		int nR4 = n * n * n * n;

		System.out.printf("%d	%d	%d	%d%n", n, nSquare, nCube, nR4);

		n++;
		}
	}
}