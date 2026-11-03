
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read user inputs
        String name = scanner.next();
        double percentage = scanner.nextDouble();
        int backlogs = scanner.nextInt();
        int graduationYear = scanner.nextInt();

        // Create objects
        Candidate candidate = new Candidate(name, percentage, backlogs, graduationYear);
        Job job = new Job("Infosys", "Java Developer", 65.0, 0, 2026);

        // Store all rules in an array for polymorphic iteration
        EligibilityRule[] rules = {
            new PercentageRule(),
            new BacklogRule(),
            new GraduationYearRule()
        };

        boolean overallEligible = true;

        // Print Report Header
        System.out.println("================================");
        System.out.println("PLACEMENT ELIGIBILITY RESULT");
        System.out.println("================================");
        System.out.println();
        System.out.println("Candidate : " + candidate.getName());
        System.out.println("Company   : " + job.getCompany());
        System.out.println("Role      : " + job.getRole());
        System.out.println();

        // Evaluate each rule dynamically
        for (EligibilityRule rule : rules) {
            boolean passed = rule.check(candidate, job);

            if (!passed) {
                overallEligible = false;
            }

            String status = passed ? "PASS" : "FAIL";
            System.out.printf("%-15s : %s\n", rule.getRuleName(), status);
        }

        System.out.println();

        // Final verdict output
        if (overallEligible) {
            System.out.println("Final Result : ELIGIBLE");
        } else {
            System.out.println("Final Result : NOT ELIGIBLE");
        }

        System.out.println("================================");

        scanner.close();
    }
}
