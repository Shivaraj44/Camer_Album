package com.example.camerax_gallery


import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.camerax_gallery.DataBase.DataBase
import com.example.camerax_gallery.Recyclerview.Adapter
import kotlinx.android.synthetic.main.activity_display_one_image.*
import kotlinx.android.synthetic.main.item.view.*
import java.io.File


class DisplayOneImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_one_image)
        val imgFile: File = File("file:///storage/emulated/0/Android/media/com.example.camerax_gallery/CameraX_Gallery/2021-02-02-03-34-37-723.jpg")
        if (imgFile.exists()) {
            val myBitmap = BitmapFactory.decodeFile("file:///storage/emulated/0/Android/media/com.example.camerax_gallery/CameraX_Gallery/2021-02-02-03-34-37-723.jpg")

            selectrd_image.setImageBitmap(myBitmap)
        }

        val database = DataBase
        Thread {
            val modellist = database.getInstance(this@DisplayOneImageActivity).Dao.getImages()
            val adapter = Adapter(modellist)
            runOnUiThread(Runnable {
                val linearLayoutManager = LinearLayoutManager(this@DisplayOneImageActivity)
                recyclerview.layoutManager = linearLayoutManager
                recyclerview.adapter = adapter
            })
        }.start()
    }
}