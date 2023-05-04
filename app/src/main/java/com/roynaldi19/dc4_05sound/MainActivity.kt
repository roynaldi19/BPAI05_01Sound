package com.roynaldi19.dc4_05sound

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.roynaldi19.dc4_05sound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var sp: SoundPool
    private var soundId: Int = 0
    private var spLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = SoundPool.Builder()
            .setMaxStreams(10)
            .build()

        sp.setOnLoadCompleteListener { _, _, status ->
            if (status == 0) {
                spLoaded = true
            } else {
                Toast.makeText(this@MainActivity, "Gagal load", Toast.LENGTH_SHORT).show()
            }
        }

        soundId = sp.load(this, R.raw.clinking_glasses, 1)

        binding.btnSoundPool.setOnClickListener {
            if (spLoaded) {
                sp.play(soundId, 1f, 1f, 0, 0, 1f)
            }
        }
    }
}