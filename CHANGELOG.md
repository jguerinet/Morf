# Change Log

## Version 5.0.0 (2018-03-03)
* Library has a new name!
* Package name has been changed to `com.guerinet.morf`
* The `FormGenerator` class has been renamed to `Morf`, and its `Settings` has been renamed to `Shape`
* Added method to set an Id on a view
* Drastically simplified the view structure: objects are no longer contained within their own `LinearLayout`s
* Removed all XML inflation, views are programmatically loaded instead
* Added method to set height and width directly without needing to pass `LayoutParams`
* Added methods on the items of type `EditText` to set text/number input types directly
* Added the `Layout` utility class, with aliases for `WRAP_CONTENT` and `MATCH_PARENT` to set these properties more concisely
* Fixed bug where inline functions would not automatically build the view at the end
* Removed need to call `build()` on space and line items
* Calling `build()` multiple times on the same object will no longer crash the app

## Version 4.0.1 (2018-02-22)
* Fixed bug where drawable wasn't being mutated before setting the alpha on it, causing it to disappear in some cases
* Bumped min version to 17

## Version 4.0.0 (2018-02-20)
* Library is now in Kotlin!
* Library structure has been entirely reworked to remove code duplication
* Package name has changed to `com.guerinet.fg`
* All items have been renamed to remove the word 'Form' from them
* `FormGenerator.Builder` has been renamed to `FormGenerator.Settings`
* `Settings` can be prepared using a DSL in Kotlin
* Form items can be prepared using a DSL in Kotlin
* Created programmatic instantiations of the `SpaceItem` and `LineItem`
* Icons now use relative positioning, and require a `Position` variable (as opposed to having one method per position)
* Icons `Drawable`s can now be set directly (as opposed to using a resource Id)
* `LineItem`s and `SpaceItem`s now need to call `build()` as well
* Added a `TextWatcher` to all `InputItem`s and descendants
* Added options to set line heights, space heights, view padding, and drawable padding in pixels, DP, or using a dimension resource Id
* Added options to set some colors using Ids or resolved colors
* Text size is now set using an Id for all `TextViewItem`s and descendants
* Support libraries have been updated to use the latest versions

## Version 3.2.2 (2017-04-12)
* Removed the setting of the default background on the `TextInputFormItem`

## Version 3.2.1 (2017-04-12)
* Fixed the instantiation of a `TextInputFormItem`

## Version 3.2.0 (2017-04-11)
* New: Fixed the constructors to use the view context as opposed to asking for a context
* New: Added `focusable()` for most of the items to set their focusable property
* New: Switched `background()` on the `TextInputFormItem` + subclasses to set the background resource on the input layout

## Version 3.1.1 (2017-04-11)
* New: Added `enabled()` for most of the items to enable/disable them

## Version 3.1.0 (2017-02-02)
* New: Added the `AutoCompleteTextViewFormItem`
* Fixed the `onClick` method for `EditTextFormItem`s

## Version 3.0.0 (2017-02-01)
* New: Added the `TextInputFormItem`, for `TextInputLayout`s
* New: Added methods to retrieve the text within the `EditText`s
* Breaking: All form items no longer take a text as an input. You now set the text with `text()`

## Version 2.2.5 (2016-11-23)
* New: Added method to update the icons without rebuilding the form item
* Update: Removed method added in v2.2.3

## Version 2.2.4 (2016-11-22)
* New: Added method to add a custom view to a form

## Version 2.2.3 (2016-04-21)
* Update: Fixed icon setting and tinting on pre-Lollipop

## Version 2.2.2 (2016-04-09)
* New: Added method to remove the single line property of the text form items
* Update: Removed `singleLine()` from the text form items since by default it's already true

## Version 2.2.1 (2016-04-09)
* Update: Brought back the default line size (0.5dp) and the default space size (8dp)

## Version 2.2.0 (2016-04-09)
* New: Added default drawable padding to the Builder
* New: Added `build()` to build the views to avoid having to reset the icons every time we add a new one
* New: Added method to set form item visibility
* New: Added method to get the parent view (a.k.a. the whole form item)
* New: Added method to set the layout params and layout gravity of most form items (not line or space)
* New: New custom `OnClickListener` implementation to have a reference to the form item in `onClick()`
* Update: `ButtonFormItem` constructor no longer takes the `OnClickListener` in the constructor
* Update: Using resolved colors for icon tinting
* Update: Using resolved colors for text coloring
* Update: Using pixels for space size
* Update: Using pixels for padding size
* Update: Using pixels for text size
* Update: Using pixels for line size

## Version 2.1.5 (2016-03-10)
* Fix: Now using the Application Context to tint a drawable to avoid memory leaks
* Update: Removed `setSingleLine()` from EditTextFormItem since it was a duplicate

## Version 2.1.4 (2016-02-29)
* Fix: Fixed bug where app would crash when the default color Id was not set

## Version 2.1.3 (2015-12-01)
* Added the borderless button

## Version 2.1.2 (2015-11-13)
* Fixed bug where the icon drawable was no longer being mutated when set

## Version 2.1.1 (2015-11-13)
* Added the possibility to initialize TextViewFormItems or its descendants with a string resource Id

## Version 2.1.0 (2015-11-13)
* Added gravity to the form items
* Now using Drawable tinting instead of a color filter to color the icons
* Added the single line option to the form items with a text field
* Added the single line option to the EditTextFormItem
* Added the ellipsize option to the form items with a text field
* Completely reworked the `get()`, `set()`, and `bind()` methods to make it more clear (see README for more info)
* Added the on and off text on the SwitchFormItem
* Added method to initialize a new Builder instance from an old one, allowing you to base a Builder instance from your default one
* ButtonFormItem no longer inherits the default background

## Version 2.0.2 (2015-10-19)
* Updated dependencies

## Version 2.0.1 (2015-06-18)
* Fixed bug where some super class methods for the form items were not overridden
* Builder no longer depends on the LayoutInflater and a container, only the FormGenerator does

## Version 2.0.0 (2015-06-09)
* Added possibility to customize the space color
* Added possibility to customize the input background
* Added possibility to set the backgrounds for any form item (except the lines) to @null
* Reworked how the views were created and added to the container: each specific view can now be customized independently of the default settings
* Added possibility to deconstruct a FormGenerator back into a Builder

## Version 1.1.0 (2015-06-05)
* Added demo project to demonstrate library capabilities
* Added possibility to customize the text size
* Added possibility to customize the typeface
* Set up singleton logic and possibility to set default instance

## Version 1.0.2 (2015-06-04)
* Added Sources

## Version 1.0.1 (2015-06-04)
* Bug Fixes

## Version 1.0.0 (2015-06-03)
* Initial Release