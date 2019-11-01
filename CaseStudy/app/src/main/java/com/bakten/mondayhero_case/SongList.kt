package com.bakten.mondayhero_case

class SongList{

    private lateinit var songList : ArrayList<Song>

    fun getSongs() : ArrayList<Song>{

        //If we want to get songs from server or sth else, we can call a service in this block


        var songs : ArrayList<Song> = ArrayList()

        songs.add(Song("Yürüyorum Dikenlerin Üstüne", "BARABAR", R.drawable.album_cover))
        songs.add(Song("Lose You To Love Me", "Selena Gomez", R.drawable.album_cover2))
        songs.add(Song("Eklemedir Koca Konak", "Zeynep Bastık", R.drawable.album_cover3))
        songs.add(Song("Aman Of", "BARABAR", R.drawable.album_cover))
        songs.add(Song("Banana Pancakes", "Jack Johnson", R.drawable.album_cover))
        songs.add(Song("Simple As This", "Jake Bugg", R.drawable.album_cover2))

        return songs

    }

}