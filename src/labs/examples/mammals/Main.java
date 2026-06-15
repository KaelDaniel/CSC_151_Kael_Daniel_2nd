package labs.examples.mammals;

import labs.example.mammals.mammals;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        mammals mammal = new mammals();

        mammal.setName("dog"); //sats the mammals name to "dog"
        String myMammalName = mammal.getName(); // line 10 and 11 pretty much assign the name "dog", and then prints the name
        System.out.println(myMammalName);

        mammal.sit(); // begins the sit command
        mammal.run(); // begins the run command
    }
}