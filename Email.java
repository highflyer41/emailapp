import java.util.Scanner;

public class Email {
    
    private String email, firstName, lastName, password, department, alternateEmail, companySuffix = "wayneindustries.com";
    private int mailboxCapacity = 500, defaultPassLength = 10;

    //contructor taking first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //sets the department by calling a method to ask for department
        this.department = setDepartment();
        System.out.println("DEPARTMENT: " + department);

        //call a method to genereate a random password
        this.password = randomPassword(defaultPassLength);
        System.out.println("Your password: " + password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    //method to generate password
    public String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i < length; i++) {
            int rand = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public String getDepartment() {
        return department;
    }

    //method to ask for department
    public String setDepartment() {
        System.out.print("New Worker: " + firstName + "DEPARTMENT CODES: \n1 for Sales \n2 for Development \n3 for Accounting \nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        in.close();
        if(choice == 1) { return "sales"; }
        else if(choice == 2) { return "dev"; }
        else if(choice == 3) { return "acct"; }
        else { return ""; }
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String showInfo() {
        return String.format("NAME: %s %s\nEMAIL: %s\nMAILBOX CAPACITY: %dmb", firstName, lastName, email, mailboxCapacity);
    }

}