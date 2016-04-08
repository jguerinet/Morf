/*
 * Copyright 2015-2016 Julien Guerinet
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
import android.widget.EditText;
import android.widget.TextView;

/**
 * Builder for an input form item
 * @author Julien Guerinet
 * @since 2.0.0
 */
public class EditTextFormItem extends TextViewFormItem {
	/**
	 * The {@link EditText}
	 */
	private EditText editText;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 * @param text The text
	 */
	public EditTextFormItem(FormGenerator fg, View view, String text) {
		super(fg, view, (EditText) view.findViewById(R.id.fg_input), text, true);
		editText = (EditText) textView;

		// Set the right background
		if (this.fg.builder.defaultInputBackgroundId != null) {
			inputBackground(this.fg.builder.defaultInputBackgroundId);
		}
	}

    /**
     * Constructor which takes a resource Id for the text
     *
     * @param fg   The {@link FormGenerator} instance
     * @param view The {@link View}
     * @param text The text Id
     */
    public EditTextFormItem(FormGenerator fg, View view, @StringRes int text) {
        super(fg, view, (EditText) view.findViewById(R.id.fg_input), text, true);
        editText = (EditText) textView;

        // Set the right background
        if (this.fg.builder.defaultInputBackgroundId != null) {
            inputBackground(this.fg.builder.defaultInputBackgroundId);
        }
    }

	/**
	 * Sets the input type for the {@link EditText}
	 *
	 * @param type The input type
	 * @return The {@link EditTextFormItem} instance
	 */
	public EditTextFormItem inputType(int type) {
		editText.setInputType(type);
		return this;
	}

	/**
	 * Sets the {@link EditText} background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link EditTextFormItem} instance
	 */
	public EditTextFormItem inputBackground(int backgroundId) {
		editText.setBackgroundResource(backgroundId);
		return this;
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param hint The hint
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem hint(String hint) {
		return (EditTextFormItem) super.hint(hint);
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param stringId The String Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem hint(@StringRes int stringId) {
		return (EditTextFormItem) super.hint(stringId);
	}

	/**
	 * Sets the {@link Button} text color
	 *
	 * @param colorId   The resource Id
	 * @param stateList True if the color is a state list, false if it's a solid color
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem textColor(@ColorRes int colorId, boolean stateList) {
		return (EditTextFormItem) super.textColor(colorId, stateList);
	}

    /**
     * Sets the {@link Button} text size
     *
     * @param dimenId The dimension Id
     * @return The {@link EditTextFormItem} instance
     */
	@Override
	public EditTextFormItem textSize(@DimenRes int dimenId) {
		return (EditTextFormItem) super.textSize(dimenId);
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
	public EditTextFormItem padding(@DimenRes int leftId, @DimenRes int topId,
            @DimenRes int rightId, @DimenRes int bottomId) {
		return (EditTextFormItem) super.padding(leftId, topId, rightId, bottomId);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param dimenId The dimension Id to use for all sides
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem padding(@DimenRes int dimenId) {
		return (EditTextFormItem) super.padding(dimenId);
	}

	/**
	 * Sets the {@link Button} {@link Typeface}
	 *
	 * @param typeface The {@link Typeface}
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem typeface(Typeface typeface) {
		return (EditTextFormItem) super.typeface(typeface);
	}

	/**
	 * Sets the {@link Button} {@link Typeface} and style
	 *
	 * @param typeface The {@link Typeface}
	 * @param style    The style
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem style(Typeface typeface, int style) {
		return (EditTextFormItem) super.style(typeface, style);
	}

	/**
	 * Sets the {@link Button} style. Note: if you are using a custom {@link Typeface},
	 *  use {@link #style(Typeface, int)}
	 *
	 * @param style The style
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem style(int style) {
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
	public EditTextFormItem leftIcon(@DrawableRes int iconId, boolean visible) {
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
	public EditTextFormItem topIcon(@DrawableRes int iconId, boolean visible) {
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
	public EditTextFormItem rightIcon(@DrawableRes int iconId, boolean visible) {
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
	public EditTextFormItem bottomIcon(@DrawableRes int iconId, boolean visible) {
		return (EditTextFormItem) super.bottomIcon(iconId, visible);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem leftIcon(@DrawableRes int iconId) {
		return (EditTextFormItem) super.leftIcon(iconId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem topIcon(@DrawableRes int iconId) {
		return (EditTextFormItem) super.topIcon(iconId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem rightIcon(@DrawableRes int iconId) {
		return (EditTextFormItem) super.rightIcon(iconId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem bottomIcon(@DrawableRes int iconId) {
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
	public EditTextFormItem leftIcon(@DrawableRes int iconId, @ColorRes int colorId) {
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
	public EditTextFormItem topIcon(@DrawableRes int iconId, @ColorRes int colorId) {
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
	public EditTextFormItem rightIcon(@DrawableRes int iconId, @ColorRes int colorId) {
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
	public EditTextFormItem bottomIcon(@DrawableRes int iconId, @ColorRes int colorId) {
		return (EditTextFormItem) super.bottomIcon(iconId, colorId);
	}

	/**
	 * Sets the {@link View.OnClickListener}
	 *
	 * @param listener The {@link View.OnClickListener}
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem onClick(View.OnClickListener listener) {
		return (EditTextFormItem) super.onClick(listener);
	}

    /**
     * Sets the {@link TextView} to be single line
     *
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem singleLine() {
        return (EditTextFormItem) super.singleLine();
    }

    /**
     * Sets the {@link TextView} ellipsize option
     *
     * @param type The ellipsize type
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem ellipsize(TextUtils.TruncateAt type) {
        return (EditTextFormItem) super.ellipsize(type);
    }

    /**
     * Sets the {@link TextView} gravity
     *
     * @param gravity The gravity
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem gravity(int gravity) {
        return (EditTextFormItem) super.gravity(gravity);
    }

	/**
	 * Sets the line size
	 *
	 * @param sizeDimen The line size dimension Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem lineSize(@DimenRes int sizeDimen) {
		return (EditTextFormItem) super.lineSize(sizeDimen);
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem lineColor(@ColorRes @DrawableRes int colorId) {
		return (EditTextFormItem) super.lineColor(colorId);
	}

	/**
	 * Sets the line visibility
	 *
	 * @param show True if the line should be visible, false otherwise
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem showLine(boolean show) {
		return (EditTextFormItem) super.showLine(show);
	}

	/**
	 * Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem background(@ColorRes @DrawableRes int backgroundId) {
		return (EditTextFormItem) super.background(backgroundId);
	}
	
	/**
	 * @return The {@link EditText}
	 */
	@Override
	public EditText view() {
		return editText;
	}
}
