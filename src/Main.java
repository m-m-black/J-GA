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

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    boolean quit = false;

    @Override
    public void run() {
        // Show menu, initialise parameters from user input, perform runs
        System.out.println("RUN [pop. size] [gen. number] [crossover] [mutation] -> run a single simulation\n" +
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
                        // Initialise the Population
                        Population population = new Population(popSize, 64, crossoverRate, mutationRate);
                        // Perform genNum generations of evolution
                        population.evolve(genNum);
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

} // End of class Main
