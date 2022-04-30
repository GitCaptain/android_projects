package com.example.kotlinlearn

const val MaxBorrowNumber = 3

object Constants {
    const val BASE_URL: String = "a"

}

open class Book(val Title: String, val Author: String, val Year: String) {
    private var currentBorrow: Int = 0
    private var currentPage: Int = 1

    var pages: Int = 100

    companion object {
        const val URL: String = "url"
    }

    fun printURL() {
        println("${Constants.BASE_URL}/$URL/$Title.html")
    }

    fun canBorrow(): Boolean {
        return currentBorrow < MaxBorrowNumber
    }

    open fun readPage() {
        currentPage += 1
    }

    fun getTitleAndAuthor(): Pair<String, String> {
        return Title to Author
    }

    fun getTitleAndAuthorAndYear(): Triple<String, String, String> {
        return Triple(Title, Author, Year)
    }
}

val Book.weight: Double
    get() = pages * 1.5

fun Book.tornPages(torn: Int = 3) {
    pages -= torn
}

class Poppy {
    fun PlayWithBook(b: Book, pages: Int) {
        b.tornPages(pages)
    }
}

class eBook(Title: String, Author: String, Year: String, var format: String = "text"): Book(Title, Author, Year) {
    private var wordCount: Int = 0

    override fun readPage() {
        wordCount += 250
    }
}
