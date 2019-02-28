import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class InputParser {

    public static LinkedList<Photo> importPhotos(String filePath) {
        LinkedList<Photo> photos = new LinkedList<>();
        AtomicInteger id = new AtomicInteger();
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.skip(1).forEach(line -> {
                List<String> splitStr = Arrays.asList(line.trim().split("\\s+"));
                if (splitStr.get(0).equals("V")) {
                    photos.add(new VerticalPhoto(id.getAndIncrement(),
                                                    splitStr.subList(2, splitStr.size())));
                } else {
                    photos.add(new HorizontalPhoto(id.getAndIncrement(),
                                                    splitStr.subList(2, splitStr.size())));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return photos;
    }
}
