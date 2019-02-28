import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Slideshow {

    private List<Slide> slides;

    public Slideshow() {
        this.slides = new LinkedList<>();
    }

    public void addSlide(Slide slide) {
        slides.add(slide);
    }

    public void buildOutputFile() throws IOException {
        Path path = Paths.get("src/output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(String.valueOf(slides.size()));
            writer.newLine();

            for (Slide s : slides) {
                writer.write(s.getId());
                writer.newLine();
            }
        }
    }
}
