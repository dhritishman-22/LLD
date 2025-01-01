package StatePattern;

public class TVContext implements State {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void doAction() {
        this.state.doAction();
    }
}
