package com.example.readlocaljsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.readlocaljsonfile.adapter.*
import com.example.readlocaljsonfile.model.*
import com.google.gson.*
import com.google.gson.reflect.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.*
import java.io.*
import java.nio.charset.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var listItems = ArrayList<Hero>()
    private lateinit var adapter: HeroesAdapter
    private val filmData = "file.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        getLocalData()
    }

    private fun setupRecyclerView() {
        adapter = HeroesAdapter(this)
        rv_landing.adapter = adapter
    }

    private fun getAssetsJSON(): String? {
        var json: String? = null
        try {
            val inputStream = this.assets.open(filmData)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, StandardCharsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }

    private fun getLocalData() {
        val jsonString = getAssetsJSON()
        if (jsonString != null) {
            try {
                val response = JSONObject(jsonString)
                val json = response.getJSONArray("data").getJSONObject(0).getJSONArray("items")
                listItems.addAll(
                    Gson().fromJson(
                        json.toString(),
                        object : TypeToken<ArrayList<Hero>>() {}.type
                    )
                )
                adapter.heroes = listItems
                adapter.notifyDataSetChanged()
            } catch (ex: JSONException) {
                ex.printStackTrace()
            }
        }
    }
}
