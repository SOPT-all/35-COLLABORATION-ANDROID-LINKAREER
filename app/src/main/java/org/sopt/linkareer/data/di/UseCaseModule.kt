package org.sopt.linkareer.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.linkareer.domain.usecase.GetChatListUseCase
import org.sopt.linkareer.domain.repository.ChatRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetChatListUseCase(chatRepository: ChatRepository): GetChatListUseCase = GetChatListUseCase(chatRepository = chatRepository)
}
