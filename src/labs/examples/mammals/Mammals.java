package labs.examples.mammals;

public class Mammals {

// javac -d bin src/labs/example/mammals/*.java (kael use this for debugging, probably gonna use it a lot)
// these are the list of traits so far
    protected String eyeColor;
    protected String hairColor;
    protected String bodyTemp;
    protected String name;
    protected String lifeSpan;
    protected String habitat;
    protected String Catagory;
    protected String feed;




// a list, one of many

    public void claws(){}

    public void eat(){}

    public void sleep(){}
    
    
    public void sit() throws InterruptedException{
        if("water".equals(habitat)){
            System.out.println("amphibious mammals cannot sit");} // if it is water living loser, then it won't sit, so yeah... FISH

        else{
            System.out.println("sit down"); // if it fits it sits, i guess

            Thread.sleep(15000); // thread waiting function, with it being in milliseconds, so 15 seconds

            stand(); // standing command, duh duh dun
        }
    } // InterruptedExpectation is needed since without it, the Thread.sleep code wouldn't work, and would cuase conflictions

    public void swim(){
        if("water".equals(habitat)){
            System.out.println("the mammal is swimming"); //a function that allows a animal to swim if it is aquatic by nature
        }
        else{
            System.out.println("the mammal cannot swim"); //simply if it can't swim then it won'd

        }
    }

    
    public void setName(String name){
        this.name = name;
    } //is used to set a mammals name for future use

    public String getName(){
        return this.name;
    } // this returns whatever the name of the mammal is set too

    public void getMammalDetails(){
        System.out.println(this.eyeColor);

        System.out.println(this.hairColor);

        System.out.println(this.bodyTemp);

        System.out.println(this.lifeSpan);

        System.out.println(this.habitat);

        System.out.println(this.Catagory);

        System.out.println(this.feed);
    } //used to print out the mammals details

    public void stand(){
    System.out.println("Stand up"); // states that the mammal is standing
    mammalSpeak(); // and then calls out the mammalSound command
    }

   
    public void mammalSpeak(){
        if("dog".equals(name)){
            System.out.println("Bark Bark");
        } // checks the mammals name, and if it is a dog, then it will bark
    }

    public void run(){}
}    