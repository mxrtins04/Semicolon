import java.util.ArrayList;

public class Person(){
	private ArrayList<Problem> problems = new ArrayList<>();

	public void addProblem(Problem problem){
		problems.add(problem);
	}
	
	public void solveProblem(Problem problem){
		problem.isSolved? = true;
	}
	
	public ArrayList<String> tellProblem(ArrayList<Problem> problems){
		ArrayList<Problem> unsolvedProblems = new ArrayList<>();

		for( Problem problem : problems ){
			if problem.isSolved? == true;
			unsolvedProblems.add(problem);
		}
		return unsolvedProblems;
	}
}

	