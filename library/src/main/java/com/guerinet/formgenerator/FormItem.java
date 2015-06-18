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

/**
 * Base Builder for all of the form items (except for line and space)
 * @author Julien Guerinet
 * @version 2.0.0
 * @since 2.0.0
 */
abstract class FormItem extends LineItem{
	/**
	 * The form item {@link View}
	 */
	protected View mView;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 */
	public FormItem(FormGenerator fg, View view){
		super(view.findViewById(R.id.fg_line), fg);
		mView = view;

		mFG.mContainer.addView(mView);

		//Set the default background
		if(mFG.mDefaultBackgroundId != null){
			background(mFG.mDefaultBackgroundId);
		}
	}

	/**
	 * Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link FormItem} instance
	 */
	public FormItem background(int backgroundId){
		mView.setBackgroundResource(backgroundId);
		return this;
	}

	/**
	 * @return The {@link View}
	 */
	public View view(){
		return mView;
	}
}
