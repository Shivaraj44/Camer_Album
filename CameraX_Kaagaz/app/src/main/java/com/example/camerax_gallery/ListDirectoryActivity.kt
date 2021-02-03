package com.example.camerax_gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.camerax_gallery.OnetoMany.Album
import com.example.camerax_gallery.Recyclerview.ListDirectoryAdapter
import kotlinx.android.synthetic.main.activity_list_photos.*

class ListDirectoryActivity : AppCompatActivity(), ItemClickListener {
    private lateinit var viewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_photos)
        viewModel = UserViewModelFactory(this).create(UserViewModel::class.java)

viewModel.fetchAllAlbums().observe(this, Observer {
    it?.let {
        setRecyclerAdapter(it)
    }
})
    }

    private fun setRecyclerAdapter(it: List<Album>) {
        val gridLayoutManager = GridLayoutManager(this,3)
        val listPhotosAdapter = ListDirectoryAdapter(it,this)
        listRecyclerView.apply {
            layoutManager = gridLayoutManager
            adapter = listPhotosAdapter
        }
    }

    override fun onItemClicked(album: Album) {
       // Open one more activity and pass album.albumName
    }
}