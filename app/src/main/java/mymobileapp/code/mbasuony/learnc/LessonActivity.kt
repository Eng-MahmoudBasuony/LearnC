package mymobileapp.code.mbasuony.learnc

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_lesson.*

class LessonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)



        if (intent!=null)
        {
           // var imageUrl=intent.getStringExtra("Image_Lesson")
            var titel=intent.extras.getString("Titel_Lession")
             var imageUrl=intent.extras.getString("Image_Lesson")
            var content=intent.extras.getString("Content_Lesson")


           Glide.with(this).load("http://www.arablancer.org/cplasplas/public"+imageUrl).into(imageContent)

            textTitelLesson.text=titel
            textContentLesson.text=content

        }

    }



}
