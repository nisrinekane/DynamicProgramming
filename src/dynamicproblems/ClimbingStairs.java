package dynamicproblems;

public class ClimbingStairs {
    public int climbStairs(int totalSteps) {
        if (totalSteps <= 1) {
            return 1;
        }

        // array to store # ways to reach each step
        int[] numberOfWaysToStep = new int[totalSteps + 1];

        // base cases, 0 steps and 1 step
        numberOfWaysToStep[0] = 1;
        numberOfWaysToStep[1] = 1;

        // since we have base cases, intialize from step 2 + calculate/update # of ways to reach each step
        for (int currentStep = 2; currentStep <= totalSteps; currentStep++) {
            numberOfWaysToStep[currentStep] = numberOfWaysToStep[currentStep - 1] + numberOfWaysToStep[currentStep - 2];
        }
        return numberOfWaysToStep[totalSteps];
    }
}