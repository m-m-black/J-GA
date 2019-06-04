public class Utility {

    // Convert bit string to integer
    public static int binToInt(int[] bits, int from, int to) {
        String binaryString = "";
        // Iterate over slice of array [from - 1 ... to - 1]
        for (int i = from - 1; i < to; i++) {
            binaryString += bits[i];
        }
        int decimal = Integer.parseInt(binaryString, 2);
        return decimal;
    }

    // Convert full binary chromosome to String
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

    // Map number from one range to another
    public static double map(double n, double oldMin, double oldMax, double newMin, double newMax) {
        return (newMax - newMin) * (n - oldMin) / (oldMax - oldMin) + newMin;
    }

    // Check if an array contains a value
    public static boolean contains(double n, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }

    // Get the 3rd harmony of a note
    public static int thirdDegree(double n, int[] array) {
        int degree = 0;
        int interimDegree = 0;
        int thirdDegree = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                degree = i;
                break;
            }
        }
        interimDegree = degree + 2;
        if (interimDegree >= array.length) {
            int diff = Math.abs(array.length - interimDegree);
            thirdDegree = 0 + diff;
        } else {
            thirdDegree = interimDegree;
        }
        return array[thirdDegree];
    }

} // End of Utility class
