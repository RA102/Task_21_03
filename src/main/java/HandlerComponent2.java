import java.util.*;
import java.util.List;

public class HandlerComponent2 {
    public  String text;
    public Paragraph paragraph = new Paragraph();
    public List<Sentence> sentences = new ArrayList<>();//предлож.
    public List<Word> words = new ArrayList<>();    //слова
    public List<Symbol> characters = new ArrayList<Symbol>();

    public static Map<String, Boolean> dictKey = new HashMap<>();
    private String[] arrStr;

    public HandlerComponent2(){
        dictKey.put("symbol", false);
        dictKey.put("words", false);
        dictKey.put("sentences", false);
        dictKey.put("paragraph", false);
    }
    public HandlerComponent2(String text){
        dictKey.put("symbol", false);
        dictKey.put("words", false);
        dictKey.put("sentences", false);
        dictKey.put("paragraph", false);
        setText(text);
    }
    public void setText(String text){
        this.text = text;
        setCharacters();
        setWords();
        setSentences();
        setParagraph();
    }

    private void setCharacters() {
        try {
            if(text == null) throw new Exception("Текст не определен!");
        }catch (Exception e){
            e.printStackTrace();
        }
        char[] chars = text.toCharArray();
        for (char symbol: chars
        ) {
            characters.add(new Symbol(symbol));
        }
        dictKey.replace("symbol", true);
    }

    private void setWords(){
        try {
            if(dictKey.get("symbol") == false) throw new Exception("Компоненты symbol отсутствуют!");
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Component component: characters){
            Word tempWord = new Word();
            if(component.value().equals(" ") || component.value().equals(".") || component.value().equals(",") ||
                    component.value().equals("!") || component.value().equals("?")){
                words.add(new Word(component));
            }
            else
                tempWord.add(component);
            words.add(tempWord);
        }
        dictKey.replace("words", true);
    }

    private void setSentences(){
        try {
            if(dictKey.get("words") == false) throw new Exception("Компоненты words отсутствуют!");
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Component component: words){
            Sentence tempSentence = new Sentence();
            if(component.value().equals(".") || component.value().equals("!") || component.value().equals("?")){
                sentences.add(new Sentence(component));
            }
            else
                tempSentence.add(component);
            sentences.add(tempSentence);
        }

        dictKey.replace("sentences", true);
    }

    private void setParagraph(){
        try {
            if(dictKey.get("sentences") == false) throw new Exception("Компоненты sentences отсутствуют!");
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Component component: sentences)  {
            Component tempParagraph = new Composite();
            if(component.value().equals("\t")){

                paragraph.add(component);
            }
            else
                tempParagraph.add(component);
            paragraph.add(tempParagraph);
        }
        dictKey.replace("words", true);
    }

}
