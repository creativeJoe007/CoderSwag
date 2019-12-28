package joe.creative.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import joe.creative.coderswag.Model.Category
import joe.creative.coderswag.R
import kotlinx.android.synthetic.main.activity_main.*

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {
    val context = context
    val categories = categories
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)

        val categoryImage = categoryView.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = categoryView.findViewById<TextView>(R.id.categoryName)
        println("Heavy Computing")

        val category = categories[position]

        val resourceID = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryImage.setImageResource(resourceID)
        categoryName.text = category.title

        println(resourceID)

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }
}