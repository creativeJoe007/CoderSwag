package joe.creative.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import joe.creative.coderswag.Adapters.ProductRecycleAdapter
import joe.creative.coderswag.R
import joe.creative.coderswag.Services.DataService
import joe.creative.coderswag.Utilities.EXTRA_CATEGORY
import joe.creative.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {
    private lateinit var adapter : ProductRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)

        adapter = ProductRecycleAdapter(this, DataService.getProducts(categoryType)) {
            val productDetailsIntent = Intent(this, ProductDetailsActivity::class.java)
            productDetailsIntent.putExtra(EXTRA_PRODUCT, it)
            startActivity(productDetailsIntent)
        }
        productListView.adapter = adapter

        val orientation = resources.configuration.orientation
        val screenSize = resources.configuration.screenWidthDp
        var spanCount = 2

        if (orientation === Configuration.ORIENTATION_LANDSCAPE) spanCount = 3
        if (screenSize > 720) spanCount = 3

        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.setHasFixedSize(true);
    }
}
