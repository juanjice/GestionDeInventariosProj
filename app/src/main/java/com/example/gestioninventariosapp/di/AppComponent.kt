package com.example.gestioninventariosapp.di

import android.app.Application
import com.example.data.di.*
import com.example.gestioninventariosapp.TestApplication
import com.example.gestioninventariosapp.assets.di.AssetModule
import com.example.gestioninventariosapp.documents.di.DocumentModule
import com.example.gestioninventariosapp.users.di.UserModule
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
        //inject module
        DataAssetModule::class,
        AssetModule::class,
        //inject document
        DataDocumentsModule::class,
        DocumentModule::class,
        //inject user
        DataUserModule::class,
        UserModule::class,



        DataSourceApiModule::class
    ]
)

interface AppComponent: AndroidInjector<TestApplication> {

    @Component.Factory
    interface Factory{
        fun create (@BindsInstance application: Application):AppComponent
    }
}