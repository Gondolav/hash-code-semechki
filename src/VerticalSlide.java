import java.util.Set;
import java.util.TreeSet;

public class VerticalSlide extends Slide {

    private VerticalPhoto leftPhoto;
    private VerticalPhoto rightPhoto;

    public VerticalSlide(VerticalPhoto leftPhoto, VerticalPhoto rightPhoto) {
        this.leftPhoto = leftPhoto;
        this.rightPhoto = rightPhoto;
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
}