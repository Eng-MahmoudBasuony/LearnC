package mymobileapp.code.mbasuony.learnc.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_fragment_lesson.*

import mymobileapp.code.mbasuony.learnc.R

 private var imageUrl:String=""
 private var titel:String=""
 private var  lesson:String=""

class FragmentLesson : Fragment()
{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        titel = this.arguments?.get("titel").toString()
        imageUrl=this.arguments?.get("imageUrl").toString()
        lesson=this.arguments?.get("content").toString()


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_lesson, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)


            Glide.with(this).load("http://www.arablancer.org/cplasplas/public" + imageUrl).into(imageContent)
            textTitelLesson.text = titel
            textContentLesson.text = lesson


        imageContent.setOnClickListener(
            {

                 val bundle=Bundle()
                 bundle.putString("imageUrl2", imageUrl)

                var fragmenFullScreen=FullImageFragment()
                    fragmenFullScreen.arguments=bundle

                   activity?.supportFragmentManager?.beginTransaction()
                       ?.replace(R.id.frameLayout_Lesson, fragmenFullScreen)
                       ?.commit()

            })



    }


}
