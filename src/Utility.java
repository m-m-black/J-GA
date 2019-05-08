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
        for (int i = 0; i < 16; i++) {
            int start = (i * 4) + 1;
            int stop = (i + 1) * 4;
            int fragment = binToInt(chromosome, start, stop);
            phenotype += fragment;
            if (i < 15) {
                phenotype += " ";
            }
        }
        return phenotype;
    }

} // End of Utility class
