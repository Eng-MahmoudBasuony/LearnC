package mymobileapp.code.mbasuony.learnc.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import mymobileapp.code.mbasuony.learnc.R
import mymobileapp.code.mbasuony.learnc.model.Data
import mymobileapp.code.mbasuony.learnc.network.ApiRetrofit
import mymobileapp.code.mbasuony.learnc.viewholder.AdabterHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
class HomeFragment : Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        fetchData()
        recyclerHomeActivity.layoutManager=LinearLayoutManager(this.context,LinearLayout.VERTICAL,false)



    }


    fun fetchData()
    {
        val BASE_URL="http://www.arablancer.org/cplasplas/public/api/"
        //Configuration for Retrofit
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Configuration for Call
        val apiRetrofit:ApiRetrofit=retrofit.create(ApiRetrofit::class.java)
        val call=apiRetrofit.getData()

        var item=call.enqueue(object :Callback<ArrayList<Data>>
                                     {
                                         override fun onFailure(call: Call<ArrayList<Data>>, t: Throwable)
                                         {
                                               Toast.makeText(activity,"Failed to make API call",Toast.LENGTH_LONG).show()
                                               Log.e("Call onFailure",""+t.message)
                                         }
                                         override fun onResponse( call: Call<ArrayList<Data>>,response: Response<ArrayList<Data>>)
                                         {
                                                      // response.body()[0] ---> Fetch First Json Object
                                                     //  response.body()[0].index_name ---> Fetch First Json Object and Fetch Value for index_name

                                             var allData : ArrayList<Data>? = response.body() //get All Data return ArrayList<Data>
                                              // allData.get(0).index_name ---> Fetch First Json Object

                                             recyclerHomeActivity.adapter=AdabterHome(allData!!)

                                         }

                                     })
    }



}
