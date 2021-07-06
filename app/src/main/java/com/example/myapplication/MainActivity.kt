package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val datos = arrayOf<String?>("Milimetros", "Centimetros", "Metros", "kilometros")
    private var unidadActual5p: Spinner? = null
    private var unidadCambio5p: Spinner? = null
    private var valorCambioET: EditText? = null
    private var resultadoTv: TextView? = null
    private val factorMilimetroCentimetro = 0
    private val factormetrosmilimetros = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adaptador: ArrayAdapter<Any?> =
            ArrayAdapter<Any?>(this, R.layout.support_simple_spinner_dropdown_item, datos)
        unidadActual5p = findViewById<View>(R.id.unidadActual5p) as Spinner
        unidadActual5p!!.adapter = adaptador
        unidadCambio5p = findViewById<View>(R.id.unidadCambio5p) as Spinner
        val preferencias = getSharedPreferences("MisPreferencias", MODE_PRIVATE)
        val trpUnidadActual = preferencias.getString("unidadActual", "")
        val trpUnidadCambio = preferencias.getString("unidadcambio", "")

        if (trpUnidadActual != "") {
            val indice = adaptador.getPosition(trpUnidadActual)
            unidadActual5p!!.setSelection(indice)
        }
        if (trpUnidadCambio != "") {
            val indice = adaptador.getPosition(trpUnidadCambio)
            unidadCambio5p!!.setSelection(indice)
        }
    }

    fun clickConvertir(V: View?) {
        unidadActual5p = findViewById<View>(R.id.unidadActual5p) as Spinner
        unidadCambio5p = findViewById<View>(R.id.unidadCambio5p) as Spinner
        valorCambioET = findViewById<View>(R.id.valorCambioET) as EditText
        resultadoTv = findViewById<View>(R.id.resultadoTV) as TextView
        val unidadActual = unidadActual5p!!.selectedItem.toString()
        val unidadCambio = unidadCambio5p!!.selectedItem.toString()
        val valorCambio = valorCambioET!!.text.toString().toDouble()
        val resultado = procesarConversion(unidadActual, unidadCambio, valorCambio)
        if (resultado > 0) {
            resultadoTv!!.text =
                String.format("por hola", valorCambio, unidadActual, resultado, unidadCambio)
            valorCambioET!!.setText("")
            val preferencias = getSharedPreferences("MisPreferencias", MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("unidadActual", unidadActual)
            editor.putString("unidadCambio", unidadCambio)
            editor.commit()
        } else {
            resultadoTv!!.text = String.format("usted recibira")
            Toast.makeText(
                this@MainActivity,
                "las operaciones eliginas no tienen comversion",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun procesarConversion(
        unidadActual: String,
        unidadCambio: String,
        ValorCambio: Double
    ): Double {
        var resultadoConversion = 0.0
        when (unidadActual) {
            "milimetros" -> {
                if (unidadCambio == "centimetros") {
                    resultadoConversion = ValorCambio * factorMilimetroCentimetro
                }
                if (unidadCambio == "metros") {
                    resultadoConversion = ValorCambio / factormetrosmilimetros
                }
            }
            "centimetros" -> if (unidadCambio == "milimetros") {
                resultadoConversion = ValorCambio / factorMilimetroCentimetro
            }
            "metros" -> if (unidadCambio == "milimetros") {
                resultadoConversion = ValorCambio * factormetrosmilimetros
            }
        }
        return resultadoConversion
    }
}