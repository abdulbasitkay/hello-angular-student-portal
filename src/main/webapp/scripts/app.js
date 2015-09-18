'use strict';

angular.module('studentApp', [
  'studentApp.services',
  'studentApp.controllers',
  'ngRoute'
  ])
.config(function ($routeProvider, $httpProvider) {
  $routeProvider.when('/update/:id', {templateUrl: 'views/update.html', controller: 'UpdateStudentController'});
  $routeProvider.when('/create', {templateUrl: 'views/create.html', controller: 'StudentCreationController'});
  $routeProvider.otherwise({redirectTo: '/create'});

  /* CORS... */
  /* http://stackoverflow.com/questions/17289195/angularjs-post-data-to-external-rest-api */
  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});