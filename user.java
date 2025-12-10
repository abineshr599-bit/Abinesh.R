import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Default user (just for login testing)
        User defaultUser = new User("user123", "pass123", "User");

        System.out.println("=====================================");
        System.out.println("       LIBRARY MANAGEMENT SYSTEM      ");
        System.out.println("=====================================");

        System.out.println("\n1) LOGIN");
        System.out.println("2) REGISTER");
        System.out.print("\nChoose an option (1 or 2): ");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        if (choice == 1) {
            // LOGIN SECTION
            System.out.println("\n---------- LOGIN PAGE ----------");
            System.out.print("User Name: ");
            String uname = sc.nextLine();

            System.out.print("Password : ");
            String pass = sc.nextLine();

            if (uname.equals(defaultUser.getUsername()) && pass.equals(defaultUser.getPassword())) {
                System.out.println("\n✔ Login Successful! Welcome " + uname);
            } else {
                System.out.println("\n✖ Invalid Username or Password!");
            }

        } else if (choice == 2) {
            // REGISTER SECTION
            System.out.println("\n---------- REGISTER PAGE ----------");

            System.out.print("Enter New Username: ");
            String newUser = sc.nextLine();

            System.out.print("Enter New Password: ");
            String newPass = sc.nextLine();

            System.out.println("\n✔ Registration Successful!");
            System.out.println("You can now login using your new credentials.");

        } else {
            System.out.println("\n✖ Invalid Option! Try Again.");
        }

        System.out.println("\n-------------------------------------");
        System.out.println("For further information contact:");
        System.out.println("Admin Name : Abinesh R");
        System.out.println("Phone      : 9344040239");
        System.out.println("Email      : abineshr599@gmail.com");
        System.out.println("-------------------------------------");
    }
}