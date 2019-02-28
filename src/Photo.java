import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

abstract public class Photo {
    private final Set<String> tags;

    Photo(String... tags) {
        this.tags = new TreeSet<>();

        Collections.addAll(this.tags, tags);
    }

    public Set<String> getTags() {
        return new TreeSet<>(tags);
    }

    public int tagsNotIn(Photo that) {
        Set<String> copies = new TreeSet<>(tags);
        copies.removeAll(that.getTags());
        return copies.size();
    }

    public int commonTags(Photo that) {
        Set<String> copies = new TreeSet<>(tags);
        copies.retainAll(that.getTags());
        return copies.size();
    }

    @Override
    public String toString() {
        return tags.toString();
    }
}
