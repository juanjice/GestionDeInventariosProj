package com.example.gestioninventariosapp.di

import com.example.gestioninventariosapp.assets.fragment.AssetsFragment
import dagger.android.ContributesAndroidInjector

abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAssetsFragment(): AssetsFragment

}