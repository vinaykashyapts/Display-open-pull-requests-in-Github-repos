package com.vinay.vymoassignment.data.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Input : BaseObservable() {
    @Bindable
    var owner_name: String = ""
        get() {
            return owner_name
        }
        set(param) {
            field = param
        }

    @Bindable
    var repo_name: String = ""
        get() {
            return repo_name
        }
        set(param) {
            field = param
        }
}