/*
    Use this class to define your application-specific fitness/cost function
 */

public class Cost {

    /*
    Binary matching cost function
     */
    public static void assess(Individual individual, int[] target) {
        // read Individual's DNA, calculate cost, update cost (stored in Individual)
        int[] chromosome = individual.getDna();
        int start, stop;
        double cost = 0; // start at 0, cost increases

        // Iterate over chromosome, store int value of each slice of bit string as 'temp'
        for (int i = 0; i < target.length; i++) {
            start = (i * 4) + 1;
            stop = (i + 1) * 4;
            double temp = Utility.binToInt(chromosome, start, stop);
            double targetValue = target[i];

            // Binary matching cost function
            if (temp != targetValue) {
                // Penalise notes that don't match the target
                cost++;
            }

            // Update cost value, stored in individual itself
            individual.setCost(cost);
        }
    }

    /*
    Absolute error cost function
     */
//    public static void assess(Individual individual, int[] target) {
//        int[] chromosome = individual.getDna();
//        int start, stop;
//        double cost = 0;
//
//        for (int i = 0; i < target.length; i++) {
//            start = (i * 4) + 1;
//            stop = (i + 1) * 4;
//            double temp = Utility.binToInt(chromosome, start, stop);
//            double targetValue = target[i];
//
//            double err = targetValue - temp;
//            double absErr = Math.sqrt(err * err);
//            // Increase cost based on total error between individual and target
//            cost += absErr;
//
//        individual.setCost(cost);
//    }

    /*
    Scale matching cost function
     */
//    public static void assess(Individual individual, int[] target) {
//        int[] chromosome = individual.getDna();
//        int start, stop;
//        double cost = 0;
//        /*
//        Make sure to un-comment the required scale, depending on the target
//         */
//        // Daytripper scale
//        int[] scale = {0, 1, 4, 5, 8, 11, 13, 15};
//        // Peer Gynt scale
//        //int[] scale = {0, 1, 2, 3, 4, 6, 7, 8, 11, 13};
//        int badNotes = 0;
//
//        for (int i = 0; i < target.length; i++) {
//            start = (i * 4) + 1;
//            stop = (i + 1) * 4;
//            double temp = Utility.binToInt(chromosome, start, stop);
//
//            if (!Utility.contains(temp, scale)) {
//                badNotes++;
//            }
//
//        cost = badNotes;
//
//        individual.setCost(cost);
//    }

    /*
    Note density cost function
     */
//    public static void assess(Individual individual, int[] target) {
//        int[] chromosome = individual.getDna();
//        int start, stop;
//        double cost = 0;
//        /*
//        Make sure to un-comment the required scale, depending on the target
//         */
//        // Daytripper scale
//        int[] scale = {0, 1, 4, 5, 8, 11, 13, 15};
//        // Peer Gynt scale
//        //int[] scale = {0, 1, 2, 3, 4, 6, 7, 8, 11, 13};
//        int badNotes = 0;
//        int restCount = 0;
//        int targetRestCount = 0;
//
//        for (int i = 0; i < target.length; i++) {
//            start = (i * 4) + 1;
//            stop = (i + 1) * 4;
//            double temp = Utility.binToInt(chromosome, start, stop);
//            double targetValue = target[i];
//
//            if (targetValue == 0) {
//                targetRestCount++;
//            }
//            if (temp == 0) {
//                restCount++;
//            }
//            if (temp == targetValue) {
//                // Penalise notes that match the target
//                badNotes++;
//            }
//            if (!Utility.contains(temp, scale)) {
//                // Penalise notes outside the scale
//                badNotes++;
//            }
//
//        double restErr = targetRestCount - restCount;
//        double absRestErr = Math.sqrt(restErr * restErr);
//        // Penalise individuals with different note densities
//        cost += absRestErr;
//        cost += badNotes;
//
//        individual.setCost(cost);
//    }

    /*
    Harmonise cost function
     */
//    public static void assess(Individual individual, int[] target) {
//        int[] chromosome = individual.getDna();
//        int start, stop;
//        double cost = 0;
//        /*
//        Make sure to un-comment the required scale, depending on the target
//         */
//        // Daytripper scale
//        int[] scale = {1, 4, 5, 8, 11, 13, 15};
//        // Peer Gynt scale
//        //int[] scale = {1, 2, 3, 4, 6, 7, 8, 11, 13};
//        int badNotes = 0;
//
//        for (int i = 0; i < target.length; i++) {
//            start = (i * 4) + 1;
//            stop = (i + 1) * 4;
//            double temp = Utility.binToInt(chromosome, start, stop);
//            double targetValue = target[i];
//
//            if (targetValue != 0) {
//                if (temp == targetValue) {
//                    // Penalise notes that match the target
//                    badNotes++;
//                } else if (temp != Utility.thirdDegree(targetValue, scale)) {
//                    // Penalise notes that don't harmonise with the target
//                    badNotes++;
//                } else if (!Utility.contains(temp, scale)) {
//                    // Penalise notes not in the scale
//                    badNotes++;
//                }
//            } else {
//                if (temp != 0) {
//                    // Penalise notes that should be rests
//                    badNotes++;
//                }
//            }
//        }
//
//        cost += badNotes;
//
//        individual.setCost(cost);
//    }

} // End of class Cost
