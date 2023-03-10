package com.binbraw.model.response.user

import com.binbraw.model.base.MetaResponse
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    val meta:MetaResponse,
    val data:RegisterResponseData
)

@Serializable
data class RegisterResponseData(
    val email:String,
    val token:String
)
