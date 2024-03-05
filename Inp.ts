import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent {
  inputFile: File;
  configFile: File;

  constructor(private http: HttpClient) { }

  onInputFileSelected(event): void {
    this.inputFile = event.target.files[0];
  }

  onConfigFileSelected(event): void {
    this.configFile = event.target.files[0];
  }

  onSubmit(): void {
    const formData = new FormData();
    formData.append('inputFile', this.inputFile);
    formData.append('configFile', this.configFile);

    this.http.post('/upload', formData)
      .subscribe(response => {
        console.log('Upload successful', response);
        // Reset the form after successful upload if needed
        // this.fileUploadForm.reset();
      }, error => {
        console.error('Upload failed', error);
      });
  }
}
