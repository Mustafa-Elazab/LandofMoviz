# Land Of Moviz
A   Movie and Tv App built to demonstrate the use of modern android architecture component with MVVM Architecture
###  Project Features

- Written in [Kotlin](https://kotlinlang.org/)
- Implementing MVVM design pattern with Android Architecture Components
- Following clean architecture principles[*](https://github.com/bbor98/movieapp-mvvm-clean-architecture#-note)
- Dependency injection with [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- Consuming a [REST API](https://www.themoviedb.org/documentation/api)
- Safe API call with [Retrofit](https://github.com/square/retrofit) & [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - with the help of Sealed Class
- Caching API response with [OkHttpClient](https://square.github.io/okhttp/4.x/okhttp/okhttp3/-ok-http-client/)
- Observing data changes and updating the UI state with [StateFlow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/)
- Lifecycle-aware RecyclerView & ViewPager2 adapters with util classes that implements [DefaultLifecycleObserver](https://developer.android.com/reference/androidx/lifecycle/DefaultLifecycleObserver)
- Easing the binding process and handling common operations with base classes (BaseActivity, BaseFragment, and BaseViewModel)
- Handling common view logic with [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters)
- Infinite scrolling with the help of RecyclerView.OnScrollListener (no paging library used)
- ViewPager2 auto sliding functionality with the help of Handler & Runnable
### App Features
   - Browse movies-TV shows through various categories on the Home screen
  -  Search movies-TV shows-people on the Search screen
  -  See the details of a movie-TV show-person
       -   Adjusted background color according to the dominant color of the poster
       -  Watch trailers directly in the app
       -   View more details by expanding the Details section
       -  Navigate to IMDb, Facebook, Instagram, or Twitter page in the browser or own app if installed
       -  Mark the movie-TV show as favorite by tapping the heart icon
   - View favorite movies-TV shows on the Favorites screen
  -  Offline support (if cached data is available)
  
  ### Architecture 
This app uses [MVVM (Model View View-Model)](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.
![ANDROID ROOM DB DIAGRAM](https://user-images.githubusercontent.com/54749693/201472770-472030ec-ae90-41b4-97d1-e42cb3696fcc.jpg)
  
### Demo
https://user-images.githubusercontent.com/54749693/201471890-d1eab1d7-e977-481d-9cf8-c3791e950067.mp4
