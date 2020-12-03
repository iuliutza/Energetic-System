import fileio.Input;
import fileio.InputLoader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        String pathIn = "/home/iulia/IdeaProjects/Project-etapa1/teme/proiect-etapa1/checker/resources/in/"
                + args[0];
        System.out.println(pathIn);

        String pathOut = "" + args[1];

        System.out.println(pathOut);


    }

    public static void action(final String fileIn, final String fileOut) throws IOException {
        InputLoader inputLoader = new InputLoader(fileIn);
        Input input = inputLoader.readData(fileIn);

        System.out.println(input);
    }
}
