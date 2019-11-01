package com.bakten.mondayhero_case

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_play_list_page.*

class PlayListPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_list_page)

        initListView()
    }

    private fun initListView(){
        val adapter = SongsAdapter(this, SongList().getSongs())
        songs_list.adapter = adapter
    }


}
