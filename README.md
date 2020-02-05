# QuantityCounter-Android
An Android View to pick item quantity

[![](https://jitpack.io/v/chtgupta/QuantityCounter-Android.svg)](https://jitpack.io/#chtgupta/QuantityCounter-Android)

## Installation

### Gradle

Step 1. Add the JitPack repository to your build file

```sh
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```sh
	dependencies {
	        implementation ('com.github.chtgupta:QuantityCounter-Android:1.0') {
          	     exclude module: 'app'
    		}
	}
```

### Maven

Step 1. Add the JitPack repository to your build file

```sh
	  <repositories>
          	<repository>
          		<id>jitpack.io</id>
	  		<url>https://jitpack.io</url>
	  	</repository>
	  </repositories>
```

Step 2. Add the dependency

```sh
	<dependency>
	    <groupId>com.github.chtgupta</groupId>
	    <artifactId>FadeInTextView-Android</artifactId>
	    <version>2.1.0</version>
	</dependency>
```

## Usage

### In the XML layout

```xml
    <chtgupta.quantitycounter.QuantityCounterView
        android:id="@+id/quantityCounter"
        android:layout_gravity="center"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:themeColor="#fff"
        app:backgroundColor="#000"
        app:initialText="Add"
        app:maxValue="10"/>
```

### In the Java class
#### Java8

```java
  QuantityCounterView quantityCounter = findViewById(R.id.quantityCounter);
  
  quantityCounter.setValueListener(value ->
                Log.d("onValueChange", String.valueOf(value))
        );
  
```

#### Java7

```java
  QuantityCounterView quantityCounter = findViewById(R.id.quantityCounter);
  
  quantityCounter.setValueListener(new QuantityCounterView.ValueListener() {
            @Override
            public void onValueChange(int value) {
                Log.d("onValueChange", String.valueOf(value));
            }
        });
  
```

## Release History

* 1.0
	* Initial release
 
