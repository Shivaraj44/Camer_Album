package com.example.camerax_gallery.Recyclerview

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.camerax_gallery.ItemClickListener
import com.example.camerax_gallery.OnetoMany.Album
import com.example.camerax_gallery.R
import kotlinx.android.synthetic.main.photos_list_item_layout.view.*

class ListDirectorViewHolder(private val view : View, private val itemClickListener: ItemClickListener) : RecyclerView.ViewHolder(view) {

    fun setData(album : Album){
        view.apply{
            ivAlbum.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cam))
            tvAlbumName.text = album.albumName
            ivAlbum.setOnClickListener {
                itemClickListener.onItemClicked(album)
            }
        }
    }
}