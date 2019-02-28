import java.util.Set;

public class HorizontalSlide extends Slide {

    private HorizontalPhoto photo;

    public HorizontalSlide(HorizontalPhoto photo) {
        this.photo = photo;
    }

    public Set<String> getTags() {
        return photo.getTags();
    }

    @Override
    public String getId() {
        return String.valueOf(photo.getId());
    }

    public HorizontalPhoto getPhoto() {
        return photo;
    }
}