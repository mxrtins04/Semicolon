public class Problem{
	private String problemName;
	private String problemType;
	private Boolean status = false;

	public Problem(String problemTypeAns, String problem){
		ProblemType problemTypeAns= ProblemType.problemTypeAns;
		this.problemType = problemTypeAns;

		this.problemName = problem;
	}

	public void changeStatus(boolean status){
	this.status = status;
}
	public String getProblemName(){
		return problemName;
	}

	public String getProblemType(){
		return problemType;
	}

	public boolean getProblemStatus(){
		return status;
	}
	public String return 
	
}