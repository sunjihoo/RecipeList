package kylejimer.lapiz.com.recipelist

/**
 * Created by Greg on 6/12/2017.
 */
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter(val RecipeList: ArrayList<Recipe>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    companion object {
        val KEY = "xxx"
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(R.id.txtFname) as TextView
        val txtDescription = itemView.findViewById<TextView>(R.id.txtFDesc) as TextView
        val vCardView = itemView.findViewById<CardView>(R.id.cardView) as CardView
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val foods: Recipe = RecipeList[position]
        holder?.txtName?.text = foods.name
        holder?.txtDescription?.text = foods.Description
        holder?.vCardView?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View){
                val nextAct = Intent(v.context, FullRecipe::class.java)
                nextAct.putExtra(KEY, foods)
                v.context.startActivity(nextAct)
            }
        })
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return RecipeList.size
    }


}