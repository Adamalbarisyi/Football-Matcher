package com.rifkiadam.gryus.footballmatcher.main

import com.rifkiadam.gryus.footballmatcher.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}