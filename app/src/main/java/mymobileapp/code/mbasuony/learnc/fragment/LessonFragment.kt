package mymobileapp.code.mbasuony.learnc.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_lesson.*

import mymobileapp.code.mbasuony.learnc.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LessonFragment : Fragment() {

    private var titel:String = ""
    private var imageUrl:String = ""
    private var lesson:String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {

             titel = this.arguments?.get("titel").toString()
             imageUrl=this.arguments?.get("imageUrl").toString()
             lesson=this.arguments?.get("content").toString()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lesson, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

         Glide.with(this).load("http://www.arablancer.org/cplasplas/public"+imageUrl).into(imageContent)

         textTitelLesson.text=titel
         textContentLesson.text=lesson


        imageContent.setOnClickListener {


        }
    }


}
