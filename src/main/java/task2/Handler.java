package task2;

import lombok.Getter;
import lombok.Setter;

abstract class Handler {
    @Setter @Getter
    public Handler next;
    public abstract void process(int price);
}
