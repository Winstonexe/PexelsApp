package com.example.pexelsapplication.domain

data class PexelsResponseDomain(
    val page: Int,
    val perPage: Int,
    val photos: List<PhotoDomain>,
    val totalResults: Int,
    val nextPage: String?
)