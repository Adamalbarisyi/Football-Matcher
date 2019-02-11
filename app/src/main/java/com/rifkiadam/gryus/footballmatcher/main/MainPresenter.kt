package com.rifkiadam.gryus.footballmatcher.main

import com.google.gson.Gson
import com.rifkiadam.gryus.footballmatcher.api.ApiRepository
import com.rifkiadam.gryus.footballmatcher.api.TheSportDBApi
import com.rifkiadam.gryus.footballmatcher.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson
) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }

}
