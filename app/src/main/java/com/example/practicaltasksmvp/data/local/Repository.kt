package com.example.practicaltasksmvp.data.local

interface Repository<T> {

    fun getAll(): List<T>

    fun getById(id: Long): T?

    fun add(obj : T)

    fun addAll(objects: List<T>)
}