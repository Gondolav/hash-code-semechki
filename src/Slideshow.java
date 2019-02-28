import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Slideshow {

    private List<Slide> slides;

    private List<HorizontalPhoto> horizontals;

    private List<VerticalPhoto> verticals;

    private Matcher matcher;

    private int score;

    public Slideshow(Tuple<LinkedList<HorizontalPhoto>, LinkedList<VerticalPhoto>> tuple) {
        this.slides = new LinkedList<>();
        this.horizontals = new LinkedList<>(tuple.x);
        this.verticals = new LinkedList<>(tuple.y);
        this.matcher = new Matcher();
        computeSlides();
    }

    private void computeSlides() {
        for (HorizontalPhoto photo: horizontals) {
            matcher.insert(new HorizontalSlide(photo));
        }

        for (VerticalPhoto photo1: verticals) {
            if (verticals.size() > 1) {
                int maxTags = -1;
                VerticalSlide bestSlide = null;
                for (VerticalPhoto photo2 : verticals) {
                    if (!photo1.equals(photo2)) {
                        VerticalSlide slide = new VerticalSlide(photo1, photo2);

                        int tagsNum = slide.getTagsNum();
                        if (tagsNum > maxTags) {
                            maxTags = tagsNum;
                            bestSlide = slide;
                        }
                    }
                }

                verticals.remove(bestSlide.getRightPhoto());
                verticals.remove(bestSlide.getLeftPhoto());
                matcher.insert(bestSlide);
            }
        }

        Slide next = matcher.getFirst();
        while (next != null) {
            slides.add(next);
            next = matcher.selectBest(next, next.getTagsNum());
        }
    }

    public void buildOutputFile(String category) throws IOException {
        Path path = Paths.get("src/output" + category + ".txt");
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
