package com.okawa.minichat.repository

import android.arch.lifecycle.LiveData
import com.okawa.minichat.api.model.Conversation
import com.okawa.minichat.data.NetworkBoundResource
import com.okawa.minichat.data.Result
import com.okawa.minichat.db.relation.FullMessage
import com.okawa.minichat.utils.ApiManager
import com.okawa.minichat.utils.AppExecutors
import com.okawa.minichat.utils.DatabaseManager
import javax.inject.Inject

class ConversationRepositoryImpl
@Inject constructor(private val apiManager: ApiManager,
                    private val appExecutors: AppExecutors,
                    private val databaseManager: DatabaseManager
) : ConversationRepository {

    override fun getConversation(): LiveData<Result<List<FullMessage>>> {
        return object : NetworkBoundResource<List<FullMessage>, Conversation>(appExecutors) {

            override fun shouldRequestFromNetwork(data: List<FullMessage>?) = data?.isEmpty() == true

            override fun saveCallResult(data: Conversation?) {
                databaseManager.storeConversation(data?:return)
            }

            override fun loadFromDatabase() = databaseManager.retrieveConversation()

            override fun createCall() = apiManager.getConversation()

        }.asLiveData()
    }

}