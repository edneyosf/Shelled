# Shelled

<img src="https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white"/>

[![Version](https://img.shields.io/badge/version-v1.0.1-blue)]()

## Gradle Setup

Add it in your root `build.gradle` at the end of repositories:
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Add the dependency

```
dependencies {
  implementation 'com.github.edneyosf:shelled:1.0.1'
}
```

## Usage

```
Shelled.run("ls")
```
