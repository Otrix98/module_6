package com.example.module_61

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_main.*

data class FormState(
    var valid: Boolean,
    val message: String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString().orEmpty()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (valid) 1 else 0)
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FormState> {
        override fun createFromParcel(parcel: Parcel): FormState {
            return FormState(parcel)
        }

        override fun newArray(size: Int): Array<FormState?> {
            return arrayOfNulls(size)
        }
    }
}