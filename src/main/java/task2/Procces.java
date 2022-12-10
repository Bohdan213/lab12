package task2;

public class Procces {
    public static boolean getResult(int price) {
        Handler handler50 = new Handler50();
        Handler handler20 = new Handler20();
        Handler handler5 = new Handler5();
        handler50.setNext(handler20);
        handler20.setNext(handler5);
        handler50.process(price);
        return true;
    }
}
