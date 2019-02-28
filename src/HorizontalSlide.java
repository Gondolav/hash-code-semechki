import java.util.Set;

public class HorizontalSlide extends Slide {

    private HorizontalPhoto photo;

    public HorizontalSlide(HorizontalPhoto photo) {
        super();
        this.photo = photo;
    }

    public Set<String> getTags() {
        return photo.getTags();
    }

    public HorizontalPhoto getPhoto() {
        return photo;
    }
}