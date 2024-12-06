package Exo9;

public class RemoveSongCommand implements Command {
    private  Playlist playlist;

    public RemoveSongCommand(Playlist playlist) { this.playlist = playlist; }

    @Override
    public void execute(Song song) {
        System.out.println(song.getTitle()+" is remove to playlist");
        playlist.removeSong(song);
    }

}