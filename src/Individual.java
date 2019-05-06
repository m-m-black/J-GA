import java.util.Random;

public class Individual {

    private DNA dna;
    private double fitness;

    public Individual(int chromosomeLength) {
        this.dna = new DNA(chromosomeLength);
        this.fitness = 0.0;
    }

    public Individual() {
        // Create new empty Individual
        this.dna = null;
        this.fitness = 0.0;
    }

    public double getFitness() {
        return fitness;
    }

    public Individual crossover(Individual partner, int chromosomeLength, double mutationRate) {
        // Initialise empty Individual as child
        Individual child = new Individual();
        Random random = new Random();
        int midpoint = random.nextInt(chromosomeLength);
        int[] chromosome = this.getDna();
        int[] partnerChromosome = partner.getDna();
        int[] childChromosome = new int[chromosomeLength];
        // Set bits from parents, split at random midpoint
        for (int i = 0; i < chromosome.length; i++) {
            if (i > midpoint) {
                childChromosome[i] = chromosome[i];
            } else {
                childChromosome[i] = partnerChromosome[i];
            }
        }
        // Assign child this new DNA
        child.setDNA(new DNA(childChromosome));
        child.mutate(mutationRate);
        return child;
    }

    public void mutate(double mutationRate) {
        Random random = new Random();
        int[] chromosome = this.getDna();
        // Iterate over chromosome, flipping bits if we exceed the mutation threshold
        for (int i = 0; i < chromosome.length; i++) {
            if (random.nextDouble() < mutationRate) {
                if (chromosome[i] == 0) {
                    chromosome[i] = 1;
                } else {
                    chromosome[i] = 0;
                }
            }
        }
        this.setDNA(new DNA(chromosome));
    }

    public int[] getDna() {
        return dna.getChromosome();
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void setDNA(DNA dna) {
        this.dna = dna;
    }

} // End of class Individual
