import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File inputFile = new File(new File("src\\main\\java\\1.txt").getAbsolutePath());
        List<Integer> lines = new ArrayList<>();

        try
        {
            Scanner scanner = new Scanner(inputFile, "UTF-8");
            while (scanner.hasNext()) {
                lines.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(lines);
        // Максимальный индентификатор сущностей
        int value = lines.get(lines.size() - 1);
        Dependencies d = new Dependencies(value+1);
        try {
            Scanner scanner = new Scanner(inputFile, "UTF-8");
            while (scanner.hasNext()) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                d.addEdge(first, second);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        DirectedCycle cycle = new DirectedCycle(d);
    }
}
