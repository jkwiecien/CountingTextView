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
    compile('com.github.jkwiecien:CountingTextView:1.0.1') {
        exclude module: 'appcompat-v7'
    }
}
```

