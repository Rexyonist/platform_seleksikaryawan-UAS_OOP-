//NAMA : BRYANT CHRISTOPHER HIHOLA
//NIM : 00000051191
package Bryant_51191_uas;

public class SearchJob {
    private String JobTitle;
    private String JobType;
    private String JobCategory;
    private int Salary;

    public SearchJob(String JobTitle, String JobType, String JobCategory, int Salary) {
        this.JobTitle = JobTitle;
        this.JobType = JobType;
        this.JobCategory = JobCategory;
        this.Salary = Salary;
    }

    public int getSalary() {
        return Salary;
    }

    public String getJobCategory() {
        return JobCategory;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobCategory(String jobCategory) {
        JobCategory = jobCategory;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
