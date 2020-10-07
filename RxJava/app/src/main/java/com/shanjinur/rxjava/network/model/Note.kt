package com.shanjinur.rxjava.network.model

class Note:BaseResponse() {
    var id:Int = 0
        private set
    lateinit var note:String
        private set
    lateinit var timestamp: String
        private set
}