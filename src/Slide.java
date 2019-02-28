import java.util.Set;
import java.util.TreeSet;

public abstract class Slide {
    public abstract Set<String> getTags();

    public int scoreWith(Slide that) {
        return Math.min(this.commonTags(that), Math.min(this.tagsNotIn(that), that.tagsNotIn(this)));
    }

    public int tagsNotIn(Slide that) {
        Set<String> copies = new TreeSet<>(getTags());
        copies.removeAll(that.getTags());
        return copies.size();
    }

    public int commonTags(Slide that) {
        Set<String> copies = new TreeSet<>(getTags());
        copies.retainAll(that.getTags());
        return copies.size();
    }

    abstract public String getId();

    abstract public int getTagsNum();
}