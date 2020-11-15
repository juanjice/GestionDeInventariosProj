package com.example.gestioninventariosapp.di

import com.example.gestioninventariosapp.assets.fragment.AddItemFragment
import com.example.gestioninventariosapp.assets.fragment.AssetsFragment
import com.example.gestioninventariosapp.ui.activities.MainActivity
import com.example.gestioninventariosapp.ui.fragments.HomeFragment
import com.example.gestioninventariosapp.users.fragment.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAssetsFragment(): AssetsFragment
    @ContributesAndroidInjector
    abstract fun contributeAddItemFragment():AddItemFragment
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment():LoginFragment
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment():HomeFragment

}