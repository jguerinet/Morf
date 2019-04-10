/*
 * Copyright 2015-2019 Julien Guerinet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guerinet.morf.demo

import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.guerinet.morf.Morf
import com.guerinet.morf.morf
import com.guerinet.morf.util.Layout
import com.guerinet.morf.util.Position

/**
 * Demonstrates the default behavior of Morf
 *
 * @author Julien Guerinet
 * @since 1.0.0
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<LinearLayout>(R.id.container)

        // Bind the default instance
        container.morf {
            // Default Form
            text {
                text = "Form Item: Text (default settings)"
            }

            text {
                text = "Form Item: Button"
                onClick {
                    Toast.makeText(this@MainActivity, "Form Item: Button Clicked",
                            Toast.LENGTH_SHORT).show()
                }
            }

            space {}

            button {
                text = "Form Item, Simple Button"
                onClick {
                    Toast.makeText(this@MainActivity, "Form Item: Simple Button Clicked",
                            Toast.LENGTH_SHORT).show()
                }
            }

            borderlessButton {
                text = "Form Item, Borderless Button"
                onClick {
                    Toast.makeText(this@MainActivity, "Form Item: Borderless Button Clicked",
                            Toast.LENGTH_SHORT).show()
                }
                layoutParams(LinearLayout.LayoutParams(Layout.WRAP_CONTENT, Layout.WRAP_CONTENT),
                        Gravity.CENTER)
            }

            space {}
            line {}

            input {
                hint = "Form Item: Input"
                watch {
                    Toast.makeText(this@MainActivity, "Text: $it", Toast.LENGTH_SHORT).show()
                }
            }

            textInput {
                hint = "FormItem: Text Input"
            }

            aSwitch {
                text = "Form Item: Switch"
                onCheckChanged { _, _ ->
                    Toast.makeText(this@MainActivity, "Form Item: Switch changed",
                            Toast.LENGTH_SHORT).show()
                }
            }

            space {}
            space {}
            space {}
            space {}
        }

        // Custom Form
        val shape = Morf.createShape {
            backgroundId = android.R.drawable.list_selector_background
            lineBackgroundId = android.R.color.black
            textColor = ContextCompat.getColor(this@MainActivity, android.R.color.holo_red_dark)
            textTypeface = Typeface.SERIF
            iconColor = ContextCompat.getColor(this@MainActivity, android.R.color.holo_blue_dark)
        }

        container.morf(shape) {
            // Add the different form items
            text {
                text = "Form Item: Text (custom settings)"
                icon(Position.START, R.drawable.ic_info)
            }

            text {
                text = "Form Item: Button"
                icon(Position.START, R.drawable.ic_info, false)
                icon(Position.END, R.drawable.ic_chevron_right)
                onClick {
                    Toast.makeText(this@MainActivity, "Form Item: Button Clicked",
                            Toast.LENGTH_SHORT).show()
                }
            }

            space {}

            button {
                text = "Form Item, Simple Button"
                onClick {
                    Toast.makeText(this@MainActivity, "Form Item: Simple Button Clicked",
                            Toast.LENGTH_SHORT).show()
                }
            }

            borderlessButton {
                text = "Form Item, Borderless Button"
                onClick {
                    Toast.makeText(this@MainActivity, "Form Item: Borderless Button Clicked",
                            Toast.LENGTH_SHORT).show()
                }
                layoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT), Gravity.CENTER)
            }

            space {}
            line {}

            input {
                hint = "Form Item: Input"
                icon(Position.START, R.drawable.ic_info)
                inputBackgroundId = 0
            }

            textInput {
                hint = "FormItem: Text Input"
                textInputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                isPasswordVisibilityToggleEnabled = true
            }

            aSwitch {
                text = "Form Item: Switch"
                onCheckChanged { _, _ ->
                    Toast.makeText(this@MainActivity, "Form Item: Switch changed",
                            Toast.LENGTH_SHORT).show()
                }
                switchText("On", "Off")
                icon(Position.START, R.drawable.ic_info, false)
            }

            textInput {
                hint = "FormItem: Text Input with drawable icon"
                backgroundId = android.R.color.white
                icon(Position.START, resources.getDrawable(R.drawable.ic_info))
            }
        }
    }
}
