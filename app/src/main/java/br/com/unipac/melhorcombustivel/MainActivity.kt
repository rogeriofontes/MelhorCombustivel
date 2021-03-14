package br.com.unipac.melhorcombustivel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etanolEdt = findViewById<EditText>(R.id.etanolEdt)
        val gasolinaEdt = findViewById<EditText>(R.id.gasolinaEdt)
        val salvarBtn = findViewById<Button>(R.id.salvarBtn)
        val resultadoTV = findViewById<TextView>(R.id.resultadoTV)

        resultadoTV.setTextSize(28F);

        salvarBtn.setOnClickListener {

            if (etanolEdt.text.toString().trim().isNotEmpty() ||
                gasolinaEdt.text.toString().trim().isNotBlank()
            ) {
                // your code
                val valorEtanol: Double = etanolEdt.text.toString().toDouble()
                val valorGasolina: Double = gasolinaEdt.text.toString().toDouble()

                var media = valorEtanol / valorGasolina
                /*Toast.makeText(
                    this@MainActivity,
                    "O calculo da média de consumo de Combustivel é" + media + " u.d/litros",
                    Toast.LENGTH_LONG
                ).show();*/
                //etanol!! / gas!! < 0.7
                if (media < 0.7) {
                    resultadoTV.text =
                        "Com a média: " + String.format(
                            "%.2f",
                            media
                        ) + " \né melhor colocar \nEtanol"
                    // resultadoTV.setTextColor(Color.parseColor("#00FF00"));
                    resultadoTV.setTextColor(
                        getResources().getColor(
                            R.color.fontRed,
                            this@MainActivity.theme
                        )
                    );
                } else {
                    resultadoTV.text =
                        "Com a média: " + String.format(
                            "%.2f",
                            media
                        ) + " \né melhor colocar \nGasolina"
                    // resultadoTV.setTextColor(Color.parseColor("#FF0000"));
                    resultadoTV.setTextColor(
                        getResources().getColor(
                            R.color.fontGreen,
                            this@MainActivity.theme
                        )
                    );

                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "É necessário digitar os valores dos combustíveis",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}