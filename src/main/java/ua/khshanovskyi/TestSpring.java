package ua.khshanovskyi;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.khshanovskyi.code.Music;
import ua.khshanovskyi.code.MusicPlayer;

import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer player = (MusicPlayer) context.getBean("player");
        Music classicalMusic = (Music) context.getBean("classicalMusic");
        Music rockMusic = (Music) context.getBean("rockMusic");
        Music rapMusic = (Music) context.getBean("rapMusic");
        List<Music> musics = (List<Music>) context.getBean("musicList");

        player.playMusic(classicalMusic);
        player.playMusic(rockMusic);
        player.playMusic(rapMusic);

        System.out.println();
        MusicPlayer playerWithArgs = (MusicPlayer) context.getBean("playerWithArgs");
        playerWithArgs.playMusic();

        System.out.println();
        MusicPlayer playerWithSetter = (MusicPlayer) context.getBean("playerWithSetter");
        playerWithSetter.playMusic();

        System.out.println();
        MusicPlayer playerWithNameAndVolumeClassical = (MusicPlayer) context.getBean("playerWithNameAndVolumeClassical");
        System.out.println(playerWithNameAndVolumeClassical.getPlayerName());
        System.out.println(playerWithNameAndVolumeClassical.getVolume());
        playerWithNameAndVolumeClassical.playMusic();

        System.out.println();
        MusicPlayer playerWithNameAndVolumeClassicalByProperties = (MusicPlayer) context.getBean("playerWithNameAndVolumeClassicalByProperties");
        System.out.println(playerWithNameAndVolumeClassicalByProperties.getPlayerName());
        System.out.println(playerWithNameAndVolumeClassicalByProperties.getVolume());
        playerWithNameAndVolumeClassical.playMusic();

        System.out.println();
        MusicPlayer playerWithMusics = (MusicPlayer) context.getBean("playerWithMusics");
        playerWithMusics.playMusics();

        System.out.println();
        MusicPlayer playerWithMusics2 = (MusicPlayer) context.getBean("player");
        playerWithMusics2.playMusics(musics);

        //scope
        System.out.println(player == playerWithMusics2);
        System.out.println(playerWithArgs == playerWithSetter);
        System.out.println(playerWithArgs == player);

        context.close();
    }
}
