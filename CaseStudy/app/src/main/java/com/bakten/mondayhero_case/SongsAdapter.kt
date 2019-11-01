package com.bakten.mondayhero_case


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class SongsAdapter (private val context: Context,
                    private val songlist: ArrayList<Song>) : BaseAdapter() {


    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_item_song, parent, false)

        val songNum = rowView.findViewById(R.id.songNumber) as TextView
        val songIm = rowView.findViewById(R.id.songImage) as ImageView
        val songName = rowView.findViewById(R.id.SongName) as TextView
        val songArtist = rowView.findViewById(R.id.artist) as TextView

        val song = getItem(position) as Song

        val num = position + 1
        songNum.text = if (num < 10) "0$num" else "$num"

        songName.text = song.getSongName()
        songArtist.text = song.getArtistName()

        songIm.setImageResource(song.getAlbumImageSource())

        rowView.isClickable = true

        rowView.setOnClickListener {
            val intent = Intent(context, PlayPage::class.java)
            intent.putExtra("Song", song)
            context.startActivity(intent)
        }

        return rowView
    }

    override fun getItem(position: Int): Any {
        return songlist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return songlist.size
    }

}