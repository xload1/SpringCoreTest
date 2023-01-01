package org.xload.springapp;

import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.xload.springapp.music.Music;

import java.util.ArrayList;
import java.util.List;

public class ListMusicPlayer
{
    @Setter
    private List<Music> musicList = new ArrayList<>();

    public void playMusic(){
        musicList.forEach(Music::outWords);
    }
}

