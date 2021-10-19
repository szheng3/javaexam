package JavaExam;

import java.util.Scanner;

public class UserName {
    private String XName;
    private String OName;

    public void inputName(Scanner in) {
        System.out.print("Enter Player X name: ");


        // Read user input and set X name
        setXName(in.nextLine());
        System.out.print("Enter Player O name: ");


        // Read user input and set O name
        setOName(in.nextLine());
    }

    public String getXName() {
        return XName;
    }

    public void setXName(String XName) {
        this.XName = XName;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }


}
