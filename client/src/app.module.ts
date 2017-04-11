import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { HttpModule, JsonpModule } from '@angular/http';

import { AppComponent }         from './app/app.component';
import { NavbarComponent } from './app/navbar/navbar.component';
import { routing } from './app/app.routes';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { PipeModule } from './pipe.module';
import {AdminComponent} from "./app/admin/admin.component";
import {ExportComponent} from "./app/admin/export.component";
import {AdminService} from "./app/admin/admin.service";
import {ImportComponent} from "./app/admin/import.component";
import {FileUploadComponent} from "./app/admin/file-upload.component";
import {RouterModule} from "@angular/router";
import {FlowerComponent} from "./app/flowers/flower.component";
import {FlowerService} from "./app/flowers/flower.service";
import {SheetUpdateComponent} from "./app/admin/sheet-update.component";
import {SearchComponent} from "./app/search/search.component";
import {SearchService} from "./app/search/search.service";

import { GardenComponent} from "./app/garden/garden-component"
import { PlantListComponent } from './app/garden/plant-list/plant-list.component';
import { PlantComponent } from './app/garden/plants/plant.component';
import { BedListComponent } from './app/garden/bed-list/bed-list.component';
import { PlantListService } from './app/garden/plant-list/plant-list.service';
import { BedListService} from "./app/garden/bed-list/bed-list.service";
import { PlantService} from "./app/garden/plants/plant.service";
//import { PlantComponent } from './app/garden/plants/plant.component';





@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        JsonpModule,
        routing,
        FormsModule,
        PipeModule,
        ReactiveFormsModule,
        RouterModule
    ],
    declarations: [
        AppComponent,
        NavbarComponent,
        PlantListComponent,
        AdminComponent,
        ExportComponent,
        ImportComponent,
        FileUploadComponent,
        // BedComponent,
        BedListComponent,
        // FlowerComponent,
        GardenComponent,
        PlantComponent,
        // FlowerComponent,
        SheetUpdateComponent

        SheetUpdateComponent,
        SearchComponent,
    ],
    // providers: [ PlantListService, AdminService,  FlowerService, BedListService, PlantService ],
    providers: [ PlantListService, AdminService, BedListService, PlantService ],
    bootstrap: [ AppComponent ]
})

export class AppModule {}