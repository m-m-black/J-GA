import java.util.ArrayList;

public class Population {

    Individual[] population;
    ArrayList<Individual> matingPool;

    public Population(int popSize, int chromosomeLength) {
        this.population = new Individual[popSize];
        this.matingPool = new ArrayList<Individual>();
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

    public void evolve(int genNum) {
        for (int i = 0; i < genNum; i++) {
            // assess fitness of each Individual
            assessFitness();
            // perform selection
            select();
            // perform crossover
            crossover();
        }
    }

    private void assessFitness() {
        for (Individual i: population) {
            Fitness.assess(i);
        }
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

    private void crossover() {
        // Select 2 parents from mating pool and perform crossover
        // Mutation occurs in crossover function in Individual class
    }

    private void mutate() {

    }

} // End of class Population
