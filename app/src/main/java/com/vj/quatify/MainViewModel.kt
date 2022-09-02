package com.vj.quatify

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.vj.quatify.retrofit.QuatesApiInterface
import com.vj.quatify.retrofit.QuatesRet
import com.vj.quatify.retrofit.RetrofitService
import com.vj.quatify.roomdb.QuatesDb
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(var context: Context) : ViewModel() {

    private lateinit var quatesDb: QuatesDb

    private var qlist: Array<Quates> = emptyArray()
    private var index=0

    init {
        qlist= loadQuates()
        quatesDb= QuatesDb.getdatabase(context.applicationContext)

        //loadQuotesFromAPI()

    }

//    private fun loadQuotesFromAPI() {
//        val quotesApiInterface=RetrofitService.getInstance().create(QuatesApiInterface::class.java)
//        val apiQuotes=quotesApiInterface.getQuates()
//        apiQuotes.enqueue(object :Callback<List<QuatesRet>>{
//            override fun onResponse(call: Call<List<QuatesRet>>, response: Response<List<QuatesRet>>) {
//                val QuotesList=response.body()
//                if(QuotesList!=null){
//                    Log.d("retrofit",QuotesList[0].toString())
//                }
//            }
//
//            override fun onFailure(call: Call<List<QuatesRet>>, t: Throwable) {
//                Log.d("Retrofit", "Fail to retrieve $t")
//            }
//        })
//        //loadIntoDb()
//    }

    private fun loadIntoDb(){

//        var i=0
////        var qlistdb:Array<QuatesEn> = emptyArray()
//
//
//        while (i<10){
//            var job=GlobalScope.launch {
//                quatesDb.getDao().insertQuates(QuatesEn(0,qlist[i].author,qlist[i].text))
//                Log.d("insert",qlist[i].toString())
//            }
//            job.join()
//            i++
//        }





    }

    private fun loadQuates(): Array<Quates> {
        var inputStream=context.assets.open("quotes.json")
        val size:Int = inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json= String(buffer, Charsets.UTF_8)
        val gson=Gson();
        return   gson.fromJson(json, Array<Quates>::class.java)
    }


    fun getQuotes(): Quates{
        return qlist[index]
    }

    fun nextQuote(): Quates {
       return qlist[++index]
    }
    fun previousQuote(): Quates {
       return qlist[--index]
    }

}