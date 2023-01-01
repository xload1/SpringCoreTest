package org.xload.springapp;

import org.springframework.context.annotation.*;
import org.xload.springapp.music.Classical;
import org.xload.springapp.music.PopRock;
import org.xload.springapp.music.Rock;

import java.util.Random;

@Configuration
@ComponentScan("org.xload.springapp")
@PropertySource("musicPlayer.properties")
public class SpringConfig
{
    Random random = new Random();
    @Scope("prototype")
    @Bean(initMethod = "init")
    public Classical classical(){
        return new Classical();
    }
    @Scope("prototype")
    @Bean
    public MusicPlayer musicPlayer(){
        switch (random.nextInt(1 ,4)){
            case 1 -> {
                return new MusicPlayer(classical());
            }
            case 2 -> {
                return new MusicPlayer(rock());
            }
            case 3 -> {
                return new MusicPlayer(popRock());
            }
        }
        return new MusicPlayer();
    }
    @Bean(initMethod = "init")
    @Scope("prototype")
    public Rock rock(){
        return new Rock();
    }
    @Bean(initMethod = "init")
    @Scope("prototype")
    public PopRock popRock(){
        return new PopRock();
    }

}
