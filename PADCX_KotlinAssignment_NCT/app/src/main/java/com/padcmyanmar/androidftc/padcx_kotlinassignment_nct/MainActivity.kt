package com.padcmyanmar.androidftc.padcx_kotlinassignment_nct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
fun main(){
//    isPalindrome()
    isBalancedParens()
}

fun isPalindrome() {
    var askAgain = true
    val sc = Scanner(System.`in`)
    while(askAgain) {
        var isPalindrome = true
        print("Please enter palindrome number ")
        val input = sc.next().toString()
        val index = input.length/2-1
        val startIndex = 0
        val endIndex = input.length-1
        for(i in 0..index) {
            if(input[startIndex+i] != input[endIndex-i]) {
                isPalindrome = false
                break
            }
        }
        if(isPalindrome) {
            askAgain = false
            println("The text you entered is Palindrome and you pass the test.")
            break
        }
        println("You fail!, Please try with other text...")
    }
    sc.close()

}
fun isBalancedParens() {
    print("Enter input ")
    val sc = Scanner(System.`in`)
    var input = sc.nextLine().toString()
    input = input.replace(" ","")
    var bracket = 0
    var paren = 0
    var curly = 0
    var countList = mutableListOf<Int>(0,0,0)
    var isInvalid = false
    checking@
    for(i in input) {
        when(i) {
            '[' -> {
                bracket+=1
                countList[0] += 1
            }
            '(' -> {
                paren += 1
                countList[1] += 1
            }
            '{' -> {
                curly += 1
                countList[2] += 1
            }
            ']' -> bracket -= 1
            ')' -> paren -=1
            '}' -> curly -=1
            else -> {
                isInvalid = true
                break@checking
            }
        }
    }
    if(bracket==0 && paren ==0 && curly==0 && !isInvalid) {
        println("It's balanced. pair of { = ${countList[2]}, pair of [ = ${countList[0]},pair of ( = ${countList[1]}")
    }else if(!isInvalid) {
        println("It's not balanced.")
    }else if(isInvalid) {
        println("invalid input format")
    }
    sc.close()
}
