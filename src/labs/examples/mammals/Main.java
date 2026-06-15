package labs.examples.mammals;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mammals mammal = new Mammals(); //makes a new mammal instance/object, to many names gonna be honesy

        mammal.setName("dog"); //the mammal is named as a dog, so, it's a dog now

        String myMammalName = mammal.getName(); // gives the mamal a name, and then calls it by its name, so we know it is a good dog
        System.out.println(myMammalName);

        mammal.sit(); // dog shal... SIT
    }
}