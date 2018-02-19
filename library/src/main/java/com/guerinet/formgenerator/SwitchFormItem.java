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

import android.graphics.Typeface;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

import com.guerinet.fg.TextViewItem;

/**
 * Builder for a {@link SwitchCompat} form item
 * @author Julien Guerinet
 * @since 2.0.0
 */
public class SwitchFormItem extends TextViewItem<SwitchFormItem, SwitchCompat> {
    /**
	 * The {@link SwitchCompat}
	 */
	private final SwitchCompat aSwitch;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 */
    SwitchFormItem(FormGenerator fg, View view) {
        super(fg, view, view.findViewById(R.id.fg_switch), true);
        aSwitch = getChildView();
        // Set the switch typeface
        aSwitch.setSwitchTypeface(fg.builder.defaultTextTypeface);
    }

    /**
	 * Sets the {@link SwitchCompat}'s checked state
	 *
	 * @param checked True if the {@link SwitchCompat} should be checked, false otherwise
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem checked(boolean checked) {
		aSwitch.setChecked(checked);
		return this;
	}

	/**
	 * Sets the {@link CompoundButton.OnCheckedChangeListener} on the {@link SwitchCompat}
	 *
	 * @param listener The {@link CompoundButton.OnCheckedChangeListener}
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem onCheckChanged(CompoundButton.OnCheckedChangeListener listener) {
		aSwitch.setOnCheckedChangeListener(listener);
		return this;
	}

    /**
     * Sets the on text
     *
     * @param on The off text
     * @return The {@link SwitchFormItem} instance
     */
    public SwitchFormItem textOn(String on) {
        aSwitch.setShowText(true);
        aSwitch.setTextOn(on);
        return this;
    }

    /**
     * Sets the off text
     *
     * @param off The off text
     * @return The {@link SwitchFormItem} instance
     */
    public SwitchFormItem textOff(String off) {
        aSwitch.setShowText(true);
        aSwitch.setTextOff(off);
        return this;
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

	@Override
	public SwitchFormItem typeface(Typeface typeface) {
        //Set the typeface on the switch as well if it is non null
        //  (it will be when first initialized)
        if (aSwitch != null) {
            aSwitch.setSwitchTypeface(typeface);
        }
        return super.typeface(typeface);
    }
}
