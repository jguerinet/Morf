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

import android.view.View
import com.guerinet.morf.base.BaseLineItem

/**
 * Line within the form. Base class for all other items except for space
 * @author Julien Guerinet
 * @since 4.0.0
 *
 * @param morf [Morf] instance
 */
class LineItem(morf: Morf) : BaseLineItem<LineItem, View>(morf, View(morf.context)) {

    init {
        build()
    }
}