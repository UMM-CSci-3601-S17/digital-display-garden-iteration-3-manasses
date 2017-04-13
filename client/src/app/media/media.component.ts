/**
 * Created by wiltz011 on 4/13/17.
 */
import { Component } from '@angular/core';

@Component({
    selector: 'my-app',
    template: `<h1>ng2-sharebuttons with SystemJS</h1>
  <div class="output">
    <share-buttons [url]="'https://twitter.com'" [showCount]="show"></share-buttons>
  </div>
  `,
    styles: [`.output{
  border-radius: 8px;
  padding: 0 20px;
  border: 3px dashed #f2bc93;
  margin: 20px 0;
}`]

})
export class AppComponent { show=true;}