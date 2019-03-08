package mymobileapp.code.mbasuony.learnc

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_lesson.*
import kotlinx.android.synthetic.main.app_bar_main.*
import mymobileapp.code.mbasuony.learnc.fragment.FragmentLesson
import mymobileapp.code.mbasuony.learnc.fragment.FullImageFragment
import mymobileapp.code.mbasuony.learnc.fragment.HomeFragment


class LessonActivity : AppCompatActivity() {


    private  var titel:String = ""
    private  var imageUrl : String=""
    private  var content : String=""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)


        if (savedInstanceState==null)
        {

            titel =  intent.extras.getString("Titel_Lession")
            imageUrl = intent.extras.getString("Image_Lesson")
            content = intent.extras.getString("Content_Lesson")


            val bundle = Bundle()
            bundle.putString("imageUrl",imageUrl)
            bundle.putString("titel",titel)
            bundle.putString("content",content)

            var fragmentLesson=FragmentLesson()
            fragmentLesson.arguments=bundle

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout_Lesson, fragmentLesson)
                .commit()
        }


    }




}
