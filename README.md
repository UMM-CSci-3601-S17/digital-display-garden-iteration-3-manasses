# Digital Display Garden
[![Build Status](https://travis-ci.org/UMM-CSci-3601-S17/digital-display-garden-iteration-3-manasses.svg?branch=master)](https://travis-ci.org/UMM-CSci-3601-S17/digital-display-garden-iteration-3-manasses)
Software Design S2017, Iteration 3, Team _Manassas_ 

This repository is a fork from [Iteration 2, Team _Grimaldi_](https://github.com/UMM-CSci-3601-S17/digital-display-garden-iteration-2-grimaldi), which is a fork from [Iteration 1 , Team _Claude Arabo_](https://github.com/UMM-CSci-3601-S17/digital-display-garden-iteration-1-claudearabo).

## Setup

Cloning the project inside IntelliJ:

- When prompted to create a new IntelliJ project, select **yes**.
- Select **import project from existing model** and select **Gradle.**
  - Make sure **Use default Gradle wrapper** is selected.
- Click **Finish.**

:fire: If IntelliJ ever prompts you to compile typescript files into
javascript **say no!**. Doing this will confuse webpack and break the client
side of your project during build. No permanent damage will be done, but it's
pretty annoying to deal with.

When you load the project on a new machine, tell Gradle to Refresh linked Gradle projects.


## Already Completed Stories
* Leave Comments About a Flower
* Allow a visitor to rate a flower
* Generate and export QR Codes
* Export Feedback to a File 
* Footer with WCROC link on every page

## Finished by Manassas
* Update Database with new spreadsheet
* Search garden by Cultivar or Common Name
* Show comment count
* Rating and Commenting works (it broke when we transferred our code base)
* Social Media Links
* Page redesign

## Documentation
* [Excel File Requirements](Documentation/ExcelFileRequirements.md)  
* [Excel Parser Documentation](Documentation/ExcelParser.md) 


## Resources

- [Bootstrap Components][bootstrap]
- [Mongo's Java Drivers (Mongo JDBC)][mongo-jdbc]
- [What _is_ Angular 2... why TypeScript?][angular-2]
- [What _is_ webpack...?][whats-webpack]
- [Testing Angular 2 with Karma/Jasmine][angular2-karma-jasmine]

[angular-2]: https://www.infoq.com/articles/Angular2-TypeScript-High-Level-Overview
[angular2-karma-jasmine]: http://twofuckingdevelopers.com/2016/01/testing-angular-2-with-karma-and-jasmine/
[labtasks]: LABTASKS.md
[travis]: https://travis-ci.org/
[whats-webpack]: https://webpack.github.io/docs/what-is-webpack.html
[bootstrap]: https://getbootstrap.com/components/ 
[mongo-jdbc]: https://docs.mongodb.com/ecosystem/drivers/java/ 
