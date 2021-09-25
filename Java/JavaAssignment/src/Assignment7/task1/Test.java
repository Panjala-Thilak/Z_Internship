package Assignment7.task1;


public class Test {
    public static void main(String[] args) {

        Rodent rodents[] = new Rodent[3];
        rodents[0] = new Mouse();
        rodents[0].tail();
        rodents[1] = new Gerbil();
        rodents[1].tail();
        rodents[2] = new Hamster();
        rodents[2].tail();
    }

}
