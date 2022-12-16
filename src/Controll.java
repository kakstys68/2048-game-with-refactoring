public class Controll {
    Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void input(){
        command.execute();
    }
}
