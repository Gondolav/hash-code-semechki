import java.util.List;
import java.util.Set;
import java.util.TreeSet;

abstract public class Photo {
    private int id;
    private final Set<String> tags;

    Photo(int id, List<String> tags) {
        this.id = id;
        this.tags = new TreeSet<>();
        this.tags.addAll(tags);
    }

    public int getId() { return id; }

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

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Photo)) {
            return false;
        }

        Photo photo = (Photo) o;
        return photo.getId() == id && photo.getTags().equals(tags);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + tags.hashCode();
        return result;
    }
}
