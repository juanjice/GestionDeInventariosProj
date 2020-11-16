package com.example.gestioninventariosapp.di

import com.example.gestioninventariosapp.assets.fragment.AddItemFragment
import com.example.gestioninventariosapp.assets.fragment.AssetsFragment
import com.example.gestioninventariosapp.documents.fragment.DocumentsFragment
import com.example.gestioninventariosapp.users.fragment.SingUpFragment
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
    abstract fun contributeSingUpFragment(): SingUpFragment
    @ContributesAndroidInjector
    abstract fun contributeDocumentFragment(): DocumentsFragment



}