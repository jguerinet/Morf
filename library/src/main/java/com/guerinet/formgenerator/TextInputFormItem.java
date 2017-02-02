/*
 * Copyright 2015-2017 Julien Guerinet
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
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Builder for an text input form item
 * @author Julien Guerinet
 * @since 3.0.0
 */
public class TextInputFormItem extends EditTextFormItem {
    /**
     * {@link TextInputLayout} instance
     */
    private final TextInputLayout inputLayout;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 */
    TextInputFormItem(FormGenerator fg, View view) {
		super(fg, view);
        inputLayout = (TextInputLayout) view.findViewById(R.id.fg_input_layout);
	}

    /**
     * @param show True if the password visibility toggle should be shown, false otherwise
     * @return {@link TextInputFormItem} instance
     */
    public TextInputFormItem showTogglePasswordVisibility(boolean show) {
        inputLayout.setPasswordVisibilityToggleEnabled(show);
        return this;
    }

	/**
	 * Sets the input type for the {@link EditText}
	 *
	 * @param type The input type
	 * @return The {@link TextInputFormItem} instance
	 */
    @Override
	public TextInputFormItem inputType(int type) {
        return (TextInputFormItem) super.inputType(type);
	}

	/**
	 * Sets the {@link EditText} background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link TextInputFormItem} instance
	 */
    @Override
	public TextInputFormItem inputBackground(int backgroundId) {
        return (TextInputFormItem) super.inputBackground(backgroundId);
	}

    /**
     * Sets the {@link EditText} text
     *
     * @param text Text to set
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem text(String text) {
        return (TextInputFormItem) super.text(text);
    }

    /**
     * Sets the {@link EditText} text
     *
     * @param text String Id of text to set
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem text(@StringRes int text) {
        return (TextInputFormItem) super.text(text);
    }

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param hint The hint
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem hint(String hint) {
        inputLayout.setHint(hint);
        return this;
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param stringId The String Id
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem hint(@StringRes int stringId) {
        return hint(inputLayout.getContext().getString(stringId));
	}

	/**
	 * Sets the {@link Button} text color
	 *
	 * @param color The color
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem textColor(@ColorInt int color) {
		return (TextInputFormItem) super.textColor(color);
	}

    /**
     * Sets the {@link Button} text size
     *
     * @param size The text size from the dimensions file
     *             (use getResources().getDimension())
     * @return The {@link TextInputFormItem} instance
     */
	@Override
	public TextInputFormItem textSize(float size) {
		return (TextInputFormItem) super.textSize(size);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param left   The size for the left padding, in <strong>pixels</strong>
	 * @param top    The size for the top padding, in <strong>pixels</strong>
	 * @param right  The size for the right padding, in <strong>pixels</strong>
	 * @param bottom The size for the bottom padding, in <strong>pixels</strong>
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem padding(int left, int top, int right, int bottom) {
		return (TextInputFormItem) super.padding(left, top, right, bottom);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param pixels The size to use for all sides, in <strong>pixels</strong>
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem padding(int pixels) {
		return (TextInputFormItem) super.padding(pixels);
	}

	/**
	 * Sets the {@link Button} {@link Typeface}
	 *
	 * @param typeface The {@link Typeface}
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem typeface(Typeface typeface) {
		return (TextInputFormItem) super.typeface(typeface);
	}

	/**
	 * Sets the {@link Button} {@link Typeface} and style
	 *
	 * @param typeface The {@link Typeface}
	 * @param style    The style
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem style(Typeface typeface, int style) {
		return (TextInputFormItem) super.style(typeface, style);
	}

	/**
	 * Sets the {@link Button} style. Note: if you are using a custom {@link Typeface},
	 *  use {@link #style(Typeface, int)}
	 *
	 * @param style The style
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem style(int style) {
		return (TextInputFormItem) super.style(style);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem leftIcon(@DrawableRes int iconId, boolean visible) {
		return (TextInputFormItem) super.leftIcon(iconId, visible);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem topIcon(@DrawableRes int iconId, boolean visible) {
		return (TextInputFormItem) super.topIcon(iconId, visible);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem rightIcon(@DrawableRes int iconId, boolean visible) {
		return (TextInputFormItem) super.rightIcon(iconId, visible);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem bottomIcon(@DrawableRes int iconId, boolean visible) {
		return (TextInputFormItem) super.bottomIcon(iconId, visible);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem leftIcon(@DrawableRes int iconId) {
		return (TextInputFormItem) super.leftIcon(iconId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem topIcon(@DrawableRes int iconId) {
		return (TextInputFormItem) super.topIcon(iconId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem rightIcon(@DrawableRes int iconId) {
		return (TextInputFormItem) super.rightIcon(iconId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem bottomIcon(@DrawableRes int iconId) {
		return (TextInputFormItem) super.bottomIcon(iconId);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem leftIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (TextInputFormItem) super.leftIcon(iconId, color);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem topIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (TextInputFormItem) super.topIcon(iconId, color);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem rightIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (TextInputFormItem) super.rightIcon(iconId, color);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem bottomIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (TextInputFormItem) super.bottomIcon(iconId, color);
	}

	/**
	 * Sets the {@link OnClickListener}
	 *
	 * @param listener The {@link OnClickListener}
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem onClick(OnClickListener listener) {
		return (TextInputFormItem) super.onClick(listener);
	}

    /**
     * Sets the {@link TextView} to be multi line
     *
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem removeSingleLine() {
        return (TextInputFormItem) super.removeSingleLine();
    }

    /**
     * Sets the {@link TextView} ellipsize option
     *
     * @param type The ellipsize type
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem ellipsize(TextUtils.TruncateAt type) {
        return (TextInputFormItem) super.ellipsize(type);
    }

    /**
     * Sets the view visibility
     *
     * @param visibility View visibility, should be one of View.VISIBLE, View.INVISIBLE, View.GONE
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem visibility(int visibility) {
        return (TextInputFormItem) super.visibility(visibility);
    }

    /**
     * Sets the {@link TextView} gravity
     *
     * @param gravity The gravity
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem gravity(int gravity) {
        return (TextInputFormItem) super.gravity(gravity);
    }

	/**
	 * Sets the line size
	 *
	 * @param pixels The line size, in <strong>pixels</strong>
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem lineSize(int pixels) {
		return (TextInputFormItem) super.lineSize(pixels);
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem lineColor(@ColorRes @DrawableRes int colorId) {
		return (TextInputFormItem) super.lineColor(colorId);
	}

	/**
	 * Sets the line visibility
	 *
	 * @param show True if the line should be visible, false otherwise
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem showLine(boolean show) {
		return (TextInputFormItem) super.showLine(show);
	}

	/**
	 * Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link TextInputFormItem} instance
	 */
	@Override
	public TextInputFormItem background(@ColorRes @DrawableRes int backgroundId) {
		return (TextInputFormItem) super.background(backgroundId);
	}

    /**
     * Sets the {@link LinearLayout.LayoutParams} for this view
     *
     * @param params The {@link LinearLayout.LayoutParams} to set
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem layoutParams(LinearLayout.LayoutParams params) {
        return (TextInputFormItem) super.layoutParams(params);
    }

    /**
     * Sets the {@link LinearLayout.LayoutParams} for this view, as well as its layout_gravity
     *
     * @param params  The {@link LinearLayout.LayoutParams} to set
     * @param gravity The layout_gravity to set
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem layoutParams(LinearLayout.LayoutParams params, int gravity) {
        return (TextInputFormItem) super.layoutParams(params, gravity);
    }

    /**
     * @return The {@link EditText}
     */
    @Override
    public EditText view() {
        return editText;
    }

    /**
     * Builds the view and adds it to the container
     *
     * @return The {@link TextInputFormItem} instance
     */
    @Override
    public TextInputFormItem build() {
        return (TextInputFormItem) super.build();
    }
}
