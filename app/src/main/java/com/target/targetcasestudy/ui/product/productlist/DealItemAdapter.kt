package com.target.targetcasestudy.ui.product.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.Product

class DealItemAdapter(private var productList: List<Product>) :
    RecyclerView.Adapter<DealItemAdapter.DealItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.deal_list_item, parent, false)
        return DealItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
        val item = productList[position]
        viewHolder.productTitle.text = item.title.split(' ').joinToString(" ") { it.capitalize() }
        var productPrice : String;
        if (item.sale_price != null) {
            productPrice = item.sale_price!!.display_string
        } else {
            productPrice = item.regular_price.display_string
        }
        viewHolder.productPrice.text = productPrice
        viewHolder.productAisle.text = item.aisle
        Glide.with(viewHolder.productImage).load(item.image_url)
            .placeholder(R.drawable.ic_launcher_foreground).dontAnimate()
            .into(viewHolder.productImage);
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    var onItemClick: ((Product) -> Unit)? = null

    inner class DealItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImage: ImageView = itemView.findViewById(R.id.deal_list_item_image_view)
        var productTitle: TextView = itemView.findViewById(R.id.deal_list_item_title)
        var productPrice: TextView = itemView.findViewById(R.id.deal_list_item_price)
        var productAisle: TextView = itemView.findViewById(R.id.deal_list_item_aisle)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(productList[adapterPosition])
            }
        }
    }

}