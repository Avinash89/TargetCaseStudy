package com.target.targetcasestudy.ui.product.productdetail

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.Product
import com.target.targetcasestudy.util.SeeMoreTextView
import com.target.targetcasestudy.util.onTextClicked


class DealItemFragment(private var product: Product) : Fragment(), onTextClicked {

    private lateinit var descAdapter: DescriptionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_deal_item, container, false)

        var image: ImageView = view.findViewById(R.id.img_product)
        var btnAddList: Button = view.findViewById(R.id.btn_add_list)
        var btnAddCart: Button = view.findViewById(R.id.btn_add_cart)
        var txtRegPrice: TextView = view.findViewById(R.id.txt_product_actual_price)
        var txtProductDesc: SeeMoreTextView = view.findViewById(R.id.txt_product_description)

        Glide.with(image).load(product.image_url)
            .placeholder(R.drawable.ic_launcher_foreground).dontAnimate().into(image);
        var productPrice: String;
        if (product.sale_price != null) {
            productPrice = product.sale_price!!.display_string
            txtRegPrice.text = product.regular_price.display_string
            txtRegPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            view.findViewById<TextView>(R.id.txt_reg_label).visibility = View.VISIBLE
        } else {
            productPrice = product.regular_price.display_string
        }
        view.findViewById<TextView>(R.id.txt_product_price).text = productPrice
        view.findViewById<TextView>(R.id.txt_product_title).text =
            product.title.split(' ').joinToString(" ") { it.capitalize() }
        txtProductDesc.setSeeMoreText("Show More", "Show Less")
        txtProductDesc.setTextMaxLength(250)
        txtProductDesc.setContent(product.description)
        txtProductDesc.expandText(false)
        txtProductDesc.setOnTextClicked(this)

        btnAddCart.setOnClickListener {
            Toast.makeText(activity, "Item added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddList.setOnClickListener {
            Toast.makeText(activity, "Item added to list", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onTextLongClicked() {
    }

    override fun onTextClicked() {
        if (product.description.length > 1000)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container,
                    DescriptionFragment(
                        product
                    )
                )?.addToBackStack(null)
                ?.commit()
    }
}
