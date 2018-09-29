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

import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.CallSuper
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import com.guerinet.morf.Morf
import com.guerinet.morf.util.Layout

/**
 * Base class for all items that could be present on a form
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param morf    [Morf] that created this item
 */
@Suppress("UNCHECKED_CAST")
open class Item<out T : Item<T, V>, out V : View>(protected val morf: Morf, val view: V) {

    /**
     * @return Item instance with the given [id] set
     */
    fun id(id: Int): T {
        view.id = id
        return this as T
    }

    /**
     * @return Item instance with its new height in [pixels] set
     */
    fun pixelHeight(pixels: Int): T {
        return pixelHeight(view, pixels)
    }

    /**
     * @return Item with its new height in [dps] set
     */
    fun dpHeight(dps: Float): T {
        return dpHeight(view, dps)
    }

    /**
     * @return Item with its new height from the [dimenId] set
     */
    fun heightId(@DimenRes dimenId: Int): T {
        return heightId(view, dimenId)
    }

    /**
     * @return Item with the [view] height set to the given [pixels]
     */
    protected fun pixelHeight(view: View?, pixels: Int): T {
        view?.layoutParams?.height = pixels
        return this as T
    }

    /**
     * @return Item with the [view] height set to the given [dps]
     */
    protected fun dpHeight(view: View?, dps: Float): T {
        return pixelHeight(view, dpToPixels(dps))
    }

    /**
     * @return Item with the [view] height set to the given [dimenId]
     */
    protected fun heightId(view: View?, @DimenRes dimenId: Int): T {
        return pixelHeight(view, dimenToPixels(dimenId))
    }

    protected fun dpToPixels(dps: Float): Int =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps,
                    morf.container.resources.displayMetrics).toInt()

    /**
     * @return Pixel equivalent of the dimen [dimenId]
     */
    protected fun dimenToPixels(@DimenRes dimenId: Int): Int =
            morf.container.resources.getDimensionPixelOffset(dimenId)

    /**
     * @return Item with the given background with [backgroundId] set
     */
    open fun backgroundId(@ColorRes @DrawableRes backgroundId: Int): T {
        view.setBackgroundResource(backgroundId)
        return this as T
    }

    /**
     * @return Item with the background of the given [color]
     */
    fun backgroundColor(@ColorInt color: Int): T {
        view.setBackgroundColor(color)
        return this as T
    }

    /**
     * @return Item with the set [width] (defaults to MATCH_PARENT), [height]
     *  (defaults to WRAP_CONTENT), and [gravity] (null if none, defaults to null
     */
    @JvmOverloads
    fun layout(width: Int = Layout.MATCH_PARENT, height: Int = Layout.WRAP_CONTENT,
               gravity: Int? = null): T {
        return layoutParams(LinearLayout.LayoutParams(width, height), gravity)
    }

    /**
     * @return Item with the given layout [params] and [gravity] (null if none, defaults to null)
     *  set
     */
    fun layoutParams(params: LinearLayout.LayoutParams, gravity: Int? = null): T {
        if (gravity != null) {
            params.gravity = gravity
        }
        view.layoutParams = params
        return this as T
    }

    /**
     * Builds the item by adding it to the container. Subclasses may perform other operations
     * @return [Item] instance
     */
    @CallSuper
    open fun build(): T {
        if (view.parent == null) {
            morf.container.addView(view)
        }
        return this as T
    }

    /**
     * Builds the item by applying the given block to it, and calling build(). Returns the
     *  built item
     */
    inline fun build(block: T.() -> Unit): T = (this as T).apply(block).build()
}