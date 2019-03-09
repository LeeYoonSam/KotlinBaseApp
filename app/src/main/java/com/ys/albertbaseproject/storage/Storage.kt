package com.ys.albertbaseproject.storage

interface Storage {
    fun save(alias: String, data: ByteArray)

    /**
     * @param alias
     * @return
     * @throws IllegalArgumentException 저장되어있지 않은 값을 불러올 때 에러발생
     */
    @Throws(NoSuchElementException::class)
    fun load(alias: String): ByteArray

    fun deleteKey(alias: String)
}