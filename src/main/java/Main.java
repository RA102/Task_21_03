public class Main {
    public static void main(String[] args) throws Exception {
        //Имеются два обработчика компонентов, "простой" и второй с допклассами Paragraph, Sentence,..
        //1-HandlerComp - более простое решение

//        Component myChar = new Composite(new Symbol('b'));
////        System.out.println(myChar.value());
//
////        //2
//        Component word = new Composite();
//        word.add(new Symbol('a'));
//        Component x = new Composite(new Symbol('b'), new Symbol('c'));
//        Component y = new Composite(new Symbol('d'), new Symbol('e'));
//        word.add(x, y);
////        System.out.println(word.value());
////        System.out.println(word.getComponent(2).value());
//
//        //3
        HandlerComponent handlerComponent = new HandlerComponent("Во саду ли в огороде.");
//        handlerComponent.words.forEach(w-> System.out.print(w.value()));
//        System.out.println();
//        handlerComponent.words.forEach(w-> w.display());
//        System.out.println();
//        handlerComponent.paragraph.display();
//        System.out.println();

//        4 - с использ. HandlerComp.2 + доп. классов Paragraph, Sentence,..
//         слишком перегружено (учебное усложнен.?)

        HandlerComponent2 handlerComponent2 = new HandlerComponent2("Во саду ли в огороде.");
        handlerComponent2.characters.forEach(ch->ch.display());
        System.out.println();

        handlerComponent2.words.forEach(i-> System.out.print(i.value()));
        System.out.println();
        handlerComponent2.words.forEach(i-> i.display());
        System.out.println();
        handlerComponent2.paragraph.display();

    }
}
