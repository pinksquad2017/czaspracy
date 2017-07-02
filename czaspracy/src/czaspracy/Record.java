package czaspracy;

public class Record {
	
	
	private String name;
	private String taskName;
	private double taskDuration;
	private String project;
	private String day;
	private String month;
	private String year;

	public Record(){
		
	}


	public String getName() {
		return this.name;
	}


	public void setName(String firstName) {
		this.name = firstName;
	}


	public String getTaskName() {
		return this.taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public double getTaskDuration() {
		return this.taskDuration;
	}


	public void setTaskDuration(double taskDuration) {
		this.taskDuration = taskDuration;
	}


	public String getProject() {
		return this.project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public String getDay() {
		return this.day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getMonth() {
		return this.month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getYear() {
		return this.year;
	}


	public void setYear(String year) {
		this.year = year;
	}
	
	public void printRecord() {
		System.out.println(name);
	}
	

}
