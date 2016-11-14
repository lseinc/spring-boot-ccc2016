import {inject} from 'aurelia-framework';
import {Server} from 'backend/server';
import 'bootstrap';

@inject(Server)
export class Welcome {
  version = "0.0";
  lower = "";

  constructor(server) {
    this.server = server;
    this.server.loadVersion(newValue => {
      this.version = newValue;
    });
    this.lower = '';
  }

  toUpper() {
    if (this.lower && this.lower.length > 0 ) {
      this.server.toUpper(this.lower, newValue => {
        this.lower = newValue;
      });
    }
  }

}
