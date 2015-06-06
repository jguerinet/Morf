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
public abstract class FormItem extends LineItem{
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
		super(fg, view.findViewById(R.id.fg_line), fg.mShowLine);
		mView = view;

		//Set the default background
		if(mFG.mDefaultBackgroundId != 0){
			view.setBackgroundResource(mFG.mDefaultBackgroundId);
		}
	}

	/**
	 *  Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link FormItem} instance
	 */
	public FormItem background(int backgroundId){
		mView.setBackgroundResource(backgroundId);
		return this;
	}

	/**
	 * Shows the line after the form item
	 *
	 * @return The {@link FormItem} instance
	 */
	public FormItem showLine(){
		visibility(true);
		return this;
	}

	/**
	 * Hides the line after the form item
	 *
	 * @return The {@link FormItem} instance
	 */
	public FormItem hideLine(){
		visibility(false);
		return this;
	}

	/**
	 * Builds the view and adds it to the container
	 *
	 * @return The {@link View}
	 */
	public View build(){
		mFG.mContainer.addView(mView);
		return mView;
	}
}
