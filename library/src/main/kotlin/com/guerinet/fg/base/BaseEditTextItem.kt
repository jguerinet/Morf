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

package com.guerinet.fg.base

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.guerinet.fg.FormGenerator

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
open class BaseEditTextItem<T : BaseEditTextItem<T, V>, V : EditText>(
        fg: FormGenerator,
        view: V,
        isDefaultBackground: Boolean = true) : BaseTextViewItem<T, V>(fg, view, isDefaultBackground
) {

    init {
        view.maxLines = 1
        textInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES)
    }

    /**
     * Current String in the [EditText]
     */
    var input: String = ""
        get() = view.text.toString()
        private set

    /**
     * Current String in the [EditText], trimmed
     */
    var trimmedInput: String = ""
        get() = input.trim()
        private set

    init {
        // Set the right background
        val inputBackgroundId = fg.settings.inputBackgroundId
        if (inputBackgroundId != null) {
            inputBackgroundId(inputBackgroundId)
        }
    }

    /**
     * Sets the input type to text class with the given [type]
     */
    fun textInputType(type: Int): T {
        return inputType(InputType.TYPE_CLASS_TEXT or type)
    }

    /**
     * Sets the input type to number class with the given [type]
     */
    fun numberInputType(type: Int): T {
        return inputType(InputType.TYPE_CLASS_NUMBER or type)
    }

    /**
     * Sets the the given input [type]
     */
    fun inputType(type: Int): T {
        view.inputType = type
        return this as T
    }

    /**
     * @return Item with the input background set to the [backgroundId]
     */
    fun inputBackgroundId(backgroundId: Int): T {
        view.setBackgroundResource(backgroundId)
        return this as T
    }

    /**
     * @return Item with a [watcher] on the [EditText]
     */
    fun watch(watcher: TextWatcher): T {
        view.addTextChangedListener(watcher)
        return this as T
    }

    /**
     * @return Item with a [TextWatcher] that calls the [watcher] when the [EditText] changes
     */
    fun watch(watcher: ((String) -> Unit)): T {
        return watch(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                watcher(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun onClick(onClick: ((T) -> Unit)?): T {
        // Make the EditText non focusable, non long clickable, and follow its parent before
        //  continuing. If the listener is null, do the opposite
        view.isFocusable = onClick == null
        view.isLongClickable = onClick == null
        view.isClickable = false
        if (onClick == null) {
            view.setOnClickListener(null)
        } else {
            view.setOnClickListener({ _ -> onClick(this as T) })
        }
        return this as T
    }
}