# GIPHY4J
Java / Kotlin wrapper library for the GIPHY API

# HOW TO USE
```java
class Giphy4JExample{
    public static void main(String... args){
        String apiKey = "myapikey";
        Giphy4J giphy4j = new Giphy4J(apiKey);
        List<Gif> gifs = giphy4j.search("sponge bob");
    }
}
```
```kotlin
fun main(args: Array<String>) {
    val giphy4K = Giphy4K("apikey")
    val gifs = giphy4K.random(tag = "sponge bob")
    println(gifs.images.looping.mp4)
}
```