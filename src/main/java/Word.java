import java.util.ArrayList;
import java.util.List;

public class Word extends Composite {
    List<Symbol> word = new ArrayList<>();

    public Word(){}
    public Word(Component component) {
        super(component);
    }
}
