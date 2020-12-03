package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class InputLoader {
    private String inputPath;

    public InputLoader(){
        this.inputPath = null;
    }

    public InputLoader(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getInputPath() {
        return inputPath;
    }

    public Input readData(String inputPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(inputPath);
        //"/home/iulia/IdeaProjects/Project-etapa1/teme/proiect-etapa1/checker/resources/in/basic_1.json"

        Input input = objectMapper.readValue(file, Input.class);
        return input;

    }

}
