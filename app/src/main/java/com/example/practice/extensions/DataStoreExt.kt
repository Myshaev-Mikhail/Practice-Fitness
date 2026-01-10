package com.example.practice.extensions

import android.content.Context
import com.example.practice.App
import com.example.practice.data.datastore.UserProfileDataStore

val Context.userProfileDataStore: UserProfileDataStore
    get() = (applicationContext as App).userProfileDataStore