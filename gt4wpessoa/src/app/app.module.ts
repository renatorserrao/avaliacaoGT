import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NotifierModule, NotifierOptions, NotifierService } from 'angular-notifier';

import {NgxMaskModule} from 'ngx-mask';
import { NgxSpinnerModule } from 'ngx-spinner';
import { OrderModule } from 'ngx-order-pipe';
import { NgxPaginationModule } from 'ngx-pagination';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { ErrorsModule } from './errors/errors.module';
import { PessoasModule } from './pessoas/pessoas.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MapsModule } from './maps/maps.module';

const customNotifierOptions: NotifierOptions = {
  position: {
    horizontal: {
      position: 'right',
      distance: 12
    },
    vertical: {
      position: 'top',
      distance: 75,
      gap: 10
    }
  },
  theme: 'material',
  behaviour: {
    autoHide: 5000,
    onClick: 'hide',
    onMouseover: 'pauseAutoHide',
    showDismissButton: true,
    stacking: 4
  },
  animations: {
    enabled: true,
    show: {
      preset: 'slide',
      speed: 300,
      easing: 'ease'
    },
    hide: {
      preset: 'fade',
      speed: 300,
      easing: 'ease',
      offset: 50
    },
    shift: {
      speed: 300,
      easing: 'ease'
    },
    overlap: 150
  }
};

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PessoasModule,
    ErrorsModule,
    NotifierModule.withConfig(customNotifierOptions),
    NgxMaskModule.forRoot(),
    OrderModule,
    FormsModule,
    ReactiveFormsModule,
    MapsModule,
    NgxPaginationModule

  ],
  providers: [NotifierService],
  bootstrap: [AppComponent]
})
export class AppModule { }
