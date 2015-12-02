# Change Log

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