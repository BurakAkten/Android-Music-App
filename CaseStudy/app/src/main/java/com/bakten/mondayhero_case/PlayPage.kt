package com.bakten.mondayhero_case


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_play_page.*



class PlayPage : AppCompatActivity() {

    private lateinit var song : Song
    private var isPlaying : Boolean = false
    private var progressStatus : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_page)

        setViewForSong()
        setSeekBarListener()
    }

    fun GoBack(view: View) {

        //decrement 3 or make 0
        if(songProcess.progress <= 3){
            progressStatus = 0
        }
        else{
            progressStatus -= 3
        }
        songProcess.progress = progressStatus
    }
    fun GoNext(view: View) {
        //Increment 3
        progressStatus += 3
        songProcess.progress = progressStatus

    }

    fun PlaySong(view: View) {

        var thread = Thread(Runnable {

            while (isPlaying && progressStatus <= songProcess.max){

                songProcess.progress = progressStatus
                progressStatus += 5

                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            if (progressStatus >= 100){
                progressStatus = 0
                songProcess.progress = progressStatus
                isPlaying = false

                runOnUiThread {
                    play_button.setImageResource(R.drawable.play_button)
                }
            }
        })

        if(!isPlaying){
            isPlaying = true
            play_button.setImageResource(R.drawable.pause)
            thread.start()
        }
        else{
            isPlaying = false
            play_button.setImageResource(R.drawable.play_button)

            songProcess.progress = progressStatus
        }

    }

    fun Close(view: View){
        super.onBackPressed()
    }

    private fun setViewForSong(){
        song = intent.getSerializableExtra("Song") as Song

        if (song != null){
            song_name.text = song.getSongName()
            song_artist.text = song.getArtistName()
        }
    }

    private fun setSeekBarListener(){
        songProcess.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                 //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var leftTime = seekBar!!.max - progress
                duration1.text = "$progress"
                duration2.text = "-$leftTime"

                if (fromUser)
                    progressStatus = songProcess.progress
            }

        })
    }


}
