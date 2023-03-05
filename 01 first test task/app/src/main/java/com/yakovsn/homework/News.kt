package com.yakovsn.homework

import com.google.gson.annotations.SerializedName
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(strict = false, name = "News")
class News {
    @field:Element(name = "date", required = false)
    @SerializedName("date")
    var date: String? = null

    @field:Element(name = "description", required = false)
    @SerializedName("description")
    var description: String? = null

    @field:Element(name = "id", required = false)
    @SerializedName("id")
    var id: Int? = null

    @field:ElementList(name = "keywords", required = false)
    @SerializedName("keywords")
    lateinit var keywords: List<String>

    @field:Element(name = "title", required = false)
    @SerializedName("title")
    var title: String? = null

    @field:Element(name = "visible", required = false)
    @SerializedName("visible")
    var visible: Boolean? = null

}