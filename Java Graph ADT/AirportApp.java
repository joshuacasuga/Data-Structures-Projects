
//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: The airport application that reads the airports.csv and distances.csv files;
//  inserts the data into vertices and edges to create a directed graph; contains a menu that 
//  takes in commands that display the desired data. 
//
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class AirportApp {
    public static void main(String[] args) throws IOException {
        BufferedReader airportsFile = new BufferedReader(new FileReader("airports.csv"));
        BufferedReader distancesFile = new BufferedReader(new FileReader("distances.csv"));
        Map<String, AirportInfo> airportTable = new HashMap<>();
        Digraph<String> digraph = new Digraph<>();

        // reads airports.csv file, maps airport codes to airport info
        try {
            String line = null;
            while ((line = airportsFile.readLine()) != null) {
                String[] info = line.split(",");
                AirportInfo airportInfo = new AirportInfo(info[0], info[1], info[2], info[3]);
                // System.out.println(airportInfo);
                airportTable.put(info[0], airportInfo);
                digraph.addVertex(info[0]);
            }
            airportsFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // reads distances.csv file
        try {
            String line = null;
            while ((line = distancesFile.readLine()) != null) {
                String[] data = line.split(",");
                Vertex<String> vertex1 = new Vertex<>(data[1]);
                Vertex<String> vertex2 = new Vertex<>(data[0]);
                vertex1.setPredecessor(vertex2);
                vertex1.setCost(Double.parseDouble(data[2]));
                vertex1.connect(vertex2, vertex1.getCost());
                // System.out.println(vertex1.getPredecessor().getLabel() + " " +
                // vertex1.getLabel() + " " + vertex1.getCost());
                digraph.addEdge(data[0], data[1], Double.parseDouble(data[2]));

                /*
                 * testing
                 * Stack<String> test = new Stack<>();
                 * digraph.getCheapestPath(data[0], data[1], test);
                 * System.out.println(digraph.hasEdge(data[0], data[1]));
                 * System.out.println(digraph.getCheapestPath(data[0], data[1], test));
                 */
            }
            distancesFile.close();
            // System.out.println(digraph.getNumberOfVertices());
            // System.out.println(digraph.getNumberOfEdges());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // begin menu code
        System.out.println("Airports v0.1 by J. Casuga" + "\n");

        Scanner userInputScanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("Command? ");
            command = userInputScanner.next();
            switch (command.toUpperCase()) {
                case "H":
                    System.out.println("Q Query the airport information by entering the airport code.");
                    System.out.println("D Find the minimum distance between two airports.");
                    System.out.println("E Exit.");
                    System.out.println();
                    break;

                case "Q":
                    String input = userInputScanner.nextLine().toUpperCase();
                    String[] inputArr = input.split(" ");
                    for (int i = 1; i < inputArr.length; i++) {
                        String code = inputArr[i];
                        if (airportTable.containsKey(code)) {
                            System.out.println(code + " - " + airportTable.get(code));
                        } else if (!airportTable.containsKey(code)) {
                            System.out.println(code + " - unknown");
                        }
                    }
                    System.out.println();
                    break;

                case "D":
                    try {
                        String begin = userInputScanner.next().toUpperCase();
                        String end = userInputScanner.next().toUpperCase();
                        Stack<String> path = new Stack<>();
                        double connected = digraph.getCheapestPath(begin, end, path);
                        if (connected == 0) {
                            System.out.println("Airports not connected");
                        } else {
                            System.out.println(airportTable.get(begin) + " to " + airportTable.get(end) + " is "
                                    + connected + " through the route: ");
                            while (!path.isEmpty()) {
                                String code = path.pop();
                                System.out.println(code + " - " + airportTable.get(code));
                            }
                        }
                        System.out.println();
                    } catch (NullPointerException e) {
                        System.out.println("Airport code unknown");
                    }
                    break;

                case "E":
                    System.exit(0);

                default:
                    userInputScanner.nextLine();
                    System.out.println("Invalid Command.");
            }
        } while (!command.equals("E"));
        userInputScanner.close();
    }
}