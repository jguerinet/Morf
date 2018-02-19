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

import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.view.View
import com.guerinet.fg.FormGenerator

/**
 * Base class for all items that have a line
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param fg    [FormGenerator] instance
 * @param view  Item [View]
 * @param line  Line [View]
 */
@Suppress("UNCHECKED_CAST")
open class BaseLineItem<out T : BaseLineItem<T>>(
        fg: FormGenerator,
        view: View,
        private val line: View
) : Item<T>(fg, view) {

    init {
        // Size
        val lineSizeId = fg.defaults.lineSizeId
        if (lineSizeId != null) {
            // Set the default line size if there is one
            lineSize(lineSizeId)
        }

        // Background
        lineBackground(fg.defaults.lineBackgroundId)

        if (view != line) {
            // Set the line visibility if this is not an independent item
            showLine(fg.defaults.isLineShown)
        }
    }

    /**
     * @return [BaseLineItem] instance with its new [size] set
     */
    fun lineSize(size: Int): T {
        line.layoutParams.height = size
        return this as T
    }

    /**
     * @return [BaseLineItem] instance with its new background with the given [resId] set
     */
    fun lineBackground(@DrawableRes @ColorRes resId: Int): T {
        line.setBackgroundResource(resId)
        return this as T
    }


    /**
     * @return Item with its new line [color] set
     */
    fun lineColor(@ColorInt color: Int): T {
        line.setBackgroundColor(color)
        return this as T
    }

    /**
     * @return Item with the line [show]n or hidden
     */
    fun showLine(show: Boolean): T {
        line.visibility = if (show) View.VISIBLE else View.GONE
        return this as T
    }
}
