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

} // End of Utility class
