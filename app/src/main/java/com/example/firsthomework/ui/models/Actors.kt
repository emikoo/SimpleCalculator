package com.example.firsthomework.ui.models

data class Actors(
    var image: String? = null,
    var name: String? = null,
    var email: String? = null,
    var age: String? = null,
    var bio: String? = null
)

val dicaprio = Actors(
    "https://in.bmscdn.com/iedb/artist/images/website/poster/large/leonardo-dicaprio-1273-06-05-2020-06-55-21.jpg?1",
    "Leonardo DiCaprio",
    "leonardo.dicaprio@gmail.com",
    "46 years",
    "Leonardo Wilhelm DiCaprio (/dɪˈkæprioʊ/, Italian: [diˈkaːprjo]; born November 11, 1974) is an American actor, producer and environmentalist. He has often played unconventional roles, particularly in biopics and period films. As of 2019, his films have grossed US\$7.2 billion worldwide, and he has placed eight times in annual rankings of the highest-paid actors in the world.\n" +
            "\n" +
            "Born in Los Angeles, DiCaprio began his career by appearing in television commercials in the late 1980s. In the early 1990s, he played recurring roles in various television series, such as the sitcom Parenthood. He had his first major film role in This Boy's Life (1993) and received acclaim for his supporting role as a developmentally disabled boy in What's Eating Gilbert Grape (1993). He achieved international stardom in the epic romance Titanic (1997), which became the highest-grossing film to that point. After a few commercially unsuccessful films, DiCaprio starred in two successful features in 2002: the biographical crime drama Catch Me If You Can and the historical drama Gangs of New York, which marked his first of many collaborations with director Martin Scorsese.\n" +
            "\n" +
            "DiCaprio portrayed Howard Hughes in The Aviator (2004) and continued to receive acclaim for his performances in the political thriller Blood Diamond (2006), the crime drama The Departed (2006), and the romantic drama Revolutionary Road (2008). In the 2010s, he starred in the science fiction thriller Inception (2010), the western Django Unchained (2012), the biopic The Wolf of Wall Street (2013), the survival drama The Revenant (2015), and the comedy-drama Once Upon a Time in Hollywood (2019), all of which were critical and commercial successes. His accolades include an Academy Award, a BAFTA, and a Golden Globe Award for The Revenant as well as two other Golden Globes for The Aviator and The Wolf of Wall Street.\n" +
            "\n" +
            "DiCaprio is the founder of Appian Way Productions—a production company that has produced some of his films and the documentary series Greensburg (2008–2010)—and the Leonardo DiCaprio Foundation, a non-profit organization devoted to promoting environmental awareness. He regularly supports charitable causes and has produced several documentaries on the environment. In 2005, he was named the commander of the Ordre des Arts et des Lettres for his contributions to the arts, and in 2016, he was listed as one of the 100 most influential people in the world by Time. "
)