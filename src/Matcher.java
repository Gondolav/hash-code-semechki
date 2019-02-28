import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Matcher {

    private final static int N = 200;
    private ArrayList<Set<Slide>> slideSet = new ArrayList<>(N);

    public Matcher() {
        for (int i = 0; i < N; i++) {
            slideSet.add(i, new HashSet<>());
        }
    }

    public void insert(Slide slide) {
        slideSet.get(slide.getTagsNum()).add(slide);
    }

    public Slide selectBest(Slide slide, int tagsNum) {
        if (tagsNum < 0) {
            return null;
        }

        Set<Slide> matchingSet = slideSet.get(tagsNum);

        if (matchingSet.isEmpty()) {
            return selectBest(slide, tagsNum - 1);
        }

        Slide bestSlide = null;
        int bestScore = -1;

        for (Slide attempt: matchingSet) {
            int currentScore = attempt.scoreWith(slide);
            if (currentScore > bestScore) { //&& currentScore >= tagsNum / 2.0
                bestScore = currentScore;
                bestSlide = attempt;
            }
        }

        matchingSet.remove(bestSlide);

        return bestSlide;
    }

    public Slide getFirst() {
        for (int i = N-1; i >= 0; i--) {
            Set<Slide> slides = slideSet.get(i);
            if (!slides.isEmpty()) {
                return slides.iterator().next();
            }
        }

        return null;
    }
}
