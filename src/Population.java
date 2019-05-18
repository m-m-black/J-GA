import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Population {

    Individual[] population;
    ArrayList<Individual> matingPool;
    int chromosomeLength;
    double crossoverRate;
    double mutationRate;
    PrintWriter fileOutput;
    int[] target;
    int maxCost;

    public Population(int popSize, int chromosomeLength, double crossoverRate, double mutationRate, int[] target) {
        this.population = new Individual[popSize];
        this.matingPool = new ArrayList<>();
        this.chromosomeLength = chromosomeLength;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.target = target;
        // Max Cost will change based on fitness function used
        maxCost = setMaxCost();
        initPop(popSize, chromosomeLength);
        try {
            this.fileOutput = new PrintWriter(new FileWriter(new File("lines.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // User-specified maximum cost for each individual
    private int setMaxCost() {
        // For binary matching cost function
        //maxCost = target.length;
        // For absolute error cost function
        maxCost = (target.length * 16);
        return maxCost;
    }

    private void initPop(int popSize, int chromosomeLength) {
        // Populate population with Individuals
        for (int i = 0; i < popSize; i++) {
            population[i] = new Individual(chromosomeLength);
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
            // assess cost of each Individual
            Individual bestIndividual = assessCost();
            // perform selection
            select();
            // perform crossover
            reproduce(chromosomeLength, crossoverRate, mutationRate);
            // Output bit string and cost of best individual each generation
            String phenotype = Utility.genoToPheno(bestIndividual.getDna());
            fileOutput.println(phenotype);
            System.out.println("Generation " + i + ", best cost: " + bestIndividual.getCost());
            System.out.println("Chromosome: " + phenotype);
        }
        fileOutput.close();
    }

    private Individual assessCost() {
        double minCost = maxCost;
        Individual bestIndividual = null;
        for (Individual i: population) {
            // Call the user-defined cost function on each individual
            Cost.assess(i, target);
            double cost = i.getCost();
            if (cost < minCost) {
                minCost = cost;
                bestIndividual = i;
            }
        }
        return bestIndividual;
    }

    private void select() {
        // Build mating pool
        matingPool.clear();
        for (Individual i: population) {
            // Add each Individual to the mating pool n times according to its cost score
            // Cost is scaled so low costs result in more additions to the pool
            int n = (int) Utility.map(i.getCost(), 0, maxCost, maxCost, 0) * 100;
            for (int j = 0; j < n; j++) {
                matingPool.add(i);
            }
        }
        System.out.println(matingPool.size());
    }

    private void reproduce(int chromosomeLength, double crossoverRate, double mutationRate) {
        // Set crossover point in population based on crossover rate
        // Select 2 parents from mating pool and perform crossover, while i < crossover point
        // Copy best fit individuals from mating pool once i >= crossover point
        // Mutation occurs in crossover function in Individual class
        int crossoverPoint = (int) (population.length * crossoverRate);
        Random random = new Random();
        for (int i = 0; i < population.length; i++) {
            if (i < crossoverPoint) {
                int a = random.nextInt(matingPool.size());
                int b = random.nextInt(matingPool.size());
                Individual parentA = matingPool.get(a);
                Individual parentB = matingPool.get(b);
                Individual child = parentA.crossover(parentB, chromosomeLength, mutationRate);
                population[i] = child;
            } else {
                int a = random.nextInt(matingPool.size());
                Individual child = matingPool.get(a);
                child.mutate(mutationRate);
                population[i] = child;
            }
        }
    }

} // End of class Population
