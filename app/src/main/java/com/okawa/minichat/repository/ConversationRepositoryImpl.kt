package com.okawa.minichat.repository

import android.arch.lifecycle.LiveData
import com.okawa.minichat.api.model.Conversation
import com.okawa.minichat.db.relation.FullMessage
import com.okawa.minichat.utils.ApiManager
import com.okawa.minichat.utils.AppExecutors
import com.okawa.minichat.utils.DataHandler
import com.okawa.minichat.utils.DatabaseManager
import javax.inject.Inject

class ConversationRepositoryImpl
@Inject constructor(private val apiManager: ApiManager,
                    private val appExecutors: AppExecutors,
                    private val databaseManager: DatabaseManager
) : ConversationRepository {

    override fun getConversation(): LiveData<List<FullMessage>> {
        object : DataHandler<Conversation>(appExecutors) {

            override fun requestFromNetwork() = !databaseManager.checkIfHasDataStored()

            override fun requestToExecute() = apiManager.getConversation()

            override fun onError() {

            }

            override fun onSuccess(conversation: Conversation) {
                databaseManager.storeConversation(conversation)
            }

        }

        return databaseManager.retrieveConversation()
    }

}