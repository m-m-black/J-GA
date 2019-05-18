/*
    Use this class to define your application-specific fitness function
 */

public class Fitness {

    // Target musical phrase is hardcoded for now
    private static final int[] target = {1, 0, 0, 4, 5, 8, 13, 11, 0, 0, 8, 15, 0, 8, 11, 13};

    // Static fitness function, call on each Individual, will update fitness value from this function
    public static void assess(Individual individual, int[] target) {
        // read Individual's DNA, calculate fitness, update fitness (stored in Individual)
        int[] chrom = individual.getDna();
        int start, stop;
        int fitness = 0; // start at 0, fitness increases
        // Might need to change this to a cost minimisation function,
        // because mean error fitness function will be cost minimisation

        // Iterate over chromosome, store int value of each slice of bit string as 'tmp'
        for (int i = 0; i < 16; i++) {
            start = (i * 4) + 1;
            stop = (i + 1) * 4;
            double temp = Utility.binToInt(chrom, start, stop);
            double targetValue = target[i];

            // Binary matching fitness function
            if (temp == targetValue) {
                fitness++;
            }
        }

        // Update fitness value, stored in individual itself
        individual.setFitness(fitness);
    }

} // End of class Fitness
