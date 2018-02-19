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

import android.graphics.Color
import android.graphics.Typeface
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.guerinet.formgenerator.R

/**
 * Creates the various form items and adds them to a given container
 * @author Julien Guerinet
 * @since 1.0.0
 */
class FormGenerator private constructor(internal val defaults: Defaults,
                                        internal val container: LinearLayout) {

    private val inflater: LayoutInflater = LayoutInflater.from(container.context)

    /**
     * @return [SpaceItem] added to the form
     */
    fun space(): SpaceItem = SpaceItem(this, inflater.inflate(R.layout.fg_space, container, false))

    /**
     * @return [LineItem] added to the form
     */
    fun line(): LineItem = LineItem(this, inflater.inflate(R.layout.fg_line, container))

    /**
     * @return [TextViewItem] added to the form
     */
    fun text(): TextViewItem {
        val view = inflater.inflate(R.layout.fg_text, container, false)
        return TextViewItem(this, view, view.findViewById(R.id.fg_text), true)
    }

    /**
     * @return [ButtonItem] added to the form
     */
    fun button(): ButtonItem =
            ButtonItem(this, inflater.inflate(R.layout.fg_button, container, false))

    /**
     * Contains all of the customizable defaults for a [FormGenerator]
     */
    class Defaults {

        /* Space */

        /**
         * Background resource for a space, defaults to transparent
         */
        @ColorRes
        @DrawableRes
        var spaceColorId: Int = android.R.color.transparent

        /**
         * TODO
         * Id of the size dimension for a space, defaults to null
         */
        @DimenRes
        var spaceSizeId: Int? = null

        /* Line */

        /**
         * TODO
         * Id of the size dimension for a line, defaults to null
         */
        @DimenRes
        var lineSizeId: Int? = null

        /**
         * Id of the background resource for a line, defaults to #EEEEEE
         */
        @ColorRes
        @DrawableRes
        var lineBackgroundId: Int = R.color.line

        /**
         * True if we should show a line after a form item, false otherwise (defaults to true)
         */
        var isLineShown: Boolean = true

        /* Text */

        /**
         * Id of the size of the text, defaults to null (which is the app's default)
         */
        @DimenRes
        var textSize: Int? = null

        /**
         * Color of the text, defaults to black
         */
        @ColorInt
        var textColor: Int = Color.BLACK

        /**
         * Typeface to use for the text, null if none (defaults to null)
         */
        var textTypeface: Typeface? = null

        /* Padding */

        /**
         * Padding size for non-space/line items, defaults to null (which is the app's default)
         */
        var paddingSize: Int? = null

        /**
         * Padding size between a view and its compound drawable, defaults to null
         *  (which is the app's default)
         */
        var drawablePaddingSize: Int? = null

        /* Resources */

        /**
         * Color to tint the icons, null if none (defaults to null)
         */
        @ColorInt
        var iconColor: Int? = null

        /**
         * Id of the background to use, null if none (defaults to null)
         */
        @ColorRes
        @DrawableRes
        var backgroundId: Int? = null

        /**
         * Id of the background to use for input items, null if none (defaults to null)
         */
        @ColorRes
        @DrawableRes
        var inputBackgroundId: Int? = null
    }
}