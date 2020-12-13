package com.example.firsthomework.ui.news

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.ui.healper.newsArray
import com.example.firsthomework.ui.healper.showActionSnackbar
import com.example.firsthomework.ui.News
import com.example.firsthomework.ui.detail_news.DetailNewsActivity
import com.example.firsthomework.ui.healper.showSingleAlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NewsAdapter.Listener {

    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAdapter()
        addAction()
    }

    private fun setupAdapter() {
        adapter = NewsAdapter(this)
        news_list.layoutManager = LinearLayoutManager(this)
        news_list.adapter = adapter
        adapter.updateItem(newsArray)
    }

    private var news: News? = null
    override fun onItemClick(item: News) {
        news = item
        val intent = Intent(this, DetailNewsActivity::class.java)
        intent.putExtra("news", news)
        startActivity(intent)
    }

    var position: Int? = null
    override fun onLongItemClick(item: News, position: Int) {
        news = item
        this.position = position
        showSingleAlertDialog(this::deleteItem, this, "Вы уверены что хотите удалить новость",
            "Удалить", "Отменить")
    }

    private fun addAction() {
        add_fab.setOnClickListener {
            showAddAlertDialog()
        }
    }

    private fun showAddAlertDialog() {
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)

        val inflater = layoutInflater.inflate(R.layout.alert_add, null)
        alert.setView(inflater)
        val image = inflater.findViewById<EditText>(R.id.set_image)
        val title = inflater.findViewById<EditText>(R.id.title_edit_text)
        val subtitle = inflater.findViewById<EditText>(R.id.subtitle_edit_text)
        val positive = inflater.findViewById<Button>(R.id.add_positive_button)
        val negative = inflater.findViewById<Button>(R.id.add_negative_button)
        val dialog = alert.create()
        positive.setOnClickListener {
            addItem(image, title, subtitle, dialog)
        }
        negative.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun deleteItem() {
        showActionSnackbar(
            news_list,
            "Новость удалена",
            "Востановить",
            this::restoreNewsItem,
            this
        )
        adapter.deleteItem(position!!)
    }

    private fun addItem(imageEditText: EditText, titleEditText: EditText,
                        subtitleEditText: EditText, dialog: AlertDialog) {
        var error = 0
        if (isEmptyInputData(imageEditText, "Добавьте картинку")) error += 1
        if (isEmptyInputData(titleEditText, "Добавьте заголовок")) error += 1
        if (isEmptyInputData(subtitleEditText, "Добавьте описание")) error += 1

        if (error > 0) return

        val news = News(imageEditText.text.toString() , titleEditText.text.toString(),
            subtitleEditText.text.toString(), "")
        adapter.addItem(news)
        dialog.dismiss()
    }

    private fun isEmptyInputData(view: EditText, message: String): Boolean {
        if (view.text.isNullOrEmpty()){
            view.error = message
            return true
        }
        return false
    }

    private fun restoreNewsItem() {
        if (news != null && position != null) adapter.restoreItem(news!!, position!!)
    }
}
