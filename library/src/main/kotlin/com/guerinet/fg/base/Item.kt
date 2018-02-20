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

import android.support.annotation.*
import android.view.View
import com.guerinet.fg.FormGenerator
import com.guerinet.fg.SpaceItem

/**
 * Base class for all items that could be present on a form
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param fg    [FormGenerator] that created this item
 */
@Suppress("UNCHECKED_CAST")
open class Item<out T : Item<T>>(protected val fg: FormGenerator, val view: View) {

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
        val scale = fg.container.resources.displayMetrics.density
        return pixelHeight(view, (dps * scale + 0.5f).toInt())
    }

    /**
     * @return Item with the [view] height set to the given [dimenId]
     */
    protected fun heightId(view: View?, @DimenRes dimenId: Int): T {
        return pixelHeight(view, fg.container.resources.getDimensionPixelOffset(dimenId))
    }

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
     * Builds the item by adding it to the container. Subclasses may perform other operations
     * @return [Item] instance
     */
    @CallSuper
    open fun build(): T {
        fg.container.addView(view)
        return this as T
    }
}