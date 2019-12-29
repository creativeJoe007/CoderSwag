package joe.creative.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import joe.creative.coderswag.Model.Product
import joe.creative.coderswag.R
import joe.creative.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val productData = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)

        val resourceID = resources.getIdentifier(productData.image,
            "drawable", this.packageName)

        productDetailsImage.setImageResource(resourceID)
        productDetailsImage.contentDescription = "Product Image For ${productData.title?.toUpperCase()}"
        productDetailsName.text = productData.title
        productDetailsPrice.text = productData.price
    }
}
