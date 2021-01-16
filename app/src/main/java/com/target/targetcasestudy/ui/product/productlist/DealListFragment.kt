package com.target.targetcasestudy.ui.product.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.Product
import com.target.targetcasestudy.ui.product.productdetail.DealItemFragment


class DealListFragment(private var productList: List<Product>) : Fragment() {

    private lateinit var dealAdapter: DealItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_deal_list, container, false)

        dealAdapter =
            DealItemAdapter(
                productList
            )
        view.findViewById<RecyclerView>(R.id.recycler_view).layoutManager =
            LinearLayoutManager(requireContext())
        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = dealAdapter
        dealAdapter.onItemClick = { product ->
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(
                    R.id.container,
                    DealItemFragment(
                        product
                    )
                )?.addToBackStack(null)
                ?.commit()
        }
        return view
    }
}
