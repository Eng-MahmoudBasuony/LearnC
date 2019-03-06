package mymobileapp.code.mbasuony.learnc.fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_about.*
import mymobileapp.code.mbasuony.learnc.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        emailAboutFragment.setOnClickListener {

            startActivity(Intent(Intent.ACTION_VIEW,
                          Uri.parse("mailto:"+"mbasuony83@gmail.com"+"?subject="+"Message From App Learn C++")))
        }

        facebookAboutFragment.setOnClickListener {

            startActivity(Intent(Intent.ACTION_VIEW,
                                 Uri.parse("https://www.facebook.com/EMBasuony")))

        }

    }





}
