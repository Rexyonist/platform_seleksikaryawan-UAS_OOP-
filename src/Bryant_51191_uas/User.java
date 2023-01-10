//NAMA : BRYANT CHRISTOPHER HIHOLA
//NIM : 00000051191
package Bryant_51191_uas;

public class User {
    private String nama;
    private String email;
    private String password;
    private String Status;

    public User(String nama, String email, String password, String Status) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.Status = Status;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return Status;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
