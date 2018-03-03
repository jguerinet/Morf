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

package com.guerinet.morf

import android.graphics.Typeface
import android.support.v7.widget.SwitchCompat
import android.widget.CompoundButton
import com.guerinet.morf.base.BaseTextViewItem

/**
 * Form item with a [SwitchCompat]
 * @author Julien Guerinet
 * @since 2.0.0
 */
class SwitchItem(fg: FormGenerator) :
        BaseTextViewItem<SwitchItem, SwitchCompat>(fg, SwitchCompat(fg.context)) {

    init {
        view.showText = false
    }

    /**
     * @return Item with the switch on if [isChecked]
     */
    fun checked(isChecked: Boolean): SwitchItem {
        view.isChecked = isChecked
        return this
    }

    /**
     * @return Item with the [listener] set on the switch
     */
    fun onCheckChanged(listener: CompoundButton.OnCheckedChangeListener?): SwitchItem {
        view.setOnCheckedChangeListener(listener)
        return this
    }

    /**
     * Sets the [textOn] and [textOff] texts if not null (both default to null) on the returned item
     */
    fun switchText(textOn: String? = null, textOff: String? = null): SwitchItem {
        view.showText = true
        if (textOn != null) {
            view.textOn = textOn
        }
        if (textOff != null) {
            view.textOff = textOff
        }
        return this
    }

    override fun typeface(typeface: Typeface?): SwitchItem {
        // Set the typeface on the switch as well
        view.setSwitchTypeface(typeface)
        return super.typeface(typeface)
    }
}