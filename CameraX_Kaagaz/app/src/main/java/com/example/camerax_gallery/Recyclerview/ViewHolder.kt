package com.example.camerax_gallery.Recyclerview

import android.R
import android.R.attr.path
import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.camerax_gallery.DataBase.Model
import kotlinx.android.synthetic.main.item.view.*
import java.io.File


class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun SetDataHome(model: Model){
            view.apply {

             //   val file = File(model.uri)
//            if (file.exists()) {
//                val myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath())
//                recycler_image.setImageBitmap(myBitmap)
//            }
//                val bm =
//                    BitmapFactory.decodeFile(model.uri)
//                recycler_image.setImageBitmap(bm)
                val imgFile: File = File(model.uri)
                if (imgFile.exists()) {
                    val myBitmap = BitmapFactory.decodeFile(imgFile.absolutePath)

                    recycler_image.setImageBitmap(myBitmap)
                }
            }
        }
    }