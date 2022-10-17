package com.daniilhrebeniuk.sudokusolver.di

import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.use_case.SolveSudoku
import com.daniilhrebeniuk.sudokusolver.feature_sudokusolver.domain.use_case.SudokuSolverUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSudokuSolverUseCases(): SudokuSolverUseCases {
        return SudokuSolverUseCases(
            SolveSudoku()
        )
    }
}