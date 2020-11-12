package com.example.gestioninventariosapp.di

import android.app.Application
import com.example.data.di.DataAssetModule
import com.example.data.di.DataSourceApiModule
import com.example.gestioninventariosapp.TestApplication
import com.example.gestioninventariosapp.assets.di.AssetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FragmentBuildersModule::class,
        TestModule::class,

        DataAssetModule::class,
        AssetModule::class,
        DataSourceApiModule::class
    ]
)

interface AppComponent: AndroidInjector<TestApplication> {

    @Component.Factory
    interface Factory{
        fun create (@BindsInstance application: Application):AppComponent
    }
}