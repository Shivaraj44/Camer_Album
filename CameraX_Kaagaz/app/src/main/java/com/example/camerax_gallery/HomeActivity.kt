package com.example.camerax_gallery

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.camerax_gallery.OnetoMany.Folder
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    private val StringPATHv = "/storage/emulated/0/Downloads/image.png"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = UserViewModelFactory(this).create(UserViewModel::class.java)



        floating_action_button.setOnClickListener(View.OnClickListener {
//
            liner_home.visibility = View.VISIBLE
            val name = et_name.text.toString()
            var b = 0;


            save.setOnClickListener(View.OnClickListener {
                val folder = Folder(b, name)
                viewModel.insertgalleryname(b, et_name.text.toString())
                val intent = Intent(this@HomeActivity, MainActivity::class.java)
                intent.putExtra("directoryName",et_name.text.toString())
                startActivity(intent)
            })
        })


    }

}