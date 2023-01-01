package org.xload.springapp.music;

import org.springframework.stereotype.Component;

import java.util.Random;
public abstract class Music
{
    int songNum;

    public Music()
    {
        Random rnd = new Random();
        songNum = rnd.nextInt(1, 4);
    }

    public abstract void outWords();
    private final String[] classNameSplit =  this.getClass().toString().split("\\.");

    public void init(){
        System.out.println("Initialization completed - " + classNameSplit
                [classNameSplit.length-1]);
    }
}
