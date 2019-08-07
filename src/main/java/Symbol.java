public class Symbol implements Component{
    private Character character;

    public Symbol(Character character) {
        this.character = character;
    }

    public String value() {
        return character.toString();
    }
    public void display(){
        System.out.print(value());
    }

    public void add(Component... component) {
        throw new UnsupportedOperationException();
    }

    public void remove(Component... component) {
        throw new UnsupportedOperationException();
    }

    public Component getComponent(int index) {
        throw new UnsupportedOperationException();
    }
}
