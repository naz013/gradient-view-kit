# Android GradientView Kit
## Collection of ViewGroups and Views with gradient helper functions

[![](https://jitpack.io/v/naz013/gradient-view-kit.svg)](https://jitpack.io/#naz013/gradient-view-kit)

<img src="https://github.com/naz013/gradient-view-kit/raw/master/res/screenshot.png" width="400" alt="Screenshot"><img src="https://github.com/naz013/gradient-view-kit/raw/master/res/screenshot2.png" width="400" alt="Screenshot">

### List of views:
- LinearLayout, FrameLayout, RelativeLayout (background gradient with animation);
- CardView (background gradient);
- TextView (paint with gradient whole text or some words);
- CheckBox (paint with gradient whole text or some words);
- Button (background gradient with animation, text gradients);

## How to
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency
```groovy
dependencies {
    implementation "com.github.naz013:gradient-view-kit:$latestVersion"
}
```



```xml
<com.github.naz013.gradientkit.viewgroup.UiGradientLinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    app:gradientLinearLayout_animate="false"
    app:gradientLinearLayout_centerColor="#203A43"
    app:gradientLinearLayout_cornerRadius="10dp"
    app:gradientLinearLayout_endColor="#2C5364"
    app:gradientLinearLayout_orientation="TL_BR"
    app:gradientLinearLayout_startColor="#0F2027">
    
    ...
            
</com.github.naz013.gradientkit.viewgroup.UiGradientLinearLayout>
```

```kotlin
tv.text = "Hello gradient world \nAlso strike through\nAnd Italic one"
tv.addGradientSection(
    "radien",
    Color.parseColor("#009FFF"),
    Color.parseColor("#ec2F4B")
)
tv.addGradientSection(
    "world",
    Color.parseColor("#f953c6"),
    Color.parseColor("#b91d73")
)

tv.addBoldSection("adient")
tv.addBoldSection("Also")

tv.addStrikeThroughSection("strike through")

tv.addItalicSection("Italic")
tv.addBoldSection("Italic")
tv.addGradientSection(
    "Italic",
    Color.parseColor("#009FFF"),
    Color.parseColor("#ec2F4B")
)
tv.addGradientSection(
    "strike",
    Color.parseColor("#FFFFFF"),
    Color.parseColor("#333333")
)
```

License
-------

    Copyright 2023 Nazar Suhovich

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
