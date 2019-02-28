import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String[] FILENAMES = {"src/a_example.txt", "src/b_lovely_landscapes.txt", "src/c_memorable_moments.txt",
            "src/d_pet_pictures.txt", "src/e_shiny_selfies.txt"};

    private static String extractFilenameFromCategory(String category) {
        switch (category) {
            case "a":
                return FILENAMES[0];
            case "b":
                return FILENAMES[1];
            case "c":
                return FILENAMES[2];
            case "d":
                return FILENAMES[3];
            case "e":
                return FILENAMES[4];
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Choose dataset [a, b, c, d, e] or build output file [out]: ");
            Scanner scanner = new Scanner(System.in);
            String filenameCategory = scanner.nextLine();

            if (filenameCategory.equals("exit")) {
                return;
            }

            Slideshow slideshow = new Slideshow();

            if (filenameCategory.equals("out")) {
                slideshow.buildOutputFile();
            } else {
                List<Photo> photos = InputParser.importPhotos(extractFilenameFromCategory(filenameCategory));

                System.out.println(photos);
            }
        }
    }
}
