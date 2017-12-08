package kylejimer.lapiz.com.recipelist

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Greg on 6/12/2017.
 */
class FullRecipe:AppCompatActivity(){
    companion object {
        val KEY = "xxx"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.full_item_layout)
     val recipe:Recipe = intent.getParcelableExtra(KEY)

        val txtIngred = findViewById<TextView>(R.id.txtIngred) as TextView
        val txtProc = findViewById<TextView>(R.id.txtProc) as TextView
        val imgPic = findViewById<ImageView>(R.id.imageView) as ImageView
        txtIngred.append(recipe.ingred)
        txtProc.append(recipe.proc)
        val drawable: Drawable = resources.getDrawable(recipe.image)
        imgPic.setImageDrawable(drawable)

        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar

        toolbar.setSubtitle(recipe.name)
        setSupportActionBar(toolbar)
        toolbar.setBackgroundColor(Color.BLUE)
        if (getSupportActionBar() != null){
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
            getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        }

}override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}