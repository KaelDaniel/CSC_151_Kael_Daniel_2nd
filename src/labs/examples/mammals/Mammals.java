package labs.examples.mammals;

public class Mammals {

// javac -d bin src/labs/example/mammals/*.java (kael use this for debugging, probably gonna use it a lot)(future Kael here, Yeah I am, becuase PAIN)
// list, one of many
    protected String eyeColor;
    protected String hairColor;
    protected String bodyTemp;
    protected String name;
    protected String lifeSpan;
    protected String habitat;
    protected String Catagory;
    protected String feed;




// a list, another of MANY

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
    } //name is set for later

    public String getName(){
        return this.name;
    } // and then used

    public void getMammalDetails(){
        System.out.println(this.eyeColor);

        System.out.println(this.hairColor);

        System.out.println(this.bodyTemp);

        System.out.println(this.lifeSpan);

        System.out.println(this.habitat);

        System.out.println(this.Catagory);

        System.out.println(this.feed);
    } //used to print out the mammals details, and it is amany a details

    public void stand(){
    System.out.println("Stand up"); // the animal stands up, I guess
    mammalSpeak(); // and then Speaks
    }

   
    public void mammalSpeak(){
        if("dog".equals(name)){
            System.out.println("Bark Bark");
        } // dogs bark, cats meow, and so on so forth, but only got barks for now
    }

    public void run(){}
}    