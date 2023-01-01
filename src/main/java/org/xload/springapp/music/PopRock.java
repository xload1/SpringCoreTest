package org.xload.springapp.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class PopRock extends Music
{
    @Override
    public void outWords()
    {
        switch (songNum){
            case 1 -> System.out.print("Girl no drugs, noo...");
            case 2 -> System.out.print("PopROcksong 2 no idea what name to put...");
            case 3 -> System.out.print("lida playing...");
        }

    }
}
