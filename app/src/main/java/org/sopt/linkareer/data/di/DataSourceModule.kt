package org.sopt.linkareer.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.linkareer.data.datasource.ChatDataSource
import org.sopt.linkareer.data.datasource.DummyRemoteDataSource
import org.sopt.linkareer.data.datasourceimpl.ChatDataSourceImpl
import org.sopt.linkareer.data.datasourceimpl.DummyRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindDummyDataSource(dummyRemoteDataSourceImpl: DummyRemoteDataSourceImpl): DummyRemoteDataSource

    @Binds
    @Singleton
    abstract fun chatDataSource(chatDataSourceImpl: ChatDataSourceImpl): ChatDataSource
}
