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
import android.widget.Button;

/**
 * Builder for a {@link Button} form item
 * @author Julien Guerinet
 * @version 2.0.0
 * @since 2.0.0
 */
public class ButtonFormItem extends TextViewFormItem {

	/**
	 * Default Constructor
	 *
	 * @param fg       The {@link FormGenerator} instance
	 * @param view     The {@link View}
	 * @param text     The text
	 * @param listener The {@link View.OnClickListener}
	 */
	public ButtonFormItem(FormGenerator fg, View view, String text, View.OnClickListener listener){
		super(fg, view, text);
		mView.setOnClickListener(listener);
	}

	/**
	 * Builds the {@link Button} form item
	 *
	 * @return The {@link Button}
	 */
	@Override
	public Button build(){
		super.build();
		return (Button)mTextView;
	}
}
