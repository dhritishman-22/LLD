package StatePattern;

public class TVStartState implements State {
    @Override
    public void doAction() {
        System.out.println("TV is on");
    }
}
