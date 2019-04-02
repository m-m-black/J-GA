public class Individual {

    private DNA dna;
    private double fitness;

    public Individual() {
        this.dna = new DNA();
        this.fitness = 0.0;
    }

    public double getFitness() {
        return fitness;
    }

    public Individual crossover(Individual partner) {
        return null;
    }

    public void mutate(double mutationRate) {

    }

}
