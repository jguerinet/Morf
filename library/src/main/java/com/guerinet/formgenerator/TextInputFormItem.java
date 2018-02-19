/*
 * Copyright 2015-2018 Julien Guerinet
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

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;

import com.guerinet.fg.EditTextItem;

/**
 * Builder for an text input form item
 * @author Julien Guerinet
 * @since 3.0.0
 */
public class TextInputFormItem extends EditTextItem {
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
		super(fg, view, false);
        inputLayout = view.findViewById(R.id.fg_input_layout);
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

	@Override
    public TextInputFormItem backgroundId(@ColorRes @DrawableRes int backgroundId) {
        inputLayout.setBackgroundResource(backgroundId);
        return this;
	}
}
