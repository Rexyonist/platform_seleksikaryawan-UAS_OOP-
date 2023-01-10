//NAMA : BRYANT CHRISTOPHER HIHOLA
//NIM : 00000051191
package Bryant_51191_uas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<User> arrUser = new ArrayList<User>();
    static ArrayList<SearchJob> arrSearchJob = new ArrayList<SearchJob>();
    static ArrayList<Submission> arrSubmission = new ArrayList<Submission>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arrSearchJob.add(new SearchJob("UI/UX Designer", "Internship", "Designer", 2400000));
        arrSearchJob.add(new SearchJob("Customer Support", "Full Time", "Customer Service", 4000000));
        arrSearchJob.add(new SearchJob("Business Analyst", "Part Time", "Finance", 5000000));
        arrSearchJob.add(new SearchJob("Content Marketing", "Full Time", "Digital Marketing", 6500000));

        arrUser.add(new User("admin", "admin@admin.com", "admin", ""));
        arrUser.add(new User("rucci", "rucci@gmail.com", "rucci", ""));
        arrUser.add(
                new User("dimas", "dimas@gmail.com", "dimas", "Sudah melamar business analyst dan customer support"));
        arrUser.add(new User("loysing", "loysing", "loysing", "Sudah melamar ui/ux designer dan customer support"));

        System.out.println("Welcome to Linkon");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
        System.out.print("Pilihan : ");
        int pilihan1 = scan.nextInt();
        if (pilihan1 == 1) {
            Pil1();
        } else if (pilihan1 == 2) {
            Pil2();
        } else if (pilihan1 == 3) {
            System.out.println("exit program ...");
            System.exit(0);
        } else {
            System.out.println("Pilihan tidak ada");
        }
    }

    public static void Pil1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Login ===");
        System.out.print("Email : ");
        String email = scan.next();
        System.out.print("Password : ");
        String password = scan.next();
        for (int i = 0; i < arrUser.size(); i++) {
            if (arrUser.get(i).getEmail().equals(email) && arrUser.get(i).getPassword().equals(password)) {
                String inputEmail = String.valueOf(email.contains("@admin.com"));
                if (inputEmail.equals("true")) {
                    DashboardAdmin(arrUser.get(i));
                } else {
                    DashboardUser(arrUser.get(i));
                }
                break;
            }
        }
    }

    public static void Pil2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Sign Up ===");
        System.out.print("Nama : ");
        String nama = scan.next();
        System.out.print("Email : ");
        String email = scan.next();
        System.out.print("Password : ");
        String password = scan.next();
        arrUser.add(new User(nama, email, password, "Belum Melamar"));
        System.out.println("Sign Up Berhasil\n");
        Pil1();
    }

    public static void DashboardAdmin(User User) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("=== Dashboard Admin ===");
            System.out.println("1. Submissions");
            System.out.println("2. Send Email");
            System.out.println("3. Logout");
            System.out.print("Pilihan : ");
            int pilihan2 = scan.nextInt();
            if (pilihan2 == 1) {
                Submissions(User);
            } else if (pilihan2 == 2) {
                SendEmail(User);
            } else if (pilihan2 == 3) {
                Logout();
            }
        }

    }

    public static void SendEmail(User User) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("=== Menu Send Email ===");

            System.out.print("To : ");
            String to = scan.next();
            for (int i = 0; i < arrSubmission.size(); i++) {
                if (!arrSubmission.get(i).getName().equals(to)) {
                    System.out.println("nama yang dituju tidak ada");
                }
            }
            System.out.println("Daftar Pekerjaan yang di apply: ");
            for (int i = 0; i < arrSubmission.size(); i++) {
                if (arrSubmission.get(i).getName().equals(to)) {
                    System.out.println("Job ID : " + (i + 1) + " - " + arrSubmission.get(i).getApplied());
                }
            }
            System.out.print("Choose Job id: ");
            int jobId = scan.nextInt();
            System.out.println("add Details");
            System.out.println("1. Lolos");
            System.out.println("2. Tidak Lolos");
            System.out.print("Pilihan : ");
            int pilihan3 = scan.nextInt();
            if (pilihan3 == 1) {
                arrSubmission.get(jobId - 1)
                        .setDetails("Congratulation, you being advanced to step 2 : interview process");
            } else if (pilihan3 == 2) {
                arrSubmission.get(jobId - 1).setDetails(
                        "unfortunately, based on the result we will not be advancing your application to the next step");
            }
        }
        System.out.println("Email Sent!!");

    }

    public static void Submissions(User User) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nMenu Submission\n");
        for (int i = 0; i < arrSubmission.size(); i++) {
            System.out.print(
                    (i + 1) + ". " + arrSubmission.get(i).getName() + " - " + arrSubmission.get(i).getApplied() + "\n");
        }
    }

    public static void DashboardUser(User User) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Menu Kandidat ===");
            System.out.println("Welcome " + User.getNama());
            System.out.println("1. Search Job");
            System.out.println("2. Apply Job");
            System.out.println("3. Submission");
            System.out.println("4. Logout");
            System.out.print("Pilihan : ");
            int pilihan2 = scan.nextInt();
            if (pilihan2 == 1) {
                SearchJob();
            } else if (pilihan2 == 2) {
                ApplyJob(User);
            } else if (pilihan2 == 3) {
                Submission(User);
            } else if (pilihan2 == 4) {
                Logout();
            }
        }

    }

    public static void Logout() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Logout success");
        System.out.println("return to main menu");
        main(null);
    }

    public static void Submission(User User) {
        Scanner scan = new Scanner(System.in);
        int a = 0;
        System.out.println("=== Submission ===");
        for (int i = 0; i < arrSubmission.size(); i++) {
            if (arrSubmission.get(i).getName().equals(User.getNama())) {
                a = 1;
                System.out.println((i + 1) + ". you applied for " + arrSubmission.get(i).getApplied());
                System.out.println("Details : " + arrSubmission.get(i).getDetails());
            }
        }
        if (a == 0) {
            System.out.println("You have not applied for any job");
        }
    }

    public static void ApplyJob(User User) {
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Apply Job ===");
        System.out.print("name : " + User.getNama());
        System.out.print("\neducation : ");
        String education = scan.next();
        System.out.print("position you want to apply (1-4) : ");
        int position = scan.nextInt();
        String posisi = arrSearchJob.get(position - 1).getJobTitle();
        arrSubmission.add(new Submission("Waiting for respond from HRD\n", posisi, User.getNama()));
        System.out.println("Thankyou for applying");
    }

    public static void SearchJob() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arrSearchJob.size(); i++) {
            System.out.println("Id : " + (i + 1));
            System.out.println("Job Title : " + arrSearchJob.get(i).getJobTitle());
            System.out.println("Job Type : " + arrSearchJob.get(i).getJobType());
            System.out.println("Job Category : " + arrSearchJob.get(i).getJobCategory());
            System.out.println("qualification : " + arrSearchJob.get(i).getSalary());
            System.out.println("-----------------------------------------------------");
        }
    }
}