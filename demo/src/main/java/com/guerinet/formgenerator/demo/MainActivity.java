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

package com.guerinet.formgenerator.demo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.guerinet.formgenerator.TextViewFormItem;

/**
 * MainActivity. Demonstrates the default behavior of the FormGenerator
 * @author Julien Guerinet
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.container);

		//Get the default instance
		FormGenerator fg = FormGenerator.bind(container);

		//Default Form
		fg.text()
                .text("Form Item: Text (default settings)")
                .build();

		fg.text()
                .text("Form Item: Button")
				.onClick(new TextViewFormItem.OnClickListener() {
                    @Override
                    public void onClick(TextViewFormItem item) {
                        Toast.makeText(MainActivity.this, "Form Item: Button Clicked",
                                Toast.LENGTH_SHORT).show();

                    }
                })
                .build();

		fg.space();

		fg.button()
                .text("Form Item, Simple Button")
                .onClick(new TextViewFormItem.OnClickListener() {
                    @Override
                    public void onClick(TextViewFormItem item) {
                        Toast.makeText(MainActivity.this, "Form Item: Simple Button Clicked",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build();

        fg.borderlessButton()
                .text("Form Item, Borderless Button")
                .onClick(new TextViewFormItem.OnClickListener() {
                    @Override
                    public void onClick(TextViewFormItem item) {
                        Toast.makeText(MainActivity.this, "Form Item: Borderless Button Clicked",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .layoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT), Gravity.CENTER)
                .build();

		fg.space();
		fg.line();

		fg.input().hint("Form Item: Input").build();

        fg.textInput()
                .hint("FormItem: Text Input")
                .build();

		fg.aSwitch()
                .text("Form Item: Switch")
                .onCheckChanged(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                        Toast.makeText(MainActivity.this, "Form Item: Switch changed",
                                Toast.LENGTH_SHORT).show();
                    }
		        })
                .build();

		fg.space();
		fg.space();
		fg.space();
		fg.space();

		//Custom Form
		fg = new FormGenerator.Builder()
				.setDefaultBackground(android.R.drawable.list_selector_background)
				.setDefaultLineColorId(android.R.color.black)
				.setDefaultTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
				.setDefaultTypeface(Typeface.SERIF)
				.setDefaultIconColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark))
				.bind(container);

		//Add the different form items
		fg.text()
                .text("Form Item: Text (custom settings)")
				.leftIcon(R.drawable.ic_info)
                .build();

		fg.text()
                .text("Form Item: Button")
				.leftIcon(R.drawable.ic_info, false)
				.rightIcon(R.drawable.ic_chevron_right)
                .onClick(new TextViewFormItem.OnClickListener() {
                    @Override
                    public void onClick(TextViewFormItem item) {
                        Toast.makeText(MainActivity.this, "Form Item: Button Clicked",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build();

		fg.space();

		fg.button()
                .text("Form Item, Simple Button")
                .onClick(new TextViewFormItem.OnClickListener() {
                    @Override
                    public void onClick(TextViewFormItem item) {
                        Toast.makeText(MainActivity.this, "Form Item: Simple Button Clicked",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build();

        fg.borderlessButton()
                .text("Form Item, Borderless Button")
                .onClick(new TextViewFormItem.OnClickListener() {
                    @Override
                    public void onClick(TextViewFormItem item) {
                        Toast.makeText(MainActivity.this, "Form Item: Borderless Button Clicked",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .layoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT), Gravity.CENTER)
                .build();

		fg.space();
		fg.line();

		fg.input()
				.hint("Form Item: Input")
				.leftIcon(R.drawable.ic_info)
				.inputBackground(0)
                .build();

        fg.textInput()
                .hint("FormItem: Text Input")
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .showTogglePasswordVisibility(true)
                .build();

		fg.aSwitch()
                .text("Form Item: Switch")
				.onCheckChanged(new CompoundButton.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
						Toast.makeText(MainActivity.this, "Form Item: Switch changed",
								Toast.LENGTH_SHORT).show();
					}
				})
                .switchText("On", "Off")
				.leftIcon(R.drawable.ic_info, false)
                .build();

		fg.textInput()
				.hint("FormItem: Text Input with drawable icon")
				.background(android.R.color.white)
				.leftIcon(getResources().getDrawable(R.drawable.ic_info))
				.build();
	}
}
