import java.util.Random;

public class DNA {

    private int[] chromosome;

    public DNA(int chromosomeLength) {
        this.chromosome = initChromosome(chromosomeLength);
    }

    private int[] initChromosome(int chromosomeLength) {
        int[] chromosome = new int[chromosomeLength];
        // Randomly initialise each bit
        Random random = new Random();
        for (int i = 0; i < chromosomeLength; i++) {
            Double d = Math.floor(random.nextDouble()*2);
            chromosome[i] = d.intValue();
        }
        return chromosome;
    }

    public int[] getChromosome() {
        return chromosome;
    }

} // End of class DNA
