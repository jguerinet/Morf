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

package com.guerinet.morf.base

import android.view.View
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import com.guerinet.morf.Morf

/**
 * Base class for all items that have a line
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param morf  [Morf] instance
 * @param view  Item [View]
 * @param line  Line [View], null if none (in the case of a button for example)
 */
@Suppress("UNCHECKED_CAST")
open class BaseLineItem<out T : BaseLineItem<T, V>, out V : View>(
        morf: Morf,
        view: V,
        protected val line: View? = view
) : Item<T, V>(morf, view) {

    init {
        // Width
        line?.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)

        // Height
        val lineHeightId = morf.shape.lineHeightId
        if (lineHeightId != null) {
            lineHeightId(lineHeightId)
        } else {
            val linePixelHeight = morf.shape.linePixelHeight
            if (linePixelHeight != null) {
                linePixelHeight(linePixelHeight)
            } else {
                lineDpHeight(morf.shape.lineDpHeight)
            }
        }

        // Background
        val lineBackgroundId = morf.shape.lineBackgroundId
        if (lineBackgroundId != null) {
            lineBackground(lineBackgroundId)
        } else {
            lineColor(morf.shape.lineColor)
        }

        if (view != line) {
            // Set the line visibility if this is not an independent item
            showLine(morf.shape.isLineShown)
        }
    }

    /**
     * @return [BaseLineItem] instance with its new height in [pixels] set
     */
    fun linePixelHeight(pixels: Int): T {
        return pixelHeight(line, pixels)
    }

    /**
     * @return Item with its new height in [dps] set
     */
    fun lineDpHeight(dps: Float): T {
        return dpHeight(line, dps)
    }

    /**
     * @return Item with its new height from the [dimenId] set
     */
    fun lineHeightId(@DimenRes dimenId: Int): T {
        return heightId(line, dimenId)
    }

    /**
     * @return [BaseLineItem] instance with its new background with the given [resId] set
     */
    fun lineBackground(@DrawableRes @ColorRes resId: Int): T {
        line?.setBackgroundResource(resId)
        return this as T
    }

    /**
     * @return Item with its new line [color] set
     */
    fun lineColor(@ColorInt color: Int): T {
        line?.setBackgroundColor(color)
        return this as T
    }

    /**
     * @return Item with the line [show]n or hidden
     */
    fun showLine(show: Boolean): T {
        line?.visibility = if (show) View.VISIBLE else View.GONE
        return this as T
    }

    override fun build(): T {
        val item = super.build()

        // We need to add the line as well
        if (line != null && line.parent == null) {
            morf.container.addView(line)
        }

        return item
    }
}
