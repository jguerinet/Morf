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

package com.guerinet.fg

import android.view.View
import android.widget.EditText
import com.guerinet.formgenerator.FormGenerator
import com.guerinet.formgenerator.R

/**
 * Form item that represents an [EditText]
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param fg                    [FormGenerator] instance
 * @param view                  Item [View]
 * @param isDefaultBackground   True if we should use the default background, false otherwise
 */
@Suppress("UNCHECKED_CAST")
open class EditTextItem<T : EditTextItem<T>>(
        fg: FormGenerator,
        view: View,
        isDefaultBackground: Boolean) :
        TextViewItem<T, EditText>(fg, view, view.findViewById(R.id.fg_input), isDefaultBackground) {

    /**
     * Current String in the [EditText]
     */
    var input: String = ""
        get() = childView.text.toString()
        private set

    /**
     * Current String in the [EditText], trimmed
     */
    var trimmedInput: String = ""
        get() = input.trim()
        private set

    init {
        // Set the right background
        if (fg.builder.defaultInputBackgroundId != null) {
            inputBackgroundId(fg.builder.defaultInputBackgroundId)
        }
    }

    /**
     * @return Item with the input type set to the given [type]
     */
    fun inputType(type: Int): T {
        childView.inputType = type
        return this as T
    }

    /**
     * @return Item with the input background set to the [backgroundId]
     */
    fun inputBackgroundId(backgroundId: Int): T {
        childView.setBackgroundResource(backgroundId)
        return this as T
    }

    override fun onClick(listener: OnClickListener<T>?): T {
        // Make the EditText non focusable, non long clickable, and follow its parent before
        //  continuing. If the listener is null, do the opposite
        childView.isFocusable = listener == null
        childView.isLongClickable = listener == null
        childView.isClickable = false
        if (listener == null) {
            childView.setOnClickListener(null)
        } else {
            childView.setOnClickListener({ _ -> listener.onClick(this as T) })
        }
        return super.onClick(listener)
    }
}