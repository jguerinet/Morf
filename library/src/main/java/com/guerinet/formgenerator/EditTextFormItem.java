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

package com.guerinet.formgenerator;

import android.view.View;
import android.widget.EditText;

/**
 * Builder for an input form item
 * @author Julien Guerinet
 * @version 2.0.0
 * @since 2.0.0
 */
public class EditTextFormItem extends TextViewFormItem {
	/**
	 * The {@link EditText}
	 */
	private EditText mEditText;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 */
	public EditTextFormItem(FormGenerator fg, View view){
		super(fg, view);
		mEditText = (EditText)mView.findViewById(R.id.fg_input);
	}

	/**
	 * Sets if the {@link EditText} should be single line or not. Default is true
	 *
	 * @param singleLine True if the {@link EditText} should be single line, false otherwise
	 * @return The {@link EditTextFormItem} instance
	 */
	public EditTextFormItem singleLine(boolean singleLine){
		mEditText.setSingleLine(singleLine);
		return this;
	}

	/**
	 * Sets the input type for the {@link EditText}
	 *
	 * @param type The input type
	 * @return The {@link EditTextFormItem} instance
	 */
	public EditTextFormItem inputType(int type){
		mEditText.setInputType(type);
		return this;
	}

	/**
	 * Builds the input form item
	 *
	 * @return The {@link EditText}
	 */
	@Override
	public EditText build(){
		return mEditText;
	}
}
