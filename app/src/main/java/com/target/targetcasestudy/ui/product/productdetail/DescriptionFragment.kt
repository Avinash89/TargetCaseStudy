package com.target.targetcasestudy.ui.product.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.Product
import com.target.targetcasestudy.util.Dialog

class DescriptionFragment(var product: Product) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.description_fragment, container, false)
        var linLayout: LinearLayout = view.findViewById(R.id.lin_list_data)
        var image: ImageView = view.findViewById(R.id.img_product_desc)
        var index = 0
        var productDesc = product.description

        val dialog = Dialog()
        activity?.supportFragmentManager?.let { dialog.show(it, "tag") }

        Glide.with(image).load(product.image_url)
            .placeholder(R.drawable.ic_launcher_foreground).dontAnimate().into(image);
        view.findViewById<TextView>(R.id.txt_title_desc).text =
            product.title.split(' ').joinToString(" ") { it.capitalize() }

        while (index < productDesc.length) {
            val textView = TextView(activity)
            textView.text = productDesc.substring(index, Math.min(index + 3000, productDesc.length))
            linLayout.addView(textView)
            index += 3000
        }
        dialog.dismiss()
        return view
    }

}