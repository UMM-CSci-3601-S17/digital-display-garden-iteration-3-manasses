/**
 * Created by saliy002 on 4/9/17.
 */

import {Component} from "@angular/core";
import {Plant} from "../plants/plant";
import {PlantComponent} from "../plants/plant.component";


@Component({
    selector: 'plant-list',
    templateUrl: 'plant-list.component.html',
    providers: [PlantComponent]
})

export class PlantListComponent{
    public currentPlant: Plant;
    public plantNames: Plant[];
    public plant: Plant;
    private static plantListComponent: PlantListComponent;
    private plantSelect: boolean = false;

    constructor() {
        // Keep track of 'this' for static factory method
        PlantListComponent.plantListComponent = this;
    }

    /**
     * The static factory method which returns currently instantiated PlantListComponent.
     * @returns {PlantListComponent}
     */
    public static getInstance(): PlantListComponent{
        return PlantListComponent.plantListComponent;
    }


    /**
     * Once a user clicks a flower, it will be populated in the PlantComponent
     * @param flower
     */
    onClickedPlant(flower: Plant): void{
        this.currentPlant = flower;
        this.plantSelect = true;
        var plantComponent = PlantComponent.getInstance();
        plantComponent.onSelectFlower(flower)

    }

    /**
     * Used to populate the Plant-List.component
     * This method is called from Bed-list.component
     * @param flowers
     * @returns {Plant[]}
     */
    public parseFlowers(flowers: Plant[]) {
        var tempNames: Plant[] = [];
        for (let each of flowers) {
            tempNames.push(each);
        }
        console.log(tempNames);
        return tempNames;
    }
}