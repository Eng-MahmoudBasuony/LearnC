package mymobileapp.code.mbasuony.learnc.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mymobileapp.code.mbasuony.learnc.R

class AdabterHome() : RecyclerView.Adapter<AdabterHome.ViewHolderIndex>()
{


    override fun onCreateViewHolder(viewGroup : ViewGroup, p1: Int): AdabterHome.ViewHolderIndex
    {
          var layoutInflator=LayoutInflater.from(viewGroup.context).inflate(R.layout.row_recycler_home,viewGroup,false)

          return ViewHolderIndex(layoutInflator)
    }

    override fun getItemCount(): Int  //Return Number Item in RecyclerView
    {
         return 9
    }

    override fun onBindViewHolder(p0: AdabterHome.ViewHolderIndex, p1: Int)
    {

    }



    class ViewHolderIndex(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }

}