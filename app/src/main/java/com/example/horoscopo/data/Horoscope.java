package com.example.horoscopo.data;

import org.jetbrains.annotations.NotNull;

public class Horoscope (val id:String, val image:Int, val name:Int, val dates:Int){
    public final int name;
    @NotNull
    public final Object date;
    @NotNull
    public final Object image;

    public Horoscope() {
        date = null;
    }
}
