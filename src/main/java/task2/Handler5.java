package task2;

public class Handler5 extends Handler{
    @Override
    public void process(int price) {
        Handler next = getNext();
        if (next == null && price % 5 != 0) {
            throw new IllegalArgumentException();
        }
        else if (next != null){
            next.process(price % 5);
            System.out.println(price / 5 + "* 5");
        }
    }
}
