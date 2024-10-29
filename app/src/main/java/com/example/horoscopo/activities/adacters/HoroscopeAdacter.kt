package com.example.horoscopo.activities.adacters

import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo.data.Horoscope

class HoroscopeAdacter( val items: list<horoscopo>) : RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class horoscopo {

}

class HoroscopeViewHolder(view: RecyclerView) : RecyclerView.ViewHolder(view){
    lateinit var  nameTextView:TextView
    lateinit var datesTextView: TextView
    lateinit var datesImageView: ImageView

    fun render(horoscope: Horoscope){
        val context = itemView.context

        nameTextView.text= context.getString(horoscope.name)




        nameTextView.setText(horoscope.name)
        nameTextView.setText(horoscope.date)
        nameTextView.setImageResource(horoscope.image)

    }



}

private fun TextView.setImageResource(image: Any) {

}
