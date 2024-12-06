package Exo9;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    List<Song> songs = new ArrayList<Song>();

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }
}
