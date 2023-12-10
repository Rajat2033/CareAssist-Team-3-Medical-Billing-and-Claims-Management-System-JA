import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular_templates';

  // generatePdf()
  // {
  //   let pdf=new jsPDF();
  //   pdf.text('Hello World',10,10);
  //   pdf.save('hello_world.pdf');
  // }
}
