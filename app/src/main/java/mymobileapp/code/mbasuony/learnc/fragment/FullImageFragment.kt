package mymobileapp.code.mbasuony.learnc.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_fragment_lesson.*
import kotlinx.android.synthetic.main.fragment_full_image.*

import mymobileapp.code.mbasuony.learnc.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FullImageFragment : Fragment()
{
    private var imageUrl:String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View?
    {

        imageUrl=this.arguments?.get("imageUrl2").toString()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_image,container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        Glide.with(this).load("http://www.arablancer.org/cplasplas/public" + imageUrl).into(imageFull)
    }



}
