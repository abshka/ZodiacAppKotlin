package com.ab.zodiacapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zodiacSigns = resources.getStringArray(R.array.zodiac_signs)

        val spinner: Spinner = findViewById(R.id.spinner)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val showDescriptionButton: Button = findViewById(R.id.showDescriptionButton)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, zodiacSigns)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Ничего не делать
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Ничего не делать
            }
        }

        showDescriptionButton.setOnClickListener {
            val selectedSign = spinner.selectedItem.toString()
            val description = getZodiacDescription(selectedSign)
            resultTextView.text = description
        }
    }

    private fun getZodiacDescription(zodiacSign: String): String {
        return when (zodiacSign) {
            "Овен" -> "Энергичный и страстный, Овен стремится к новым испытаниям и приключениям."
            "Телец" -> "Телец обладает терпением и стойкостью, ценит комфорт и материальную стабильность."
            "Близнецы" -> "Общительные и умные, Близнецы обожают общество и разнообразие."
            "Рак" -> "Семейный и чувствительный, Рак глубоко связан с домом и близкими."
            "Лев" -> "Лев любит внимание и восхищение, является лидером и творческой личностью."
            "Дева" -> "Аналитичная и педантичная, Дева стремится к совершенству и порядку."
            "Весы" -> "Весы ценят гармонию и справедливость, стремятся к равновесию в отношениях."
            "Скорпион" -> "Страстный и решительный, Скорпион обладает глубокими эмоциями и интенсивностью."
            "Стрелец" -> "Оптимистичный и приключенческий, Стрелец исследует мир и ищет смысл жизни."
            "Козерог" -> "Козерог ценит трудолюбие и ответственность, стремится к карьерному успеху."
            "Водолей" -> "Эксцентричный и свободолюбивый, Водолей стремится к инновациям и социальным идеалам."
            "Рыбы" -> "Сочувственные и креативные, Рыбы часто погружены в мир фантазии и эмоций."
            else -> "Описание не найдено."
        }
    }
}