package org.xload.springapp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.xload.springapp.music.Music;
import org.xload.springapp.music.Rock;
import java.util.Scanner;

import java.util.Scanner;

@NoArgsConstructor
@Component
public class MusicPlayer
{
    @Setter
    private Music music;
    @Setter
    @Value("${MusicPlayer.defaultVolume}")
    private int volume;
    @Getter
    private boolean isPlaying;

    public MusicPlayer(Music music)
    {
        this.music = music;
    }
    private final Runnable playMusicRunnable = ()->{
        while (isPlaying)
        {
            music.outWords();
            System.out.println(" (pmt volume: " + volume + ")");
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                System.out.println("PlayMusicThreadInterrupted");
            }
        }
    };
    @Getter
    Thread current;
    public void playMusicSeconds(int seconds){
        new Thread(()->{
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                System.out.println("PlayMusicThreadSecondsInterrupted");
            }
            for (int i = 0; i < seconds; i++)
            {

                music.outWords();
                System.out.println(" (pmts volume: "+volume+")");
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    System.out.println("PlayMusicThreadSecondsInterrupted");
                }
            }
        }).start();
    }
    public void playMusic(){
        isPlaying = true;
        current  = new Thread(playMusicRunnable);
        current.start();
    }
    public void stopMusic() throws InterruptedException
    {
        isPlaying = false;
        Thread.sleep(1000);
        if(current!=null) current.interrupt();
    }
}
