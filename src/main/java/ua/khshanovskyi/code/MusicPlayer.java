package ua.khshanovskyi.code;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MusicPlayer {

    private Music music;
    private List<Music> musics;
    private String playerName;
    private int volume;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println(this.music.getSong());
    }

    public void playMusic(Music music) {
        System.out.println(music.getSong());
    }

    public void playMusics() {
       musics.forEach(music1 -> System.out.println(music1.getSong()));
    }
    public void playMusics(List<Music> musics) {
        musics.forEach(music1 -> System.out.println(music1.getSong()));
    }
}
