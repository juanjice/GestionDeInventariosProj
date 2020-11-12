package com.example.gestioninventariosapp.di

import com.example.gestioninventariosapp.assets.fragment.AssetsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAssetsFragment(): AssetsFragment

}