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
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.guerinet.morf.Morf;
import com.guerinet.morf.util.Position;

import kotlin.Unit;

/**
 * Demonstrates the default behavior of the FormGenerator
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
        Morf fg = Morf.Companion.bind(container);

        // Default Form
        fg.text()
                .text("Form Item: Text (default settings)")
                .build();

		fg.text()
                .text("Form Item: Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Button Clicked", Toast.LENGTH_SHORT).show();
                    return Unit.INSTANCE;
                })
                .build();

        fg.space().build();

		fg.button()
                .text("Form Item, Simple Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Simple Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    return Unit.INSTANCE;
                })
                .build();

        fg.borderlessButton()
                .text("Form Item, Borderless Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Borderless Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    return Unit.INSTANCE;
                })
                .layoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT), Gravity.CENTER)
                .build();

        fg.space().build();
        fg.line().build();

        fg.input()
                .hint("Form Item: Input")
                .watch(s -> {
                    Toast.makeText(this, "Text:" + s, Toast.LENGTH_SHORT).show();
                    return Unit.INSTANCE;
                })
                .build();

        fg.textInput()
                .hint("FormItem: Text Input")
                .build();

		fg.aSwitch()
                .text("Form Item: Switch")
                .onCheckChanged((buttonView, isChecked) -> Toast.makeText(this,
                        "Form Item: Switch changed", Toast.LENGTH_SHORT).show())
                .build();

        fg.space().build();
        fg.space().build();
        fg.space().build();
        fg.space().build();

        // Custom Form
        Morf.Shape shape = new Morf.Shape();
        shape.setBackgroundId(android.R.drawable.list_selector_background);
        shape.setLineBackgroundId(android.R.color.black);
        shape.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        shape.setTextTypeface(Typeface.SERIF);
        shape.setIconColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
        fg = shape.bind(container);

        // Add the different form items
        fg.text()
                .text("Form Item: Text (custom settings)")
                .icon(Position.START, R.drawable.ic_info)
                .build();

		fg.text()
                .text("Form Item: Button")
                .icon(Position.START, R.drawable.ic_info, false)
                .icon(Position.END, R.drawable.ic_chevron_right)
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Button Clicked", Toast.LENGTH_SHORT).show();
                    return Unit.INSTANCE;
                })
                .build();

        fg.space().build();

		fg.button()
                .text("Form Item, Simple Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Simple Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    return Unit.INSTANCE;
                })
                .build();

        fg.borderlessButton()
                .text("Form Item, Borderless Button")
                .onClick(item -> {
                    Toast.makeText(this, "Form Item: Borderless Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    return Unit.INSTANCE;
                })
                .layoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT), Gravity.CENTER)
                .build();

        fg.space().build();
        fg.line().build();

		fg.input()
				.hint("Form Item: Input")
                .icon(Position.START, R.drawable.ic_info)
                .inputBackgroundId(0)
                .build();

        fg.textInput()
                .hint("FormItem: Text Input")
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .showPasswordVisibilityToggle(true)
                .build();

		fg.aSwitch()
                .text("Form Item: Switch")
                .onCheckChanged((buttonView, isChecked) -> Toast.makeText(this,
                        "Form Item: Switch changed", Toast.LENGTH_SHORT).show())
                .switchText("On", "Off")
                .icon(Position.START, R.drawable.ic_info, false)
                .build();

		fg.textInput()
				.hint("FormItem: Text Input with drawable icon")
                .backgroundId(android.R.color.white)
                .icon(Position.START, getResources().getDrawable(R.drawable.ic_info))
                .build();
	}
}
