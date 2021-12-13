package com.example.composetutorial


data class Message(val author: String, val date: String, val body: String)

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Colleague",
            "2021-11-12",
            "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "2021-11-14",
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        Message(
            "Colleague",
            "2021-11-12",
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!"
        ),
        Message(
            "Colleague",
            "2021-11-12",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Colleague",
            "2021-11-12",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        Message(
            "Colleague",
            "2021-11-12",
            "It's available from API 21+ :)"
        ),
        Message(
            "Colleague",
            "2021-11-12",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Colleague",
            "2021-11-12",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Colleague",
            "2021-11-12",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Colleague",
            "2021-11-13",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Colleague",
            "2021-11-13",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Colleague",
            "2021-11-14",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Colleague",
            "2021-11-14",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}