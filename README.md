# Form Generator

## Summary
Generates customizable forms for Android 8+ (tested on 10+). Form items include:

* Simple text with/without left/right icons
* Text buttons with/without left/right icons
* Standard Android buttons
* Switches with/without a left icon
* Input fields with/without a left icon
* Lines
* Spaces

Customization includes:

* Text color (size coming soon)
* Background color (can be solid colors or a color state list)
* Icon color
* Padding size
* Line width and color
* Space width
* Whether or not lines should be shown after form items

## Instructions
To include this in your project, you can add it with Gradle by using [JitPack][1]:

    repositories {
        maven { url "https://jitpack.io" }
    }

	dependencies {
	    compile 'com.github.jguerinet:form-generator:1.0.2'
	}

You can also attach the sources by using the [AARLinkSources][2] plugin:

	aarLinkSources 'com.github.jguerinet:form-generator:1.0.2:sources@jar'

[1]:https://jitpack.io
[2]:https://github.com/xujiaao/AARLinkSources

To use this in your project, first build your `FormGenerator` with its custom `Builder`, customizing
anything you might want to change. The default values are:

* Text Color: Black
* Text Size: 14sp
* Background: Transparent
* Padding: 8dp
* Line Width: 0.5 dp
* Space Width: 10dp

## Demo
A demo is included within this repo (in the demo folder). The demo shows 2 forms with all of the types of buttons:
the top one is the default settings for FormGenerator, the bottom is a customized FormGenerator (changed text color, background selector, line width, line color). Below is a screenshot:

![Demo Screenshot](assets/demo_screenshot.png)

## Gradle Dependencies
* appcompat-v7: AppCompat Support Library

## Contributors
* [Julien Guerinet](https://github.com/jguerinet)

## Version History
See the [Change Log](CHANGELOG.md).

## Copyright
	 Copyright 2015 Julien Guerinet

	 Licensed under the Apache License, Version 2.0 (the "License");
	 you may not use this file except in compliance with the License.
	 You may obtain a copy of the License at

	    http://www.apache.org/licenses/LICENSE-2.0

	 Unless required by applicable law or agreed to in writing, software
	 distributed under the License is distributed on an "AS IS" BASIS,
	 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 See the License for the specific language governing permissions and
	 limitations under the License.