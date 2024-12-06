package Exo9;

public class Main {
    public static void main(String[] args) {
        Song song1 = new Song("Smell like teen spirit","nirvana");
        Song song2 = new Song("Toxicity","SOAD");
        Playlist playlist = new Playlist();
        AddSongCommand addSongCommand = new AddSongCommand(playlist);
        RemoveSongCommand removeSongCommand = new RemoveSongCommand(playlist);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(addSongCommand);
        remoteControl.pressButton(song1);
        remoteControl.pressButton(song2);


        remoteControl.setCommand(removeSongCommand);
        remoteControl.pressButton(song2);
    }
}
