package com.example.kalku

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kalku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var op1: Double? = 0.0 //operando 1
    private var result: Double = 0.0
    private var operacion : String? = ""

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("op1", op1!!)
        outState.putString("operacion", operacion)
        outState.putCharSequence("pantalla", binding.pantalla.text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)
        op1 = savedInstanceState?.getDouble("op1") ?: 0.0
        operacion = savedInstanceState?.getString(operacion) ?: ""
        binding.pantalla.text = savedInstanceState?.getString("pantalla") ?: "0"


        binding.num0.setOnClickListener(this)
        binding.num1.setOnClickListener(this)
        binding.num2.setOnClickListener(this)
        binding.num3.setOnClickListener(this)
        binding.num4.setOnClickListener(this)
        binding.num5.setOnClickListener(this)
        binding.num6.setOnClickListener(this)
        binding.num7.setOnClickListener(this)
        binding.num8.setOnClickListener(this)
        binding.num9.setOnClickListener(this)
        binding.opAC.setOnClickListener(this)
        binding.opSUMA.setOnClickListener(this)
        binding.opIGUAL.setOnClickListener(this)
        binding.opRESTA.setOnClickListener(this)
        binding.opDIVISION.setOnClickListener(this)
        binding.opMULTIPLICACION.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.num0.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("0")
            }

            binding.num1.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("1")
            }

            binding.num2.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("2")
            }

            binding.num3.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("3")
            }

            binding.num4.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("4")
            }

            binding.num5.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("5")
            }

            binding.num6.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("6")
            }

            binding.num7.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("7")
            }

            binding.num8.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("8")
            }

            binding.num9.id -> {
                if (binding.pantalla.text == "0") binding.pantalla.text = ""
                binding.pantalla.append("9")
            }

            binding.opSUMA.id ->{
                op1 = binding.pantalla.text.toString().toDoubleOrNull()!!
                operacion = "suma"
                binding.pantalla.text = "0"
            }
            binding.opRESTA.id ->{
                op1 = binding.pantalla.text.toString().toDoubleOrNull()!!
                operacion = "resta"
                binding.pantalla.text = "0"
            }
            binding.opMULTIPLICACION.id ->{
                op1 = binding.pantalla.text.toString().toDoubleOrNull()!!
                operacion = "multiplicacion"
                binding.pantalla.text = "0"
            }
            binding.opDIVISION.id ->{
                op1 = binding.pantalla.text.toString().toDoubleOrNull()!!
                operacion = "division"
                binding.pantalla.text = "0"
            }
            binding.opAC.id ->{
                op1 = 0.0
                operacion = ""
                binding.pantalla.text = "0"
            }
            binding.opIGUAL.id ->{
                operar()
            }


        }
    }

    private fun operar() {
        when(operacion){
            "suma"->{
                binding.pantalla.text = (op1!! + binding.pantalla.text.toString().toDoubleOrNull()!!).toString()
            }
            "resta"->{
                binding.pantalla.text = (op1!! - binding.pantalla.text.toString().toDoubleOrNull()!!).toString()
            }
            "multiplicacion"->{
                binding.pantalla.text = (op1!! * binding.pantalla.text.toString().toDoubleOrNull()!!).toString()
            }
            "division"->{
                binding.pantalla.text = (op1!! / binding.pantalla.text.toString().toDoubleOrNull()!!).toString()
            }
        }
    }
}