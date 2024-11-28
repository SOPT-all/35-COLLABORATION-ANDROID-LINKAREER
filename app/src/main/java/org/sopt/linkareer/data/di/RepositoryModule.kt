package org.sopt.linkareer.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.linkareer.data.repositoryimpl.ChatRepositoryImpl
import org.sopt.linkareer.data.repositoryimpl.DummyRepositoryImpl
import org.sopt.linkareer.domain.repository.ChatRepository
import org.sopt.linkareer.domain.repository.DummyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindDummyRepository(dummyRepositoryImpl: DummyRepositoryImpl): DummyRepository

    @Binds
    @Singleton
    abstract fun chatDataSource(chatRepositoryImpl: ChatRepositoryImpl): ChatRepository
}
