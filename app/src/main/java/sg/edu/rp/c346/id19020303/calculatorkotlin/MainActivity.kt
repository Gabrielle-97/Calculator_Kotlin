package sg.edu.rp.c346.id19020303.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    var isNewOp = true
    var dot = false


    fun onDigit(view: View){

        if(isNewOp){
            txtInput.setText("")
        }
        isNewOp = false
        val btnSelected = view as Button
        var btnClickDigit:String = txtInput.text.toString()

        when(btnSelected.id){
            btnZero.id -> {
                btnClickDigit+="0"
            }
            btnOne.id -> {
                btnClickDigit+="1"
            }
            btnTwo.id -> {
                btnClickDigit+="2"
            }
            btnThree.id -> {
                btnClickDigit+="3"
            }
            btnFour.id -> {
                btnClickDigit+="4"
            }
            btnFive.id -> {
                btnClickDigit+="5"
            }
            btnSix.id -> {
                btnClickDigit+="6"
            }
            btnSeven.id -> {
                btnClickDigit+="7"
            }
            btnEight.id -> {
                btnClickDigit+="8"
            }
            btnNine.id -> {
                btnClickDigit+="9"
            }

            btnDecimal.id -> {
                if(dot == false){
                    btnClickDigit += "."
                }
                dot = true
            }


        }
        txtInput.setText(btnClickDigit)
    }

    var op="*"
    var oldNumber = ""

    fun onOperator(view: View){

        val btnOpSelected = view as Button
        when(btnOpSelected.id){
            btnMultiply.id->
            {
                op="*"
            }
            btnDivide.id->
            {
                op="/"
            }
            btnSubtract.id->
            {
                op="-"
            }
            btnAdd.id->
            {
                op="+"
            }
        }
        oldNumber=txtInput.text.toString()
        isNewOp=true
        dot=false

    }


    var lastNumeric: Boolean = false

    fun onDecimalPoint(view: View){
        if(lastNumeric && !dot){
            txtInput.append(".")
            lastNumeric = false
            dot = true
        }
    }

    fun onEqual(view: View){

        val newNumber=txtInput.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "*"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "/"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        txtInput.setText(finalNumber.toString())
        isNewOp=true

    }

    fun onClear(view: View){
        txtInput.setText("")
        isNewOp = true
        dot = false
    }
}