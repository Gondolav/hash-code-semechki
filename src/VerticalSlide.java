import java.util.Set;

public class VerticalSlide extends Slide {

    private VerticalPhoto leftPhoto;
    private VerticalPhoto rightPhoto;

    public VerticalSlide(VerticalPhoto leftPhoto, VerticalPhoto rightPhoto) {
        super();
        this.leftPhoto = leftPhoto;
        this.rightPhoto = rightPhoto;
    }

    @Override
    public Set<String> getTags() {
        Set<String> union = leftPhoto.getTags();
        union.addAll(rightPhoto.getTags());
        return union;
    }

    public VerticalPhoto getLeftPhoto() {
        return leftPhoto;
    }

    public VerticalPhoto getRightPhoto() {
        return rightPhoto;
    }
}