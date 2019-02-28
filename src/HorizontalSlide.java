import java.util.Set;

public class HorizontalSlide extends Slide {

    private HorizontalPhoto photo;
    private int tagsNum;

    public HorizontalSlide(HorizontalPhoto photo) {
        super();
        this.photo = photo;
        tagsNum = getTags().size();
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

    public int getTagsNum() {
        return tagsNum;
    }
}