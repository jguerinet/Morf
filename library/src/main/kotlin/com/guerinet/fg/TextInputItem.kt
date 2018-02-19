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

import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.EditText
import com.guerinet.fg.base.BaseTextInputItem

/**
 * Form item for a [TextInputLayout]
 * @author Julien Guerinet
 * @since 4.0.0
 *
 * @param fg    [FormGenerator] instance
 * @param view  Item [View]
 */
class TextInputItem(fg: FormGenerator, view: View) :
        BaseTextInputItem<TextInputItem, EditText>(fg, view)