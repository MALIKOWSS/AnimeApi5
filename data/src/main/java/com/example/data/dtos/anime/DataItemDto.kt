package com.example.data.dtos.anime

import com.example.domain.models.DataItem
import com.google.gson.annotations.SerializedName

data class DataItemDto(
    @SerializedName("attributes")
    val attributes: AttributesDto,
    @SerializedName("id")
    val id: String
)

fun DataItemDto.toDomain() : DataItem = DataItem(
    attributes.toDomain(),
    id
)