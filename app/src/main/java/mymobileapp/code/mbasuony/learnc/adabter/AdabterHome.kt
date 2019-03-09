package mymobileapp.code.mbasuony.learnc.adabter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.row_recycler_home.view.*
import mymobileapp.code.mbasuony.learnc.LessonActivity
import mymobileapp.code.mbasuony.learnc.R
import mymobileapp.code.mbasuony.learnc.model.Data

class AdabterHome(var allData : ArrayList<Data>) : RecyclerView.Adapter<AdabterHome.ViewHolderIndex>()
{


    override fun onCreateViewHolder(viewGroup : ViewGroup, p1: Int): AdabterHome.ViewHolderIndex
    {
          var layoutInflator=LayoutInflater.from(viewGroup.context).inflate(R.layout.row_recycler_home,viewGroup,false)

          return ViewHolderIndex(layoutInflator)
    }

    override fun getItemCount(): Int  //Return Number Item in RecyclerView
    {
         return allData.size
    }

    override fun onBindViewHolder(viewHolder: AdabterHome.ViewHolderIndex, postion1: Int)
    {
       var item=allData[postion1]

        viewHolder.bind(item)
    }



    class ViewHolderIndex(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(data: Data)
        {
          val nameLesson=itemView.textTitle as TextView  //Create Object textTitle
              nameLesson.text=data.index_name

          itemView.setOnClickListener(
              {
                  val intent=Intent(itemView.context,LessonActivity::class.java)
                            intent.putExtra("Image_Lesson",data.image_url)
                            intent.putExtra("Titel_Lession",data.index_name)
                            intent.putExtra("Content_Lesson",data.lesson)
                  itemView.context.startActivity(intent)
              })

        }

    }

}