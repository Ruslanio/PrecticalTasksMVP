package com.example.practicaltasksmvp.di.modules.app

import com.example.practicaltasksmvp.di.builder.ActivityBuilder
import dagger.Module

@Module(includes = [DataModule::class, NavigationModule::class])
class MainModule {
}