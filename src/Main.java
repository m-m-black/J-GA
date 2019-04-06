import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Thread {

    Population population;
    int popSize;
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
        System.out.println("System running...");
        try {
            while (!quit && (line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                String command = tokens[0];

                switch (command.toUpperCase()) {
                    case "PRINT":
                        System.out.println("You typed [print]");
                        break;
                    case "RUN":
                        System.out.println("You typed [run]");
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
}
