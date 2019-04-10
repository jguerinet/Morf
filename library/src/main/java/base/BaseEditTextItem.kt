/*
 * Copyright 2015-2019 Julien Guerinet
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

package com.guerinet.morf.base

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.guerinet.morf.Morf

/**
 * Form item that represents an [EditText]
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param morf [Morf] instance
 * @param view Item [View]
 * @param isDefaultBackground True if we should use the default background, false otherwise
 */
open class BaseEditTextItem<T : BaseEditTextItem<T, V>, V : EditText>(
    morf: Morf,
    view: V,
    isDefaultBackground: Boolean = true
) : BaseTextViewItem<T, V>(morf, view, isDefaultBackground) {

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
        val inputBackgroundId = morf.shape.inputBackgroundId
        if (inputBackgroundId != null) {
            inputBackgroundId(inputBackgroundId)
        }
    }

    var textInputType: Int
        get() = error("Setter only")
        set(value) {
            inputType(InputType.TYPE_CLASS_TEXT or value)
        }

    /**
     * Sets the input type to text class with the given [type]
     */
    fun textInputType(type: Int): T = inputType(InputType.TYPE_CLASS_TEXT or type)

    var numberInputType: Int
        get() = error("Setter only")
        set(value) {
            inputType(InputType.TYPE_CLASS_NUMBER or value)
        }

    /**
     * Sets the input type to number class with the given [type]
     */
    fun numberInputType(type: Int): T = inputType(InputType.TYPE_CLASS_NUMBER or type)

    var inputType: Int
        get() = error("Setter only")
        set(value) {
            view.inputType = value
        }

    /**
     * Sets the the given input [type]
     */
    fun inputType(type: Int): T = setAndReturn { this.inputType = type }

    var inputBackgroundId: Int
        get() = error("Setter only")
        set(value) = view.setBackgroundResource(value)

    /**
     * @return Item with the input background set to the [backgroundId]
     */
    fun inputBackgroundId(backgroundId: Int): T =
            setAndReturn { this.inputBackgroundId = backgroundId }

    /**
     * @return Item with a [watcher] on the [EditText]
     */
    fun watch(watcher: TextWatcher): T = setAndReturn { view.addTextChangedListener(watcher) }

    /**
     * @return Item with a [TextWatcher] that calls the [watcher] when the [EditText] changes
     */
    fun watch(watcher: ((String) -> Unit)): T {
        return watch(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) = watcher(s.toString())

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    @Suppress("UNCHECKED_CAST")
    override fun onClick(onClick: ((T) -> Unit)?): T = setAndReturn {
        // Make the EditText non focusable, non long clickable, and follow its parent before
        //  continuing. If the listener is null, do the opposite
        view.isFocusable = onClick == null
        view.isLongClickable = onClick == null
        view.isClickable = false
        if (onClick == null) {
            view.setOnClickListener(null)
        } else {
            view.setOnClickListener { _ -> onClick(this as T) }
        }
    }
}
