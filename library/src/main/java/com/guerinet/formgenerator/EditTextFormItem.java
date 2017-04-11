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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
    EditText editText;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 */
    EditTextFormItem(FormGenerator fg, View view) {
		super(fg, view, (EditText) view.findViewById(R.id.fg_input), true);
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
     * @return Current String in the {@link EditText}
     */
    public String getInput() {
        return editText.getText().toString();
    }

    /**
     * @return Current String in the {@link EditText}, trimmed
     */
    public String getTrimmedInput() {
        return editText.getText().toString().trim();
    }

    /**
     * Sets the {@link EditText} text
     *
     * @param text Text to set
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem text(String text) {
        return (EditTextFormItem) super.text(text);
    }

    /**
     * Sets the {@link EditText} text
     *
     * @param text String Id of text to set
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem text(@StringRes int text) {
        return (EditTextFormItem) super.text(text);
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
     * @param focusable True if the item should be focusable, false otherwise
     * @return {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem focusable(boolean focusable) {
        editText.setFocusable(focusable);
        return this;
    }

    /**
     * @param enabled True if the item should be enabled, false otherwise
     * @return {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem enabled(boolean enabled) {
        editText.setEnabled(enabled);
        return this;
    }

	/**
	 * Sets the {@link Button} text color
	 *
	 * @param color The color
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem textColor(@ColorInt int color) {
		return (EditTextFormItem) super.textColor(color);
	}

    /**
     * Sets the {@link Button} text size
     *
     * @param size The text size from the dimensions file
     *             (use getResources().getDimension())
     * @return The {@link EditTextFormItem} instance
     */
	@Override
	public EditTextFormItem textSize(float size) {
		return (EditTextFormItem) super.textSize(size);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param left   The size for the left padding, in <strong>pixels</strong>
	 * @param top    The size for the top padding, in <strong>pixels</strong>
	 * @param right  The size for the right padding, in <strong>pixels</strong>
	 * @param bottom The size for the bottom padding, in <strong>pixels</strong>
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem padding(int left, int top, int right, int bottom) {
		return (EditTextFormItem) super.padding(left, top, right, bottom);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param pixels The size to use for all sides, in <strong>pixels</strong>
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem padding(int pixels) {
		return (EditTextFormItem) super.padding(pixels);
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
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem leftIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (EditTextFormItem) super.leftIcon(iconId, color);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem topIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (EditTextFormItem) super.topIcon(iconId, color);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem rightIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (EditTextFormItem) super.rightIcon(iconId, color);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem bottomIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (EditTextFormItem) super.bottomIcon(iconId, color);
	}

	/**
	 * Sets the {@link OnClickListener}
	 *
	 * @param listener The {@link OnClickListener}
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem onClick(OnClickListener listener) {
        // Make the EditText non focusable, non long clickable,
        //  and follow its parent before continuing
        //  If the listener is null, do the opposite
        editText.setFocusable(listener == null);
        editText.setLongClickable(listener == null);
        editText.setClickable(false);
        editText.setOnClickListener(listener == null ? null : v -> listener.onClick(this));
		return this;
	}

    /**
     * Sets the {@link TextView} to be multi line
     *
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem removeSingleLine() {
        return (EditTextFormItem) super.removeSingleLine();
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
     * Sets the view visibility
     *
     * @param visibility View visibility, should be one of View.VISIBLE, View.INVISIBLE, View.GONE
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem visibility(int visibility) {
        return (EditTextFormItem) super.visibility(visibility);
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
	 * @param pixels The line size, in <strong>pixels</strong>
	 * @return The {@link EditTextFormItem} instance
	 */
	@Override
	public EditTextFormItem lineSize(int pixels) {
		return (EditTextFormItem) super.lineSize(pixels);
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
     * Sets the {@link LinearLayout.LayoutParams} for this view
     *
     * @param params The {@link LinearLayout.LayoutParams} to set
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem layoutParams(LinearLayout.LayoutParams params) {
        return (EditTextFormItem) super.layoutParams(params);
    }

    /**
     * Sets the {@link LinearLayout.LayoutParams} for this view, as well as its layout_gravity
     *
     * @param params  The {@link LinearLayout.LayoutParams} to set
     * @param gravity The layout_gravity to set
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem layoutParams(LinearLayout.LayoutParams params, int gravity) {
        return (EditTextFormItem) super.layoutParams(params, gravity);
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
     * @return The {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem build() {
        return (EditTextFormItem) super.build();
    }
}
