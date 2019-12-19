package ru.netology.lambdaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val context = this

        // Метод обработки событий без использования лямбды
        lambdaBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(context, initials("aaa", "bbb"), Toast.LENGTH_SHORT).show()
            }
        })

        // Промежуточный вариант с использованием параметра v (View)
        lambdaBtn.setOnClickListener { v ->
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }

        // "Стандартный" способ обработки событий, используя лямбду
        lambdaBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Общий синтаксис лямбда выражения:
     * { arguments -> return type
     *      fun body
     *      fun body
     *      ...
     * }
     *
     */
    val sum = { x: Int, y: Int ->
        x + y
    }

    // Опустим "лишние" пояснения:
    val sumShort: (Int, Int) -> Int = { x, y -> x + y }

    // Практический пример:
    val square = { number: Int -> number * number }
    val nine = square(3)

    // Еще один пример
    val initials = { firstName: String, lastName: String ->
        "${firstName[0].toUpperCase()}${lastName[0].toUpperCase()}"
    }

    // Когда тип параметра однозначно определен в контексте, мы его опускаем:
    val listOfSomeNames = arrayOf("Ivan", "Vasiliy", "Petr", "Maria", "Natalia")
    val selectedName = listOfSomeNames
        .filter { name -> name.startsWith("v", ignoreCase = true) }
        .sortedBy { name -> name.length }
        .firstOrNull()

    // упрощаем запись, используем it
    val listOfSomeNamesWithIt = arrayOf("Ivan", "Vasiliy", "Petr", "Maria", "Natalia")
    val selectedNameWithIt = listOfSomeNamesWithIt
        .filter { it.startsWith("v", ignoreCase = true) }.minBy { it.length }

    fun defaultFun(x: Int, y: Int): Int = x + y // Именованная функция

    val f = fun(x: Int, y: Int): Int = x + y // Анонимная функция

}
