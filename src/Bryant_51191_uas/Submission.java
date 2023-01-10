//NAMA : BRYANT CHRISTOPHER HIHOLA
//NIM : 00000051191
package Bryant_51191_uas;

public class Submission {
    private String Details;
    private String Applied;
    private String Name;

    public Submission(String Details, String Applied, String Name) {
        this.Details = Details;
        this.Applied = Applied;
        this.Name = Name;
    }

    public void setApplied(String applied) {
        Applied = applied;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getApplied() {
        return Applied;
    }

    public String getDetails() {
        return Details;
    }

    public String getName() {
        return Name;
    }
}
