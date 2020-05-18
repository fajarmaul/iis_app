package com.mauldev.iisapp.model

data class Pengumuman(
    var title: String = "",
    var name: String = "",
    var schoolName: String = "",
    var date: String = "",
    var time: String = "",
    var isConfirmed: Boolean = false,
    var confirmationStatus: String = ""
)