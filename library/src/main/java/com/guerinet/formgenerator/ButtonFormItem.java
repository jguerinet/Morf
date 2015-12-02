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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Builder for a {@link Button} form item
 * @author Julien Guerinet
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
		super(fg, view, (Button)view.findViewById(R.id.fg_button), text, false);
		mView.setOnClickListener(listener);
		//Bold buttons
		style(mFG.mBuilder.mDefaultTextTypeface, Typeface.BOLD);
	}

    /**
     * Constructor which takes a String resource Id to set the text
     *
     * @param fg       The {@link FormGenerator} instance
     * @param view     The {@link View}
     * @param text     The text Id
     * @param listener The {@link View.OnClickListener}
     */
    public ButtonFormItem(FormGenerator fg, View view, @StringRes int text,
            View.OnClickListener listener){
        super(fg, view, (Button)view.findViewById(R.id.fg_button), text, false);
        mView.setOnClickListener(listener);
        //Bold buttons
        style(mFG.mBuilder.mDefaultTextTypeface, Typeface.BOLD);
    }

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param hint The hint
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem hint(String hint){
		return (ButtonFormItem)super.hint(hint);
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param stringId The String Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem hint(@StringRes int stringId){
		return (ButtonFormItem)super.hint(stringId);
	}

	/**
	 * Sets the {@link Button} text color
	 *
	 * @param colorId   The resource Id
	 * @param stateList True if the color is a state list, false if it's a solid color
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem textColor(int colorId, boolean stateList){
		return (ButtonFormItem)super.textColor(colorId, stateList);
	}

	/**
	 * Sets the {@link Button} text size
	 *
	 * @param dimenId The dimension Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem textSize(@DimenRes int dimenId){
		return (ButtonFormItem)super.textSize(dimenId);
 	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param leftId   The dimension Id for the left padding
	 * @param topId    The dimension Id for the top padding
	 * @param rightId  The dimension Id for the right padding
	 * @param bottomId The dimension Id for the bottom padding
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem padding(@DimenRes int leftId, @DimenRes int topId,
            @DimenRes int rightId, @DimenRes int bottomId){
		return (ButtonFormItem) super.padding(leftId, topId, rightId, bottomId);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param dimenId The dimension Id to use for all sides
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem padding(@DimenRes int dimenId){
		return (ButtonFormItem) super.padding(dimenId);
	}

	/**
	 * Sets the {@link Button} {@link Typeface}
	 *
	 * @param typeface The {@link Typeface}
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem typeface(Typeface typeface){
		return (ButtonFormItem) super.typeface(typeface);
	}

	/**
	 * Sets the {@link Button} {@link Typeface} and style
	 *
	 * @param typeface The {@link Typeface}
	 * @param style    The style
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem style(Typeface typeface, int style){
		return (ButtonFormItem) super.style(typeface, style);
	}

	/**
	 * Sets the {@link Button} style. Note: if you are using a custom {@link Typeface},
	 *  use {@link #style(Typeface, int)}
	 *
	 * @param style The style
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem style(int style){
		return (ButtonFormItem) super.style(style);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem leftIcon(@DrawableRes int iconId, boolean visible){
		return (ButtonFormItem) super.leftIcon(iconId, visible);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem topIcon(@DrawableRes int iconId, boolean visible){
		return (ButtonFormItem) super.topIcon(iconId, visible);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem rightIcon(@DrawableRes int iconId, boolean visible){
		return (ButtonFormItem) super.rightIcon(iconId, visible);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem bottomIcon(@DrawableRes int iconId, boolean visible){
		return (ButtonFormItem) super.bottomIcon(iconId, visible);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem leftIcon(@DrawableRes int iconId){
		return (ButtonFormItem) super.leftIcon(iconId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem topIcon(@DrawableRes int iconId){
		return (ButtonFormItem) super.topIcon(iconId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem rightIcon(@DrawableRes int iconId){
		return (ButtonFormItem) super.rightIcon(iconId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem bottomIcon(@DrawableRes int iconId){
		return (ButtonFormItem) super.bottomIcon(iconId);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem leftIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (ButtonFormItem) super.leftIcon(iconId, colorId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem topIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (ButtonFormItem) super.topIcon(iconId, colorId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem rightIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (ButtonFormItem) super.rightIcon(iconId, colorId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem bottomIcon(@DrawableRes int iconId, @ColorRes int colorId){
		return (ButtonFormItem) super.bottomIcon(iconId, colorId);
	}

	/**
	 * Sets the {@link View.OnClickListener}
	 *
	 * @param listener The {@link View.OnClickListener}
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem onClick(View.OnClickListener listener){
		return (ButtonFormItem) super.onClick(listener);
	}

    /**
     * Sets the {@link TextView} gravity
     *
     * @param gravity The gravity
     * @return The {@link ButtonFormItem} instance
     */
    @Override
    public ButtonFormItem gravity(int gravity) {
        return (ButtonFormItem) super.gravity(gravity);
    }

    /**
     * Sets the {@link TextView} to be single line
     *
     * @return The {@link ButtonFormItem} instance
     */
    @Override
    public ButtonFormItem singleLine() {
        return (ButtonFormItem) super.singleLine();
    }

    /**
     * Sets the {@link TextView} ellipsize option
     *
     * @param type The ellipsize type
     * @return The {@link ButtonFormItem} instance
     */
    @Override
    public ButtonFormItem ellipsize(TextUtils.TruncateAt type) {
        return (ButtonFormItem) super.ellipsize(type);
    }

	/**
	 * Sets the line size
	 *
	 * @param sizeDimen The line size dimension Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem lineSize(@DimenRes int sizeDimen){
		return (ButtonFormItem)super.lineSize(sizeDimen);
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem lineColor(@ColorRes @DrawableRes int colorId){
		return (ButtonFormItem)super.lineColor(colorId);
	}

	/**
	 * Sets the line visibility
	 *
	 * @param show True if the line should be visible, false otherwise
	 * @return The {@link LineItem} instance
	 */
	@Override
	public ButtonFormItem showLine(boolean show){
		return (ButtonFormItem)super.showLine(show);
	}

	/**
	 * Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link ButtonFormItem} instance
	 */
	@Override
	public ButtonFormItem background(@ColorRes @DrawableRes int backgroundId){
		return (ButtonFormItem)super.background(backgroundId);
	}

	/**
	 * @return The {@link Button}
	 */
	@Override
	public Button view(){
		return (Button)mTextView;
	}
}
