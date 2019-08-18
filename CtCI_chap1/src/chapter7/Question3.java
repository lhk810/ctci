package chapter7;

import java.util.ArrayList;
import java.util.Iterator;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class JukeBox {
	ArrayList<Song> playList = new ArrayList<Song>();
	ArrayList<Song> songList = new ArrayList<Song>();
	
	Song currentSong = null;
	
	public Song getCurrentSong() {
		return currentSong;
	}
	
	public void appendToSongList(Song song) {
		songList.add(song);
	}
	
	public void appendToPlayList(Song song) {
		songList.add(song);
	}
	
	public ArrayList<Song> getPlayList() {
		return playList;
	}
	
	public ArrayList<Song> getSongList() {
		return songList;
	}
	
	public ArrayList<Song> searchSongByArtist(String artist) {
		ArrayList<Song> list = new ArrayList<Song>();
		for (int i=0; i<songList.size(); i++) {
			Song target = songList.get(i);
			if (target.artist.equals(artist)) {
				list.add(target);
			}
		}
		return list;
	}
	
	public Song findSongByTitle(String title) {
		for (int i=0; i<songList.size(); i++) {
			if (title.equals(songList.get(i).title)) {
				return songList.get(i);
			}
		}
		return null;
	}
	
}

class Song {
	String title;
	String artist;
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
}
