import java.util.ArrayList;
import java.util.List;

public class Sentence extends Composite {
    List<Word> sentence = new ArrayList<>();

    public Sentence(){}
    public Sentence(Component component) {
        super(component);
    }
}
