public class SetMovement implements Command{
    Movement movement;
    char input;

    public SetMovement(Movement movement, char input) {
        this.movement = movement;
        this.input = input;
    }

    @Override
    public void execute() {
        movement.move(input);
    }
}
