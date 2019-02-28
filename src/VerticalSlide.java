import java.util.Set;

public class VerticalSlide extends Slide {

    private VerticalPhoto leftPhoto;
    private VerticalPhoto rightPhoto;
    private int tagsNum;

    public VerticalSlide(VerticalPhoto leftPhoto, VerticalPhoto rightPhoto) {
        super();
        this.leftPhoto = leftPhoto;
        this.rightPhoto = rightPhoto;
        tagsNum = getTags().size();
    }

    @Override
    public Set<String> getTags() {
        Set<String> union = leftPhoto.getTags();
        union.addAll(rightPhoto.getTags());
        return union;
    }

    @Override
    public String getId() {
        return leftPhoto.getId() + " " + rightPhoto.getId();
    }

    public VerticalPhoto getLeftPhoto() {
        return leftPhoto;
    }

    public VerticalPhoto getRightPhoto() {
        return rightPhoto;
    }

    public int getTagsNum() {
        return tagsNum;
    }

    @Override
    public void use() {
        leftPhoto.use();
        rightPhoto.use();
    }
}