package joe.creative.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import joe.creative.coderswag.R
import joe.creative.coderswag.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)
    }
}
