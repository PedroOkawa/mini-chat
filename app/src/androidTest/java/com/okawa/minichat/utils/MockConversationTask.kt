package com.okawa.minichat.utils

import android.arch.lifecycle.MutableLiveData
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.idling.CountingIdlingResource
import com.okawa.minichat.api.model.Conversation
import com.okawa.minichat.api.response.ApiResponse
import org.mockito.Mockito
import retrofit2.Response
import javax.inject.Inject

class MockConversationTask @Inject constructor(private val apiManager: ApiManager, private val appExecutors: AppExecutors, private val fileHelper: FileHelper) {

    companion object {
        private const val RESOURCE_NAME = "mock_conversation"
        private const val SUCCESS_FILE_NAME = "success/conversation.json"
    }

    private val idlingResource = CountingIdlingResource(RESOURCE_NAME)

    private val mockedResult = MutableLiveData<ApiResponse<Conversation>>()

    fun mockSuccessConversation() {
        idlingResource.increment()
        appExecutors.getMainThread().execute {
            mockedResult.value = ApiResponse.create(Response.success(retrieveMockedConversation()))
            Mockito.`when`(apiManager.getConversation()).thenReturn(mockedResult)
            idlingResource.decrement()
        }
    }

    private fun retrieveMockedConversation() = fileHelper .loadJSONFromAsset<Conversation>(
                    SUCCESS_FILE_NAME,
                    Conversation::class.java)

    fun register() {
        IdlingRegistry.getInstance().register(idlingResource)
    }

    fun unregister() {
        IdlingRegistry.getInstance().unregister(idlingResource)
    }

}