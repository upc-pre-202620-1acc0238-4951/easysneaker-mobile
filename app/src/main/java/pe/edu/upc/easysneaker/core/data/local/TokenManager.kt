package pe.edu.upc.easysneaker.core.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

import javax.inject.Inject


class TokenManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private val tokenKey = stringPreferencesKey("token")

    suspend fun getAuthToken(): String? {
        return dataStore.data.map {
            it[tokenKey]
        }.first()
    }

    suspend fun saveAuthToken(token: String) {
        dataStore.edit { it[tokenKey] = token }
    }


}
