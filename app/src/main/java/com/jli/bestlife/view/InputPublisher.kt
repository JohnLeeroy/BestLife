package com.jli.bestlife.view

import io.reactivex.Observable


interface InputPublisher<EVENT : BaseInputEvent> {
    fun getInputObservable() : Observable<EVENT>
}
