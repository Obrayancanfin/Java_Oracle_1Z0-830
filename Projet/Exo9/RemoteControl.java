package Exo9;

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton(Song song) {
        if(command != null){
            command.execute(song);
        }else {
            System.out.println("Aucune commande assigné a ce bouton");
        }
    }
}

