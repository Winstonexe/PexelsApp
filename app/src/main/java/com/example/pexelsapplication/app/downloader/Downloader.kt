package com.example.pexelsapplication.app.downloader

interface Downloader {
    fun downloadFile(url: String, fileName: String): Long
}