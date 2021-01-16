package com.target.targetcasestudy.ui.product

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.Product
import com.target.targetcasestudy.ui.product.productlist.DealListFragment
import com.target.targetcasestudy.ui.payment.PaymentDialogFragment
import com.target.targetcasestudy.util.Dialog
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel: MainActivityViewModel
    var productList = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog = Dialog()
        dialog.show(supportFragmentManager, "tag")

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getProducts()!!.observe(this, Observer { serviceSetterGetter ->
            productList = serviceSetterGetter.products as ArrayList<Product>
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    DealListFragment(
                        productList
                    )
                )
                .commit()
            dialog.dismiss()
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.credit_card -> {
                PaymentDialogFragment().show(supportFragmentManager, "CreditCardValidation")
                true
            }
            else -> false
        }
    }
}
