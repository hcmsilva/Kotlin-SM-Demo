# Kotlin-SM-Demo

A Kotlin proof-of-concept app that uses modularity to demonstrate how a team can make a reusable component that can be shared across different apps.

Written **98%** in **Kotlin** / 2% in Java, uses the **MVP design pattern**, **local Unit tests** and **Mockito** for unit test isolation.

- Architecture Pattern: **Model View Presenter (MVP)**
- The app is organized *Feature-per-Package* 
- There is a set of local Unit tests written with **JUnit**
- **Mockito** was used to generate mocks and better isolate these unit tests
- The android library module was developed using TDD and includes Unit / Integration tests
- The app module can be considered a dummy shop app (separate module which tests will be added later) 
- The UI has been developed using the newer `ConstraintLayout` (see screenshots below)
- Kotlin Extensions / kotlinx view bindings have been used for code simplicity

The app is divided in two separate modules `:app` and `:mypaymentslibrary` each with its: gradle build file, manifest, source sets, resources, etc.

![kotlin-sm-1](https://user-images.githubusercontent.com/4844875/51154193-e808c680-186a-11e9-86c5-31a1abe77d89.PNG)

The library can be used by other apps by importing the module into android studio and including the below.

App's lib module gradle build file:

```
    dependencies {
        //...
        implementation project(path: ':mypaymentslibrary')
    }
```

Alternatively the library could by published and version-released into jCenter or Maven, with the benefits
of having clearly versioned easily swappable dependencies help to achieve deterministic builds (beware of x.y.+ declared dependencies).

Yet another way of importing this library is to build it so the `aar` library file can be saved and reused

usage of the payment library can be as simple as invoking:
```
@JvmStatic
fun pay(description: String, price: Int, parentActivity: Activity, code: Int)
``` 

The result of the payment operation is returned via the `onActivityResult` callback on the invoking activity.

note: the mock ApiClient doesn't actually access the internet as it is a stub which implements the payments flow / hypermedia available actions by using an internal state machine that controls the next possible states/actions/urls

Examples of use of `ConstraintLayout` in this project:

![constraint_layout_demo1](https://user-images.githubusercontent.com/4844875/51153764-5187d580-1869-11e9-9d71-e9f71268d008.PNG)

![constraint_layout_demo2](https://user-images.githubusercontent.com/4844875/51153833-898f1880-1869-11e9-9944-cef170723a23.PNG)

![constraint_layout_demo3](https://user-images.githubusercontent.com/4844875/51153854-a0356f80-1869-11e9-91a6-2eaeabce822f.PNG)


