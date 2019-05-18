/*
    Use this class to define your application-specific fitness function
 */

public class Cost {

    // Static cost function, call on each Individual, will update cost value from this function
    public static void assess(Individual individual, int[] target) {
        // read Individual's DNA, calculate cost, update cost (stored in Individual)
        int[] chrom = individual.getDna();
        int start, stop;
        int cost = 0; // start at 0, cost increases

        // Iterate over chromosome, store int value of each slice of bit string as 'tmp'
        for (int i = 0; i < target.length; i++) {
            start = (i * 4) + 1;
            stop = (i + 1) * 4;
            double temp = Utility.binToInt(chrom, start, stop);
            double targetValue = target[i];

            // Binary matching cost function
            if (temp != targetValue) {
                cost++;
            }
        }

        // Update cost value, stored in individual itself
        individual.setCost(cost);
    }

} // End of class Cost
