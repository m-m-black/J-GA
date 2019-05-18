public class Utility {

    public static int binToInt(int[] bits, int from, int to) {
        String binaryString = "";
        // Iterate over slice of array [from - 1 ... to - 1]
        for (int i = from - 1; i < to; i++) {
            binaryString += bits[i];
        }
        int decimal = Integer.parseInt(binaryString, 2);
        return decimal;
    }

    public static String genoToPheno(int[] chromosome) {
        String phenotype = "";
        for (int i = 0; i < (chromosome.length / 4); i++) {
            int start = (i * 4) + 1;
            int stop = (i + 1) * 4;
            int fragment = binToInt(chromosome, start, stop);
            phenotype += fragment;
            if (i < (chromosome.length / 4) - 1) {
                phenotype += " ";
            }
        }
        return phenotype;
    }

    public static double map(double n, double oldMin, double oldMax, double newMin, double newMax) {
        return (newMax - newMin) * (n - oldMin) / (oldMax - oldMin) + newMin;
    }

} // End of Utility class
