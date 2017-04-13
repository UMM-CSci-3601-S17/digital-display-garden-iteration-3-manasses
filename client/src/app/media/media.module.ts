/**
 * Created by wiltz011 on 4/13/17.
 */
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { ShareButtonsModule} from 'ng2-sharebuttons';
import { AppComponent }  from './app.component';

@NgModule({
    imports:      [ BrowserModule, HttpModule, ShareButtonsModule],
    declarations: [ AppComponent ],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }