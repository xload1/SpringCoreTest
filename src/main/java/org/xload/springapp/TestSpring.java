package org.xload.springapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xload.springapp.music.Classical;

import java.util.Scanner;

public class TestSpring
{
    public static void main(String[] args) throws InterruptedException
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        MusicPlayer mp1 = context.getBean("musicPlayer", MusicPlayer.class);
//        context.getBean("musicPlayer2", MusicPlayer.class).PlayMusicSeconds(7);
//        mp1.playMusic();
//        Thread.sleep(4000);
//        mp1.stopMusic();
//        context.close();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        boolean switchedPlayer = false;
        while (!input.equals("exit"))
        {
            input = scanner.nextLine();
            try
            {
                int seconds = Integer.parseInt(input);
                musicPlayer.playMusicSeconds(seconds);
            } catch (Exception e)
            {
                switch (input)
                {
                    case "p" ->
                    {
                        musicPlayer.playMusic();
//                        System.out.println(musicPlayer.isPlaying());
//                        System.out.println(musicPlayer.getCurrent().getState());
                    }
                    case "s" ->
                    {
                        musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
                        System.out.println("song switched");
                        switchedPlayer = true;
                    }
                    default -> System.out.println("Unknown command");
                }
            }
            if(!switchedPlayer)
            {
                scanner.nextLine();
                musicPlayer.stopMusic();
            }
            switchedPlayer = false;
        }
        context.close();
    }
}
