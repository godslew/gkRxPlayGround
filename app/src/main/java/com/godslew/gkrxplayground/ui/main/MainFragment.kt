package com.godslew.gkrxplayground.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.godslew.gkrxplayground.R
import com.godslew.gkrxplayground.client.GitHubClient
import com.godslew.gkrxplayground.extension.bindTo
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val disposable = CompositeDisposable()
    @Inject
      internal lateinit var gitHubClient: GitHubClient

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        button.setOnClickListener {
            viewModel.createSingle()
            //github()

        }
    }

    fun github() {
        gitHubClient.getUser("godslew") // API
            .observeOn(AndroidSchedulers.mainThread()) // 結果を受け取るスレッド
            .subscribeOn(Schedulers.io()) // 購読するスレッド
            .subscribe{ u -> Log.d("Main", "snake00 $u") }  //購読開始
            //.bindTo { Log.d("Main", "snake00 $it") } //購読開始
            .addTo(disposable) // dispose管理

        gitHubClient.getRepos("godslew")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .bindTo { it.forEach {  repo -> Log.d("Main", "snake00 ${repo.name}")} }
            .addTo(disposable)
    }

}
