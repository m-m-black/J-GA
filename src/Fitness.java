public class Fitness {

    private static final int[] target = {1, 0, 0, 4, 5, 8, 13, 11, 0, 0, 8, 15, 0, 8, 11, 13};

    public static void assess(Individual individual) {
        // read Individual's DNA, calculate fitness, update fitness (stored in Individual)
        int[] chrom = individual.getDna();

        int start, stop;

        // Iterate over chromosome, store int value of each slice of bit string as 'tmp'
        for (int i = 0; i < 16; i++) {
            start = (i * 4) + 1;
            stop = (i + 1) * 4;
            double tmp = Utility.binToInt(chrom, start, stop);
        }
    }

} // End of class Fitness
