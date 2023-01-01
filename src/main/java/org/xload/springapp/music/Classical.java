package org.xload.springapp.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;
import org.springframework.objenesis.instantiator.annotations.Instantiator;
import org.springframework.stereotype.Component;

@Component
public class Classical extends Music
{
    @Override
    public void outWords()
    {
        switch (songNum){
            case 1 -> System.out.print("lilMozart on the beat...");
            case 2 -> System.out.print("lilBeethoven playing k elise...");
            case 3 -> System.out.print("Kankan playing...");
        }

    }
}
