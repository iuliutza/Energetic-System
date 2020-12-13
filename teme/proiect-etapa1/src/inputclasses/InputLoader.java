package inputclasses;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public final class InputLoader {
    private String inputPath;

    public InputLoader() {
        this.inputPath = null;
    }

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    public String getInputPath() {
        return inputPath;
    }

    /**
     *
     * @param inputPath path to the input file
     * @return return the data from the json input file mapped into an input object.
     * @throws IOException exception
     */
    public Input readData(final String inputPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(inputPath);
        Input input = objectMapper.readValue(file, Input.class);
        return input;
    }
}
