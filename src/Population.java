import java.util.ArrayList;
import java.util.Random;

public class Population {

    Individual[] population;
    ArrayList<Individual> matingPool;
    int chromosomeLength;
    double mutationRate;

    public Population(int popSize, int chromosomeLength, double mutationRate) {
        this.population = new Individual[popSize];
        this.matingPool = new ArrayList<Individual>();
        this.chromosomeLength = chromosomeLength;
        this.mutationRate = mutationRate;
        initPop(popSize, chromosomeLength);
    }

    private void initPop(int popSize, int chromosomeLength) {
        // Populate population with Individuals
        for (int i = 0; i < popSize; i++) {
            population[i] = new Individual(chromosomeLength);
        }
    }

    public void printPop() {
        for (Individual i: population) {
            for (int d: i.getDna()) {
                System.out.print(d);
            }
            System.out.println();
        }
    }

    private String buildBitString(int[] chromosome) {
        String bitString = "";
        for (int i: chromosome) {
            bitString += i;
        }
        return bitString;
    }

    public void evolve(int genNum) {
        for (int i = 0; i < genNum; i++) {
            // assess fitness of each Individual
            Individual bestIndividual = assessFitness();
            // perform selection
            select();
            // perform crossover
            reproduce(chromosomeLength, mutationRate);
            // Output bit string and fitness of best individual each generation
            String bitString = buildBitString(bestIndividual.getDna());
            System.out.println("Chromosome: " + bitString + "\tFitness: " + bestIndividual.getFitness());
        }
    }

    private Individual assessFitness() {
        double maxFitness = 0.0;
        Individual bestIndividual = null;
        for (Individual i: population) {
            Fitness.assess(i);
            double fitness = i.getFitness();
            if (fitness > maxFitness) {
                maxFitness = fitness;
                bestIndividual = i;
            }
        }
        return bestIndividual;
    }

    private void select() {
        // Build mating pool
        matingPool.clear();
        for (Individual i: population) {
            // Add each Individual to the mating pool n times according to its fitness score
            int n = (int) i.getFitness() * 100;
            for (int j = 0; j < n; j++) {
                matingPool.add(i);
            }
        }
    }

    private void reproduce(int chromosomeLength, double mutationRate) {
        // Select 2 parents from mating pool and perform crossover
        // Mutation occurs in crossover function in Individual class
        // Population is replaced by children in this scheme
        Random random = new Random();
        for (int i = 0; i < population.length; i++) {
            int a = random.nextInt(matingPool.size());
            int b = random.nextInt(matingPool.size());
            Individual parentA = matingPool.get(a);
            Individual parentB = matingPool.get(b);
            Individual child = parentA.crossover(parentB, chromosomeLength, mutationRate);
            population[i] = child;
        }
    }

} // End of class Population
