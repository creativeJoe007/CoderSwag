package joe.creative.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import joe.creative.coderswag.Model.Product
import joe.creative.coderswag.R


class ProductRecycleAdapter(val context: Context, val products: List<Product>, val itemClicked: (Product) -> Unit) : RecyclerView.Adapter<ProductRecycleAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImage = itemView.findViewById<ImageView>(R.id.productImage)
        var productName = itemView.findViewById<TextView>(R.id.productName)
        var productPrice = itemView.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context) {
            // get resource ID for static image
            val resourceID = context.resources.getIdentifier(product.image, "drawable", context.packageName)

            productImage.setImageResource(resourceID)
            productImage.contentDescription = "Images for products named ${product.title}"
            productName.text = product.title
            productPrice.text = product.price

            itemView.setOnClickListener{
                itemClicked(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.product_list_item, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindProduct(products[position], context)
    }
}