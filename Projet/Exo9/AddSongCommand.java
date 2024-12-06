package Exo9;

public class AddSongCommand implements Command {
    private  Playlist playlist;

    public AddSongCommand(Playlist playlist) { this.playlist = playlist; }

    @Override
    public void execute(Song song) {
        System.out.println(song.getTitle()+" is added to the playlist");
        playlist.addSong(song);}

}
