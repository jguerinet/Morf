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

import android.view.View;
import android.widget.EditText;

import com.guerinet.fg.TextViewItem;

import org.jetbrains.annotations.NotNull;

/**
 * Builder for an input form item
 * @author Julien Guerinet
 * @since 2.0.0
 */
public class EditTextFormItem extends TextViewItem<EditTextFormItem, EditText> {

	/**
	 * Default Constructor
	 *
	 * @param fg         The {@link FormGenerator} instance
	 * @param view       The {@link View}
     * @param background True if the background should be applied, false otherwise
	 */
    EditTextFormItem(FormGenerator fg, View view, boolean background) {
        super(fg, view, view.findViewById(R.id.fg_input), background);

		// Set the right background
        if(fg.builder.defaultInputBackgroundId != null) {
            inputBackground(fg.builder.defaultInputBackgroundId);
        }
	}

	/**
	 * Sets the input type for the {@link EditText}
	 *
	 * @param type The input type
	 * @return The {@link EditTextFormItem} instance
	 */
	public EditTextFormItem inputType(int type) {
        getChildView().setInputType(type);
        return this;
	}

	/**
	 * Sets the {@link EditText} background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link EditTextFormItem} instance
	 */
	public EditTextFormItem inputBackground(int backgroundId) {
        getChildView().setBackgroundResource(backgroundId);
        return this;
	}

    /**
     * @return Current String in the {@link EditText}
     */
    public String getInput() {
        return getChildView().getText().toString();
    }

    /**
     * @return Current String in the {@link EditText}, trimmed
     */
    public String getTrimmedInput() {
        return getChildView().getText().toString().trim();
    }


    @NotNull
    @Override
    public EditTextFormItem isFocusable(boolean isFocusable) {
        getChildView().setFocusable(isFocusable);
        return this;
    }

    /**
     * @param enabled True if the item should be enabled, false otherwise
     * @return {@link EditTextFormItem} instance
     */
    @Override
    public EditTextFormItem isEnabled(boolean enabled) {
        getChildView().setEnabled(enabled);
        return this;
    }

	/**
	 * Sets the {@link OnClickListener}
	 *
	 * @param listener The {@link OnClickListener}
	 * @return The {@link EditTextFormItem} instance
	 */
    @NotNull
    @Override
    public EditTextFormItem onClick(OnClickListener<? super EditTextFormItem> listener) {
        // Make the EditText non focusable, non long clickable,
        //  and follow its parent before continuing
        //  If the listener is null, do the opposite
        getChildView().setFocusable(listener == null);
        getChildView().setLongClickable(listener == null);
        getChildView().setClickable(false);
        getChildView().setOnClickListener(listener == null ? null : v -> listener.onClick(this));
        return super.onClick(listener);
    }
}
