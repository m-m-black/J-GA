public class Utility {

    public static int binToInt(int[] bits) {
        String binaryString = "";
        for (int i = 0; i < bits.length; i++) {
            binaryString += bits[i];
        }
        int decimal = Integer.parseInt(binaryString, 2);
        return decimal;
    }

} // End of Utility class
