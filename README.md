# League friend
**League friend** is an app that uses the [**Riot Developer API**](https://developer.riotgames.com/api-methods/) to show player information from the game League of Legends. At the moment you can search players (summoners) by name, add them to your favourits and check their recent matches and current ranked league position.

## Motivation
The motivation behind this project was to practise Android development by using MVP, Clean Architecture, best practices, Dagger2 and other common libraries (see below).

## Project status
First core version working.

█████████░░░ 75%

### Work to do
* Makeover the UI and add images, icons, animations
* Add localization
* Add settings funtionality (changing region e.g.)
* Add background tasks by using JobScheduler to get player updates in the background
* Show notification on player updates
* Write tests :shipit:

## Building sources
After checking out the sourcecode you need to create a `keystore.properties` file in you root folder with `riotAPIKey="your_personal_api_token"` in it.

## Used open source libraries
* [Dagger2](https://github.com/google/dagger)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [Retrofit](https://github.com/square/retrofit)
* [DBFlow](https://github.com/Raizlabs/DBFlow)
* [Butter Knife](https://github.com/JakeWharton/butterknife)
* [Timber](https://github.com/JakeWharton/timber)
* [Glide](https://github.com/bumptech/glide)
* [Moshi](https://github.com/square/moshi)

## License
[MIT Liceense](https://opensource.org/licenses/MIT)
