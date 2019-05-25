import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Thread {

    Population population;
    int popSize;
    int genNum;
    int chromosomeLength;
    int fieldSize;
    double crossoverRate;
    double mutationRate;
    int[] target;

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    boolean quit = false;

    @Override
    public void run() {
        // Show menu, initialise parameters from user input, perform runs
        System.out.println("RUN [pop. size] [gen. number] [crossover] [mutation] [target] -> run a single simulation\n" +
                "QUIT -> exit the program");
        try {
            while (!quit && (line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                String command = tokens[0];

                switch (command.toUpperCase()) {
                    case "PRINT":
                        System.out.println("You typed [print]");
                        break;
                    case "RUN":
                        popSize = Integer.parseInt(tokens[1]);
                        genNum = Integer.parseInt(tokens[2]);
                        crossoverRate = Double.parseDouble(tokens[3]);
                        mutationRate = Double.parseDouble(tokens[4]);
                        target = setTarget(tokens[5].toLowerCase());
                        chromosomeLength = target.length * 4;
                        // Initialise the Population
                        Population population = new Population(popSize, chromosomeLength, crossoverRate, mutationRate, target);
                        // Perform genNum generations of evolution
                        //population.evolve(genNum);
                        // Evolve until convergence
                        population.evolve();
                        break;
                    case "QUIT":
                        quit = true;
                        break;
                    default:
                        System.out.println("Unknown command");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[] setTarget(String targetName) {
        int[] dt = {1, 0, 0, 4, 5, 8, 13, 11, 0, 0, 8, 15, 0, 8, 11, 13};
        int[] pg = {1, 3, 4, 6, 8, 4, 8, 0, 7, 3, 7, 0, 6, 2, 6, 0, 1, 3, 4, 6, 8, 4, 8, 13, 11, 8, 4, 8, 11, 0, 0, 0};
        if (targetName.equals("dt")) {
            return dt;
        } else if (targetName.equals("pg")) {
            return pg;
        } else {
            return null;
        }
    }

} // End of class Main
