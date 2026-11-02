import java.util.Scanner;
public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        double percentage = sc.nextDouble();
        int backlogs = sc.nextInt();
        int graduationYear = sc.nextInt();

        System.out.println("Candidate: " + name);
        System.out.println("Percnetage: " + percentage);
        System.out.println("Bacl=klogs: " + backlogs);
        System.out.println("Graduation Year: " + graduationYear);

        sc.close();
    }
}
