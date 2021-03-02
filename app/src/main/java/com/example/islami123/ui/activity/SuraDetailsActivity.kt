package com.example.islami123.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.islami123.R
import com.example.islami123.adapter.AyaAdapter
import kotlinx.android.synthetic.main.activity_sura_details.*
import kotlinx.android.synthetic.main.item_aya.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var ayaAdapter: AyaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        val suraName: String = intent.getStringExtra(Constance.EXTRA_SURA_NAME)?:""
        val fileName: String = intent.getStringExtra(Constance.EXTRA_FILE_NAME)?:""

        sura_title.setText(suraName)
        val ayat = readSuraContent(fileName)
        ayaAdapter = AyaAdapter(ayat)
        Recycler_View.adapter = ayaAdapter
    }

    private fun readSuraContent(fileName: String):List<String> {
       val readSura = mutableListOf<String>()
        val reader: BufferedReader

        try {
            val file: InputStream = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
                //Log.d("line", line)
                readSura.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
            return readSura
    }
}