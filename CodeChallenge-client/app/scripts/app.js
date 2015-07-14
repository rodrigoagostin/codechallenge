'use strict';

/**
 * @ngdoc overview
 * @name codeChallengeClientApp
 * @description
 * # codeChallengeClientApp
 *
 * Main module of the application.
 */

angular
  .module('codeChallengeClientApp', [
    'ngAnimate',
    'ngResource',
    'ngRoute',
    'restangular',
    'ngCpfCnpj'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  }).config(function(RestangularProvider) {
    RestangularProvider.setBaseUrl('http://localhost:8080/api/rest');
  });