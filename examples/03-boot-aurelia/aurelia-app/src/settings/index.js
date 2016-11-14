import {Server} from 'backend/server';
import {inject} from 'aurelia-framework';

@inject(Server)
export class Settings {
  server = {};

  constructor(server) {
    this.server = server;
    this.versionUrl = this.server.versionUrl;
    this.toUpperUrl = this.server.toUpperUrl;
  }

  submit() {
    alert('Settings saved!');
    this.server.versionUrl = this.versionUrl;
    this.server.toUpperUrl = this.toUpperUrl;
  }
}
