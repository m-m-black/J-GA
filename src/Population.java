public class Population {

    Individual[] population;

    public Population(int popSize, int chromosomeLength) {
        this.population = new Individual[popSize];
        initPop(popSize, chromosomeLength);
    }

    private void initPop(int popSize, int chromosomeLength) {
        // Populate population with Individuals
        for (int i = 0; i < popSize; i++) {
            population[i] = new Individual(chromosomeLength);
        }
    }

}
