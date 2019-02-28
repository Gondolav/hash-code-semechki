import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class InputParser {

    public void importPhotos() {
        String fileName = "c://lines.txt";
        LinkedList<String> input = new LinkedList<>();

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(input::add);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int numberOfPhotos = Integer.parseInt(input.get(0));
        input.remove(0);

        LinkedList<Photo> photos = new LinkedList<>();
        for (String line : input) {
            List<String> splitStr = Arrays.asList(line.trim().split("\\s+"));

            if (splitStr.get(0) == "V") {
                photos.add(new VerticalPhoto(splitStr.subList(2, splitStr.size())));
            } else {
                photos.add(new HorizontalPhoto(splitStr.subList(2, splitStr.size())));
            }
        }

    }
}
