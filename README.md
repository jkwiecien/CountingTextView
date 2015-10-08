[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-CountingTextView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/2602)

# CountingTextView
Animated value change on a TextView made easy. Just call ```setValue(float value)``` on a CountingTextView and watch the magic happen.

# How does it work?

This is only a GIF, so it won't look smooth, but believe me that live it is smooth as Sir Sean O'Connery 

<img src="http://g.recordit.co/ID5SBXCvVM.gif" height="360" />

# Value formatting

You can customize what do you wan't to add to your number:
```
textView.setFormatter(new CountingTextView.ValueFormatter() {
                    @Override 
                    public String formatValue(float value) {
                        return String.format("%.2f%% of rabbits", value);
                    } 
                }); 
```

#Setup
```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile('com.github.jkwiecien:CountingTextView:1.0.10') {
        exclude module: 'appcompat-v7'
    }
}
```

License
=======

    Copyright 2015 Jacek Kwiecień.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

