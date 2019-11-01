package com.bakten.mondayhero_case

import java.io.Serializable

class Song(private val Name:String, private val Artist:String, private val albumImageSource : Int)
    : Serializable {

    fun getSongName() : String{
        return Name
    }

    fun getArtistName() : String{
        return Artist
    }

    fun getAlbumImageSource() : Int{
        return albumImageSource
    }
}