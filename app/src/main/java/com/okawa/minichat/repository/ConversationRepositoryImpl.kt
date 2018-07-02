package com.okawa.minichat.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.okawa.minichat.api.model.Conversation
import com.okawa.minichat.data.NetworkBoundResource
import com.okawa.minichat.data.Result
import com.okawa.minichat.db.relation.FullMessageEntity
import com.okawa.minichat.utils.ApiManager
import com.okawa.minichat.utils.AppExecutors
import com.okawa.minichat.utils.DatabaseManager
import javax.inject.Inject

class ConversationRepositoryImpl
@Inject constructor(private val apiManager: ApiManager,
                    private val appExecutors: AppExecutors,
                    private val databaseManager: DatabaseManager
) : ConversationRepository {

    companion object {
        private const val PAGE_SIZE = 20
    }

    override fun getConversation(): LiveData<Result<PagedList<FullMessageEntity>>> {
        return object : NetworkBoundResource<PagedList<FullMessageEntity>, Conversation>(appExecutors) {

            override fun shouldRequestFromNetwork(data: PagedList<FullMessageEntity>?) = data?.isEmpty() == true

            override fun saveCallResult(data: Conversation?) {
                databaseManager.storeConversation(data?:return)
            }

            override fun loadFromDatabase() = LivePagedListBuilder(databaseManager.retrieveConversation(), PAGE_SIZE).build()

            override fun createCall() = apiManager.getConversation()

        }.asLiveData()
    }

}