package kylejimer.lapiz.com.recipelist

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Greg on 6/12/2017.
 */
data class Recipe(
        val image: Int =0,
        val name: String="",
                  val Description: String="",

                  val ingred: String="",
                  val proc: String="") : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(Description)
        parcel.writeString(ingred)
        parcel.writeString(proc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}