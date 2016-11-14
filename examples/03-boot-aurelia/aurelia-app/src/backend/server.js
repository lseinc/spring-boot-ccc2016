import {HttpClient} from 'aurelia-http-client';

const latency = 0;

function wait(ms = latency) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

export class Server {

  constructor() {
    this.versionUrl = "http://localhost:9090/r/version";
    this.toUpperUrl = "http://localhost:9090/r/toUpper";
  }

  loadVersion(callback) {
      let client = new HttpClient();
      return client.get(this.versionUrl)
        .then(data => {
          console.log(data);
          if (data.content && data.content.version) {
            callback(data.content.version);
          }
          return data;
        });
  }

  toUpper(lower, callback) {
    let client = new HttpClient().configure( conf => {
        conf.withHeader('X-Application', 'aurelia');
      });
    return client.get(this.toUpperUrl+"/"+lower)
      .then(data => {
        console.log(data);
        let rsWord = "";
        if (data.content) {
          rsWord = data.content.word;
        }
        callback(rsWord);
        return rsWord;
      });
  }
}
