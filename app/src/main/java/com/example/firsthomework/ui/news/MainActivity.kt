package com.example.firsthomework.ui.news

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.newsArray
import com.example.firsthomework.showActionSnackbar
import com.example.firsthomework.showSnackbar
import com.example.firsthomework.ui.News
import com.example.firsthomework.ui.detail_news.DetailNewsActivity
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

    override fun onItemClick(item: News) {
        val intent = Intent(this, DetailNewsActivity::class.java)
        intent.putExtra("news", item)
        startActivity(intent)
    }

    private var news: News? = null
    var position: Int? = null
    override fun onLongItemClick(item: News, position: Int) {
        news = item
        this.position = position
        showAlertDialog(R.layout.custom_dialog, R.id.positive_button, R.id.negative_button, false)
    }

    private fun addAction() {
        add_fab.setOnClickListener {
            showAlertDialog(
                R.layout.alert_add,
                R.id.add_positive_button,
                R.id.add_negative_button,
                true
            )
        }
    }

    private fun showAlertDialog(view: Int, positive: Int, negative: Int, boolean: Boolean) {
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)
        val inflater = layoutInflater.inflate(view, null)
        alert.setView(inflater)
            .setCancelable(false)
        val positiveButton: Button = inflater.findViewById(positive)
        val negativeButton: Button = inflater.findViewById(negative)
        val dialog = alert.create()
        positiveButton.setOnClickListener {
            if (boolean) {
                val imageURL: EditText = inflater.findViewById(R.id.set_image)
                val title: EditText = inflater.findViewById(R.id.title_edit_text)
                val subtitle: EditText = inflater.findViewById(R.id.subtitle_edit_text)
                if (title.text.isEmpty() && subtitle.text.isEmpty() && imageURL.text.isEmpty()) {
                    title.error = "Добавьте заголовок"
                    subtitle.error = "Добавьте описание"
                    imageURL.error = "Добавьте url картинки"
                    showSnackbar(news_list, "Добавьте картинку, заголовок и описание")
                    return@setOnClickListener
                }
                if (title.text.isEmpty() && imageURL.text.isEmpty()) {
                    title.error = "Добавьте заголовок"
                    imageURL.error = "Добавьте url картинки"
                    showSnackbar(news_list, "Добавьте заголовок и url картинки")
                    return@setOnClickListener
                }
                if (title.text.isEmpty() && subtitle.text.isEmpty()) {
                    title.error = "Добавьте заголовок"
                    subtitle.error = "Добавьте описание"
                    showSnackbar(news_list, "Добавьте заголовок и описание")
                    return@setOnClickListener
                }
                if (imageURL.text.isEmpty()){
                    title.error = "Добавьте url картинки"
                    showSnackbar(news_list, "Нельзя загрузить картинку без ссылки")
                    return@setOnClickListener
                }
                if (title.text.isEmpty()) {
                    title.error = "Добавьте заголовок"
                    showSnackbar(news_list, "Нельзя добавить пустой заговок")
                    return@setOnClickListener
                }
                if (subtitle.text.isEmpty()) {
                    subtitle.error = "Добавьте описание"
                    showSnackbar(news_list, "Нельзя добавить пустое описание")
                    return@setOnClickListener
                }
                addItem(imageURL.text.toString() ,title.text.toString(), subtitle.text.toString())
            }
            if (!boolean) deleteItem()
            dialog.dismiss()
        }
        negativeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun deleteItem() {
        adapter.deleteItem(position!!)
        showActionSnackbar(news_list, "Новость удалена", "Востановить", this::restoreNewsItem, this)
    }

    private fun addItem(image: String, title: String, subtitle: String) {
        val news = News(image , title, subtitle, "")
        adapter.addItem(news)
    }

    private fun restoreNewsItem() {
        if (news != null && position != null) adapter.restoreItem(news!!, position!!)
    }
}
