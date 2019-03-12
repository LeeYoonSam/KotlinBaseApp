# KotlinBaseApp

## Using Library
* Dagger
* Arch
* Retrofit
* RxJava/RxAndroid
* Glide

## Todo
* add Room
* app permission grant util
* separate flavor / build type
* auto generate of apk
* add crashlytics

## TIP 
* 모듈에서 인젝트 안되는 현상 수정(@ActivityScope가 동일해야함)
* 모듈에서 Context를 못가져오는 현상 수정
    * AppModule을 만들어서 Context를 Binds 시킴
