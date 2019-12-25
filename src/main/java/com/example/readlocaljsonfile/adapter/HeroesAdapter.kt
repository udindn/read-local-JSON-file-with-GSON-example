package com.example.readlocaljsonfile.adapter

import android.content.*
import android.view.*
import android.widget.*
import com.example.readlocaljsonfile.*
import com.example.readlocaljsonfile.model.*
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroesAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()

    override fun getCount(): Int = heroes.size

    override fun getItem(i: Int): Any = heroes[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder constructor(view: View) {
        private val txtName: TextView = view.txt_name
        private val txtDescription: TextView = view.txt_description
        private val txtYear: TextView = view.txt_year
        private val imgPhoto: ImageView = view.img_photo
        private val itemView: View = view

        internal fun bind(hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            txtYear.text = hero.year
            val resourceId = context.resources.getIdentifier(hero.photo, "drawable", context.packageName)
            imgPhoto.setImageResource(resourceId)
        }
    }
}