package org.xload.springapp.music;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.xload.springapp.music.Music;

import java.beans.BeanProperty;

@Component
public class Rock extends Music
{
    @Override
    public void outWords()
    {
        switch (songNum){
            case 1 -> System.out.print("Thunderstuuuuckk....");
            case 2 -> System.out.print("DO, DO HAST, DO HAST MICH..");
            case 3 -> System.out.print("Mamaaaaa, oooooooo.....");
        }

    }
}
