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

import android.support.annotation.CallSuper
import android.view.View
import com.guerinet.formgenerator.FormGenerator

/**
 * Base class for all items that could be present on a form
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param fg    [FormGenerator] that created this item
 */
@Suppress("UNCHECKED_CAST")
open class Item<T : Item<T>>(protected val fg: FormGenerator, protected val view: View) {

    /**
     * Builds the item by adding it to the container. Subclasses may perform other operations
     * @return [Item] instance
     */
    @CallSuper
    open fun build(): T {
        fg.container.addView(view)
        return this as T
    }

    /**
     * TODO This might be useless
     * @return [View] this item represents
     */
    open fun view(): View = view
}