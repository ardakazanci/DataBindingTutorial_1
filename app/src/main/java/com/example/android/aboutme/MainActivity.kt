/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Bu örnekte bir data class aracılığıyla ilgili view elemanlarına,
 * değer atanması örneği işlenmiştir.
 */


/**
 * Main Activity of the AboutMe app. This app demonstrates:
 *     * LinearLayout with TextViews, ImageView, Button, EditText, and ScrollView
 *     * ScrollView to display scrollable text
 *     * Getting user input with an EditText.
 *     * Click handler for a Button to retrieve text from an EditText and set it in a TextView.
 *     * Setting the visibility status of a view.
 *     * Data binding between MainActivity and activity_main.xml. How to remove findViewById,
 *       and how to display data in views using the data binding object.
 */
class MainActivity : AppCompatActivity() {

    // TODO (COMPLETED) Create a binding object in the MainActivity.

    private lateinit var binding: ActivityMainBinding


    // TODO (COMPLETED) Create an instance of MyName and set binding.myName to it.

    private val myName: MyName = MyName("Arda Kazancı") // Sadece name değerini atandı.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO (COMPLETED) Use DataBindingUtil to set the layout for MainActivity.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // TODO (COMPLETED) Use the binding object to replace all calls to findViewById.
        /*findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }*/

        binding.myName = myName // Binding ' e data class ' ı bağladık.

        binding.doneButton.setOnClickListener {


            addNickname(it)

        }


    }

    /**
     * Click handler for the Done button.
     * Demonstrates how data binding can be used to make code much more readable
     * by eliminating calls to findViewById and changing data in the binding object.
     */
    private fun addNickname(view: View) {
        // TODO (COMPLETED) set the nickname in the binding object and invalidateAll().


        // Toplu atamalar için.
        binding.apply {

            myName?.nickname = nickname_edit.text.toString() // NickName ' e değer sonradan atandığı için.
            // Edittext'ten gelen değer beklendi.
            invalidateAll() // Edittexten gelen değer aktarılması için. Tüm Binding Yeniden başlatıldı
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE


        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
