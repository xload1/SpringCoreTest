package org.xload.springapp;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xload.springapp.music.Music;
@Component
public class Phone
{
    private MusicPlayer musicPlayer;
    @Autowired
    public Phone(MusicPlayer musicPlayer)
    {
        this.musicPlayer = musicPlayer;
    }
    public void startMusicPlayer(){
        System.out.println("music player started!");
        musicPlayer.playMusic();
    }
    public void closeMusicPlayer() throws InterruptedException
    {
        musicPlayer.stopMusic();
    }
}
