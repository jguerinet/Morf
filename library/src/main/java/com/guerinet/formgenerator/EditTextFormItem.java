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

import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Button;
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
	 * @param text The text
	 */
	public EditTextFormItem(FormGenerator fg, View view, String text){
		super(fg, view, text);
		mEditText = (EditText)mTextView;

		//Set the right background
		background(mFG.mDefaultInputBackgroundId);
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
	 * Sets the {@link Button} hint
	 *
	 * @param hint The hint
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem hint(String hint){
		return (EditTextFormItem)super.hint(hint);
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param stringId The String Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem hint(@StringRes int stringId){
		return (EditTextFormItem)super.hint(stringId);
	}

	/**
	 * Sets the {@link Button} text color
	 *
	 * @param colorId   The resource Id
	 * @param stateList True if the color is a state list, false if it's a solid color
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem textColor(int colorId, boolean stateList){
		return (EditTextFormItem)super.textColor(colorId, stateList);
	}

	/**
	 * Sets the {@link Button} text size
	 *
	 * @param dimenId The dimension Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem textSizeDimen(@DimenRes int dimenId){
		return (EditTextFormItem)super.textSizeDimen(dimenId);
	}

	/**
	 * Sets the {@link Button} text size
	 *
	 * @param textSize The text size, in pixels
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem textSize(int textSize){
		return (EditTextFormItem)super.textSize(textSize);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param left   The left padding, in pixels
	 * @param top    The top padding, in pixels
	 * @param right  The right padding, in pixels
	 * @param bottom The bottom padding, in pixels
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem padding(int left, int top, int right, int bottom){
		return (EditTextFormItem)super.padding(left, top, right, bottom);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param padding The padding to use for all sides, in pixels
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem padding(int padding){
		return (EditTextFormItem)super.padding(padding);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param leftId   The dimension Id for the left padding
	 * @param topId    The dimension Id for the top padding
	 * @param rightId  The dimension Id for the right padding
	 * @param bottomId The dimension Id for the bottom padding
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem paddingDimen(@DimenRes int leftId, @DimenRes int topId,
			@DimenRes int rightId, @DimenRes int bottomId){
		return (EditTextFormItem)super.paddingDimen(leftId, topId, rightId, bottomId);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param dimenId The dimension Id to use for all sides
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem paddingDimen(@DimenRes int dimenId){
		return (EditTextFormItem)super.paddingDimen(dimenId);
	}

	/**
	 * Sets the {@link Button} {@link Typeface}
	 *
	 * @param typeface The {@link Typeface}
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem typeface(Typeface typeface){
		return (EditTextFormItem)super.typeface(typeface);
	}

	/**
	 * Sets the {@link Button} {@link Typeface} and style
	 *
	 * @param typeface The {@link Typeface}
	 * @param style    The style
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem style(Typeface typeface, int style){
		return (EditTextFormItem)super.style(typeface, style);
	}

	/**
	 * Sets the {@link Button} style. Note: if you are using a custom {@link Typeface},
	 *  use {@link #style(Typeface, int)}
	 *
	 * @param style The style
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem style(int style){
		return (EditTextFormItem) super.style(style);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem leftIcon(@DrawableRes int iconId, boolean visible){
		return (EditTextFormItem) super.leftIcon(iconId, visible);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem topIcon(@DrawableRes int iconId, boolean visible){
		return (EditTextFormItem) super.topIcon(iconId, visible);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem rightIcon(@DrawableRes int iconId, boolean visible){
		return (EditTextFormItem) super.rightIcon(iconId, visible);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem bottomIcon(@DrawableRes int iconId, boolean visible){
		return (EditTextFormItem) super.bottomIcon(iconId, visible);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem leftIcon(@DrawableRes int iconId){
		return (EditTextFormItem) super.leftIcon(iconId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem topIcon(@DrawableRes int iconId){
		return (EditTextFormItem) super.topIcon(iconId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem rightIcon(@DrawableRes int iconId){
		return (EditTextFormItem) super.rightIcon(iconId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem bottomIcon(@DrawableRes int iconId){
		return (EditTextFormItem) super.bottomIcon(iconId);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem leftIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (EditTextFormItem) super.leftIcon(iconId, colorId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem topIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (EditTextFormItem) super.topIcon(iconId, colorId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem rightIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (EditTextFormItem) super.rightIcon(iconId, colorId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem bottomIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (EditTextFormItem) super.bottomIcon(iconId, colorId);
	}

	/**
	 * Sets the {@link View.OnClickListener}
	 *
	 * @param listener The {@link View.OnClickListener}
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem onClick(View.OnClickListener listener){
		return (EditTextFormItem) super.onClick(listener);
	}

	/**
	 * Builds the input form item
	 *
	 * @return The {@link EditText}
	 */
	@Override
	public EditText build(){
		super.build();
		return mEditText;
	}
}