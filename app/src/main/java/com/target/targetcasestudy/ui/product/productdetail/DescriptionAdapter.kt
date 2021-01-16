package com.target.targetcasestudy.ui.product.productdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.R

class DescriptionAdapter(private var descList: List<String>) :
    RecyclerView.Adapter<DescriptionAdapter.DescItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_desc, parent, false)
        return DescItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DescItemViewHolder, position: Int) {
        val item = descList[position]
        viewHolder.txtDesc.text = item
//        viewHolder.txtDesc.text = item.split(' ').joinToString(" ") { it.capitalize() }
//        var productPrice : String;
//        if (item.sale_price != null) {
//            productPrice = item.sale_price!!.display_string
//        } else {
//            productPrice = item.regular_price.display_string
//        }
//        viewHolder.productPrice.text = productPrice
//        Glide.with(viewHolder.productImage).load(item.image_url)
//            .placeholder(R.drawable.ic_launcher_foreground).dontAnimate()
//            .into(viewHolder.productImage);
    }

    override fun getItemCount(): Int {
        return descList.size
    }

//    var onItemClick: ((Product) -> Unit)? = null

    inner class DescItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var productImage: ImageView = itemView.findViewById(R.id.deal_list_item_image_view)
        var txtDesc: TextView = itemView.findViewById(R.id.txt_item_desc)
//        var productPrice: TextView = itemView.findViewById(R.id.deal_list_item_price)

//        init {
//            itemView.setOnClickListener {
//                onItemClick?.invoke(descList[adapterPosition])
//            }
//        }
    }

}