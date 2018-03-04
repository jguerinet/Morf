# Morf

## Summary
Generates customizable forms for Android 17+. Form items include:

* Simple text
* Text buttons
* Standard Android buttons
* Standard Android borderless buttons
* Switches
* Input fields
* Text input fields
* Autocomplete text input fields
* Lines
* Spaces

Customization includes:

* Text (color, typeface, size)
* Background color (can be solid colors, drawables, or a color state list)
* Input background (For the EditTexts)
* Icons (location, visibility, color, padding)
* Padding size
* Line width and color
* Space width and color
* Whether or not lines should be shown after form items
* Switch on and off text
* View height and width
* View visibility

## Instructions
[![Release](https://jitpack.io/v/com.guerinet/morf.svg)](https://jitpack.io/#com.guerinet/morf)

To include this in your project, you can add it with Gradle by using [JitPack](https://jitpack.io). Replace X.X.X below with the latest version found on the status badge above or on the  [Releases](https://github.com/jguerinet/morf/releases) page:

    repositories {
        maven { url "https://jitpack.io" }
    }

	dependencies {
	    implementation 'com.guerinet:morf:X.X.X'
	}

To use this in your project, you can either build an instance of `Morf` with its custom `Shape`, customizing
anything you might want to change or you can use the default `Morf` instance by calling `Morf.bind()`.
You can set the default shape by calling `Morf.createAndSetShape()` if you want to use a customized `Morf` throughout your app. The default values are:

* Text Color: Black
* Text Size: Default Android Text size
* Text Typeface: Default Android Typeface
* Background: Transparent
* Input Background: Default Android background
* Icon Color: None
* Padding: Default Android Padding
* Line Width: 0.5dp
* Line Color: #EEEEE
* Space Width: 8dp
* Space Color: Transparent
* Lines after items: True

Once you set your default `Shape`, you can always customize it by calling `Morf.shape` and changing the desired fields. You can also construct a new instance from your default one by calling
`Morf.shape.newShape()` so that you can start off with your default values, but any changes you make will not change the default instance.
Each item can be further customized if you need to have some properties that are different from the default properties. When adding each item, there are a number of methods you can call to further customize the item itself.
To get the associated view, simple access `view` property of the item. All of the above properties can be customized per form item, as well as:

* Check state for `Switch`es
* On and off text for `Switch`es (not recommended as the text is poorly rendered on Lollipop-style `Switch`es
* Setting an `OnCheckedChangeListener` for `Switch`es
* Setting an `OnClickListener` for all form items except the spaces and lines
* Setting the input type on the `EditText`s (default is capitalized sentences)
* Setting if the `EditText` should be multi line (default is single line)
* Adding a `TextWatcher` to `EditText`s
* Setting icons on all form items except the spaces and lines
* Showing/hiding the password visibility toggle for the `TextInputFormItem`

IMPORTANT: All views need to be built by calling `build()` (apart from spaces and lines). If you do not call `build()` they will not be added to the container. You can safely call `build()` multiple times.

## Demo
A demo is included within this repo (in the demo folder). The demo shows 2 forms with all of the types of form items:
the top one is a `Morf` with the default `Shape`, the bottom is a `Morf` with a customized `Shape` (changed text color, background selector, line width, line color, icon, and icon color). Below is a screenshot:

![Demo Screenshot](assets/demo_screenshot.png)

## Gradle Dependencies
* [Android AppCompat](http://developer.android.com/tools/support-library/features.html#v7-appcompat)
* [Android Design](http://developer.android.com/tools/support-library/features.html#design)

## Contributors
* [Julien Guerinet](https://github.com/jguerinet)

## Version History
See the [Change Log](CHANGELOG.md).

## Copyright
	 Copyright 2015-2018 Julien Guerinet

	 Licensed under the Apache License, Version 2.0 (the "License");
	 you may not use this file except in compliance with the License.
	 You may obtain a copy of the License at

	    http://www.apache.org/licenses/LICENSE-2.0

	 Unless required by applicable law or agreed to in writing, software
	 distributed under the License is distributed on an "AS IS" BASIS,
	 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 See the License for the specific language governing permissions and
	 limitations under the License.
