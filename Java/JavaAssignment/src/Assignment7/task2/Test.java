package Assignment7.task2;

public class Test {
    public static void main(String[] args) {
        Cycle cycles[]=new Cycle[3];
        cycles[0]=new Unicycle();
        cycles[0].balance();
        cycles[0]=new Cycle();
        cycles[0].balance();
        cycles[1]=new Bicycle();
        cycles[1].balance();
        cycles[1]=new Cycle();
        cycles[1].balance();
        cycles[2]=new Tricycle();
        cycles[2].balance();
        cycles[2]=new Cycle();
        cycles[2].balance();
    }
}
