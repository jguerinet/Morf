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
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

/**
 * Builder for a {@link SwitchCompat} form item
 * @author Julien Guerinet
 * @version 2.0.0
 * @since 2.0.0
 */
public class SwitchFormItem extends TextViewFormItem {
	/**
	 * The {@link SwitchCompat}
	 */
	private SwitchCompat mSwitch;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 * @param text The text
	 */
	public SwitchFormItem(FormGenerator fg, View view, String text){
		super(fg, view, (SwitchCompat)view.findViewById(R.id.fg_switch), text);
		mSwitch = (SwitchCompat)mTextView;
	}

	/**
	 * Sets the {@link SwitchCompat}'s checked state
	 *
	 * @param checked True if the {@link SwitchCompat} should be checked, false otherwise
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem checked(boolean checked){
		mSwitch.setChecked(checked);
		return this;
	}

	/**
	 * Sets the {@link CompoundButton.OnCheckedChangeListener} on the {@link SwitchCompat}
	 *
	 * @param listener The {@link CompoundButton.OnCheckedChangeListener}
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem onCheckChanged(CompoundButton.OnCheckedChangeListener listener){
		mSwitch.setOnCheckedChangeListener(listener);
		return this;
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param hint The hint
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem hint(String hint){
		return (SwitchFormItem)super.hint(hint);
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param stringId The String Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem hint(@StringRes int stringId){
		return (SwitchFormItem)super.hint(stringId);
	}

	/**
	 * Sets the {@link Button} text color
	 *
	 * @param colorId   The resource Id
	 * @param stateList True if the color is a state list, false if it's a solid color
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem textColor(int colorId, boolean stateList){
		return (SwitchFormItem)super.textColor(colorId, stateList);
	}

	/**
	 * Sets the {@link Button} text size
	 *
	 * @param dimenId The dimension Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem textSizeDimen(@DimenRes int dimenId){
		return (SwitchFormItem)super.textSizeDimen(dimenId);
	}

	/**
	 * Sets the {@link Button} text size
	 *
	 * @param textSize The text size, in pixels
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem textSize(int textSize){
		return (SwitchFormItem)super.textSize(textSize);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param left   The left padding, in pixels
	 * @param top    The top padding, in pixels
	 * @param right  The right padding, in pixels
	 * @param bottom The bottom padding, in pixels
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem padding(int left, int top, int right, int bottom){
		return (SwitchFormItem)super.padding(left, top, right, bottom);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param padding The padding to use for all sides, in pixels
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem padding(int padding){
		return (SwitchFormItem)super.padding(padding);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param leftId   The dimension Id for the left padding
	 * @param topId    The dimension Id for the top padding
	 * @param rightId  The dimension Id for the right padding
	 * @param bottomId The dimension Id for the bottom padding
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem paddingDimen(@DimenRes int leftId, @DimenRes int topId,
			@DimenRes int rightId, @DimenRes int bottomId){
		return (SwitchFormItem)super.paddingDimen(leftId, topId, rightId, bottomId);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param dimenId The dimension Id to use for all sides
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem paddingDimen(@DimenRes int dimenId){
		return (SwitchFormItem)super.paddingDimen(dimenId);
	}

	/**
	 * Sets the {@link Button} {@link Typeface}
	 *
	 * @param typeface The {@link Typeface}
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem typeface(Typeface typeface){
		return (SwitchFormItem)super.typeface(typeface);
	}

	/**
	 * Sets the {@link Button} {@link Typeface} and style
	 *
	 * @param typeface The {@link Typeface}
	 * @param style    The style
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem style(Typeface typeface, int style){
		return (SwitchFormItem)super.style(typeface, style);
	}

	/**
	 * Sets the {@link Button} style. Note: if you are using a custom {@link Typeface},
	 *  use {@link #style(Typeface, int)}
	 *
	 * @param style The style
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem style(int style){
		return (SwitchFormItem) super.style(style);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem leftIcon(@DrawableRes int iconId, boolean visible){
		return (SwitchFormItem) super.leftIcon(iconId, visible);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem topIcon(@DrawableRes int iconId, boolean visible){
		return (SwitchFormItem) super.topIcon(iconId, visible);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem rightIcon(@DrawableRes int iconId, boolean visible){
		return (SwitchFormItem) super.rightIcon(iconId, visible);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem bottomIcon(@DrawableRes int iconId, boolean visible){
		return (SwitchFormItem) super.bottomIcon(iconId, visible);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem leftIcon(@DrawableRes int iconId){
		return (SwitchFormItem) super.leftIcon(iconId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem topIcon(@DrawableRes int iconId){
		return (SwitchFormItem) super.topIcon(iconId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem rightIcon(@DrawableRes int iconId){
		return (SwitchFormItem) super.rightIcon(iconId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem bottomIcon(@DrawableRes int iconId){
		return (SwitchFormItem) super.bottomIcon(iconId);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem leftIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (SwitchFormItem) super.leftIcon(iconId, colorId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem topIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (SwitchFormItem) super.topIcon(iconId, colorId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem rightIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (SwitchFormItem) super.rightIcon(iconId, colorId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem bottomIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (SwitchFormItem) super.bottomIcon(iconId, colorId);
	}

	/**
	 * Sets the {@link View.OnClickListener}
	 *
	 * @param listener The {@link View.OnClickListener}
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem onClick(View.OnClickListener listener){
		return (SwitchFormItem) super.onClick(listener);
	}

	/**
	 * Sets the line size
	 *
	 * @param pixels The line size, in pixels
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem lineSize(int pixels){
		return (SwitchFormItem)super.lineSize(pixels);
	}

	/**
	 * Sets the line size
	 *
	 * @param sizeDimen The line size dimension Id
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem lineSizeDimen(@DimenRes int sizeDimen){
		return (SwitchFormItem)super.lineSizeDimen(sizeDimen);
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem lineColor(@DrawableRes int colorId){
		return (SwitchFormItem)super.lineColor(colorId);
	}

	/**
	 * @return The {@link SwitchCompat}
	 */
	@Override
	public SwitchCompat view(){
		return mSwitch;
	}
}
