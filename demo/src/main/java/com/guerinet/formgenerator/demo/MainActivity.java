/*
 * Copyright 2015 Julien Guerinet
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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.guerinet.formgenerator.FormGenerator;

/**
 * MainActivity. Demonstrates the default behavior of the FormGenerator
 * @author Julien Guerinet
 * @version 1.0.0
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LinearLayout container = (LinearLayout)findViewById(R.id.container);

		//Get the default instance
		FormGenerator fg = FormGenerator.bind(this, container);

		//Default Form
		fg.text("Form Item: Text (default settings)");

		fg.text("Form Item: Button")
				.onClick(new View.OnClickListener() {
					@Override
					public void onClick(View v){
						Toast.makeText(MainActivity.this, "Form Item: Button Clicked", Toast
								.LENGTH_SHORT)
								.show();
					}
				});

		fg.space();

		fg.button("Form Item, Simple Button", new View.OnClickListener() {
			@Override
			public void onClick(View v){
				Toast.makeText(MainActivity.this, "Form Item: Default Button Clicked",
						Toast.LENGTH_SHORT).show();
			}
		});

		fg.space();
		fg.line();

		fg.input("").hint("Form Item: Input");

		fg.aSwitch("Form Item: Switch").onCheckChanged(new CompoundButton.OnCheckedChangeListener
				() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
				Toast.makeText(MainActivity.this, "Form Item: Switch changed",
						Toast.LENGTH_SHORT).show();
			}
		});

		fg.space();
		fg.space();
		fg.space();
		fg.space();

		//Custom Form
		fg = new FormGenerator.Builder()
				.setDefaultBackground(android.R.drawable.list_selector_background)
				.setDefaultLineColorId(android.R.color.black)
				.setDefaultTextColorId(android.R.color.holo_red_dark, false)
				.setDefaultTypeface(Typeface.SERIF)
				.setDefaultIconColorId(android.R.color.holo_blue_dark)
				.bind(this, container);

		//Add the different form items
		fg.text("Form Item: Text (custom settings)")
				.leftIcon(R.drawable.ic_info);

		fg.text("Form Item: Button")
				.leftIcon(R.drawable.ic_info, false)
				.rightIcon(R.drawable.ic_chevron_right)
				.onClick(new View.OnClickListener() {
					@Override
					public void onClick(View v){
						Toast.makeText(MainActivity.this, "Form Item: Button Clicked",
                                Toast.LENGTH_SHORT).show();
					}
				});

		fg.space();

		fg.button("Form Item, Simple Button", new View.OnClickListener() {
			@Override
			public void onClick(View v){
				Toast.makeText(MainActivity.this, "Form Item: Default Button Clicked",
						Toast.LENGTH_SHORT).show();
			}
		});

		fg.space();
		fg.line();

		fg.input("")
				.hint("Form Item: Input")
				.leftIcon(R.drawable.ic_info)
				.inputBackground(0);

		fg.aSwitch("Form Item: Switch")
				.onCheckChanged(new CompoundButton.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
						Toast.makeText(MainActivity.this, "Form Item: Switch changed",
								Toast.LENGTH_SHORT).show();
					}
				})
				.leftIcon(R.drawable.ic_info, false);
	}
}
