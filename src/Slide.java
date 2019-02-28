import java.util.Set;
import java.util.TreeSet;

public abstract class Slide {
    public abstract Set<String> getTags();
<<<<<<< HEAD
    private int tagsNum;

    public Slide() {
        tagsNum = getTags().size();
    }
=======
>>>>>>> f41bd61198066947ffee84cbf6f87e7853e01b87

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

<<<<<<< HEAD
    public int getTagsNum() {
        return tagsNum;
    }
=======
    abstract public String getId();
>>>>>>> f41bd61198066947ffee84cbf6f87e7853e01b87
}