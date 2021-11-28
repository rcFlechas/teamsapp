package com.rcflechas.teamsapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rcflechas.teamsapp.core.Constants
import com.rcflechas.teamsapp.core.isConnect
import com.rcflechas.teamsapp.core.subscribe
import com.rcflechas.teamsapp.models.data.local.entities.TeamEntity
import com.rcflechas.teamsapp.models.data.remote.response.TeamResponse
import com.rcflechas.teamsapp.models.repositories.TeamRepository
import com.rcflechas.teamsapp.presentation.binds.TeamBind
import com.rcflechas.teamsapp.utilities.Event
import com.rcflechas.teamsapp.utilities.UIState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class TeamsViewModel (application: Application, private val teamRepository: TeamRepository) : AndroidViewModel(application) {

    private val subscriptions = CompositeDisposable()

    private val _getByLeagueName = MutableLiveData<Event<UIState<List<TeamBind>>>>()
    val getByLeagueName: LiveData<Event<UIState<List<TeamBind>>>> = _getByLeagueName

    fun getByLeagueName (leagueName: String, reload: Boolean = false) {
        if (reload) {
            getByLeagueNameRemote(leagueName)
        }
        this.getByLeagueNameLocal(leagueName)
    }

    private fun getByLeagueNameLocal(leagueName: String) {
        subscriptions.add(
            teamRepository.getTeamsByLeagueNameLocal(leagueName)
                .doOnSubscribe {
                    _getByLeagueName.postValue(Event(UIState.OnLoading(true)))
                }
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                    onSuccess = { teamsEntity ->

                        if (teamsEntity.isNotEmpty()) {
                            _getByLeagueName.postValue(Event(UIState.OnSuccess(teamsEntity.map(TeamEntity::toBind))))
                        } else {
                            getByLeagueNameRemote(leagueName)
                        }
                    },
                    onError = {
                        _getByLeagueName.postValue(Event( UIState.OnError(it.message ?: "Error" )))
                    }
                )
        )
    }

    private fun getByLeagueNameRemote (leagueName: String) {
        if (isConnect()) {
            subscriptions.add(
                teamRepository.getTeamsByLeagueNameRemote(leagueName)
                    .subscribeOn(Schedulers.io())
                    .subscribeBy(
                        onSuccess = {
                            saveTeams(it.teams.map(TeamResponse::toEntity))
                        },
                        onError = {
                            _getByLeagueName.postValue(Event( UIState.OnError( it.message ?: "Error" ) ))
                        }
                    )
            )
        } else {
            _getByLeagueName.postValue(Event( UIState.OnError( Constants.ERROR_NETWORK ) ))
        }
    }

    private fun saveTeams(teams: List<TeamEntity>) {
        subscriptions.add(
            teamRepository.insertAll(teams).subscribe(_getByLeagueName)
        )
    }

    fun closeSubscriptions() {
        subscriptions.dispose()
    }
}