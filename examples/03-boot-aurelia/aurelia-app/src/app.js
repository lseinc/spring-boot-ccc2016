import {bindable} from 'aurelia-framework';

export class App {
  @bindable router = {};

  configureRouter(config, router){
    config.title = 'Aurelia Sample Client';
    config.map([
      {
        route: '',
        moduleId: 'welcome',
        nav: true,
        title:'Aurelia Sample Client',
        href: '#',
        settings: { icon:'book' }
      },
      { route: 'settings',
        moduleId: 'settings/index',
        nav: true,
        title: 'Settings',
        settings: { icon:'cog' } }
    ]);

    this.router = router;
  }
}
