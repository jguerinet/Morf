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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Builder for a {@link SwitchCompat} form item
 * @author Julien Guerinet
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
		super(fg, view, (SwitchCompat)view.findViewById(R.id.fg_switch), text, true);
		mSwitch = (SwitchCompat)mTextView;
        //Set the switch typeface
        mSwitch.setSwitchTypeface(mFG.mBuilder.mDefaultTextTypeface);
	}

    /**
     * Constructor which takes a resource Id for the text
     *
     * @param fg   The {@link FormGenerator} instance
     * @param view The {@link View}
     * @param text The text Id
     */
    public SwitchFormItem(FormGenerator fg, View view, @StringRes int text){
        super(fg, view, (SwitchCompat)view.findViewById(R.id.fg_switch), text, true);
        mSwitch = (SwitchCompat)mTextView;
        //Set the switch typeface
        mSwitch.setSwitchTypeface(mFG.mBuilder.mDefaultTextTypeface);
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
     * Sets the on text
     *
     * @param on The off text
     * @return The {@link SwitchFormItem} instance
     */
    public SwitchFormItem textOn(String on) {
        mSwitch.setShowText(true);
        mSwitch.setTextOn(on);
        return this;
    }

    /**
     * Sets the on text
     *
     * @param onId The on text String Id
     * @return The {@link SwitchFormItem} instance
     */
    public SwitchFormItem textOn(@StringRes int onId) {
        return textOn(mContext.getString(onId));
    }

    /**
     * Sets the off text
     *
     * @param off The off text
     * @return The {@link SwitchFormItem} instance
     */
    public SwitchFormItem textOff(String off) {
        mSwitch.setShowText(true);
        mSwitch.setTextOff(off);
        return this;
    }

    /**
     * Sets the off text
     *
     * @param offId The off text String Id
     * @return The {@link SwitchFormItem} instance
     */
    public SwitchFormItem textOff(@StringRes int offId) {
        return textOff(mContext.getString(offId));
    }

    /**
     * Sets both the on and off text
     *
     * @param on  The on text
     * @param off The off text
     * @return The {@link SwitchFormItem} instance
     */
    public SwitchFormItem switchText(String on, String off) {
        textOn(on);
        textOff(off);
        return this;
    }

    /**
     * Sets both the on and off text
     *
     * @param onId  The on text String Id
     * @param offId The off text String Id
     * @return The {@link SwitchFormItem} instance
     */
    public SwitchFormItem switchText(@StringRes int onId, @StringRes int offId) {
        textOn(onId);
        textOff(offId);
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
	public SwitchFormItem textSize(@DimenRes int dimenId){
		return (SwitchFormItem)super.textSize(dimenId);
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
	public SwitchFormItem padding(@DimenRes int leftId, @DimenRes int topId,
            @DimenRes int rightId, @DimenRes int bottomId){
		return (SwitchFormItem)super.padding(leftId, topId, rightId, bottomId);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param dimenId The dimension Id to use for all sides
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem padding(@DimenRes int dimenId){
		return (SwitchFormItem)super.padding(dimenId);
	}

	/**
	 * Sets the {@link Button} {@link Typeface}
	 *
	 * @param typeface The {@link Typeface}
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem typeface(Typeface typeface){
        //Set the typeface on the switch as well if it is non null
        //  (it will be when first initialized)
        if (mSwitch != null) {
            mSwitch.setSwitchTypeface(typeface);
        }
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
     * Sets the {@link TextView} gravity
     *
     * @param gravity The gravity
     * @return The {@link SwitchFormItem} instance
     */
    @Override
    public SwitchFormItem gravity(int gravity) {
        return (SwitchFormItem) super.gravity(gravity);
    }

    /**
     * Sets the {@link TextView} to be single line
     *
     * @return The {@link SwitchFormItem} instance
     */
    @Override
    public SwitchFormItem singleLine() {
        return (SwitchFormItem) super.singleLine();
    }

    /**
     * Sets the {@link TextView} ellipsize option
     *
     * @param type The ellipsize type
     * @return The {@link SwitchFormItem} instance
     */
    @Override
    public SwitchFormItem ellipsize(TextUtils.TruncateAt type) {
        return (SwitchFormItem) super.ellipsize(type);
    }

	/**
	 * Sets the line size
	 *
	 * @param sizeDimen The line size dimension Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem lineSize(@DimenRes int sizeDimen){
		return (SwitchFormItem)super.lineSize(sizeDimen);
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem lineColor(@ColorRes @DrawableRes int colorId){
		return (SwitchFormItem)super.lineColor(colorId);
	}

	/**
	 * Sets the line visibility
	 *
	 * @param show True if the line should be visible, false otherwise
	 * @return The {@link LineItem} instance
	 */
	@Override
	public SwitchFormItem showLine(boolean show){
		return (SwitchFormItem)super.showLine(show);
	}

	/**
	 * Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link SwitchFormItem} instance
	 */
	@Override
	public SwitchFormItem background(@ColorRes @DrawableRes int backgroundId){
		return (SwitchFormItem)super.background(backgroundId);
	}

	/**
	 * @return The {@link SwitchCompat}
	 */
	@Override
	public SwitchCompat view(){
		return mSwitch;
	}
}
