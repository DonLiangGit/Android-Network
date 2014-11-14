Android-Network
===============

Android Network Library &amp; Framework Analysis and Tutorial

Reference: [OkHttp / Retrofit / Volley](http://stackoverflow.com/questions/16902716/comparison-of-android-networking-libraries-okhttp-retrofit-volley)

Retrofit
====
####Introduction
1. Retrofit Documentation [link](http://square.github.io/retrofit/)
2. Principles: [Proxy Design Pattern]() & [Java Reflect & Dynamic Proxy]() & [Callback function]()
3. RESTful (GET/PUT/POST/DELETE/HEAD)

####How to use?
1. Gradle: <code> compile 'com.squareup.retrofit:retrofit:x.x.x' </code>,
2. Adding Internet Permission in AndroidManifest.xml,
3. Create a ClientClass, API_URL, Class for fetch JSON member, declare and define the interface(with RESTful APIs),
4. Set RestAdapter, Instance an the interfaced defined previously and fetch the API based on the parameters,
5. In onCreate() method, get the callback.

Volley
====
