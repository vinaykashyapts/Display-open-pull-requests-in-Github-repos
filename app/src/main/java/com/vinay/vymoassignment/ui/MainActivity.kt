package com.vinay.vymoassignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vinay.vymoassignment.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myfragment = InputRepoDetailsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentFragment, myfragment)
            .commitAllowingStateLoss()
    }

    /*
    private var myCompositeDisposable: CompositeDisposable? = null
    private val BASE_URL = "https://api.github.com/repos/square/okhttp/"
    private fun init() {

        val rep = RepoPullsRepository(GithubAPI())
        GlobalScope.launch(Dispatchers.Main) {
            val pulls = rep.getRepoPulls()
            Toast.makeText(this@MainActivity, pulls.toString(), Toast.LENGTH_LONG).show();
        }

        myCompositeDisposable = CompositeDisposable()
        loadData()
    }

    private fun loadData() {

        val requestInterface = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(GetData::class.java)
        myCompositeDisposable?.add(
            requestInterface.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse))
    }

    private fun handleResponse(repoList: List<RepoPulls>) {
        Toast.makeText(this@MainActivity, repoList.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        myCompositeDisposable?.clear()
    }
    */
}