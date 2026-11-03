
public class EligibilityChecker {

    // Evaluates an array of rules against a candidate and a job
    public static boolean evaluate(Candidate candidate, Job job, EligibilityRule[] rules) {
        boolean overallEligible = true;

        System.out.println("================================");
        System.out.println("PLACEMENT ELIGIBILITY RESULT");
        System.out.println("================================");
        System.out.println();
        System.out.println("Candidate : " + candidate.getName());
        System.out.println("Company   : " + job.getCompany());
        System.out.println("Role      : " + job.getRole());
        System.out.println();

        // Loop through each rule polymorphically
        for (EligibilityRule rule : rules) {
            boolean passed = rule.check(candidate, job);

            if (!passed) {
                overallEligible = false;
            }

            String status = passed ? "PASS" : "FAIL";
            System.out.printf("%-15s : %s\n", rule.getRuleName(), status);
        }

        System.out.println();

        if (overallEligible) {
            System.out.println("Final Result : ELIGIBLE");
        } else {
            System.out.println("Final Result : NOT ELIGIBLE");
        }

        System.out.println("================================");

        return overallEligible;
    }
}
