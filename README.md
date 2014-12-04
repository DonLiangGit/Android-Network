Android-Network
===============

Android Network Library &amp; Framework Analysis and Tutorial

Network Basic
====
####Introduction
1. What happen after a url-input: [link](http://article.yeeyan.org/view/54517/91367)
2. Interacting with server-side APIs: [Issue in my another repo]()
3. [HTTPResponse Code](http://developer.android.com/reference/org/apache/http/HttpStatus.html#SC_OK)



Retrofit
====
####Introduction
1. Retrofit Documentation [link](http://square.github.io/retrofit/);
2. Retrofit Principles: [Proxy Design Pattern]() & [Java Reflect & Dynamic Proxy]() & [Callback function](), it also integrates with OKHttp;
3. Picasso Principles: [LRU Cache]() & [Disk Cache]();
3. RESTful (GET/PUT/POST/DELETE/HEAD);
4. The sample is used with Picasso 2.4.0 and Retrofit 1.7.1;

####How to use?
1. Gradle: <code> compile 'com.squareup.retrofit:retrofit:x.x.x' </code>,
2. Adding Internet Permission in AndroidManifest.xml,
3. Create a ClientClass, API_URL, Class for fetch JSON member, declare and define the interface(with RESTful APIs),
4. Set RestAdapter, Instance an the interfaced defined previously and fetch the API based on the parameters,
5. In onCreate() method, get the callback.

Reference: [OkHttp / Retrofit / Volley](http://stackoverflow.com/questions/16902716/comparison-of-android-networking-libraries-okhttp-retrofit-volley)  
[Retrofit v.s. Volley](http://instructure.github.io/blog/2013/12/09/volley-vs-retrofit/)

####Conclusion
1. Retrofit supports Java NIO [link](http://shmilyaw-hotmail-com.iteye.com/blog/1896683), we use Retrofit to improve IO performance(Blocking IO creates too much thread to handle jobs!)
2. 

Volley
====

OkHttp
====
####Introduction
1. OkHttp Documentation [link](http://square.github.io/okhttp/)

####How to use?
1. Gradle: <code> compile 'com.squareup.okhttp:okhttp:x.x.x' </code>,
2. Adding Internet Permission in AndroidManifest.xml,
3. Setting OkHttpClient: <code>sample: OkHttpClient client = new OkHttpClient();</code>,
4. Setting OkHttp Request: <code>sample: Request OkRequest = new Request.Builder().url(**url**).build();</code>
5. Setting OkHttp Response: <code>sample: Response OkResponse = client.newCall(OkRequest).execute();</code>
6. Getting the whole JSON string: <code>sample: String jsonString = OkResponse.body().string();


