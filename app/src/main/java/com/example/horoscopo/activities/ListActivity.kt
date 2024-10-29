package com.example.horoscopo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.horoscopo.R

class ListActivity : AppCompatActivity() {

    lateinit var horoscopeList: List<Horoscope>

    lateinit var recyclerView: RecyclerView

    lateinit var adapter: HoroscopeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        horoscopeList = HoroscopeProvider.findAll()

        recyclerView = findViewById(R.id.recyclerView)

        adapter = HoroscopeAdapter(horoscopeList) { position ->
            navigateToDetail(horoscopeList[position as Int])
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    class HoroscopeProvider {

    }

    override fun onResume() {
        super.onResume()
        adapter.updateData(horoscopeList)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)

        val searchViewItem = menu.findItem(R.id.menu_search)
        val searchView = searchViewItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    horoscopeList = HoroscopeProvider.findAll().filter {
                        getString(it.name).contains(newText, true) ||
                                getString(it.description).contains(newText, true)
                    }
                    adapter.updateData(horoscopeList, newText)
                }
                return true
            }
        })

        return true
    }

    fun navigateToDetail(horoscope: Horoscope) {
        val intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID, horoscope.id)
        startActivity(intent)
    }
}

class HoroscopeAdapter(horoscopeList: List<Any>, param: (Any) -> Unit) {

}
