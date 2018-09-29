/*
 * Copyright 2015-2018 Julien Guerinet
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

package com.guerinet.morf.demo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.guerinet.morf.Morf;
import com.guerinet.morf.util.Position;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import kotlin.Unit;

/**
 * Demonstrates the default behavior of Morf
 *
 * @author Julien Guerinet
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.container);

        // Get the default instance
        Morf morf = Morf.Companion.bind(container);

        // Default Form
        morf.text()
                .text("Form Item: Text (default settings)")
                .build();

        morf.text()
                .text("Form Item: Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Button Clicked", Toast.LENGTH_SHORT).show();
                    return Unit.INSTANCE;
                })
                .build();

        morf.space().build();

        morf.button()
                .text("Form Item, Simple Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Simple Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    return Unit.INSTANCE;
                })
                .build();

        morf.borderlessButton()
                .text("Form Item, Borderless Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Borderless Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    return Unit.INSTANCE;
                })
                .layoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT), Gravity.CENTER)
                .build();

        morf.space().build();
        morf.line().build();

        morf.input()
                .hint("Form Item: Input")
                .watch(s -> {
                    Toast.makeText(this, "Text:" + s, Toast.LENGTH_SHORT).show();
                    return Unit.INSTANCE;
                })
                .build();

        morf.textInput()
                .hint("FormItem: Text Input")
                .build();

        morf.aSwitch()
                .text("Form Item: Switch")
                .onCheckChanged((buttonView, isChecked) -> Toast.makeText(this,
                        "Form Item: Switch changed", Toast.LENGTH_SHORT).show())
                .build();

        morf.space().build();
        morf.space().build();
        morf.space().build();
        morf.space().build();

        // Custom Form
        Morf.Shape shape = new Morf.Shape();
        shape.setBackgroundId(android.R.drawable.list_selector_background);
        shape.setLineBackgroundId(android.R.color.black);
        shape.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        shape.setTextTypeface(Typeface.SERIF);
        shape.setIconColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
        morf = shape.bind(container);

        // Add the different form items
        morf.text()
                .text("Form Item: Text (custom settings)")
                .icon(Position.START, R.drawable.ic_info)
                .build();

        morf.text()
                .text("Form Item: Button")
                .icon(Position.START, R.drawable.ic_info, false)
                .icon(Position.END, R.drawable.ic_chevron_right)
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Button Clicked", Toast.LENGTH_SHORT).show();
                    return Unit.INSTANCE;
                })
                .build();

        morf.space().build();

        morf.button()
                .text("Form Item, Simple Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Simple Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    return Unit.INSTANCE;
                })
                .build();

        morf.borderlessButton()
                .text("Form Item, Borderless Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Borderless Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    return Unit.INSTANCE;
                })
                .layoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT), Gravity.CENTER)
                .build();

        morf.space().build();
        morf.line().build();

        morf.input()
                .hint("Form Item: Input")
                .icon(Position.START, R.drawable.ic_info)
                .inputBackgroundId(0)
                .build();

        morf.textInput()
                .hint("FormItem: Text Input")
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .showPasswordVisibilityToggle(true)
                .build();

        morf.aSwitch()
                .text("Form Item: Switch")
                .onCheckChanged((buttonView, isChecked) -> Toast.makeText(this,
                        "Form Item: Switch changed", Toast.LENGTH_SHORT).show())
                .switchText("On", "Off")
                .icon(Position.START, R.drawable.ic_info, false)
                .build();

        morf.textInput()
                .hint("FormItem: Text Input with drawable icon")
                .backgroundId(android.R.color.white)
                .icon(Position.START, getResources().getDrawable(R.drawable.ic_info))
                .build();
    }
}
