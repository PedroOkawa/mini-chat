package com.okawa.minichat.utils

import android.content.Context
import com.google.gson.Gson
import java.lang.reflect.Type
import java.io.FileNotFoundException
import java.io.InputStreamReader

class FileHelper(private val context: Context, private val gson: Gson) {

    fun <T> loadJSONFromAsset(fileName: String, type: Type): T? {
        try {
            val assetManager = context.resources.assets
            val inputStream = assetManager.open(fileName)
            val reader = InputStreamReader(inputStream, Charsets.UTF_8)

            return gson.fromJson<T>(reader, type)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        return null
    }

}
