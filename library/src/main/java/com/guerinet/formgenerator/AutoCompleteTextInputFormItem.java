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
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Builder for an text input form item that has an autcomplete option
 * @author Julien Guerinet
 * @since 3.0.0
 */
public class AutoCompleteTextInputFormItem extends TextInputFormItem {
    /**
     * {@link TextInputLayout} instance
     */
    private final TextInputLayout inputLayout;
    /**
     * The AutoCompleteTextView instance
     */
    private final AutoCompleteTextView acTextView;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 */
    AutoCompleteTextInputFormItem(FormGenerator fg, View view) {
		super(fg, view);
        inputLayout = (TextInputLayout) view.findViewById(R.id.fg_input_layout);
        acTextView = (AutoCompleteTextView) editText;
	}

    /**
     * @param adapter Adapter to set on the AutoCompleteTextView
     * @param <T> Adapter type (must extend ListAdapter and Filterable)
     * @return {@link AutoCompleteTextInputFormItem}
     */
    public <T extends ListAdapter & Filterable> AutoCompleteTextInputFormItem setAdapter(
            T adapter) {
        acTextView.setAdapter(adapter);
        return this;
    }

    /**
     * @param threshold Number of characters that need to be typed before the options are displayed
     * @return {@link AutoCompleteTextInputFormItem} instance
     */
    public AutoCompleteTextInputFormItem setThreshold(int threshold) {
        // If the threshold is 0, set an OnTouchListener to open the list when clicked
        if (threshold == 0) {
            acTextView.setThreshold(1);
            acTextView.setOnTouchListener((v, event) -> {
                acTextView.showDropDown();
                return false;
            });
        } else {
            acTextView.setThreshold(threshold);
        }
        return this;
    }

    /**
     * @param show True if the password visibility toggle should be shown, false otherwise
     * @return {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem showTogglePasswordVisibility(boolean show) {
        return (AutoCompleteTextInputFormItem) super.showTogglePasswordVisibility(show);
    }

	/**
	 * Sets the input type for the {@link EditText}
	 *
	 * @param type The input type
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
    @Override
	public AutoCompleteTextInputFormItem inputType(int type) {
        return (AutoCompleteTextInputFormItem) super.inputType(type);
	}

	/**
	 * Sets the {@link EditText} background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
    @Override
	public AutoCompleteTextInputFormItem inputBackground(int backgroundId) {
        return (AutoCompleteTextInputFormItem) super.inputBackground(backgroundId);
	}

    /**
     * Sets the {@link EditText} text
     *
     * @param text Text to set
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem text(String text) {
        return (AutoCompleteTextInputFormItem) super.text(text);
    }

    /**
     * Sets the {@link EditText} text
     *
     * @param text String Id of text to set
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem text(@StringRes int text) {
        return (AutoCompleteTextInputFormItem) super.text(text);
    }

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param hint The hint
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem hint(String hint) {
        inputLayout.setHint(hint);
        return this;
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param stringId The String Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem hint(@StringRes int stringId) {
        return hint(inputLayout.getContext().getString(stringId));
	}

	/**
	 * Sets the {@link Button} text color
	 *
	 * @param color The color
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem textColor(@ColorInt int color) {
		return (AutoCompleteTextInputFormItem) super.textColor(color);
	}

    /**
     * @param focusable True if the item should be focusable, false otherwise
     * @return {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem focusable(boolean focusable) {
        return (AutoCompleteTextInputFormItem) super.focusable(focusable);
    }

    /**
     * @param enabled True if the item should be enabled, false otherwise
     * @return {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem enabled(boolean enabled) {
        return (AutoCompleteTextInputFormItem) super.enabled(enabled);
    }

    /**
     * Sets the {@link Button} text size
     *
     * @param size The text size from the dimensions file
     *             (use getResources().getDimension())
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
	@Override
	public AutoCompleteTextInputFormItem textSize(float size) {
		return (AutoCompleteTextInputFormItem) super.textSize(size);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param left   The size for the left padding, in <strong>pixels</strong>
	 * @param top    The size for the top padding, in <strong>pixels</strong>
	 * @param right  The size for the right padding, in <strong>pixels</strong>
	 * @param bottom The size for the bottom padding, in <strong>pixels</strong>
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem padding(int left, int top, int right, int bottom) {
		return (AutoCompleteTextInputFormItem) super.padding(left, top, right, bottom);
	}

	/**
	 * Sets the {@link Button} padding
	 *
	 * @param pixels The size to use for all sides, in <strong>pixels</strong>
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem padding(int pixels) {
		return (AutoCompleteTextInputFormItem) super.padding(pixels);
	}

	/**
	 * Sets the {@link Button} {@link Typeface}
	 *
	 * @param typeface The {@link Typeface}
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem typeface(Typeface typeface) {
		return (AutoCompleteTextInputFormItem) super.typeface(typeface);
	}

	/**
	 * Sets the {@link Button} {@link Typeface} and style
	 *
	 * @param typeface The {@link Typeface}
	 * @param style    The style
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem style(Typeface typeface, int style) {
		return (AutoCompleteTextInputFormItem) super.style(typeface, style);
	}

	/**
	 * Sets the {@link Button} style. Note: if you are using a custom {@link Typeface},
	 *  use {@link #style(Typeface, int)}
	 *
	 * @param style The style
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem style(int style) {
		return (AutoCompleteTextInputFormItem) super.style(style);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem leftIcon(@DrawableRes int iconId, boolean visible) {
		return (AutoCompleteTextInputFormItem) super.leftIcon(iconId, visible);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem topIcon(@DrawableRes int iconId, boolean visible) {
		return (AutoCompleteTextInputFormItem) super.topIcon(iconId, visible);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem rightIcon(@DrawableRes int iconId, boolean visible) {
		return (AutoCompleteTextInputFormItem) super.rightIcon(iconId, visible);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem bottomIcon(@DrawableRes int iconId, boolean visible) {
		return (AutoCompleteTextInputFormItem) super.bottomIcon(iconId, visible);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem leftIcon(@DrawableRes int iconId) {
		return (AutoCompleteTextInputFormItem) super.leftIcon(iconId);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem topIcon(@DrawableRes int iconId) {
		return (AutoCompleteTextInputFormItem) super.topIcon(iconId);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem rightIcon(@DrawableRes int iconId) {
		return (AutoCompleteTextInputFormItem) super.rightIcon(iconId);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem bottomIcon(@DrawableRes int iconId) {
		return (AutoCompleteTextInputFormItem) super.bottomIcon(iconId);
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem leftIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (AutoCompleteTextInputFormItem) super.leftIcon(iconId, color);
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem topIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (AutoCompleteTextInputFormItem) super.topIcon(iconId, color);
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem rightIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (AutoCompleteTextInputFormItem) super.rightIcon(iconId, color);
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId The icon resource Id
	 * @param color  The color
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem bottomIcon(@DrawableRes int iconId, @ColorInt int color) {
		return (AutoCompleteTextInputFormItem) super.bottomIcon(iconId, color);
	}

	/**
	 * Sets the {@link OnClickListener}
	 *
	 * @param listener The {@link OnClickListener}
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem onClick(OnClickListener listener) {
		return (AutoCompleteTextInputFormItem) super.onClick(listener);
	}

    /**
     * Sets the {@link TextView} to be multi line
     *
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem removeSingleLine() {
        return (AutoCompleteTextInputFormItem) super.removeSingleLine();
    }

    /**
     * Sets the {@link TextView} ellipsize option
     *
     * @param type The ellipsize type
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem ellipsize(TextUtils.TruncateAt type) {
        return (AutoCompleteTextInputFormItem) super.ellipsize(type);
    }

    /**
     * Sets the view visibility
     *
     * @param visibility View visibility, should be one of View.VISIBLE, View.INVISIBLE, View.GONE
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem visibility(int visibility) {
        return (AutoCompleteTextInputFormItem) super.visibility(visibility);
    }

    /**
     * Sets the {@link TextView} gravity
     *
     * @param gravity The gravity
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem gravity(int gravity) {
        return (AutoCompleteTextInputFormItem) super.gravity(gravity);
    }

	/**
	 * Sets the line size
	 *
	 * @param pixels The line size, in <strong>pixels</strong>
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem lineSize(int pixels) {
		return (AutoCompleteTextInputFormItem) super.lineSize(pixels);
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem lineColor(@ColorRes @DrawableRes int colorId) {
		return (AutoCompleteTextInputFormItem) super.lineColor(colorId);
	}

	/**
	 * Sets the line visibility
	 *
	 * @param show True if the line should be visible, false otherwise
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem showLine(boolean show) {
		return (AutoCompleteTextInputFormItem) super.showLine(show);
	}

	/**
	 * Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem background(@ColorRes @DrawableRes int backgroundId) {
		return (AutoCompleteTextInputFormItem) super.background(backgroundId);
	}

    /**
     * Sets the {@link LinearLayout.LayoutParams} for this view
     *
     * @param params The {@link LinearLayout.LayoutParams} to set
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem layoutParams(LinearLayout.LayoutParams params) {
        return (AutoCompleteTextInputFormItem) super.layoutParams(params);
    }

    /**
     * Sets the {@link LinearLayout.LayoutParams} for this view, as well as its layout_gravity
     *
     * @param params  The {@link LinearLayout.LayoutParams} to set
     * @param gravity The layout_gravity to set
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem layoutParams(LinearLayout.LayoutParams params, int gravity) {
        return (AutoCompleteTextInputFormItem) super.layoutParams(params, gravity);
    }

    /**
     * @return The AutoCompleteTextView
     */
    @Override
    public AutoCompleteTextView view() {
        return acTextView;
    }

    /**
     * Builds the view and adds it to the container
     *
     * @return The {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem build() {
        return (AutoCompleteTextInputFormItem) super.build();
    }
}
