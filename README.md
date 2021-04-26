# shelled
A simple root shell for Android

---

### Download

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
  implementation 'com.github.edneyosf:shelled:1.0.0'
}
```

---

### How do I use Shelled?

```
Shelled.run("ls")
```
