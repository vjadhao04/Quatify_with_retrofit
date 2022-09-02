package com.vj.quatify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.vj.quatify.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var quates: Quates

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)


        mainViewModel=ViewModelProvider(this, MainVMFactory(application)).get(MainViewModel::class.java)
        quates=mainViewModel.getQuotes()
        setQuates()


    }

    fun onPrevious(view: android.view.View) {
        quates=mainViewModel.previousQuote()
        setQuates()

    }
    fun onNext(view: android.view.View) {
        quates=mainViewModel.nextQuote()
        setQuates()
    }
    fun setQuates(){
        binding.quoteText.text=quates.text
        binding.quoteAuthor.text=quates.author
    }


    fun onShare(view: android.view.View) {
        quates=mainViewModel.getQuotes()
        val intent= Intent()
        intent.action=Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, quates.text)
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Share Via"))
    }
}