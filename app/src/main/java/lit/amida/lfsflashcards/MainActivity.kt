package lit.amida.lfsflashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.view.setMargins
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.view.marginBottom as marginBottom1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordList = listOf(
                Word(R.drawable.fruit_orange, "みかん", "orange"),
                Word(R.drawable.fruit_banana, "ばなな", "banana"),
                Word(R.drawable.fruit_grape, "ぶどう", "grape"),
                Word(R.drawable.fruit_melon, "めろん", "melon"),
        )

        wordList.forEach{ addWord(it) }
    }

    private fun addWord(word: Word){
        val linerLayout = LinearLayout(applicationContext)
        linerLayout.orientation = LinearLayout.HORIZONTAL
        linerLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f)
        linerLayout.gravity = Gravity.CENTER

        val imageView = ImageView(applicationContext)
        imageView.setImageResource(word.resId)
        setLayoutParams(imageView)

        val textName = TextView(applicationContext)
        textName.text = word.name
        setLayoutParams(textName)

        val textEng = TextView(applicationContext)
        textEng.text = word.nameEng
        setLayoutParams(textEng)

        linerLayout.addView(imageView)
        linerLayout.addView(textName)
        linerLayout.addView(textEng)

        container.addView(linerLayout)

    }

    fun setLayoutParams(v: View){
        v.layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        (v.layoutParams as ViewGroup.MarginLayoutParams).setMargins(24, 24, 24, 24)
    }
}