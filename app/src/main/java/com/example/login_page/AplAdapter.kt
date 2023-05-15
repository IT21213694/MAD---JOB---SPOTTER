package com.example.login_page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AplAdapter (private val aplList:ArrayList<ApplicationModel>):
    RecyclerView.Adapter<AplAdapter.ViewHolder>(){

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
       mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AplAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.apl_list_items,parent,false)
        return ViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val currentApl = aplList[position]
        holder.tvAplName.text = currentApl.aplName
    }

    override fun getItemCount(): Int {
        return aplList.size
    }
    class ViewHolder(itemView: View,clickListener: onItemClickListener):RecyclerView.ViewHolder(itemView){

        val tvAplName:TextView=itemView.findViewById(R.id.tvAplName)
        init{
            itemView.setOnClickListener{
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

}