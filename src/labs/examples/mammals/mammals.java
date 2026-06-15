package labs.example.mammals;

public class mammals {

// javac -d bin src/labs/example/mammals/*.java (kael use this for debugging, probably gonna use it a lot)
// these are the list of traits so far
    protected String eyeColor;
    protected String hairColor;
    protected String bodyTemp;
    protected String name;
    protected String habitat;
    protected String species;
    protected String diet;




// list of comands, and actions
    public void run(){
        int lineX = (3); // sets the lines up, down 3 right 4
        int lineY = (4);
        System.out.println("the Mammal walked 3 miles south, and 4 miles east");
        double lineZ = (lineX*lineX + lineY*lineY); // gets the C^2
        double Pythagorean = Math.sqrt(lineZ); // finds the squreroot of C^2
        System.out.println("the Mammal walked " + Pythagorean + "miles back to the begining");
        double Theta = Math.atan2(lineX,lineY); // finds the theta
        double ThetaAngle = Math.toDegrees(Theta); // turns the theta into a degree
        System.out.println(ThetaAngle); //prints out the final result
    }

    public void scratch(){}

    public void eat(){}

    public void sleep(){}
    
    
    public void sit() throws InterruptedException{
        if("water".equals(habitat)){
            System.out.println("amphibious mammals cannot sit");} // checks if the mammal lives in water, and if it does, then it can't sit
        else{
            System.out.println("sit down"); // if th animal can sit, the animal will sit
            Thread.sleep(15000); // this will make it so the code waits 15 seconds before continueing the command
            stand(); //begins the stand command
        }
    } // InterruptedExpectation is needed since without it, the Thread.sleep code wouldn't work, and would cuase conflictions

    public void swim(){}

    
    public void setName(String name){
        this.name = name;
    } //is used to set a mammals name for future use

    public String getName(){
        return this.name;
    } // this returns whatever the name of the mammal is set too

    public void getMammalDetails(){
        System.out.println(this.eyeColor);
    } //used to print out the mammals details

    public void stand(){
    System.out.println("Stand up"); // states that the mammal is standing
    mammalSound(); // and then calls out the mammalSound command
    }

   
    public void mammalSound(){
        if("dog".equals(name)){
            System.out.println("Bark Bark");
        } // checks the mammals name, and if it is a dog, then it will bark
    }
}    