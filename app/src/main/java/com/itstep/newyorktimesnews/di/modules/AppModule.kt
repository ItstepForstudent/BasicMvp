package com.itstep.newyorktimesnews.di.modules

import com.itstep.newyorktimesnews.utils.DataBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides @Singleton
    fun provideDataBus(): DataBus {
        return DataBus()
    }
}